package com.prashant.sqllearn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** One exercise: the expected rows are hard-coded here so no answer query is ever stored in the repo. */
final class Exercise {
    final int number;
    final String title;
    final boolean ordered;            // true = row order must match (the exercise asks for ORDER BY)
    final List<List<String>> expected;

    private Exercise(int number, String title, boolean ordered, List<List<String>> expected) {
        this.number = number;
        this.title = title;
        this.ordered = ordered;
        this.expected = expected;
    }

    static Exercise ordered(int number, String title, Object[]... rows) {
        return new Exercise(number, title, true, toRows(rows));
    }

    static Exercise unordered(int number, String title, Object[]... rows) {
        return new Exercise(number, title, false, toRows(rows));
    }

    static Object[] row(Object... values) {
        return values;
    }

    /** A decimal value, e.g. d("49416.83"). */
    static BigDecimal d(String value) {
        return new BigDecimal(value);
    }

    private static List<List<String>> toRows(Object[][] rows) {
        List<List<String>> result = new ArrayList<>();
        for (Object[] row : rows) {
            List<String> r = new ArrayList<>();
            for (Object v : Arrays.asList(row)) {
                r.add(normalize(v));
            }
            result.add(r);
        }
        return result;
    }

    /** Same normalisation for expected and actual values: NULL, plain numbers, text as-is. */
    static String normalize(Object v) {
        if (v == null) {
            return "NULL";
        }
        if (v instanceof Number) {
            BigDecimal bd = new BigDecimal(v.toString());
            if (bd.signum() == 0) {
                return "0";
            }
            return bd.stripTrailingZeros().toPlainString();
        }
        return v.toString();
    }
}
