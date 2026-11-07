# 📅 Day 16 (Sat 7 Nov): labs Ch 1 · Daily Temperatures · LargestRectangle write-up

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-16-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work. Every track still has unfinished items from Day 15, so **nothing new is added**: no new Stack problem, no new buggy round, no new labs chapter. Morning = carried write-up → **spring-boot-labs Chapter 1** → **Daily Temperatures**. Evening = finish the two due redos. **Each step ends in a push, even if red.**

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🏦 banking · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` on **both** repos first (`java-switch-journey` and [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs)). Suites on tip `03a1373` / last student code `ec608e3`: `Day00BuggyExampleTest` 10/10, `ValidParenthesesRedoNov01Test` **17/18** 🔶, `ValidParenthesesTest` 2/2, `CarFleetTest` 37/37, `DailyTemperaturesTest` **0/18**, `MinStackRedoNov01Test` **0/10**, `Day04LargestRectangleTest` 36/36. Labs Ch 1 stub still **1/19**. No push after the 6 Nov 10 PM check.

## 🌅 Morning

### ⏱️ Time plan (120 min)

| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-15 | 🐞 | `Day04LargestRectangle` symptom table + `[2, 1, 2]` hand trace (carried, **no code change**) | yes, first |
| 15-65 | 🌱 | **spring-boot-labs Chapter 1**: Maven and the `pom.xml` (6 tasks + interview Q out loud) | yes, on `my-solutions` in that repo |
| 65-100 | 🧩 | **Daily Temperatures** (stub **0/18**): 3-5 lines of plain-English pseudocode first, then code | yes, even if red |
| 100-110 | 🧩 | `CarFleet` single-pair follow-up in chat (if time; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) still open) | chat |
| 110-120 | Buffer | `mvn test` and push leftovers | yes |

> [!TIP]
> Ask for a hint after **15 minutes** on any step. Bring the Drill 1 habit into Chapter 1: before adding a tag, ask what the parent / scope / profile already gives you, then add only what is missing.

---

## 1️⃣ 🐞 `Day04LargestRectangle` write-up (15 min, **push first**)

The code is ✅ 36/36 (`d8306e2`). The localisation write-up was skipped on 5 Nov and again on 6 Nov. Spec and the failing-test table: [day14.md evening](day14.md#-debugging-write-up-for-day04largestrectangle-the-part-that-was-skipped). Full buggy rules: [day09.md](day09.md#-day04largestrectangle-buggy-round).

- [x] Symptom table + `[2, 1, 2]` hand trace **graded in chat** (7 Nov, **supported** — not cold-clean; sentinel rows corrected after feedback; max **3** accepted). Do not reassign as missing.
- [ ] One sentence: why width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise (**geometric** left/right bound + ASCII — still soft after tonight's review).
- [x] **No code change** required for the write-up (code already ✅ 36/36).

> [!CAUTION]
> Do not open a new buggy round today. This write-up is the open buggy-track item; new material waits until it is ✅.

---

## 2️⃣ 🌱 spring-boot-labs Chapter 1: Maven and the pom.xml (~50 min)

> [!IMPORTANT]
> Repo: [`PrashantSury/spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · chapter: [`chapters/01-maven-and-the-pom/`](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom) · edit **one file**: `lab/pom.xml`. ✅ Done when `mvn -pl chapters/01-maven-and-the-pom test` is green (**19/19**) and the interview question is answered out loud (then written under [interview-answers.md](../interview-answers.md)). Banking module 1 / Drills 2–3 stay **parked**.

| Step | What | Minutes |
|---|---|---|
| 0 | `git pull` (or clone) the labs repo; open `chapters/01-maven-and-the-pom/README.md` | 3 |
| 1 | Read Why / Coordinates / Parent / Scopes / Profiles (skim the trees) | 10 |
| 2 | Tasks 1-3: coordinates, parent `4.1.2`, `java.version=21`. Run checks after each | 15 |
| 3 | Tasks 4-6: web starter (no version), test starter + h2 scopes, `uat` profile | 15 |
| 4 | Interview Q out loud (2-3 sentences), then write it in chat / `interview-answers.md` | 5 |
| 5 | Push on a `my-solutions` branch (do **not** commit solutions on `main` of labs) | 2 |

**Interview question.** Who picks the version of `spring-boot-starter-webmvc` when you don't write one, and what happens to all your starters when you upgrade Spring Boot? Then: what is the difference between `runtime` and `provided`?

