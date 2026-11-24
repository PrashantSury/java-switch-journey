# ☕ java-switch-journey

Senior Java backend interview prep: **DSA** (NeetCode by pattern), **buggy rounds** and **cold redos**, plus the daily plan and progress records. Spring work lives in [spring-boot-labs](https://github.com/PrashantSury/spring-boot-labs) (`my-solutions` branch).

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
| [`PROGRESS.md`](PROGRESS.md) | "Now" summary at the top, full status below |
| [`interview-answers.md`](interview-answers.md) | graded interview answers |
| `src/main/java/com/prashant/dsa/<pattern>/` | DSA solutions |
| `src/main/java/com/prashant/dailytests/` (+ `redo/`) | buggy rounds and redos |
| [`CONTRIBUTING.md`](CONTRIBUTING.md) | naming and stub rules (short) |

Coach-maintained, no need to open: `revision/` (redo calendar, mistake logs), `docs/` (program, style guide, [day template](docs/DAY-TEMPLATE.md)), `open-stubs.txt`, `archive/` (SQL, old days, progress history, parked [banking-app](archive/banking-app/README.md), old `spring-boot/`).
