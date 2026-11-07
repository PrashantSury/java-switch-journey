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

- [ ] Comment block at the top of `src/main/java/com/prashant/dailytests/Day04LargestRectangle.java`: **Table 1** (failing tests grouped by what the wrong answers share) and **Table 2** (blank hand trace on `[2, 1, 2]`, expected **3**: `i`, `current`, stack before, popped, `height`, `width`, `area`, `best`).
- [ ] One sentence: why width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise.
- [ ] **No code change.** Push with a real commit message (not a copy of an older one).

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

- [ ] **ValidParen first:** add `null` → `IllegalArgumentException` **in the redo file** (do not touch `dsa/stack/ValidParentheses` for this). Even 18/18 after feedback stays 🔶 (same +1 gap).
- [ ] **MinStack second:** blank approach — 3 comment lines + 3-5 lines of plain-English pseudocode; do **not** open `dsa/stack/MinStack`. Push at the end of each, even if red.
- [ ] Before any Java on MinStack: pattern / time / space with one sentence each on where the cost comes from.

> [!WARNING]
> Cap **2**. `ScoreOfParentheses` and `RemoveKAdjacentDuplicates` stay queued for **8 Nov** ([redo-schedule.md](../revision/redo-schedule.md)). Do not start a third redo tonight.

## 📦 Carried backlog (not for this morning unless listed above)

| Item | Track | Status | When |
|---|---|---|---|
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | tonight / spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| Redos queued: `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` (8 Nov) | 🔁 | 🟡 IN_PROGRESS | [redo-schedule.md](../revision/redo-schedule.md) |
| `Day00BuggyExample` redo (+1) | 🔁 | 🟡 IN_PROGRESS | queued **11 Nov** |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.
