# 📅 Day 18 (Mon 9 Nov): labs Ch 1 Tasks 1-3 · Daily Temperatures · LargestRectangle width-why

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-18-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work. Nothing was pushed on 8 Nov (last student code `3019054`, 7 Nov 14:11 IST), so every track carries its open item and **nothing new is added**: no Chapter 2, no new Stack problem, no new buggy round. This is the **fourth morning** for labs Ch 1 and Daily Temperatures, so today's bar is deliberately small: **land one push on each repo before 7 AM**, even if red. A red push is progress; an empty morning is not.

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` on **both** repos first (`java-switch-journey` and [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs)). Re-run at 6 AM on tip `e480448` (JDK 21): `ValidParenthesesRedoNov01Test` 18/18, `ValidParenthesesTest` 2/2, `CarFleetTest` 37/37, `Day04LargestRectangleTest` 36/36, `Day00BuggyExampleTest` 10/10, `DailyTemperaturesTest` **0/18**, `ValidParenthesesRedoNov08Test` **0/18**, `MinStackRedoNov01Test` **0/10**. Labs `Chapter01CheckTest` **1/19** on `main` `507aaa3`; no `my-solutions` branch yet.

## 🌅 Morning

### ⏱️ Time plan (120 min)

| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-25 | 🌱 | **labs Ch 1 Tasks 1-3** (parent → coordinates → `java.version`) | **yes, on `my-solutions`, even if red** |
| 25-50 | 🌱 | labs Ch 1 Tasks 4-6 + interview Q out loud | yes → aim **19/19** |
| 50-85 | 🧩 | **Daily Temperatures** (0/18): brute force in 2 lines → pseudocode → Java | yes, even if red |
| 85-100 | 🐞 | `Day04LargestRectangle` empty-stack width: one sentence + 3-line ASCII (chat) | chat |
| 100-120 | Buffer | `mvn test`, push leftovers; `CarFleet` single-pair Q in chat if time | yes |

> [!TIP]
> Ask for a hint after **15 minutes** on any step. Ch 1 habit (same as Drill 1): before adding a tag, ask **what the parent already gives you**, then add only what is missing.

## 1️⃣ 🌱 spring-boot-labs Chapter 1: Maven and the pom.xml (~50 min)

![Status](https://img.shields.io/badge/status-NOT__STARTED-lightgrey) ![Checks](https://img.shields.io/badge/Chapter01CheckTest-1%2F19-orange)

> [!IMPORTANT]
> Repo: [`PrashantSury/spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · chapter: [`chapters/01-maven-and-the-pom/`](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom) · edit **one file**: `lab/pom.xml`. ✅ Done when `mvn -pl chapters/01-maven-and-the-pom test` is **19/19** on your pushed `my-solutions` branch and the interview question is graded. Full step table, traps and question: [day16.md § Chapter 1](day16.md#2--spring-boot-labs-chapter-1-maven-and-the-pomxml-50-min) (unchanged).

```bash
cd spring-boot-labs && git pull && git switch -c my-solutions
# edit chapters/01-maven-and-the-pom/lab/pom.xml, then after each task:
mvn -pl chapters/01-maven-and-the-pom test
git add -A && git commit -m "Ch1 tasks 1-3" && git push -u origin my-solutions
```

Why it matters for a lead: every "works on my machine, breaks in CI" dependency incident starts in the `pom.xml`. Knowing exactly which versions the parent's BOM pins, and which scope keeps a jar out of the production artifact, is what lets you approve a Spring Boot upgrade PR with confidence.

- [ ] Tasks 1-3 (parent first, then your coordinates, then `java.version=21`), checks after each, **push** even if red
- [ ] Tasks 4-6 (web starter, test + h2 scopes, `uat` profile), checks → **19/19**, push
- [ ] Interview Q in 2-3 sentences, then in chat for grading: who picks the starter's version, what an upgrade changes, `runtime` vs `provided`

> [!WARNING]
> The task comments inside `lab/pom.xml` are the spec; read each one fully before editing. Banking module 1 / Drills 2-3 stay **parked**. Chapter 2 opens only after Chapter 1 is ✅.

## 2️⃣ 🧩 Daily Temperatures (carried Stack, ~35 min)

![Status](https://img.shields.io/badge/status-IN__PROGRESS%20(stub)-yellow) ![Tests](https://img.shields.io/badge/DailyTemperaturesTest-0%2F18-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` · `mvn test -Dtest=DailyTemperaturesTest` (18). ✅ Done when all 18 pass on your pushed code, with pattern / time / space comment lines that each say where the cost comes from. Full 8-part spec (optimised part collapsed): [day16.md § Daily Temperatures](day16.md#3--daily-temperatures-carried-stack-35-min). It blocks the next Stack problem.

Start here, before opening any spec details:

- [ ] Brute force in 2 lines of English (for day `i`, scan right for the first warmer day).
- [ ] In a comment: on `[75, 71, 69, 72]`, which earlier days get re-scanned when you reach `72`? What would let you stop re-scanning them?
- [ ] 3-5 lines of plain-English pseudocode for the stack version, **then** Java.
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

No new redo stubs today: both files already exist and are still blank. `ScoreOfParentheses` and `RemoveKAdjacentDuplicates` stay queued for **10 Nov** ([redo-schedule.md](../revision/redo-schedule.md)).

## 📦 Carried backlog (not for this morning)

| Item | Track | Status | When |
|---|---|---|---|
| `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) merge or close | 🧩 | 🟡 IN_PROGRESS | buffer / chat |
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| `Day00BuggyExample` symptom groups | 🐞 | 🟡 IN_PROGRESS | backlog |
