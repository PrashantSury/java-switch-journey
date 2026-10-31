# 🗄️ Archive

![Archived](https://img.shields.io/badge/status-archived-lightgrey) ![Section](https://img.shields.io/badge/section-SQL-blue)

> [!IMPORTANT]
> SQL was **retired from the prep plan on 31 Oct 2026**. Prashant now practises only Spring Boot, DSA and buggy-code problems. Nothing here was deleted: it is kept for history and for a quick brush-up before interviews. No routine assigns, tracks or grades anything in this folder, and it is not part of `mvn test`.

> [!NOTE]
> **Legend:** 🗄️ SQL · 🎓 learn track · 🧪 checker · 📂 files.

## 📂 What is archived
| | Path | What |
|---|---|---|
| 🗄️ | [`sql/day01.sql`](sql/day01.sql) to [`sql/day04.sql`](sql/day04.sql), `sql/day01-test.sql` | daily banking SQL files, none answered |
| 🎓 | [`sql/learn/`](sql/learn/README.md) | five guided lessons (setup, exercises, `check.cmd`) |
| 🏦 | [`sql/banking/`](sql/banking/README.md) | banking SQL notes (same schema as `banking-app`) |
| 🧪 | [`sql/tests/`](sql/tests) | the lesson checker (`SqlLessonCheckTest`, `LessonSpecs`, `Exercise`), moved out of `src/test/java` so `mvn test` no longer runs it |
| 🔁 | [`sql/mistakes-sql.md`](sql/mistakes-sql.md) | the SQL mistake log (one row, its redo dates are cancelled) |

## 📊 Where SQL stood when it was retired
| Item | Status |
|---|---|
| Learn lesson 01 (SELECT, WHERE, ORDER BY, LIMIT) | ✅ Completed and verified (5/5, 30 Oct) |
| Learn lesson 02 (NULL handling and CASE) | ✅ Completed and verified (5/5, 31 Oct) |
| Learn lessons 03, 04, 05 | ⬜ Not started |
| `day01`, `day01-test`, `day02`, `day03`, `day04` | ⬜ Not started |

> [!TIP]
> To restore the checker, copy the three files in `sql/tests/` back to `src/test/java/com/prashant/sqllearn/` and re-add the PostgreSQL test dependency (`org.postgresql:postgresql:42.7.3`, scope `test`) to `pom.xml`. The old tracker rows are in the git history before the commit "Retire SQL: archive to archive/sql".

> [!WARNING]
> Links inside the archived files that mention `sql/` or `src/test/java/com/prashant/sqllearn/` describe the old layout. Read them as `archive/sql/` and `archive/sql/tests/`.