> [!WARNING]
> Traps from the chapter README: parent **before** your own `groupId`; three-number version `4.1.2` (not `4.1`); edit the existing `<properties>` (don't add a second); `<profiles>` at the end; no version on the starters.

---

## 3️⃣ 🧩 Daily Temperatures (carried Stack, ~35 min)

![Type](https://img.shields.io/badge/type-DSA%20Stack-blue) ![Tests](https://img.shields.io/badge/DailyTemperaturesTest-18-lightgrey) ![Stub](https://img.shields.io/badge/stub-0%2F18-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` · tests `DailyTemperaturesTest` (18). ✅ Done when all 18 pass on your pushed code, with pattern / time / space comment lines that each say where the cost comes from. Assigned Day 15; still untouched (`0/18`) — finish this before any new Stack problem.

### 1️⃣ Why it matters
A "next warmer day" story is the same shape as next-greater-element. Interviewers check two things: do you keep a **monotonic stack of indices** (so the answer is a distance), and can you defend the amortised O(n) cost in one sentence?

### 2️⃣ The variants
| Approach | Idea | Cost |
|---|---|---|
| Brute force | For each day `i`, scan `i+1..n-1` for the first warmer | O(n²) time, O(1) space |
| Monotonic decreasing stack of indices | Pop cooler-or-equal past days when a warmer day arrives; write `i - j` | O(n) time, O(n) space |

### 3️⃣ Worked example
`temperatures = [73, 74, 75, 71, 69, 72, 76, 73]` → `[1, 1, 4, 2, 1, 1, 0, 0]`.

### 4️⃣ Approach (brute force only — write this first)
For each index `i`, walk right until you find a value `> temperatures[i]`, else write 0. Then ask: which days get visited more than once, and can a stack remove that re-scanning?

### 5️⃣ Rules the suite enforces
- New `int[]`, same length; **do not mutate** the input.
- `null` → `IllegalArgumentException`; empty → empty array; single day → `[0]`.
- Equal temperature is **not** warmer.
- n = 100 000 must finish in O(n) (three large cases are timed).

### 6️⃣ Java stub
Already in the repo (`throw new UnsupportedOperationException("TODO")`). Fill it in.

### 7️⃣ Complexity (brute force visible)
Brute force is O(n²) time. State the optimised time and space **after** your attempt, with one sentence each on where the cost comes from (push ≤ 1 per index, pop ≤ 1 per index → ≤ 2n stack ops).

### 8️⃣ Interview follow-ups
1. Why store indices, not temperatures, on the stack?
2. What happens on a strictly decreasing input? On a strictly increasing one?
3. In one sentence: where does the O(n) cost come from?

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Optimised idea.** Walk left → right. Keep a stack of indices whose temperatures are **strictly decreasing**. When day `i` is warmer than `stack.peek()`, pop `j` and set `ans[j] = i - j`. Push `i`. Leftovers stay 0.

**Dry run** on `[73, 74, 75, 71, 69, 72, 76, 73]`:

| i | temp | stack (indices) after | writes |
|---|---|---|---|
| 0 | 73 | [0] | |
| 1 | 74 | [1] | ans[0]=1 |
| 2 | 75 | [2] | ans[1]=1 |
| 3 | 71 | [2,3] | |
| 4 | 69 | [2,3,4] | |
| 5 | 72 | [2,5] | ans[4]=1, ans[3]=2 |
| 6 | 76 | [6] | ans[5]=1, ans[2]=4 |
| 7 | 73 | [6,7] | |

**Answers.** (1) Need the day index to write a distance. (2) Decreasing: nothing pops, all 0; increasing: every day pops the previous, wait 1. (3) Each index is pushed at most once and popped at most once, so ≤ 2n stack operations.

</details>

- [ ] 3-5 lines of plain-English pseudocode **before** any Java.
- [ ] Three comment lines (pattern, time, space) with reason sentences.
- [ ] `mvn test -Dtest=DailyTemperaturesTest` → **18/18**. Push.

> [!NOTE]
> Full Day 15 copy of this spec (same content): [day15.md § Daily Temperatures](day15.md#-daily-temperatures-new-stack-35-min).

---

## 4️⃣ 🧩 `CarFleet` single-pair follow-up (if time, ~10 min)

- [ ] In chat: two cars, one behind and faster — when do they count as one fleet, and why is a plain `double` division unsafe?
- [ ] Written reason sentences on `main` still await PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) merge (comment-only branch). Do not force-push `main` yourself for that.

---

## 🌙 Evening plan (60 min)

| Order | Item | Track |
|---|---|---|
| 1 | Review and score each track out of 10 | all |
| 2 | Finish whatever is pending from the morning, in the order above | all |
| 3 | In chat: B2 Q3 + catch-all sentence; Chapter 1 interview Q if not done | 🌱 |
| 4 | 🔁 cold redos (cap 2): **`ValidParenthesesRedoNov01`** then **`MinStackRedoNov01`** | 🔁 |

### 🔁 Due redos tonight (cap 2, most overdue first)

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov01.java` | `ValidParenthesesRedoNov01Test` **17/18** 🔶 | +1 (post-feedback; finish null→IAE **in the redo**) | 20-30 min |
| 🧩 `MinStack` | `src/main/java/com/prashant/dailytests/redo/MinStackRedoNov01.java` | `MinStackRedoNov01Test` **0/10** | +1 (never redone since 23 Oct) | 20-30 min, cold |

- [x] **ValidParen first:** null → `IllegalArgumentException` **in the redo file** (`3019054`); `ValidParenthesesRedoNov01Test` **18/18**. Still 🔶 (post-feedback, same +1 gap).
- [ ] **MinStack second:** blank approach — 3 comment lines + 3-5 lines of plain-English pseudocode; do **not** open `dsa/stack/MinStack`. Push at the end, even if red.
- [ ] Before any Java on MinStack: pattern / time / space with one sentence each on where the cost comes from.

> [!WARNING]
> Cap **2**. `ScoreOfParentheses` and `RemoveKAdjacentDuplicates` stay queued for **8 Nov** ([redo-schedule.md](../revision/redo-schedule.md)). Do not start a third redo tonight.


## 🌙 Evening (7 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Time](https://img.shields.io/badge/time-60%20min-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-6%2F10-orange) ![Buggy](https://img.shields.io/badge/Buggy-7%2F10-yellowgreen)

> [!NOTE]
> Evening review at ~8:00 PM IST on tip `f61c7d3` (JDK 21, Maven). Student code today: `3019054` (14:11 IST) null→IAE **in** `ValidParenthesesRedoNov01.java`, merged `f61c7d3`. Weekly review `98cc269` (~2:07 PM IST) already on `main` — not redone here. Chat: `Day04LargestRectangle` symptom table + `[2,1,2]` hand trace graded (**supported**, not cold-clean); table diagnosis correct; sentinel rows corrected after feedback; max **3** accepted; empty-stack width still needs a geometric why + ASCII. No push on [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) (still stub / no `my-solutions`). `MinStackRedoNov01` and `DailyTemperatures` untouched. **No new conceptual mistake** logged.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | Labs Chapter 1 still **no student push** and no graded interview Q. B2 Q3 / Q6 / catch-all sentence unanswered. Banking module 1 / Drills 2–3 parked. No Spring dimension applied today |
| 🧩 DSA | **6/10** (🟡 Moderate) | concept 7: ValidParen stack matching was already right; null→IAE landed in the **redo** file (`3019054`). Implementation 8: `ValidParenthesesRedoNov01Test` **18/18**. Problem solving 4: `DailyTemperatures` still stub **0/18**; cold `MinStackRedoNov01` **0/10** not attempted. Complexity / interview: no new DailyTemps or MinStack evidence; `CarFleetTest` **37/37** re-verified. Post-feedback ValidParen stays 🔶 (same +1) |
| 🐞 Buggy | **7/10** (🟡 Moderate) | concept 7 / debugging 7: LargestRectangle write-up **graded in chat** (supported) — table groups correct after sentinel feedback, `[2,1,2]` max 3 accepted. Empty-stack width rationale still thin (needs geometric left/right bound + ASCII). Implementation 9 unchanged (`Day04LargestRectangleTest` **36/36**, `Day00BuggyExampleTest` **10/10`). Interview readiness 6: width-why sentence not yet interview-solid |

> [!WARNING]
> `ValidParenthesesRedoNov01` is **18/18 after feedback**, **not** a cold clean pass. Ladder stays at **+1** (next due **8 Nov**). Do **not** advance. Do **not** reassign the LargestRectangle table/trace as missing — it was graded tonight (supported).

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 `spring-boot-labs` Chapter 1 (Maven / pom) | ⬜ Pending | no push, no graded Q |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🌱 HTTP semantics / `ResponseEntity` / `@PathVariable` set | 🔴 Weak (carried) | Day 02–03 scores; packs still ⬜ not generated — labs Ch 1 stays the Spring slot |
| 🧩 `DailyTemperatures` | ⬜ Pending | stub only (0/18) |
| 🧩 `CarFleet` single-pair / PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) | 🟡 Moderate | chat reasons closed; written merge pending |
| 🔁 `ValidParentheses` redo | 🟡 Moderate / 🔶 complete for this attempt | **18/18** post-feedback; same +1 |
| 🔁 `MinStack` redo | ⬜ Pending | stub 0/10, not attempted tonight |
| 🐞 `Day04LargestRectangle` write-up | 🟡 Moderate (supported ✅ graded) | table + `[2,1,2]` done in chat; empty-stack width geometric why still soft |
| 🐞 `Day00BuggyExample` write-up | 🟡 Pending | code 10/10; no symptom groups |
| 🏦 Banking module 1 / Drills 2–3 | ⬜ Pending, **parked** | unchanged |
| ⛔ Blocked | none | — |

