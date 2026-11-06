# 📅 Day 15 (Fri 6 Nov): spring-boot-labs Ch 1 · Daily Temperatures · carried write-ups

![Week](https://img.shields.io/badge/Week-3-blue) ![Day](https://img.shields.io/badge/Day-15-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h%20%2B%201%20h-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Progress decides the work. From today the 🌱 Spring slot lives in **[PrashantSury/spring-boot-labs](https://github.com/PrashantSury/spring-boot-labs)** (Chapter 1 is READY). DSA, buggy and redos stay here. Pending write-ups from last night come first; then the first labs chapter, the next Stack problem, and the warm-up buggy. **Each step ends in a push, even if red.**

> [!NOTE]
> **Legend:** 🌅 morning · 🌙 evening · 🌱 Spring · 🏦 banking · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified) · 🔴 `REVISION_REQUIRED`. Run `git pull` on **both** repos first. Suites on `090be7e` (5 Nov 10 PM): `course-practice` 23/23, `CarFleetTest` 37/37, `Day04LargestRectangleTest` 36/36, `Day02RpnEvaluatorRedoNov01Test` 44/44, `ValidParenthesesRedoNov01Test` 0/18, `Day00BuggyExampleTest` 4/10, new stubs `DailyTemperaturesTest` 0/18 and `MinStackRedoNov01Test` 0/10. No push after the evening review.

## 🌅 Morning

### ⏱️ Time plan (120 min)

| Minutes | Track | Item | Push it |
|---|---|---|---|
| 0-15 | 🐞 | `Day04LargestRectangle` symptom table + `[2, 1, 2]` hand trace (carried, no code change) | yes |
| 15-65 | 🌱 | **spring-boot-labs Chapter 1**: Maven and the `pom.xml` (6 tasks + interview Q out loud) | yes, in that repo |
| 65-75 | 🧩 | `CarFleet`: one reason sentence next to each of the 3 comment lines + single-pair follow-up in chat | yes; `CarFleetTest` stays 37/37 |
| 75-110 | 🧩 | **Daily Temperatures** (new Stack): 3-5 lines of plain-English pseudocode first, then code | yes, even if red |
| 110-120 | 🐞 / buffer | `Day00BuggyExample` warm-up (4/10) if time; else `mvn test` and push leftovers | yes |

> [!TIP]
> Ask for a hint after **15 minutes** on any step. Bring the Drill 1 habit into Chapter 1: before adding a tag, ask what the parent / scope / profile already gives you, then add only what is missing.

---

## 1️⃣ 🐞 `Day04LargestRectangle` write-up (15 min, **push first**)

