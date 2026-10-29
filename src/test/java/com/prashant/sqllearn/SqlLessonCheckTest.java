package com.prashant.sqllearn;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

/**
 * Checks your answers in sql/learn/lessonNN-exercises.sql against PostgreSQL.
 *
 * Run one lesson:   mvn test -Dtest=SqlLessonCheckTest -Dlesson=01
 * Run all lessons:  mvn test -Dtest=SqlLessonCheckTest -Dlesson=all
 *
 * Connection (environment variables):
 *   SQL_LEARN_URL       default jdbc:postgresql://localhost:5432/postgres
 *   SQL_LEARN_USER      default postgres
 *   SQL_LEARN_PASSWORD  no default: set it yourself
 *
 * Without -Dlesson the test is skipped, so a plain "mvn test" never depends on your database.
 */
class SqlLessonCheckTest {

    private static final Pattern MARKER = Pattern.compile("(?m)^[ \\t]*--[ \\t]*@ex[ \\t]+(\\d+)[ \\t]*\\r?$");
    private static final int MAX_ROWS_SHOWN = 12;

    @Test
    void checkLessons() throws Exception {
        String requested = System.getProperty("lesson");
        assumeTrue(requested != null && !requested.isBlank(),
                "SQL learn track skipped. Run it with: mvn test -Dtest=SqlLessonCheckTest -Dlesson=01");

        List<String> lessons = new ArrayList<>();
        if (requested.equalsIgnoreCase("all")) {
            lessons.addAll(new TreeMap<>(LessonSpecs.LESSONS).keySet());
        } else {
            lessons.add(String.format("%02d", Integer.parseInt(requested.trim())));
        }

        int failedLessons = 0;
        StringBuilder summary = new StringBuilder();
        for (String lesson : lessons) {
            if (!LessonSpecs.LESSONS.containsKey(lesson)) {
                fail("There is no lesson " + lesson + ". Available: " + new TreeMap<>(LessonSpecs.LESSONS).keySet());
            }
            LessonResult r = checkLesson(lesson);
            summary.append(String.format("Lesson %s: %d/%d passed%n", lesson, r.passed, r.total));
            if (r.passed != r.total) {
                failedLessons++;
            }
        }
        if (failedLessons > 0) {
            fail("Not all exercises pass yet.\n" + summary
                    + "Fix the [FAIL] items, write the [TODO] ones, and run the check again.");
        }
        System.out.println();
        System.out.println("*** ALL DONE: " + summary.toString().trim().replace("\n", " | ") + " ***");
    }

    // ---------------------------------------------------------------- lesson

    private LessonResult checkLesson(String lesson) throws Exception {
        Path dir = Paths.get(System.getProperty("sql.learn.dir", "sql/learn"));
        Path setupFile = dir.resolve("lesson" + lesson + "-setup.sql");
        Path exercisesFile = dir.resolve("lesson" + lesson + "-exercises.sql");
        if (!Files.exists(setupFile) || !Files.exists(exercisesFile)) {
            fail("Cannot find " + setupFile + " or " + exercisesFile
                    + ". Run Maven from the repository root (the folder that contains pom.xml).");
        }
        String setupSql = read(setupFile);
        Map<Integer, String> answers = splitExercises(read(exercisesFile));
        List<Exercise> exercises = LessonSpecs.LESSONS.get(lesson);

        System.out.println();
        System.out.println("==================== SQL learn track: lesson " + lesson + " ====================");

        int passed = 0;
        try (Connection conn = connect()) {
            try (Statement st = conn.createStatement()) {
                st.execute(setupSql);                                  // rebuild schema learn_NN
                st.execute("SET search_path TO learn_" + lesson);
                st.execute("SET default_transaction_read_only = on");  // your answers can only read
                st.execute("SET statement_timeout = 10000");
            }
            for (Exercise ex : exercises) {
                if (checkExercise(conn, lesson, ex, answers.get(ex.number))) {
                    passed++;
                }
            }
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Lesson " + lesson + ": " + passed + "/" + exercises.size() + " exercises passed");
        if (passed == exercises.size()) {
            System.out.println("LESSON " + lesson + " COMPLETE. Tell Lumi, then update PROGRESS.md.");
        }
        return new LessonResult(passed, exercises.size());
    }

    private boolean checkExercise(Connection conn, String lesson, Exercise ex, String sql) {
        String label = "Exercise " + ex.number + " (" + ex.title + ")";
        if (sql == null) {
            System.out.println("[FAIL] " + label);
            System.out.println("       The marker '-- @ex " + ex.number + "' is missing from lesson" + lesson
                    + "-exercises.sql. Put it back above your query.");
            return false;
        }
        if (isBlank(sql)) {
            System.out.println("[TODO] " + label + ": not attempted yet. Write your query under '-- @ex "
                    + ex.number + "'.");
            return false;
        }

        List<String> columns = new ArrayList<>();
        List<List<String>> actual = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            boolean isResultSet = st.execute(sql);
            while (!isResultSet) {
                if (st.getUpdateCount() == -1) {
                    System.out.println("[FAIL] " + label + ": your SQL did not return any rows. Use a SELECT.");
                    return false;
                }
                isResultSet = st.getMoreResults();
            }
            try (ResultSet rs = st.getResultSet()) {
                ResultSetMetaData md = rs.getMetaData();
                for (int c = 1; c <= md.getColumnCount(); c++) {
                    columns.add(md.getColumnLabel(c));
                }
                while (rs.next()) {
                    List<String> row = new ArrayList<>();
                    for (int c = 1; c <= md.getColumnCount(); c++) {
                        row.add(Exercise.normalize(rs.getObject(c)));
                    }
                    actual.add(row);
                }
            }
        } catch (SQLException e) {
            System.out.println("[FAIL] " + label + ": PostgreSQL rejected your query.");
            System.out.println("       " + firstLine(e.getMessage()));
            return false;
        }

        String problem = compare(ex, actual);
        if (problem == null) {
            System.out.println("[PASS] " + label);
            return true;
        }
        System.out.println("[FAIL] " + label + ": " + problem);
        System.out.println("       Expected" + (ex.ordered ? " (in this order)" : " (any order)") + ":");
        printTable("         ", null, ex.expected);
        System.out.println("       Yours:");
        printTable("         ", columns, actual);
        System.out.println("       Hint: open lesson" + lesson + ".md and read the hint for exercise " + ex.number + ".");
        return false;
    }

