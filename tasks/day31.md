# Day 31 · Sun 22 Nov · 120 min

**Focus:** weekend catch-up — Ch 3 re-answer, Day06 and Two Sum guided walkthroughs, two cold redos · Past day: kept for history; the original day file is in the block below, unchanged.

## ✅ Today (as planned)

| # | Min | Track | Item | Done when |
|---|---|---|---|---|
| 1 | 0-35 | 🌱 | **Ch 3 interview re-answer** in chat: part 2 (why a singleton bean isn't thread-safe by default: where fields live vs where locals live, plus two real fixes), part 3 (the *why* behind `@Component` vs `@Bean`); senior **Q2** (`TransferService` `runningTotal` drift, one fix that survives 3 instances and a restart) and **Q3** (a prototype `Receipt` inside a singleton); floor-vs-cap line; Ch 3 knowledge checks 1-3 (letters only). Questions in [day30.md §1](day30.md#-1-spring-close-chapter-2s-interview-re-answer-chapter-3-35-min-no-new-chapter) | graded in chat |
| 2 | 35-55 | 🐞 | **`Day06FirstUniqueCode`** guided: trace `"aab"` by hand (answer 2); what should the last loop's index stand for, and what is its upper bound? Rewrite only the last loop; symptom-group comment + one comment per fix | 20/20 pushed |
| 3 | 55-85 | 🧩 | **Two Sum** guided: (1) what completes the pair? (2) what should an O(1) lookup remember? (3) check before store or store before check? (`[3,2,4]`, target 6) (4) int overflow when target is `MIN_VALUE`? Then pseudocode + three "because" lines, fill the skeleton blanks, retype from a blank method | 19/19 pushed |
| 4 | 85-90 | 🧩 | Frequency-counting weak-pack exercise + Valid Anagram checks ([day28.md pack](../archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums)) | answered |
| 5 | 90-115 | 🔁 | **`AsteroidCollisionRedoNov17`** cold, 25 min (moved to the morning after 5 skipped evenings) | 28/28 pushed (push even if red) |
| 6 | 115-120 | 🧩 | `DailyTemperatures` comments | pushed |
| 7 | Evening | 🔁 | **`CarFleetRedoNov20`** cold | 37/37 pushed |

<details><summary>📜 Full day file (original layout: morning specs, evening review, end of day)</summary>

# 📅 Day 31 (Sun 22 Nov): weekend catch-up — Ch 3 re-answer, Day06 and Two Sum guided walkthroughs, two cold redos

![Week](https://img.shields.io/badge/week-5-blue) ![Day](https://img.shields.io/badge/day-31-blue) ![Type](https://img.shields.io/badge/type-weekend%20(no%20new%20problems)-lightgrey) ![Spring](https://img.shields.io/badge/Spring-Ch%203%20re--answer-orange) ![DSA](https://img.shields.io/badge/TwoSum-0%2F19%20guided-orange) ![Buggy](https://img.shields.io/badge/Day06-16%2F20-orange) ![Redos](https://img.shields.io/badge/redos-Asteroid%20%2B%20CarFleet-purple)

> [!IMPORTANT]
> Sunday catch-up (weekend: no new DSA problem, no buggy round, no Chapter 4). **Done when** the Ch 3 interview re-answer + senior Q2/Q3 are graded, `Day06FirstUniqueCodeTest` 20/20 and `TwoSumTest` 19/19 are pushed, and both redos are pushed cold.

> [!NOTE]
> **Legend:** 🌱 Spring (`spring-boot-labs`) · 🧩 DSA · 🐞 buggy round · 🔁 redo · ✅ done · ❌ missed · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Sections: 🌅 Morning, 🌙 Evening, 🌒 End of day.

## 🌅 Morning

> [!NOTE]
> Recreated at the 8 PM review: the 6 AM session's push approval expired, so this file never reached the repo. The plan below is the one sent in chat at ~6:33 AM IST. State at ~6:15 AM IST: no student commits since the 21 Nov 10 PM check (this repo `c85379f`, labs `my-solutions` `e619f82`); the 10 PM re-run stands at **795 run / 88 red**, exactly the four open files (`TwoSum` 0/19, `Day06FirstUniqueCode` 16/20, `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 0/37). No cosmetic fixes, no new mistakes.

### ⏱️ Time plan (120 min)

| Min | Track | Item | Done when |
|---|---|---|---|
| 0-35 | 🌱 | **Ch 3 interview re-answer** in chat: part 2 (why a singleton bean isn't thread-safe by default: where fields live vs where locals live, plus two real fixes), part 3 (the *why* behind `@Component` vs `@Bean`); senior **Q2** (`TransferService` `runningTotal` drift, one fix that survives 3 instances and a restart) and **Q3** (a prototype `Receipt` inside a singleton); floor-vs-cap line; Ch 3 knowledge checks 1-3 (letters only). Questions in [day30.md §1](day30.md#-1-spring-close-chapter-2s-interview-re-answer-chapter-3-35-min-no-new-chapter) | graded in chat |
| 35-55 | 🐞 | **`Day06FirstUniqueCode`** guided: trace `"aab"` by hand (answer 2); what should the last loop's index stand for, and what is its upper bound? Rewrite only the last loop; symptom-group comment + one comment per fix | 20/20 pushed |
| 55-85 | 🧩 | **Two Sum** guided: (1) what completes the pair? (2) what should an O(1) lookup remember? (3) check before store or store before check? (`[3,2,4]`, target 6) (4) int overflow when target is `MIN_VALUE`? Then pseudocode + three "because" lines, fill the skeleton blanks, retype from a blank method | 19/19 pushed |
| 85-90 | 🧩 | Frequency-counting weak-pack exercise + Valid Anagram checks ([day28.md pack](../archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums)) | answered |
| 90-115 | 🔁 | **`AsteroidCollisionRedoNov17`** cold, 25 min (moved to the morning after 5 skipped evenings) | 28/28 pushed (push even if red) |
| 115-120 | 🧩 | `DailyTemperatures` comments | pushed |
| Evening | 🔁 | **`CarFleetRedoNov20`** cold | 37/37 pushed |

> [!WARNING]
> 🔁 Cold means a blank file and no peeking. A redo that matches the original code doesn't pass.

Pending: 10 items. Monday unlocks Chapter 4 and Arrays & Hashing 4 of 9 **only if** today's first three items close.

## 🌙 Evening (22 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey) ![Redos](https://img.shields.io/badge/redos-none%20graded-lightgrey)

> [!NOTE]
> Checked at ~8:00 PM IST on a fresh clone. **No student commits today in either repo**: this repo's `main` is still `c85379f` (21 Nov 10:06 PM IST, the 10 PM records), and labs `my-solutions` is still `e619f82` (20 Nov). No answers in chat today. Nothing was touched, so the 21 Nov 10 PM re-run stands: **795 run / 88 red**, exactly the four open files. No cosmetic fixes, no new mistakes to log, no redo graded, so [redo-schedule.md](../revision/redo-schedule.md) is unchanged (the 10 PM check moves the queue; missed is not failed).

Nothing landed today, so no track can be scored honestly. I won't invent a number.

| Track | Score | Evidence |
|---|---|---|
| 🌱 Spring | **can't be scored yet** (no work today; last 7, 21 Nov) | Ch 3 re-answer, Q2/Q3, floor-vs-cap line, knowledge checks: none in chat or pushed |
| 🧩 DSA | **can't be scored yet** (no work today; last 6, 19 Nov) | `TwoSumTest` 0/19, untouched (now past its 2-day limit); frequency-counting pack not answered |
| 🐞 Buggy | **can't be scored yet** (no work today; last 5, 21 Nov) | `Day06FirstUniqueCodeTest` still 16/20 (`41abb48`); `DailyTemperatures` comments not pushed |
| 🔁 Redos | none graded | Asteroid 0/28 and CarFleet 0/37 still blank |

### 🗂️ Topic classification tonight

| Topic | Class | Why |
|---|---|---|
| Registering beans (`@Component`, `@Bean`, `@Primary`, prototype) in code | 🟢 Strong (unchanged) | Ch 3 15/15 first push, 20 Nov |
| `@SpringBootApplication` (Ch 2) | 🟢 Strong enough to move on | Ch 2 ✅ 21 Nov (19/19 + answer 7/10) |
| `@Component` vs `@Bean` (the why) | 🟡 Moderate (unchanged) | right rule, missing "needs code to build it" |
| Singleton beans and shared mutable state | 🔴 Weak (unchanged) | 20 Nov conceptual miss; re-answer and pack not attempted → [day29.md pack](day29.md#-weak-topic-pack-singleton-beans-and-shared-mutable-state) |
| Frequency counting: counts, and the second pass walks string positions | 🔴 Weak (unchanged) | missed 19 Nov (Valid Anagram) and 21 Nov (`Day06`); pack not attempted → [day28.md pack](../archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums) |
| HTTP semantics; `ResponseEntity` vs `@ResponseStatus` | 🔴 Weak (unchanged) | 16 Nov packs not attempted → [day25.md evening](../archive/tasks/day25.md#-weak-topic-pack-2-http-semantics-carried-short) |
| `TwoSum`, `Day06` last loop, `DailyTemperatures` comments, Asteroid + CarFleet redos | ⏳ Pending | not started today |
| ⛔ Blocked | none | no tool or spec in the way; the gap is time on task |

> [!NOTE]
> No new weak topic, so no new pack. The three 🔴 packs above already have revision notes, one conceptual question, one implementation exercise, one debugging exercise and one interview scenario each.

### 🌙 Tonight (rest of the evening slot, in this order)

1. 🌱 **Ch 3 re-answer, part 2 only** in chat (~10 min): where a singleton's field lives vs a local, and two real fixes.
2. 🐞 **`Day06` last loop** (~15 min): trace `"aab"`, rewrite only the last loop to walk `i = 0..n-1` → push → 20/20.
3. 🧩 **Two Sum guiding questions 1-3** in chat (~10 min); skeleton only if time.
4. 🔁 `CarFleetRedoNov20` or Asteroid cold, only if there is time left. Push even if red.

### 🔮 Tomorrow's focus (Mon 23 Nov), based on tonight

Six days in a row with little or no landed work means the plan is too big right now, not that you can't do it. So Monday stays a **catch-up day**: no Chapter 4 and no new Arrays & Hashing problem until the items below close.

| Track | Focus | Why |
|---|---|---|
| 🌱 Spring | Ch 3 re-answer (part 2 + part 3) + Q2, in chat, first thing (~20 min). Chapter 4 opens only once this is graded ≥ 7 | 🔴 singleton/shared state is the one open Spring concept gap; Ch 3 code is already 15/15 |
| 🧩 DSA | Two Sum with a near-full skeleton (only the lookup line and the store line blank), then retype from blank → 19/19. Group Anagrams (A&H 4 of 9) only after that | past its 2-day limit, so the hint level goes up, per the pace rule |
| 🐞 Buggy | `Day06` last loop → 20/20 + symptom-group comment (if not done tonight) | it's the same 🔴 frequency-counting gap; closing it closes the weak pack's implementation exercise too |
| 🔁 Redos | `AsteroidCollisionRedoNov17` cold, 25 min (cap 2; CarFleet second if time) | overdue since 1 Nov |

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-unscored-lightgrey) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey) ![Pending](https://img.shields.io/badge/pending-10-blue)

> [!NOTE]
> 10 PM check (~10 PM IST). No student commits after the 8 PM review in either repo (this repo still `c85379f`, labs `main` and `my-solutions` unchanged, `my-solutions` still `e619f82`) and no answers in chat. Nothing was touched, so nothing new to test: the 21 Nov re-run stands at **795 run / 88 red**, exactly the four open files. The morning plan and the evening review had not reached the repo (the push approval expired), so they go in with tonight's records.

| Track | Item | Result | Status |
|---|---|---|---|
| 🌱 | Ch 3 re-answer (part 2 thread-safety, part 3 the why) + senior Q2/Q3 | not answered | 🔴 REVISION_REQUIRED (**Mon 23 Nov, first task**) |
| 🌱 | Floor-vs-cap mistake redo (one line) | not answered | ⬜ NOT_STARTED |
| 🧩 | `TwoSum` (Arrays & Hashing 3 of 9) | 0/19, untouched; past its 2-day limit | ⬜ NOT_STARTED (Mon 23 Nov, near-full skeleton) |
| 🧩 | Frequency-counting weak pack | not attempted | ⬜ NOT_STARTED |
| 🐞 | `Day06FirstUniqueCode` | still 16/20 (`41abb48`) | 🔴 REVISION_REQUIRED (Mon 23 Nov: last loop → 20/20 + symptom groups) |
| 🧩🐞 | `DailyTemperatures` comments | not pushed | 🟡 IN_PROGRESS (open since 12 Nov) |
| 🔁 | `AsteroidCollisionRedoNov17` cold | not attempted (17-22 Nov). Missed is not failed, no gap changed | 🟡 IN_PROGRESS (**Mon 23 Nov, slot 1**) |
| 🔁 | `CarFleetRedoNov20` cold | not attempted (20-22 Nov) | 🟡 IN_PROGRESS (**Mon 23 Nov, slot 2**) |

> [!NOTE]
> Redo queue moved one slot ([redo-schedule.md](../revision/redo-schedule.md)): Asteroid + CarFleet Mon 23 Nov, every later slot one day later, last graduation **Sat 30 Jan 2027**. Sunday plan projection refreshed in [PROGRESS.md](../PROGRESS.md#-plan-projection-3-h-a-day): overall finish moved from W10-W15 to **W11-W16**. No new mistakes, so nothing logged.

> [!IMPORTANT]
> **First task Mon 23 Nov:** `git pull` this repo (tonight's records are on top of `c85379f`). Then the **Spring Ch 3 interview re-answer** in chat (~20 min): part 2, where a singleton bean's field lives (the **heap**, shared by every request thread) compared with a local variable (each thread's **own stack**), plus **two real fixes**; part 3, the *why* for `@Component` vs `@Bean`; then senior Q2. Chapter 4 opens only once this is graded 7 or more.

</details>
