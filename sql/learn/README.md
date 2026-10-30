# 🎓 SQL learn track

![Lessons](https://img.shields.io/badge/lessons-5-blue) ![Time](https://img.shields.io/badge/time-15--20%20min%20each-yellow) ![DB](https://img.shields.io/badge/DB-PostgreSQL-blue) ![Checker](https://img.shields.io/badge/checker-mvn%20test-brightgreen)

> [!IMPORTANT]
> Short guided lessons, 15-20 minutes each, on the banking domain (branches, customers, accounts, transactions, loans). No website: just files in this repo and one command that checks your answers, a bit like freeCodeCamp's "Run the tests".

> [!NOTE]
> **Legend:** `[PASS]` correct · `[FAIL]` expected rows next to yours · `[TODO]` empty slot · ⬜ Not started · 🟡 In progress · 🟠 Attempted · 🔴 Needs correction · 🔵 Ready for revision · ✅ Completed and verified.

> [!IMPORTANT]
> You write every query yourself. The files you see contain **no answers**: the expected rows live only inside the
> checker (`src/test/java/com/prashant/sqllearn/LessonSpecs.java`). Please do not open that file before you try; it
> is the answer sheet for the output (not for the queries).

## 🔄 How a lesson works
1. Read `lessonNN.md` (concept, one worked example on a *different* table, 5 exercises, a hint for each).
2. Run `lessonNN-setup.sql` in pgAdmin (Query Tool). It drops and rebuilds the schema `learn_NN` with small tricky data (NULLs, ties, empty groups). Safe to run again any time.
3. Try your queries in pgAdmin (`SET search_path TO learn_NN;` first).
4. Paste each final query under its `-- @ex N` marker in `lessonNN-exercises.sql`. One query per marker. Do not edit the marker lines.
5. Run the check (below). It prints `[PASS]`, `[FAIL]` (expected rows next to your rows) or `[TODO]` (empty slot = not attempted).
6. When all 5 pass, tell Lumi. She reviews your queries and updates the status in `PROGRESS.md`.

## 🧰 One-time setup
1. In pgAdmin create a scratch database: `CREATE DATABASE sql_learn;`. Do **not** use the banking database: the checker drops and recreates the `learn_NN` schemas, so it needs the right to create schemas, which your banking DML-only user (correctly) does not have.
2. Set the connection in your terminal (never write the password in a file in the repo):

| Variable | Meaning | Default |
|---|---|---|
| `SQL_LEARN_URL` | JDBC URL | `jdbc:postgresql://localhost:5432/postgres` |
| `SQL_LEARN_USER` | database user | `postgres` |
| `SQL_LEARN_PASSWORD` | password | none, you must set it |

PowerShell (this terminal only):
```powershell
$env:SQL_LEARN_URL = "jdbc:postgresql://localhost:5432/sql_learn"
$env:SQL_LEARN_USER = "postgres"
$env:SQL_LEARN_PASSWORD = "your-password"
```
Or once and for all on Windows (open a new terminal afterwards): `setx SQL_LEARN_PASSWORD "your-password"`, same for the other two.
macOS/Linux: `export SQL_LEARN_PASSWORD=...`.

## 🔎 Run the check
From the repository root (the folder with `pom.xml`):
```bash
mvn test -Dtest=SqlLessonCheckTest -Dlesson=01
```
- `-Dlesson=01` ... `05` checks one lesson, `-Dlesson=all` checks all five.
- Windows shortcut: `sql\learn\check.cmd 01`.
- Maven finishes with a red `BUILD FAILURE` and a short stack trace while any exercise is not passing. Read the `[PASS]/[FAIL]/[TODO]` lines above it. Everything is green when you see `LESSON 01 COMPLETE`.
- A plain `mvn test` (no `-Dlesson`) **skips** this check, so it never breaks the rest of the project or needs your database.

How rows are compared: the column ORDER and the values must match; column names and aliases do not matter. Row order only matters when the exercise says to sort.
Your answers run in a read-only session with a 10 second timeout, so a wrong `DELETE` cannot damage anything.

## 📚 Lessons
| # | Lesson | Time | Status |
|---|---|---|---|
| 01 | [SELECT, WHERE, ORDER BY, LIMIT](lesson01.md) | 15 min | ✅ Completed and verified |
| 02 | [NULL handling and CASE](lesson02.md) | 20 min | ⬜ Not started |
| 03 | [Aggregates, GROUP BY, HAVING](lesson03.md) | 20 min | ⬜ Not started |
| 04 | [INNER JOIN and LEFT JOIN](lesson04.md) | 20 min | ⬜ Not started |
| 05 | [Subqueries and EXISTS](lesson05.md) | 20 min | ⬜ Not started |

The official status lives in [PROGRESS.md](../../PROGRESS.md) (statuses: Not started / In progress / Attempted / Needs correction / Ready for revision / Completed and verified). A lesson is only "Completed and verified" after the checker passes **and** Lumi has read your queries.

## 📂 Files per lesson
| File | What it is |
|---|---|
| `lessonNN.md` | concept, worked example, exercises, hints |
| `lessonNN-setup.sql` | idempotent: drops and creates schema `learn_NN`, seeds data |
| `lessonNN-exercises.sql` | your answers, one slot per `-- @ex N` marker |
| `check.cmd` | Windows shortcut for the Maven command |

## 🛠️ Troubleshooting
- `Could not connect to PostgreSQL`: check the three variables above and that PostgreSQL is running. The message shows which URL/user was used.
- `permission denied for database`: the user cannot create schemas. Use a database you own (the scratch `sql_learn`).
- `[FAIL] ... marker is missing`: you deleted or edited a `-- @ex N` line. Put it back exactly as `-- @ex 3`.
- Exercise passes in pgAdmin but fails here: compare column order and the number of columns first, then the row order.