    private String compare(Exercise ex, List<List<String>> actual) {
        int expectedCols = ex.expected.get(0).size();
        if (!actual.isEmpty() && actual.get(0).size() != expectedCols) {
            return "expected " + expectedCols + " column(s) but your query returns " + actual.get(0).size() + ".";
        }
        if (actual.size() != ex.expected.size()) {
            return "expected " + ex.expected.size() + " row(s) but your query returns " + actual.size() + ".";
        }
        if (ex.ordered) {
            for (int i = 0; i < actual.size(); i++) {
                if (!actual.get(i).equals(ex.expected.get(i))) {
                    return "row " + (i + 1) + " is different (the order of rows matters here).";
                }
            }
            return null;
        }
        List<String> a = flatten(actual);
        List<String> e = flatten(ex.expected);
        Collections.sort(a);
        Collections.sort(e);
        return a.equals(e) ? null : "the rows are different.";
    }

    // ---------------------------------------------------------------- helpers

    private static List<String> flatten(List<List<String>> rows) {
        List<String> out = new ArrayList<>();
        for (List<String> r : rows) {
            out.add(String.join("\u0001", r));
        }
        return out;
    }

    static Map<Integer, String> splitExercises(String file) {
        Map<Integer, String> result = new TreeMap<>();
        Matcher m = MARKER.matcher(file);
        List<int[]> spans = new ArrayList<>();   // {exerciseNumber, bodyStart, markerStart}
        while (m.find()) {
            spans.add(new int[] {Integer.parseInt(m.group(1)), m.end(), m.start()});
        }
        for (int i = 0; i < spans.size(); i++) {
            int end = (i + 1 < spans.size()) ? spans.get(i + 1)[2] : file.length();
            result.put(spans.get(i)[0], file.substring(spans.get(i)[1], end));
        }
        return result;
    }

    /** True when the slot holds only comments, whitespace and semicolons. */
    static boolean isBlank(String sql) {
        String s = sql.replaceAll("(?s)/\\*.*?\\*/", " ").replaceAll("(?m)--.*$", " ");
        return s.replace(";", " ").isBlank();
    }

    private static Connection connect() {
        String url = env("SQL_LEARN_URL", "jdbc:postgresql://localhost:5432/postgres");
        String user = env("SQL_LEARN_USER", "postgres");
        String password = System.getenv("SQL_LEARN_PASSWORD");   // deliberately no default
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            fail("Could not connect to PostgreSQL.\n"
                    + "  URL:  " + url + "\n  user: " + user + "\n  password variable set: " + (password != null) + "\n"
                    + "  Reason: " + firstLine(e.getMessage()) + "\n"
                    + "Set SQL_LEARN_URL, SQL_LEARN_USER and SQL_LEARN_PASSWORD (see sql/learn/README.md).");
            return null;
        }
    }

    private static String env(String name, String fallback) {
        String v = System.getenv(name);
        return (v == null || v.isBlank()) ? fallback : v;
    }

    private static String read(Path p) throws IOException {
        return new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
    }

    private static String firstLine(String s) {
        if (s == null) {
            return "(no message)";
        }
        return s.split("\\r?\\n")[0];
    }

    private static void printTable(String indent, List<String> header, List<List<String>> rows) {
        if (header != null) {
            System.out.println(indent + String.join(" | ", header));
        }
        if (rows.isEmpty()) {
            System.out.println(indent + "(no rows)");
            return;
        }
        int shown = 0;
        for (List<String> r : rows) {
            if (shown++ == MAX_ROWS_SHOWN) {
                System.out.println(indent + "... (" + (rows.size() - MAX_ROWS_SHOWN) + " more rows)");
                break;
            }
            System.out.println(indent + String.join(" | ", r));
        }
    }

    private static final class LessonResult {
        final int passed;
        final int total;

        LessonResult(int passed, int total) {
            this.passed = passed;
            this.total = total;
        }
    }
}
