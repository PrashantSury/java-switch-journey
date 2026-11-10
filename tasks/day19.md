# 📅 Day 19 (Tue 10 Nov): labs Ch 1 Task 1 · Daily Temperatures pseudocode · LargestRectangle width-why

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-19-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work. Nothing was pushed on 8 or 9 Nov (last student code `3019054`, 7 Nov 14:11 IST), so every track carries its open item and **nothing new is added**: no Chapter 2, no new Stack problem, no new buggy round, no new redo stubs. This is the **fifth morning** for labs Ch 1 and Daily Temperatures. Today's rule: **one push in the first 15 minutes** (labs Task 1, before 6:20 AM, even if red). Everything after that is a bonus.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` on **both** repos first (`java-switch-journey` and [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs)). Re-run at 6 AM on tip `23af947` (JDK 21): `mvn test` **514 run, 46 red**, and the 46 are exactly `DailyTemperaturesTest` **0/18**, `ValidParenthesesRedoNov08Test` **0/18**, `MinStackRedoNov01Test` **0/10**; everything else green. Labs: still only `main` `507aaa3`, no `my-solutions` branch.

## 🌅 Morning

### ⏱️ Time plan (120 min)

| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-15 | 🌱 | **labs Ch 1 Task 1 only** (the parent) on a new `my-solutions` branch | **yes, before 6:20 AM, even if red** |
| 15-55 | 🌱 | labs Ch 1 Tasks 2-6, then the interview Q out loud | yes, after each task; aim **19/19** |
| 55-90 | 🧩 | **Daily Temperatures**: 2-line brute force + 3-5 lines of stack pseudocode as comments, then Java | yes, even if red |
| 90-105 | 🐞 | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII (chat) | chat |
| 105-120 | Buffer | `mvn test`, push leftovers | yes |

> [!TIP]
> Ask for a hint after **15 minutes** on any step. Ch 1 habit (same as Drill 1): before adding a tag, ask **what the parent already gives you**, then add only what is missing.

## 1️⃣ 🌱 spring-boot-labs Chapter 1: Maven and the pom.xml (~55 min)

