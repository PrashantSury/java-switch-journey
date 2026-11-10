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
