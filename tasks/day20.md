# 📅 Day 20 (Wed 11 Nov): one must-do (labs Ch 1 Task 1) · everything else optional

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-20-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-15%20min%20must%20%2B%20optional-yellow) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> A lighter day. Nothing was pushed on 8, 9 or 10 Nov (last student code `3019054`, 7 Nov 14:11 IST), so every track carries its open item and **nothing new is added**. Today has **one must-do**: `spring-boot-labs` Chapter 1 **Task 1** (three lines: the project's coordinates), pushed on a new `my-solutions` branch **within 15 minutes, by 6:20 AM, even if red**. ✅ Done when `task1a`, `task1b` and `task1c` are green on your pushed branch. Everything else on this page is optional.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` on **both** repos first.
>
> Re-run at 6 AM on tip `9e7058c` (JDK 21): `mvn test` **514 run, 46 red**, and the 46 are exactly `DailyTemperaturesTest` **0/18**, `ValidParenthesesRedoNov08Test` **0/18**, `MinStackRedoNov01Test` **0/10**; everything else green. Labs: still only `main` `507aaa3`, no `my-solutions` branch; `Chapter01CheckTest` **1/19** (only `task6d` passes on the untouched file).

> [!WARNING]
> **Correction to day16-day19:** they called Task 1 "the parent". In the chapter README and in `lab/pom.xml`, **Task 1 is the coordinates** (`com.ledgerly : ledgerly-core : 0.1.0-SNAPSHOT`) and **Task 2 is the parent**. Today's must-do is the coordinates: a smaller first step than the one carried all week.

## 🌅 Morning

### ⏱️ Time plan (15 min must-do + up to 75 min optional)

| Minutes | Track | Item | Must? | Push it |
|---|---|---|---|---|
| 0-15 | 🌱 | **labs Ch 1 Task 1**: change three lines (`groupId`, `artifactId`, `version`) on a new `my-solutions` branch | **must** | **yes, by 6:20 AM, even if red** |
| 15-45 | 🌱 | labs Ch 1 Task 2 (parent), then Tasks 3-6 if they flow | optional | after each task |
| 45-65 | 🧩 | `DailyTemperatures`: 2-line brute force + 3-5 lines of plain-English pseudocode as comments (no Java yet) | optional | yes, even if red |
| 65-75 | 🐞 | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII (chat) | optional | chat |
| 75-90 | Buffer | `mvn test`, push leftovers | optional | yes |

> [!TIP]
> If you stop after the first 15 minutes, today still counts: one green push restarts the chain. Stuck for **15 minutes** on anything? Ask for a hint in chat instead of pushing on alone.

## 1️⃣ 🌱 spring-boot-labs Chapter 1: Maven and the pom.xml

![Status](https://img.shields.io/badge/status-NOT__STARTED-lightgrey) ![Checks](https://img.shields.io/badge/Chapter01CheckTest-1%2F19-orange)

> [!IMPORTANT]
> Repo: [`PrashantSury/spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · chapter: [`chapters/01-maven-and-the-pom/`](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom) · edit **one file**: `lab/pom.xml`. Must-do done when `task1a_groupId`, `task1b_artifactId`, `task1c_version` are green on pushed `my-solutions`. Chapter ✅ when `mvn -pl chapters/01-maven-and-the-pom test` is **19/19** and the interview question is graded. Full step table, traps and question: [day16.md § Chapter 1](day16.md#2--spring-boot-labs-chapter-1-maven-and-the-pomxml-50-min) (read its task numbers with the correction above).

Why the coordinates matter for a lead: `groupId : artifactId : version` is the address every other build, the artifact repository and the dependency tree use for this service. Leave the scaffold's `com.example : demo` in and two services clash in Nexus, a `-SNAPSHOT` decides whether a consumer gets a moving or a pinned build, and a release pipeline that bumps the version can't find it.

```bash
cd spring-boot-labs && git pull && git switch -c my-solutions
# edit chapters/01-maven-and-the-pom/lab/pom.xml: the three lines under "Task 1" only
mvn -pl chapters/01-maven-and-the-pom test     # expect task1a/b/c green, the rest red
git add -A && git commit -m "Ch1 task 1" && git push -u origin my-solutions
```

| Task | What | Checks | Must today? |
|---|---|---|---|
| 1 | Coordinates → `com.ledgerly : ledgerly-core : 0.1.0-SNAPSHOT` (only the three lines directly under `<project>`) | `task1a-c` | **yes** |
| 2 | Parent `spring-boot-starter-parent`, three-number version from the root `pom.xml`, empty `relativePath`, placed **before** your `groupId` | `task2a-e` | optional |
| 3 | `java.version` 17 → 21 in the existing `<properties>` | `task3` | optional |
| 4 | `spring-boot-starter-webmvc`, no version, no scope (+ interview Q) | `task4a-d` | optional |
| 5 | `spring-boot-starter-webmvc-test` scope `test`; `h2` scope `runtime`; no versions | `task5a-b` | optional |
| 6 | `uat` profile, last in `<project>`, sets `spring-boot.run.profiles` inside the profile | `task6a-d` | optional |

- [ ] **Task 1** pushed on `my-solutions` by 6:20 AM (three checks green)
- [ ] (optional) Task 2, then Tasks 3-6, checks after each, push → aim **19/19**
- [ ] (optional) Interview Q in 2-3 sentences in chat: who picks the starter's version, what an upgrade changes, `runtime` vs `provided`

> [!WARNING]
> Task 1 is **only** the project's own three lines, not anything inside a `<parent>` or a dependency. Read each task comment in `lab/pom.xml` fully before editing; the comments are the spec. Chapter 2 opens only after Chapter 1 is ✅. Banking module 1 / Drills 2-3 stay **parked**.

## 2️⃣ 🧩 Daily Temperatures (carried Stack, optional today)

![Status](https://img.shields.io/badge/status-IN__PROGRESS%20(stub)-yellow) ![Tests](https://img.shields.io/badge/DailyTemperaturesTest-0%2F18-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` · `mvn test -Dtest=DailyTemperaturesTest` (18). ✅ Done when all 18 pass on your pushed code, with pattern / time / space comment lines that each say where the cost comes from. Full 8-part spec (optimised part collapsed): [day16.md § Daily Temperatures](day16.md#3--daily-temperatures-carried-stack-35-min). It blocks the next Stack problem.

Today's slice is **comments only**, no Java:

- [ ] Brute force in 2 lines of English, as a comment.
- [ ] In a comment: on `[75, 71, 69, 72]`, which earlier days get re-scanned when you reach `72`? What would let you stop re-scanning them?
- [ ] 3-5 lines of plain-English pseudocode. **Push** (it will be red; that is fine).
- [ ] Java, the three comment lines (pattern, time, space, one reason each) and **18/18** wait for the next slot unless the pseudocode came easily.

## 3️⃣ 🐞 `Day04LargestRectangle`: empty-stack width (optional, chat)

Code is ✅ 36/36 (`d8306e2`); symptom table and `[2, 1, 2]` trace graded supported (7 Nov). Still open:

- [ ] One sentence: when you pop a bar, which index is its **left** limit and which its **right** limit, and therefore why width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise.
- [ ] A 3-line ASCII of `[2, 1, 2]` marking the left/right limits for the bar of height `1`.

> [!CAUTION]
> No code change and no new buggy round. A new Stack buggy round waits until this sentence is graded 7+.

## 🔁 Due redos (evening, cap 2, optional on a light day)

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov08.java` (blank) | `mvn test -Dtest=ValidParenthesesRedoNov08Test` (0/18) | +1 repeated | 20-30 min, cold |
| 🧩 `MinStack` | `src/main/java/com/prashant/dailytests/redo/MinStackRedoNov01.java` (untouched stub) | `mvn test -Dtest=MinStackRedoNov01Test` (0/10) | +1 | 20-30 min, cold |

- [ ] Each redo starts with a pattern line + time and space comment lines, before any code. Do **not** open `ValidParenthesesRedoNov01`, `dsa/stack/ValidParentheses` or `dsa/stack/MinStack`. Push at the end, even if red.
- [ ] If the evening has room for only one, do `ValidParenthesesRedoNov08` (most overdue, 🔶 re-queue).

No new redo stubs: both files exist and are still blank. If neither is done tonight, the 10 PM check moves them again and `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` slide from Thu 12 Nov ([redo-schedule.md](../revision/redo-schedule.md)).

## 📦 Carried backlog (not for this morning)

| Item | Track | Status | When |
|---|---|---|---|
| labs Ch 1 Tasks 2-6 + interview Q | 🌱 | ⬜ NOT_STARTED | after Task 1 lands |
| `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) merge or close | 🧩 | 🟡 IN_PROGRESS | buffer / chat |
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| `Day00BuggyExample` symptom groups | 🐞 | 🟡 IN_PROGRESS | backlog |

> [!NOTE]
> 🧭 Pace: the offer from the 10 Nov review stands. If no push lands by tonight's review, the plan switches to a **one-slot day** (one 45-minute block, one item) until pushes restart, unless you reply with the shape you want.

## 🌙 Evening (11 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-45%20min%20max-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `fae7a26` (JDK 21.0.13, Maven). No student commits after the 6 AM session; last student code is still `3019054` (7 Nov 14:11 IST). No answers in chat today to grade. Full `mvn test`: **514 run, 46 red**, and the 46 are exactly the three untouched stubs: `DailyTemperaturesTest` **0/18**, `ValidParenthesesRedoNov08Test` **0/18**, `MinStackRedoNov01Test` **0/10**. Everything else is green. [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs): still only `main` `507aaa3`, no `my-solutions` branch, so the one must-do (Task 1, the coordinates) did not land. **No new conceptual mistake** logged. No redo graded, so [redo-schedule.md](../revision/redo-schedule.md) rows are unchanged; both redos are still due tonight.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | No labs push and no Chapter 1 interview answer. Sixth assigned morning (6–11 Nov) with Chapter 1 still at 1/19. Last scored Spring night: 5 Nov (7/10). No number without work |
| 🧩 DSA | **unscored** (⬜ Pending) | `DailyTemperatures` still the 0/18 stub; no chat answers. Last scored DSA night: 7 Nov (6/10) |
| 🐞 Buggy | **unscored** (⬜ Pending) | No empty-stack width sentence or ASCII. Last scored buggy night: 7 Nov (7/10) |

> [!WARNING]
> Fourth day in a row with no student work (8–11 Nov), including the lighter one-must-do day. As promised at the 10 Nov review, the plan now switches to a **one-slot day**: from Thu 12 Nov, one 45-minute block with **one** item, until pushes restart. Reply in chat with a different shape (other time, other length, a pause for a few days) and the plan follows that instead.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 `spring-boot-labs` Chapter 1 (Maven / pom) | ⬜ Pending | sixth morning, no push, no graded Q |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | Day 02–03 scores; packs stay parked until labs Ch 1 lands |
| 🧩 `DailyTemperatures` | ⬜ Pending | stub 0/18; blocks the next Stack problem |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | written merge pending |
| 🔁 `ValidParentheses` redo (`ValidParenthesesRedoNov08`) | ⬜ Pending | 0/18, due tonight |
| 🔁 `MinStack` redo | ⬜ Pending | 0/10, due tonight |
| 🐞 `Day04LargestRectangle` empty-stack width | 🟡 Moderate / ⬜ Pending sentence | geometric why still open |
| 🐞 `Day00BuggyExample` write-up | 🟡 Pending | code 10/10; no symptom groups |
| 🏦 Banking module 1 / Drills 2–3 | ⬜ Pending, **parked** | unchanged |
| ⛔ Blocked | none | nothing outside his control is stopping the work |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack.

### ⏳ Tonight's evening-slot work (finishable; push after each)

> [!IMPORTANT]
> One item is enough tonight. If you have 15 minutes, do item 1 and stop.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 15 | `spring-boot-labs` Chapter 1 **Task 1** (three lines: `com.ledgerly : ledgerly-core : 0.1.0-SNAPSHOT`) on a new `my-solutions` branch | 🌱 | branch pushed, `task1a-c` green |
| 2 | if time | Cold `ValidParenthesesRedoNov08` (3 comment lines first; don't open the Nov01 file) | 🔁 | pushed; target 18/18 |

Everything else on today's page (Tasks 2–6, `DailyTemperatures` pseudocode, width sentence, `MinStackRedoNov01`) waits; none of it is expected tonight.

- [ ] labs Ch 1 Task 1 pushed on `my-solutions`
- [ ] (if time) `ValidParenthesesRedoNov08` pushed

### 🎯 Tomorrow's focus (Thu 12 Nov): one-slot day, from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | **The single item**: Chapter 1 Task 1 (coordinates) on `my-solutions`, then Task 2 (parent) only if the block has time left | six mornings unused; one green push restarts the chain |
| 🧩 DSA | Rests. `DailyTemperatures` pseudocode returns once one labs push has landed | one item a day until pushes restart |
| 🐞 Buggy | Rests. Width sentence stays open in the backlog | same |
| 🔁 Redos | No redo is due on a one-slot day; the 10 PM check moves the queue (ValidParen Nov08 first) | cap 2 still applies once the normal plan resumes |
| 🧭 Pace | One 45-minute block, one item, until two days with a push; then back to the lighter plan | four days with no work; a plan he can finish beats one he can't start |

> [!TIP]
> Reply in chat when something is pushed, when you want an answer graded, or with the pace that fits this week. Each answer is graded and recorded the same night.

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Pushes](https://img.shields.io/badge/student%20pushes%20today-0-lightgrey)

> [!NOTE]
> 10 PM check on tip `18c09e3` (the evening review itself). No student commits after the 8 PM review and none all day; last student code is still `3019054` (7 Nov 14:11 IST). No answers in chat to grade, so nothing new to test and every suite stands as re-run at the evening review. No new conceptual mistake and no cosmetic fix needed.

| Item | Track | Outcome | Status |
|---|---|---|---|
| `spring-boot-labs` Chapter 1 Task 1 (coordinates) | 🌱 | no push (still `main` `507aaa3`, no `my-solutions`) | ⬜ NOT_STARTED |
| `DailyTemperatures` | 🧩 | not attempted, 0/18 | 🟡 IN_PROGRESS (stub) |
| LargestRectangle empty-stack width sentence + ASCII | 🐞 | not answered | 🟡 IN_PROGRESS |
| `CarFleet` single-pair follow-up / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🧩 | not answered; PR still open | 🟡 IN_PROGRESS |
| 🔁 `ValidParenthesesRedoNov08` | 🔁 | not attempted, 0/18 → on hold, earliest **Sat 14 Nov** | ⬜ NOT_STARTED |
| 🔁 `MinStackRedoNov01` | 🔁 | not attempted, 0/10 → on hold, earliest **Sat 14 Nov** | 🟡 IN_PROGRESS (stub) |

> [!IMPORTANT]
> **First task tomorrow (Thu 12 Nov, one-slot day):** `git pull` both repos, then `spring-boot-labs` Chapter 1 **Task 1** (the coordinates: `com.ledgerly : ledgerly-core : 0.1.0-SNAPSHOT`, the three lines directly under `<project>`) on a new `my-solutions` branch, and **push it even if red**. That is the only item for the 45-minute block; Task 2 (the parent) only if time is left. DSA, buggy and redos rest until pushes restart ([redo-schedule.md](../revision/redo-schedule.md)).
