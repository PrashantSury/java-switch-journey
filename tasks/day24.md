# 📅 Day 24 (Sun 15 Nov): one-slot day · 15 minutes

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-24-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-15%20min-yellow) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Still a **one-slot day**. Nothing landed on 14 Nov (no commits, no chat answer), so the **second push day** is still needed before the normal 2-hour plan and the redo queue come back. One must-do: the 🎤 **Chapter 1 interview question in chat** (unchanged from [day23.md](day23.md#-1-chapter-1-interview-question-must-do-in-chat)). It's about 10 minutes and needs no IDE. A chat answer closes Chapter 1 but does **not** count as a push; the normal plan returns the day after the second push day.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first.
>
> State at 6 AM on tip `7325500` (the 14 Nov weekly review): no student commits after `d6ca103` (this repo, 12 Nov 9:01 PM IST) and `4384b9c` ([`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) `main`, 12 Nov 10:26 PM IST); still no `my-solutions` branch. No code changed, so the last verified results stand: labs `Chapter01CheckTest` **19/19**, `Chapter02CheckTest` **0/19** (stub), root `mvn test` **514 run, 0 red**.

## 🌅 Morning

### ⏱️ Time plan (15 min)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-2 | — | `git pull` both repos | — |
| 2-15 | 🌱🎤 | **Chapter 1 interview question, in chat** (below) | answered and graded in chat → Chapter 1 ✅ |
| +15 (optional) | 🌱 | `git switch -c my-solutions` in `spring-boot-labs`, Chapter 2 **Task 1**, push | `task1a`, `task1b`, `task1c` green on the pushed branch |

### 🎤 1. Chapter 1 interview question (must-do, in chat)

> [!TIP]
> Why it matters for a lead: you're the one who bumps Spring Boot across many services. Knowing *where* a version comes from tells you what an upgrade actually changes, and why a "no code change" bump can still break a build.

Answer in your own words, 2-3 sentences per part, without opening the pom.

1. Your `pom.xml` lists `spring-boot-starter-webmvc` with **no `<version>`**. Who decides its version, and through which mechanism?
2. You bump `spring-boot-starter-parent` from one 4.1.x to the next. What happens to **all** your starters and their transitive jars, and what's the one risk you'd check before merging?
3. `runtime` vs `provided` scope: on which classpath (compile, test, packaged jar) is each jar present? Give one Ledgerly example of each.

Not sure where to start? Write one line per part first ("the version comes from ___ via ___", "a bump changes ___; I'd check ___", "runtime = ___ / provided = ___"), then expand. Stuck for 15 minutes? Ask for a hint.

### 🌱 2. Chapter 2 Task 1 (optional, 15 min)

Same as [day23.md](day23.md#-2-chapter-2-task-1-optional-15-min): `GET /status` → `200`, plain text `Ledgerly is open`; `POST /status` → `405`.

> [!WARNING]
> Ask first: *what does Spring already do for an unmapped method?* `task1c` needs **no** code of its own.

### 🧩 DSA · 🐞 Buggy · 🔁 Redos: resting today

| Track | Open item (unchanged) | Status | Returns when |
|---|---|---|---|
| 🧩 DSA | `DailyTemperatures` ✅ 18/18; next Stack problem not assigned yet (pseudocode-first habit is the focus when it comes) | ✅ / ⬜ next | the day after the second push day |
| 🐞 Buggy | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII for `[2,1,2]` | 🟡 IN_PROGRESS | with the normal plan |
| 🔁 Redos | none assigned today (on hold on one-slot days). Most overdue next: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` | ⬜ | first normal day |

### 📦 Carried backlog (not for today)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open | 🧩 | 🟡 IN_PROGRESS |
| 2 | B2 interview Q3 and Q6, plus "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED |
| 3 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 4 | `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED |
| 5 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 6 | HTTP semantics / `ResponseEntity` / `@PathVariable` weak pack (🔴) | 🌱 | parked until Chapter 2 with the normal plan |

- [x] Chapter 1 interview question answered in chat
- [x] (optional) Chapter 2 Task 1 pushed on `my-solutions`

## 🎤 Chapter 1 interview grade (~8:07-8:15 AM IST)

![Score](https://img.shields.io/badge/interview-7%2F10-yellow) ![Chapter](https://img.shields.io/badge/Chapter%201-closed-brightgreen) ![Spring](https://img.shields.io/badge/Spring%20stays-8%2F10-blue)

> [!NOTE]
> Graded in chat on Sun 15 Nov, ~8:07-8:15 AM IST, on tip `7325500`. No new student commit. Labs tasks already **19/19** on `4384b9c`, so with this answer **Chapter 1 is ✅ closed**. Spring score stays **8/10** (the 12 Nov late re-check). A chat answer is **not** a push day; the second push day is still needed before the normal plan returns (redos `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` come back on the first normal day after it).

| Part | First answer | After hint / correction | Result |
|---|---|---|---|
| 1. Who picks the starter version when the pom writes none? | "Parent dependency" | After a hint, named the **BOM** (`spring-boot-dependencies`, inherited into `<dependencyManagement>`) | ✅ correct with a hint |
| 2. What a `spring-boot-starter-parent` bump changes, and the risk to check | Half: "all other dependencies will get downloaded with respect to the parent version as a jar" | After a hint: code that depends on a library can break when that library's version moves; run the unit tests before merging | ✅ correct with a hint. Coaching add: also read the release notes, or run `mvn dependency:tree`, to see which versions actually changed |
| 3. `runtime` vs `provided` classpaths, plus one Ledgerly example each | ❌ Reversed: said `provided` is on compile, test and the packaged jar, and `runtime` is only on the packaged jar | After a corrected grid: **H2** = `runtime` (no compile-time import; needed when the app runs), **Tomcat** = `provided` (the server already has it, so leave it out of a WAR) | ✅ correct after a correction |

Correct classpath picture used in the review:

```
             compile   test   packaged jar
provided       ✅        ✅        ❌   (the server already has it)
runtime        ❌        ✅        ✅   (needed only when the app runs)
```

> [!IMPORTANT]
> **Interview 7/10.** All three parts were reached, but part 3 needed a correction and parts 1 and 2 needed hints. Weak-topic note: **Maven dependency scopes (the classpath grid)** — revisit briefly, no pack (🟡 Moderate, not 🔴 Weak). Next push: Chapter 2 **Task 1** on `my-solutions` (`GET /status` → 200, `Ledgerly is open`; `POST /status` → 405 is already handled by Spring).

## 🌱 Chapter 2 Task 1 grade (`1ded3b3`, 8:35 AM IST)

![Score](https://img.shields.io/badge/Task%201-9%2F10-brightgreen) ![Ch2](https://img.shields.io/badge/Ch2-3%2F19-yellow) ![Push day](https://img.shields.io/badge/push%20day-2%20of%202-brightgreen)

> [!NOTE]
> Graded on tip `1075608`. Student push on [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) `my-solutions` `1ded3b3` (15 Nov, 8:35 AM IST, "completed chapter2- task 1"). Only file changed: `AccountController.java` — `@GetMapping("/status")` returns `"Ledgerly is open"`. Verified: `Chapter01CheckTest` **19/19**; `Chapter02CheckTest` **3/19** (`task1a`, `task1b`, `task1c` all green). `POST /status` → 405 from Spring's default, with **no** extra handler. Tasks 2-6 not started; first fail is `task2a_list` (`GET /accounts` → 404).

### 📝 Score (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot (Task 1) | **9/10** (concept 9 · implementation 10 · debugging n/a) | The mapped `GET` is exact (200, plain text `Ledgerly is open`), and `task1c` was left to Spring — the first unprompted "check Spring defaults first" win, after the Drill 1 catch-all habit. No debugging dimension: the three Task 1 checks were green on this push |

> [!TIP]
> This is the habit we wanted on 405: check what Spring already does before writing a handler. Hold onto that for Task 2 onward.

> [!IMPORTANT]
> This is the **second push day** (the first was 12 Nov). The normal 2-hour plan returns **Mon 16 Nov**, and the evening starts with redos `ScoreOfParentheses` + `RemoveKAdjacentDuplicates`. Next labs item: Chapter 2 **Task 2** (`GET /accounts`).
