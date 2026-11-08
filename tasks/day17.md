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

## 🌙 Evening (8 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-60%20min-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey)

> [!NOTE]
> Evening review at ~7:58 PM IST on tip `73a1fd7` (JDK 21, Maven). No student commits after the 6 AM session (`1af6500` + `73a1fd7`). Last student code is still `3019054` (7 Nov 14:11 IST). No answers in this chat today to grade. Re-ran: `ValidParenthesesRedoNov01Test` **18/18**, `ValidParenthesesTest` 2/2, `CarFleetTest` 37/37, `Day04LargestRectangleTest` 36/36, `Day00BuggyExampleTest` 10/10, `Day02RpnEvaluatorRedoNov01Test` 44/44, `DailyTemperaturesTest` **0/18**, `ValidParenthesesRedoNov08Test` **0/18**, `MinStackRedoNov01Test` **0/10**. No push on [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) (still `main` `507aaa3`, no `my-solutions` branch; `Chapter01CheckTest` last verified **1/19** this morning). **No new conceptual mistake** logged. No redo graded, so [redo-schedule.md](../revision/redo-schedule.md) is unchanged (both 8 Nov redos remain due tonight).

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | No student work today: no `my-solutions` push, no graded Chapter 1 interview Q, B2 Q3 / Q6 / catch-all sentence still unanswered. Banking module 1 / Drills 2–3 parked. Last scored Spring night was 5 Nov (7/10); 6–7 Nov were also unscored. Do not invent a number |
| 🧩 DSA | **unscored** (⬜ Pending) | No Daily Temperatures attempt (`DailyTemperaturesTest` still **0/18** stub). No chat answers. Cold `ValidParenthesesRedoNov08` still **0/18** and `MinStackRedoNov01` still **0/10**. Last scored DSA night was 7 Nov (6/10, on the post-feedback ValidParen 18/18). Suites that were already green were re-verified only (`ValidParenthesesRedoNov01Test` 18/18, `CarFleetTest` 37/37). Do not reuse yesterday's 6 as today's score |
| 🐞 Buggy | **unscored** (⬜ Pending) | No new buggy code and no empty-stack width sentence / ASCII in chat. `Day04LargestRectangleTest` **36/36** and `Day00BuggyExampleTest` **10/10** stand from earlier days. Last scored buggy night was 7 Nov (7/10, on the supported write-up). Width-why remains the open item |

> [!WARNING]
> Nothing from today can be marked ✅ `COMPLETED`. A track with no work is left unscored, not given yesterday's number again.

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 `spring-boot-labs` Chapter 1 (Maven / pom) | ⬜ Pending | third assigned morning, still no push and no graded Q |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | Day 02–03 scores; packs still ⬜ not generated — labs Ch 1 stays the Spring slot |
| 🧩 `DailyTemperatures` | ⬜ Pending | stub only (0/18); third morning unused |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | chat reasons closed; written merge pending |
| 🔁 `ValidParentheses` redo (`ValidParenthesesRedoNov08`) | ⬜ Pending | blank stub 0/18, not attempted as of this review; still due tonight |
| 🔁 `MinStack` redo | ⬜ Pending | stub 0/10, not attempted 6–8 Nov; still due tonight |
| 🐞 `Day04LargestRectangle` empty-stack width | 🟡 Moderate / ⬜ Pending sentence | table + `[2,1,2]` graded 7 Nov (supported); geometric why + ASCII still open |
| 🐞 `Day00BuggyExample` write-up | 🟡 Pending | code 10/10; no symptom groups |
| 🏦 Banking module 1 / Drills 2–3 | ⬜ Pending, **parked** | unchanged |
| ⛔ Blocked | none | — |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack. Carried Spring 🔴 Weak rows stay in [PROGRESS.md](../PROGRESS.md); do not insert them ahead of labs Ch 1.

### ⏳ Tonight's evening-slot work (finishable; push after each)

> [!IMPORTANT]
> The evening slot is the unfinished morning list, in that order. If the hour is running out, still land the most overdue redo (`ValidParenthesesRedoNov08`) before stopping — better one ladder step than two misses. Cap **2** redos.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 25 | `spring-boot-labs` Chapter 1 Tasks 1-3 on `my-solutions` (parent `4.1.2` before your own `groupId`, then coordinates, then `java.version=21`) | 🌱 | push even if checks red |
| 2 | 20 | `DailyTemperatures`: 3–5 lines plain-English pseudocode, then code (even if red) | 🧩 | push; aim 18/18 |
| 3 | 10 | Empty-stack width in one geometric sentence + 3-line ASCII for `[2,1,2]` (chat) | 🐞 | graded 7+ |
| 4 | if time | Cold `ValidParenthesesRedoNov08` (blank file; 3 comment lines first; do **not** open `ValidParenthesesRedoNov01` or `dsa/stack/ValidParentheses`) | 🔁 | push even if red; target 18/18 |
| 5 | if time | Cold `MinStackRedoNov01` (3 comments + pseudocode; do **not** open `dsa/stack/MinStack`) | 🔁 | push even if red; target 10/10 |

- [ ] labs Ch 1 Tasks 1-3 pushed on `my-solutions`
- [ ] `DailyTemperatures` pushed (even if red)
- [ ] Empty-stack width sentence + ASCII in chat
- [ ] (if time) `ValidParenthesesRedoNov08` pushed
- [ ] (if time) `MinStackRedoNov01` pushed

### 🎯 Tomorrow's focus (Mon 9 Nov), from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | `spring-boot-labs` Chapter 1 end-to-end (Tasks 1-6 + interview Q written); habit: ask what the parent already gives, then add only what is missing | unscored three nights (6–8 Nov); Ch 1 is still the whole Spring slot and still ⬜ |
| 🧩 DSA | Finish `DailyTemperatures` if not green tonight: monotonic stack of **indices**, reason sentences on pattern/time/space (push≤1 + pop≤1 → ≤2n) | stub still 0/18 after three assigned mornings; it blocks the next Stack problem |
| 🐞 Buggy | No new buggy round. Empty-stack width geometric sentence + ASCII if not graded tonight; Day00 symptom groups stay backlog | write-up table/trace already graded (supported); width-why is the remaining debugging-depth item |
| 🔁 Redos (evening) | If tonight's two are still open: **`ValidParenthesesRedoNov08`** then **`MinStackRedoNov01`**. If both land tonight: `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` as queued for 9 Nov | no redo was graded at this review; cap 2; most overdue first |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.

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
