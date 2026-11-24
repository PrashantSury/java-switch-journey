# ☕ java-switch-journey

DSA practice repo: **NeetCode problems by pattern**, **buggy rounds** and **cold redos**, plus the daily plan and progress records. (Spring practice lives in [spring-boot-labs](https://github.com/PrashantSury/spring-boot-labs).)

## ▶️ How to run (JDK 21, Maven 3.9+)

| Command | Runs | Expected |
|---|---|---|
| `mvn test` | everything **done** (skips [`open-stubs.txt`](open-stubs.txt)) | 🟢 always green |
| `mvn test -Popen` | only the open stubs (today's work) | 🔴 until done |
| `mvn test -Dtest=TwoSumTest` | one class, open or done | grade one push |

## 🗂️ Where things are

| Open this | For |
|---|---|
| [`tasks/dayNN.md`](tasks/) | **today's plan** (last 5 days; older in [`archive/tasks/`](archive/tasks/)) |
| [`PROBLEMS.md`](PROBLEMS.md) | every problem + pattern cheat sheets |
| [`PROGRESS.md`](PROGRESS.md) | one page: DSA, buggy, Spring (paused), redos, last 7 days of scores |
| `src/main/java/com/prashant/dsa/<pattern>/` | DSA solutions |
| `src/main/java/com/prashant/dailytests/` (+ `redo/`) | buggy rounds and redos |
| [`CONTRIBUTING.md`](CONTRIBUTING.md) | naming and stub rules (short) |

**🏦 [`banking-app/`](banking-app/README.md)**: separate Spring Boot banking project (already set up, kept here so it isn't lost); build with `mvn -f banking-app/pom.xml verify` (its integration tests need Docker). The root `mvn test` does not touch it.

Coach-maintained, no need to open: `revision/` (redo calendar, mistake logs), `docs/` (program, style guide, [day template](docs/DAY-TEMPLATE.md)), `open-stubs.txt`, `archive/` (SQL, old days, progress history, old Spring notes).