![Status](https://img.shields.io/badge/status-NOT__STARTED-lightgrey) ![Checks](https://img.shields.io/badge/Chapter01CheckTest-1%2F19-orange)

> [!IMPORTANT]
> Repo: [`PrashantSury/spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · chapter: [`chapters/01-maven-and-the-pom/`](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom) · edit **one file**: `lab/pom.xml`. ✅ Done when `mvn -pl chapters/01-maven-and-the-pom test` is **19/19** on your pushed `my-solutions` branch and the interview question is graded. Full step table, traps and question: [day16.md § Chapter 1](day16.md#2--spring-boot-labs-chapter-1-maven-and-the-pomxml-50-min) (unchanged).

```bash
cd spring-boot-labs && git pull && git switch -c my-solutions
# edit chapters/01-maven-and-the-pom/lab/pom.xml: Task 1 only, then
mvn -pl chapters/01-maven-and-the-pom test
git add -A && git commit -m "Ch1 task 1" && git push -u origin my-solutions
```

Why it matters for a lead: when a Spring Boot upgrade PR lands, the parent's dependency management decides which versions of a hundred jars move with it. Reading a `pom.xml` and knowing what the parent pins, and which scope keeps a jar out of the production artifact, is how you approve that PR without guessing.

- [ ] Task 1 (parent) pushed on `my-solutions` **before 6:20 AM**, even if red
- [ ] Tasks 2-6 (coordinates, `java.version=21`, web starter, test + h2 scopes, `uat` profile), checks after each, push → **19/19**
- [ ] Interview Q in 2-3 sentences, then in chat for grading: who picks the starter's version, what an upgrade changes, `runtime` vs `provided`

> [!WARNING]
> The task comments inside `lab/pom.xml` are the spec; read each one fully before editing. Banking module 1 / Drills 2-3 stay **parked**. Chapter 2 opens only after Chapter 1 is ✅.

## 2️⃣ 🧩 Daily Temperatures (carried Stack, ~35 min)

![Status](https://img.shields.io/badge/status-IN__PROGRESS%20(stub)-yellow) ![Tests](https://img.shields.io/badge/DailyTemperaturesTest-0%2F18-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` · `mvn test -Dtest=DailyTemperaturesTest` (18). ✅ Done when all 18 pass on your pushed code, with pattern / time / space comment lines that each say where the cost comes from. Full 8-part spec (optimised part collapsed): [day16.md § Daily Temperatures](day16.md#3--daily-temperatures-carried-stack-35-min). It blocks the next Stack problem.

- [ ] Brute force in 2 lines of English, as a comment.
- [ ] In a comment: on `[75, 71, 69, 72]`, which earlier days get re-scanned when you reach `72`? What would let you stop re-scanning them?
- [ ] 3-5 lines of plain-English pseudocode, **push** (even if red), **then** Java.
- [ ] Three comment lines (pattern, time, space), one reason sentence each.
- [ ] `mvn test -Dtest=DailyTemperaturesTest` → **18/18**. Push.

## 3️⃣ 🐞 `Day04LargestRectangle`: empty-stack width (~15 min, chat)

Code is ✅ 36/36 (`d8306e2`); symptom table + `[2, 1, 2]` trace were graded in chat on 7 Nov (supported). The one open part:

- [ ] One sentence: when you pop a bar, which index is its **left** limit and which is its **right** limit, and therefore why width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise.
- [ ] A 3-line ASCII of `[2, 1, 2]` marking the left/right limits for the bar of height `1`.

> [!CAUTION]
> No code change and no new buggy round today. A new Stack buggy round waits until this sentence is graded 7+.

## 🔁 Due redos (evening, cap 2)

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov08.java` (blank) | `mvn test -Dtest=ValidParenthesesRedoNov08Test` (0/18) | +1 repeated | 20-30 min, cold |
| 🧩 `MinStack` | `src/main/java/com/prashant/dailytests/redo/MinStackRedoNov01.java` (untouched stub) | `mvn test -Dtest=MinStackRedoNov01Test` (0/10) | +1 | 20-30 min, cold |

- [ ] Each redo starts with a pattern note + time/space comment lines, before code. Do **not** open `ValidParenthesesRedoNov01`, `dsa/stack/ValidParentheses` or `dsa/stack/MinStack`. Push at the end, even if red.

No new redo stubs: both files already exist and are still blank. `ScoreOfParentheses` and `RemoveKAdjacentDuplicates` stay queued for **11 Nov** ([redo-schedule.md](../revision/redo-schedule.md)).

## 📦 Carried backlog (not for this morning)

| Item | Track | Status | When |
|---|---|---|---|
| `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) merge or close | 🧩 | 🟡 IN_PROGRESS | buffer / chat |
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| `Day00BuggyExample` symptom groups | 🐞 | 🟡 IN_PROGRESS | backlog |

## 🌙 Evening (10 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-60%20min-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `dc71902` (JDK 21, Maven). No student commits after the 6 AM session; last student code is still `3019054` (7 Nov 14:11 IST). No answers in chat today to grade. Full `mvn test`: **514 run, 46 red**, and the 46 are exactly the three untouched stubs: `DailyTemperaturesTest` **0/18**, `ValidParenthesesRedoNov08Test` **0/18**, `MinStackRedoNov01Test` **0/10**. Everything else is green. [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs): still only `main` `507aaa3`, no `my-solutions` branch. **No new conceptual mistake** logged. No redo graded, so [redo-schedule.md](../revision/redo-schedule.md) rows are unchanged; both redos are still due tonight.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | No labs push and no Chapter 1 interview answer. Fifth assigned morning (6–10 Nov) with Chapter 1 still at 1/19. Last scored Spring night: 5 Nov (7/10). No number without work |
| 🧩 DSA | **unscored** (⬜ Pending) | `DailyTemperatures` still the 0/18 stub; no chat answers. Last scored DSA night: 7 Nov (6/10) |
| 🐞 Buggy | **unscored** (⬜ Pending) | No empty-stack width sentence or ASCII. Earlier suites stand but don't earn a score today. Last scored buggy night: 7 Nov (7/10) |

> [!WARNING]
> Third day in a row with no student work (8, 9 and 10 Nov). The plan isn't the blocker; time or energy for it is. Rather than carry the full 2 h + 1 h plan again, the offer stands to **slow the pace** (for example, one 45-minute slot a day for a week) until pushes restart. Say which shape fits and the plan changes tomorrow morning.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 `spring-boot-labs` Chapter 1 (Maven / pom) | ⬜ Pending | fifth morning, no push, no graded Q |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | Day 02–03 scores; packs stay parked until labs Ch 1 lands |
| 🧩 `DailyTemperatures` | ⬜ Pending | stub 0/18; blocks the next Stack problem |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | written merge pending |
| 🔁 `ValidParentheses` redo (`ValidParenthesesRedoNov08`) | ⬜ Pending | 0/18, due tonight |
| 🔁 `MinStack` redo | ⬜ Pending | 0/10, never redone since 23 Oct; due tonight |
| 🐞 `Day04LargestRectangle` empty-stack width | 🟡 Moderate / ⬜ Pending sentence | geometric why still open |
| 🐞 `Day00BuggyExample` write-up | 🟡 Pending | code 10/10; no symptom groups |
| 🏦 Banking module 1 / Drills 2–3 | ⬜ Pending, **parked** | unchanged |
| ⛔ Blocked | none | nothing outside his control is stopping the work |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack.

### ⏳ Tonight's evening-slot work (finishable; push after each)

> [!IMPORTANT]
> If you have only 15 minutes, do item 1 and stop. Cap **2** redos.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 15 | `spring-boot-labs` Chapter 1 **Task 1 only** on a new `my-solutions` branch | 🌱 | branch pushed, even if red |
| 2 | 20 | `DailyTemperatures`: 2-line brute force + 3–5 lines of stack pseudocode as comments | 🧩 | pushed, even if red |
| 3 | 10 | Empty-stack width sentence + 3-line ASCII for `[2,1,2]` (chat) | 🐞 | graded 7+ |
| 4 | if time | Cold `ValidParenthesesRedoNov08` (3 comment lines first; don't open the Nov01 file) | 🔁 | pushed; target 18/18 |
| 5 | if time | Cold `MinStackRedoNov01` (3 comments + pseudocode first) | 🔁 | pushed; target 10/10 |

- [ ] labs Ch 1 Task 1 pushed on `my-solutions`
- [ ] `DailyTemperatures` pseudocode pushed
- [ ] Width sentence + ASCII in chat
- [ ] (if time) `ValidParenthesesRedoNov08` pushed
- [ ] (if time) `MinStackRedoNov01` pushed

### 🎯 Tomorrow's focus (Wed 11 Nov), from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | Chapter 1 Task 1 as the **only must-do** of the morning (push before 6:20 AM), Tasks 2-6 as bonus | five mornings unused; the first step must be tiny |
| 🧩 DSA | `DailyTemperatures` pseudocode push; Java only after it | stub 0/18; blocks the next Stack problem |
| 🐞 Buggy | No new round. Width sentence + ASCII if not graded tonight | the last open debugging-depth item |
| 🔁 Redos (evening) | If tonight's two are still open, the 10 PM check moves them again ahead of `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` | no redo graded; cap 2, most overdue first |
| 🧭 Pace | If no push lands by tomorrow's review, the plan switches to a lighter one-slot day unless you say otherwise | three days with no work; a smaller plan he can finish beats a full plan he can't start |

> [!TIP]
> Reply in chat when something is pushed or when you want an answer graded. Each answer is graded and recorded the same night.

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Pushes](https://img.shields.io/badge/student%20pushes%20today-0-lightgrey)

> [!NOTE]
> 10 PM check on tip `d311827` (the evening review itself). No student commits after the 8 PM review and none all day; last student code is still `3019054` (7 Nov 14:11 IST). No answers in chat to grade, so nothing new to test and every suite stands as re-run at the evening review. No new conceptual mistake and no cosmetic fix needed.

| Item | Track | Outcome | Status |
|---|---|---|---|
| `spring-boot-labs` Chapter 1 Task 1 | 🌱 | no push (still `main` `507aaa3`, no `my-solutions`) | ⬜ NOT_STARTED |
| `DailyTemperatures` | 🧩 | not attempted, 0/18 | 🟡 IN_PROGRESS (stub) |
| LargestRectangle empty-stack width sentence + ASCII | 🐞 | not answered | 🟡 IN_PROGRESS |
| `CarFleet` single-pair follow-up / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🧩 | not answered; PR still open | 🟡 IN_PROGRESS |
| 🔁 `ValidParenthesesRedoNov08` | 🔁 | not attempted, 0/18 → moves to **Wed 11 Nov** | ⬜ NOT_STARTED |
| 🔁 `MinStackRedoNov01` | 🔁 | not attempted, 0/10 → moves to **Wed 11 Nov** | 🟡 IN_PROGRESS (stub) |

> [!IMPORTANT]
> **First task tomorrow (Wed 11 Nov, 6 AM):** `git pull` both repos, then `spring-boot-labs` Chapter 1 **Task 1 only** (parent `spring-boot-starter-parent`) on a new `my-solutions` branch, and **push it before 6:20 AM, even if red**. That is the only must-do; Tasks 2-6, `DailyTemperatures` (pseudocode first) and the width sentence follow if there is time. Evening redos: `ValidParenthesesRedoNov08` then `MinStackRedoNov01` ([redo-schedule.md](../revision/redo-schedule.md), moved to 11 Nov).
