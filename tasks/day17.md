# 📅 Day 17 (Sun 8 Nov): labs Ch 1 · Daily Temperatures · LargestRectangle width-why

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-17-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work. Nothing was pushed after the 7 Nov 10 PM check, so every track carries its open item and **nothing new is added**: no Chapter 2, no new Stack problem, no new buggy round. Morning = **spring-boot-labs Chapter 1** → **Daily Temperatures** → **LargestRectangle empty-stack width sentence**. Evening = two cold redos (`ValidParenthesesRedoNov08` on a **new blank file**, then `MinStackRedoNov01`). **Each step ends in a push, even if red.**

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🏦 banking · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` on **both** repos first (`java-switch-journey` and [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs)). Re-run at 6 AM on tip `795b269` (last student code `3019054`, 7 Nov 14:11 IST; JDK 21): `ValidParenthesesRedoNov01Test` 18/18, `ValidParenthesesTest` 2/2, `CarFleetTest` 37/37, `Day04LargestRectangleTest` 36/36, `Day00BuggyExampleTest` 10/10, `DailyTemperaturesTest` **0/18**, `MinStackRedoNov01Test` **0/10**. Labs `Chapter01CheckTest` **1/19** on `main` `507aaa3`; no `my-solutions` branch yet.

## 🌅 Morning

### ⏱️ Time plan (120 min)

| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-50 | 🌱 | **spring-boot-labs Chapter 1**: Maven and the `pom.xml`, Tasks 1-6 + interview Q out loud | yes, on `my-solutions` in that repo, after Task 3 and again at the end |
| 50-85 | 🧩 | **Daily Temperatures** (stub **0/18**): 3-5 lines of plain-English pseudocode first, then code | yes, even if red |
| 85-100 | 🐞 | `Day04LargestRectangle`: empty-stack width in **one geometric sentence** + a tiny ASCII for `[2, 1, 2]` (chat, no code) | chat |
| 100-110 | 🧩 | `CarFleet` single-pair follow-up in chat (if time) | chat |
| 110-120 | Buffer | `mvn test` and push leftovers | yes |

> [!TIP]
> Ask for a hint after **15 minutes** on any step. Chapter 1 habit (same as Drill 1): before adding a tag, ask what the parent / default scope already gives you, then add only what is missing.

## 1️⃣ 🌱 spring-boot-labs Chapter 1: Maven and the pom.xml (~50 min)

![Status](https://img.shields.io/badge/status-NOT__STARTED-lightgrey) ![Checks](https://img.shields.io/badge/Chapter01CheckTest-1%2F19-orange)

> [!IMPORTANT]
> Repo: [`PrashantSury/spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · chapter: [`chapters/01-maven-and-the-pom/`](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom) · edit **one file**: `lab/pom.xml`. ✅ Done when `mvn -pl chapters/01-maven-and-the-pom test` is green (**19/19**) on your pushed `my-solutions` branch and the interview question is graded. Full step table, traps and question: [day16.md § Chapter 1](day16.md#2--spring-boot-labs-chapter-1-maven-and-the-pomxml-50-min) (unchanged; assigned Day 15, not started).

```bash
cd spring-boot-labs && git pull && git switch -c my-solutions
# edit chapters/01-maven-and-the-pom/lab/pom.xml, then after each task:
mvn -pl chapters/01-maven-and-the-pom test
git add -A && git commit -m "Ch1 tasks 1-3" && git push -u origin my-solutions
```

- [ ] Tasks 1-3 (coordinates, parent, `java.version`), checks after each, **push** (even if red)
- [ ] Tasks 4-6 (web starter, test + h2 scopes, `uat` profile), checks → **19/19**, push
- [ ] Interview Q out loud in 2-3 sentences, then in chat for grading: who picks the starter's version, what an upgrade changes, `runtime` vs `provided`

> [!WARNING]
> The task comments inside `lab/pom.xml` are the spec. Read each one fully before editing; the chapter README lists the traps. Banking module 1 / Drills 2-3 stay **parked**. Chapter 2 is not opened until Chapter 1 is ✅.

## 2️⃣ 🧩 Daily Temperatures (carried Stack, ~35 min)

![Status](https://img.shields.io/badge/status-IN__PROGRESS%20(stub)-yellow) ![Tests](https://img.shields.io/badge/DailyTemperaturesTest-0%2F18-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` · `mvn test -Dtest=DailyTemperaturesTest` (18). ✅ Done when all 18 pass on your pushed code, with pattern / time / space comment lines that each say where the cost comes from. Full 8-part spec (optimised part collapsed): [day16.md § Daily Temperatures](day16.md#3--daily-temperatures-carried-stack-35-min). Third morning on this item; it blocks the next Stack problem.

Start here, before opening any spec details:

- [ ] Write the brute force in 2 lines of English (for day `i`, scan right for the first warmer day).
- [ ] Answer in a comment: on `[75, 71, 69, 72]`, which earlier days get re-scanned when you reach `72`? What would let you stop re-scanning them?
- [ ] 3-5 lines of plain-English pseudocode for the stack version, **then** Java.
- [ ] Three comment lines (pattern, time, space) with one reason sentence each.
- [ ] `mvn test -Dtest=DailyTemperaturesTest` → **18/18**. Push.

## 3️⃣ 🐞 `Day04LargestRectangle`: empty-stack width (~15 min, chat)

The code is ✅ 36/36 (`d8306e2`) and the symptom table + `[2, 1, 2]` trace were graded in chat on 7 Nov (supported). The one open part of this write-up:

- [ ] One sentence: when you pop a bar, which index is its **left** limit and which is its **right** limit, and therefore why width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise.
- [ ] A 3-line ASCII of `[2, 1, 2]` marking the left/right limits for the bar of height `1`.

> [!CAUTION]
> No code change and no new buggy round today. A new Stack buggy round waits until this sentence is graded 7+.

## 4️⃣ 🧩 `CarFleet` single-pair follow-up (if time, ~10 min)

- [ ] In chat: two cars, the one behind is faster. When do they count as one fleet, and why is a plain `double` division of time unsafe?
- [ ] Written reason sentences on `main` still wait on PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) (comment-only branch, open since 6 Nov). Merge it or tell me to close it.

## 🌙 Evening plan (60 min)

| Order | Item | Track |
|---|---|---|
| 1 | Review and score each track out of 10 | all |
| 2 | Finish whatever is pending from the morning, in the order above | all |
| 3 | 🔁 cold redos (cap 2): **`ValidParenthesesRedoNov08`** then **`MinStackRedoNov01`** | 🔁 |

### 🔁 Due redos tonight (cap 2)

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov08.java` (**new blank file**) | `mvn test -Dtest=ValidParenthesesRedoNov08Test` (18, 0/18 now) | +1 repeated (7 Nov pass was post-feedback 🔶) | 20-30 min, cold |
| 🧩 `MinStack` | `src/main/java/com/prashant/dailytests/redo/MinStackRedoNov01.java` (existing untouched stub) | `mvn test -Dtest=MinStackRedoNov01Test` (10, 0/10 now) | +1 (never redone since 23 Oct) | 20-30 min, cold |

- [ ] ValidParen: blank file, 3 comment lines (pattern / time / space) **before** code; do **not** open `ValidParenthesesRedoNov01` or `dsa/stack/ValidParentheses`. Clean cold 18/18 with no hint = step up to +3.
- [ ] MinStack: 3 comment lines + 3-5 lines of plain-English pseudocode; do **not** open `dsa/stack/MinStack`. Push at the end, even if red.

> [!WARNING]
> Why a new ValidParen file: the old `ValidParenthesesRedoNov01` already holds your 7 Nov answer, so redoing it there is not cold. Cap **2**: `ScoreOfParentheses` and `RemoveKAdjacentDuplicates` stay queued for **9 Nov** ([redo-schedule.md](../revision/redo-schedule.md)).

## 📦 Carried backlog (not for this morning unless listed above)

| Item | Track | Status | When |
|---|---|---|---|
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| `Day00BuggyExample` symptom groups | 🐞 | 🟡 IN_PROGRESS | backlog |
| Redos queued: `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` (**9 Nov**); `Day03NextGreaterIndex`, `AsteroidCollision` (**10 Nov**) | 🔁 | 🟡 IN_PROGRESS | [redo-schedule.md](../revision/redo-schedule.md) |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.
