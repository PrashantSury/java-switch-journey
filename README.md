# ☕ java-switch-journey

![Java](https://img.shields.io/badge/Java-21-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen) ![Tracks](https://img.shields.io/badge/tracks-3-blue) ![Time](https://img.shields.io/badge/day-2h%20%2B%201h-yellow)

> [!IMPORTANT]
> Senior Java backend interview preparation, in three tracks: a Spring Boot retail-banking project, DSA (NeetCode 150 by pattern) and fix-the-buggy-code problems. SQL was archived on 31 Oct 2026. Start with [docs/PROGRAM.md](docs/PROGRAM.md) (how the program works) and [PROGRESS.md](PROGRESS.md) (where I am).

> [!NOTE]
> **Legend:** 🧭 program · 📈 tracking · 📋 tasks · 🧩 DSA · 🐞 buggy · 🏦 banking · 🌱 Spring notes · 🔁 revision · 🗄️ archive. Markdown conventions: [docs/STYLE-GUIDE.md](docs/STYLE-GUIDE.md).

## 🗂️ Layout
| | Path | What |
|---|---|---|
| 🧭 | [`docs/PROGRAM.md`](docs/PROGRAM.md), [`docs/STYLE-GUIDE.md`](docs/STYLE-GUIDE.md) | the operating model (tracks, time split, statuses, scoring) and the markdown/spec style |
| 📈 | [`PROGRESS.md`](PROGRESS.md), [`interview-answers.md`](interview-answers.md) | sources of truth: status of every track, graded interview answers |
| 📋 | `tasks/` | one file per day, `dayNN.md`, with the specs of pending tasks |
| 🧩 🐞 | `src/` (root `pom.xml`) | DSA solutions in `dsa/<pattern>/`, buggy rounds in `dailytests/` and `dailytests/redo/`, tests in `src/test/java` |
| 🏦 | [`banking-app/`](banking-app/README.md) | the Spring Boot banking project; design in [`project-architecture.md`](banking-app/project-architecture.md) |
| 🌱 | `spring-boot/` | the finishing `course-practice` module, the revision workbook and `prerequisites.md`, graded answers in `interview-answers/` |
| 🔁 | `revision/` | spaced-repetition calendar ([`redo-schedule.md`](revision/redo-schedule.md)) and one mistake log per track (`mistakes/dsa.md`, `mistakes/spring.md`; index in [`mistake-log.md`](revision/mistake-log.md)) |
| 🗄️ | [`archive/`](archive/README.md) | the retired SQL track and the early `day02-05-morning` task files, kept for history |

> [!NOTE]
> 🌱 **Spring lives in [spring-boot-labs](https://github.com/PrashantSury/spring-boot-labs)** (the Ledgerly roadmap; my work is on its `my-solutions` branch). This repo is DSA + buggy rounds + records.

## ▶️ How to run
Needs JDK 21 and Maven 3.9+. The root `pom.xml` covers DSA (`dsa/<pattern>/`) and buggy rounds (`dailytests/`, `dailytests/redo/`).

| Command | What it runs | Expected |
|---|---|---|
| `mvn test` | the **done** suite: everything except the classes listed in [`open-stubs.txt`](open-stubs.txt) | 🟢 always green; red means something finished broke |
| `mvn test -Popen` | **only** the open stubs listed in `open-stubs.txt` (today's problem, unfinished buggy round, pending redos) | 🔴 red until the work is done |
| `mvn test -Dtest=TwoSumTest` | one class (works for open and done classes alike) | grade a single push |
| `mvn test -Dtest='GroupAnagramsTest,Day06*'` | several classes, wildcards allowed | |

**`open-stubs.txt`**: one pattern per line, e.g. `**/dsa/arrayshashing/GroupAnagramsTest.java`; `#` starts a comment.
- When a stub is handed out (new problem, buggy round or redo), **add** its test class.
- When the class passes all its tests, **remove** the line, so it joins the green suite and guards against regressions.

> [!TIP]
> `banking-app` and `spring-boot/course-practice` are separate Maven projects with their own `pom.xml`; the root `mvn test` does not build them.