The code is ✅ 36/36 (`d8306e2`). The localisation was skipped. Spec and the failing-test table: [day14.md evening](day14.md#-debugging-write-up-for-day04largestrectangle-the-part-that-was-skipped).

- [ ] Comment block at the top of `src/main/java/com/prashant/dailytests/Day04LargestRectangle.java`: **Table 1** (failing tests grouped by what the wrong answers share) and **Table 2** (blank hand trace on `[2, 1, 2]`, expected **3**: `i`, `current`, stack before, popped, `height`, `width`, `area`, `best`).
- [ ] One sentence: why width is `i` when the stack is empty and `i - stack.peek() - 1` otherwise.
- [ ] **No code change.** Push with a real commit message.

---

## 2️⃣ 🌱 spring-boot-labs Chapter 1: Maven and the pom.xml (~50 min)

> [!IMPORTANT]
> Repo: `https://github.com/PrashantSury/spring-boot-labs` · chapter: [`chapters/01-maven-and-the-pom/`](https://github.com/PrashantSury/spring-boot-labs/tree/main/chapters/01-maven-and-the-pom) · edit **one file**: `lab/pom.xml`. ✅ Done when `mvn -pl chapters/01-maven-and-the-pom test` is green (19/19) and the interview question is answered out loud (then written under [interview-answers.md](../interview-answers.md)).

| Step | What | Minutes |
|---|---|---|
| 0 | `git clone` (or `git pull`) the labs repo; open `chapters/01-maven-and-the-pom/README.md` | 3 |
| 1 | Read Why / Coordinates / Parent / Scopes / Profiles (skim the trees) | 10 |
| 2 | Tasks 1-3: coordinates, parent `4.1.2`, `java.version=21`. Run checks after each | 15 |
| 3 | Tasks 4-6: web starter (no version), test starter + h2 scopes, `uat` profile | 15 |
| 4 | Interview Q out loud (2-3 sentences), then write it in chat / `interview-answers.md` | 5 |
| 5 | Push on a `my-solutions` branch (do not commit solutions on `main` of labs) | 2 |

**Interview question (task 4).** Who picks the version of `spring-boot-starter-webmvc` when you don't write one, and what happens to all your starters when you upgrade Spring Boot? Then: what is the difference between `runtime` and `provided`?

> [!WARNING]
> Traps from the chapter README: parent before your own `groupId`; three-number version `4.1.2` (not `4.1`); edit the existing `<properties>` (don't add a second); `<profiles>` at the end; no version on the starters.

> [!NOTE]
> Banking module 1 step 1 and Drills 2/3 stay **parked** in Pending. `course-practice` B2 is ✅ and is not extended.

---

## 3️⃣ 🧩 `CarFleet` reasons (10 min)

The 3 comment lines are in (`1c9c6aa`) but have no reason sentence. Weakest DSA dimension last night was complexity (7).

- [ ] Next to each of pattern / time / space: one sentence saying **where the cost comes from** (hint: which step is `O(n log n)`? what is the stack's worst-case size?).
- [ ] In chat, the single-pair follow-up: two cars, one behind and faster — when do they count as one fleet, and why is a plain `double` division unsafe?
- [ ] `mvn test -Dtest=CarFleetTest` still **37/37**. Push.

---

## 4️⃣ 🧩 Daily Temperatures (new Stack, ~35 min)

![Type](https://img.shields.io/badge/type-DSA%20Stack-blue) ![Tests](https://img.shields.io/badge/DailyTemperaturesTest-18-lightgrey) ![Stub](https://img.shields.io/badge/stub-0%2F18-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` · tests `DailyTemperaturesTest` (18). ✅ Done when all 18 pass on your pushed code, with pattern / time / space comment lines that each say where the cost comes from.

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

---

## 5️⃣ 🐞 `Day00BuggyExample` warm-up (if time, ~10 min)

Spec: [day09.md](day09.md#-day00buggyexample-buggy-warm-up). Stub: `Day00BuggyExample.java` (4/10).

- [ ] Read the 6 failing tests; group them by symptom **before** touching code.
- [ ] Fix each group with the smallest change. `mvn test -Dtest=Day00BuggyExampleTest` → **10/10**. Push.

> [!CAUTION]
> The bugs are not described. Do not ask for them. Localise from the failing tests.

---

## 🌙 Evening plan (60 min)

| Order | Item | Track |
|---|---|---|
| 1 | Review and score each track out of 10 | all |
| 2 | Finish whatever is pending from the morning, in the order above | all |
| 3 | In chat: B2 Q3 + catch-all sentence; Chapter 1 interview Q if not done | 🌱 |
| 4 | 🔁 cold redo **`ValidParenthesesRedoNov01`** (0/18), then **`MinStackRedoNov01`** (0/10) | 🔁 |

### 🔁 Due redos tonight (cap 2, most overdue first)

| Redo | File | Tests | Gap | Timebox |
|---|---|---|---|---|
| 🧩 `ValidParentheses` | `src/main/java/com/prashant/dailytests/redo/ValidParenthesesRedoNov01.java` | `ValidParenthesesRedoNov01Test` 0/18 | +1 (13 days late) | 20-30 min, cold |
| 🧩 `MinStack` | `src/main/java/com/prashant/dailytests/redo/MinStackRedoNov01.java` | `MinStackRedoNov01Test` 0/10 | +1 (13 days late) | 20-30 min, cold |

- [ ] Before any Java on each: 3 comment lines (pattern, time, space) + 3-5 lines of plain-English pseudocode.
- [ ] Cold: do not open `dsa/stack/ValidParentheses` or `dsa/stack/MinStack`. Push at the end of each, even if red.

## 🌙 Evening (6 Nov): catch-up review (routine missed 8 PM)

![Slot](https://img.shields.io/badge/slot-catch--up-yellow) ![Time](https://img.shields.io/badge/time-60%20min-blue) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-6%2F10-orange) ![Buggy](https://img.shields.io/badge/Buggy-7%2F10-yellow)

> [!NOTE]
> Catch-up review after the 8 PM evening routine did not run (last recorded run 5 Nov; cause unknown — not investigated). Checked at ~8:30 PM IST on tip `ec608e3` (JDK 21, Maven). User pushes today: `c0f5d64` (08:42, Day00 + ValidParen redo body) and `ec608e3` (09:03, null guard on **original** `ValidParentheses.java`). Lumi comment-only PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) (`f902f34`, CarFleet reasons) is still **open / not merged**. No commits today on [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs). Suites re-run below. **No new conceptual mistake** logged (wrong-file null guard is process, not a new rule miss).

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric))

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring Boot | **unscored** (⬜ Pending) | Labs Chapter 1 (Maven / `pom.xml`) had **no push** and no graded interview answer. B2 Q3 / Q6 and the catch-all sentence stay unanswered. Banking module 1 / Drills 2–3 remain parked. No Spring dimension applied today, so no invented number |
| 🧩 DSA | **6/10** (🟡 Moderate) | concept 7: ValidParen stack matching is right; null→IAE is in the redo Javadoc but the guard was added to the original class (`ec608e3`), so the redo is still 17/18. Implementation 6: `ValidParenthesesRedoNov01` **17/18**; `DailyTemperatures` still stub **0/18**; `CarFleetTest` **37/37**. Problem solving 5: new Stack problem not started. Complexity 8: CarFleet time (sort O(n log n) + walk O(n), accepted 5 Nov) and space (pairs + ≤n fleets → O(n), accepted 6 Nov chat, "storing not processing") are closed in chat; main still has bare comments until PR #1 merges. Interview readiness 6: single-pair CarFleet follow-up still owed |
| 🐞 Buggy | **7/10** (🟡 Moderate) | concept 7 / implementation 9: `Day00BuggyExample` **10/10** on `c0f5d64` (null/empty → IAE, `Integer.MIN_VALUE` seed, loop from 0). Debugging 6: no written symptom groups for Day00, and the carried `Day04LargestRectangle` symptom table + `[2,1,2]` hand trace are still missing. Interview readiness 6: empty-stack width sentence for LargestRectangle still owed |

> [!WARNING]
> `ValidParenthesesRedoNov01` is a **post-feedback** attempt (17/18), **not** a cold clean pass. Do **not** step the redo ladder. Finish the null→IAE guard **in the redo file**, then re-run; even 18/18 after feedback stays 🔶 (same +1 gap).

### 🧪 Topic classification

| Topic | Class | Reason |
|---|---|---|
| 🌱 `spring-boot-labs` Chapter 1 (Maven / pom) | ⬜ Pending | no push, no graded Q |
| 🌱 B2 Q3 / Q6 / catch-all sentence | ⬜ Pending (carried) | unanswered |
| 🧩 `CarFleet` reasons | 🟡 Moderate → chat closed; written pending merge | time + space accepted in chat; PR #1 holds refined comments on a branch |
| 🧩 `DailyTemperatures` | ⬜ Pending | stub only (0/18) |
| 🔁 `ValidParentheses` redo | 🟡 Moderate / 🔶 incomplete | 17/18; wrong file patched; **not** cold-clean |
| 🔁 `MinStack` redo | ⬜ Pending | stub 0/10, not attempted |
| 🐞 `Day00BuggyExample` | ✅ code verified, 🟡 write-up absent | 10/10; joins redo ladder at +1 |
| 🐞 `Day04LargestRectangle` write-up | 🟡 Pending (carried) | code 36/36; tables still owed |
| 🏦 Banking module 1 / Drills 2–3 | ⬜ Pending, **parked** | unchanged |
| ⛔ Blocked | none | — |

No topic is newly 🔴 Weak, so no weak-topic pack tonight.

### ⏳ Tonight's catch-up work (finishable; push after each)

> [!IMPORTANT]
> Cap **2 redos**. `ValidParentheses` must be finished in the **redo** class first; then `MinStack` if time. Morning leftovers that still fit: LargestRectangle write-up (15 min). Labs Ch 1 and Daily Temperatures are tomorrow's main slots unless you have a longer evening.

| # | Minutes | Item | Track | Done when |
|---|---|---|---|---|
| 1 | 10 | `ValidParenthesesRedoNov01`: null → `IllegalArgumentException` **in the redo file** (do not touch `dsa/stack/ValidParentheses` for this) | 🔁 | `ValidParenthesesRedoNov01Test` **18/18**; still 🔶 (post-feedback) |
| 2 | 25 | Cold `MinStackRedoNov01` (blank approach: 3 comments + pseudocode, no peeking at `dsa/stack/MinStack`) | 🔁 | push even if red; target 10/10 |
| 3 | 15 | `Day04LargestRectangle` symptom table + `[2,1,2]` hand trace (comment block only) | 🐞 | one commit, no code change |
| 4 | if time | Single-pair CarFleet follow-up in chat; B2 Q3 + catch-all sentence | 🧩🌱 | graded 7+ |

- [ ] `ValidParenthesesRedoNov01` 18/18 (post-feedback)
- [ ] `MinStackRedoNov01` pushed
- [ ] LargestRectangle write-up pushed
- [ ] (optional) single-pair / Q3 answers in chat

### 🎯 Tomorrow's focus (Sat 7 Nov), from tonight's assessment

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | `spring-boot-labs` Chapter 1 end-to-end (6 pom tasks + interview Q written); habit: ask what the parent already gives, then add only what is missing | unscored today; Ch 1 is the whole Spring slot |
| 🧩 DSA | `DailyTemperatures`: 3–5 lines of plain-English pseudocode, then monotonic stack of **indices**, reason sentences on pattern/time/space | new Stack work was 0/18; weakest DSA dimension was problem solving (5) |
| 🐞 Buggy | Finish LargestRectangle write-up if not done tonight; no new buggy round until that lands | debugging evidence keeps trailing the green suites |
| 🔁 Redos (evening) | If ValidParen still not 18/18, it stays first; else `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` as queued | cap 2; most overdue first · [redo-schedule.md](../revision/redo-schedule.md) |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.

## 📦 Carried backlog (not for this morning unless listed above)

| Item | Track | Status | When |
|---|---|---|---|
| B2 Q3, Q6 and the catch-all sentence | 🌱 | ⬜ NOT_STARTED | tonight / spare chat |
| Banking module 1 step 1, Drills 2 and 3 | 🏦🌱 | ⬜ NOT_STARTED (**parked**) | after labs Foundations settle |
| `ScoreOfParentheses` follow-up questions | 🧩 | ⬜ NOT_STARTED | after CarFleet follow-up |
| Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS | spare evenings |
| Redos queued: `ScoreOfParentheses`, `RemoveKAdjacentDuplicates` (7 Nov) | 🔁 | 🟡 IN_PROGRESS | [redo-schedule.md](../revision/redo-schedule.md) |

> [!TIP]
> Reply in chat when something is pushed, or when you want an answer graded. Each answer is graded and recorded the same night.