No topic is newly 🔴 Weak tonight, so no new weak-topic pack. Carried Spring 🔴 Weak rows stay in [PROGRESS.md](../PROGRESS.md); do not insert them ahead of labs Ch 1.

### ⏳ Tonight's evening-slot work (finishable; push after each)

> [!IMPORTANT]
> Cap **2 redos**. ValidParen is done for tonight. **MinStack** is still due. Morning leftovers that still fit take the rest of the hour after MinStack.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 25 | Cold `MinStackRedoNov01` (3 comments + pseudocode first; do **not** open `dsa/stack/MinStack`) | 🔁 | push even if red; target 10/10 |
| 2 | 20 | `DailyTemperatures`: 3–5 lines plain-English pseudocode, then code (even if red) | 🧩 | push; aim 18/18 |
| 3 | if time | `spring-boot-labs` Chapter 1 first tasks on `my-solutions` (parent before coordinates) | 🌱 | push even if checks red |
| 4 | if time | Empty-stack width in one geometric sentence + tiny ASCII for `[2,1,2]` (chat) | 🐞 | graded 7+ |
| 5 | if time | Single-pair CarFleet follow-up; B2 Q3 + catch-all sentence | 🧩🌱 | graded 7+ |

- [ ] `MinStackRedoNov01` pushed
- [ ] `DailyTemperatures` pushed (even if red)
- [ ] (optional) labs Ch 1 first push on `my-solutions`
- [ ] (optional) empty-stack width sentence + single-pair / Q3 in chat

### 🎯 Tomorrow's focus (Sun 8 Nov), from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | `spring-boot-labs` Chapter 1 end-to-end (6 pom tasks + interview Q written); habit: ask what the parent already gives, then add only what is missing | unscored two nights; Ch 1 is the whole Spring slot |
| 🧩 DSA | Finish `DailyTemperatures` if not green tonight: monotonic stack of **indices**, reason sentences on pattern/time/space (push≤1 + pop≤1 → ≤2n) | problem solving was 4; stub still blocks the next Stack problem |
| 🐞 Buggy | No new buggy round. Optional: empty-stack width geometric sentence if not graded tonight; Day00 symptom groups stay backlog | write-up for LargestRect is graded (supported); debugging depth still the soft edge |
| 🔁 Redos (evening) | Cap 2 from [redo-schedule.md](../revision/redo-schedule.md): **`ValidParentheses` (+1, 🔶 re-queue)** then **`MinStack` (+1)** if MinStack still open; else `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` | ValidParen stays same gap; MinStack still never redone |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.

## 📦 Carried backlog (not for this morning unless listed above)

| Item | Track | Status | When |
|---|---|---|---|
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | tonight / spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| Redos queued: `ValidParentheses` (+1 🔶) + `MinStack` (+1) (**8 Nov**); then `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` | 🔁 | 🟡 IN_PROGRESS | [redo-schedule.md](../revision/redo-schedule.md) |
| `Day00BuggyExample` redo (+1) | 🔁 | 🟡 IN_PROGRESS | queued **11 Nov** |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.
