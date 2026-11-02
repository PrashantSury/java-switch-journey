# 🔁 DSA redo schedule

![Spaced repetition](https://img.shields.io/badge/redo-results--based%201%20%E2%86%92%203%20%E2%86%92%207%20%E2%86%92%2014%20%E2%86%92%2030-purple) ![Problems](https://img.shields.io/badge/problems-11-blue) ![Cap](https://img.shields.io/badge/cap-2%20redos%20per%20day-yellow) ![Start](https://img.shields.io/badge/start-1%20Nov%202026-blue)

> [!IMPORTANT]
> Every DSA problem and buggy round is redone cold, and **the result of each redo decides the next gap**: 1 → 3 → 7 → 14 → 30 days, at most **2 redos a day**, so the backlog never lands on one day and each pattern gets time to stick. This file is the single source for "what do I redo today?"; conceptual mistakes still go to [mistakes/dsa.md](mistakes/dsa.md).

> [!NOTE]
> **Legend:** 🧩 DSA · 🐞 buggy round · 🔁 redo · ✅ clean pass · 🔶 pass with a hint or a fix · ❌ conceptual miss · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` (in the redo cycle) · ⏰ overdue · 🎓 graduated (= ✅ `COMPLETED`). Other logs: [mistake-log index](mistake-log.md) · [PROGRESS.md](../PROGRESS.md). Results-based gaps approved by Prashant on 31 Oct 2026.

## 📏 Rules
| # | Rule |
|---|---|
| 1 | **The ladder:** 1 → 3 → 7 → 14 → 30 days. A gap is counted from the **day of the last pass** (the first solve, or the latest redo), so a late redo pushes the next date later. A newly verified solve starts at gap 1. |
| 2 | **✅ Clean cold pass** (all tests pass, blank file, no hint, no peeking, no fix needed): move up **one step**; next due = pass date + the new gap. |
| 3 | **🔶 Pass with a hint, or only after a fix** (passed after a review round or after re-reading the original): **repeat the same gap**. |
| 4 | **❌ Conceptual miss** (a conceptual mistake, logged in [mistakes/dsa.md](mistakes/dsa.md)): **reset to day 1**, due the day after it is verified. Cosmetic slips don't reset anything. |
| 5 | **Skip to 30:** two clean passes in a row, each at least **14 days** after the previous pass, go straight to the 30-day gap. A clean pass at the 30-day gap = graduation 🎓. |
| 6 | **How to redo:** blank file, timed at **20-30 minutes**. Before any code, write the **pattern line** and the **time and space complexity** at the top as comments. |
| 7 | **Cap:** at most **2 redos per day**. A problem that just reset to day 1 keeps its day-1 date; the other slot, and every other day, goes to the **most overdue** (ties: problems with a logged conceptual mistake first). The rest wait in the queue. |
| 8 | **Buggy rounds** (`Day0N...` in `dailytests`) follow exactly the same schedule. A redo file (`...Redo`, `...Redo7`) is a redo of its problem, not a new problem. |
| 9 | **New problems** join at gap 1 the day they are verified and take a free slot, never a third one. |
| 10 | **Mistake logs:** the day-3 and day-7 columns in [mistakes/dsa.md](mistakes/dsa.md) are only the first checkpoints. The next-due dates in this file replace them. |

> [!NOTE]
> **Where redos happen (from 1 Nov 2026):** in the 🌙 evening block, after the review and after any pending morning work (see [docs/PROGRAM.md](../docs/PROGRAM.md)). The cap stays at 2 a day; if pending work eats the evening, the most overdue redo goes first and the rest wait in the queue. Status words follow `PROGRAM.md`: a problem keeps ✅ `COMPLETED` for its first verified solve and shows 🟡 `IN_PROGRESS` here until it graduates.

> [!TIP]
> Redo checklist: ① blank file ② 3 comment lines: pattern, time, space ③ set a 25-minute timer ④ `mvn test -Dtest=<Problem>Test` ⑤ all green and no hint = ✅ (step up), all green after a hint or fix = 🔶 (same gap), a conceptual slip = ❌ (day 1; log it in [mistakes/dsa.md](mistakes/dsa.md)).

## 📋 The schedule
| Problem | Pattern | Last verified | Last result | Current gap | Next due | Status |
|---|---|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | Stack: expression evaluation | 31 Oct | ❌ 31 Oct `Day02RpnEvaluatorRedo7`: 3 conceptual misses (15/44, 43/44, then 44/44 after fixes) · 1 and 2 Nov redo not attempted (stub 0/44) | +1 (reset) | **3 Nov** | 🟡 IN_PROGRESS · ⏰ due 1 Nov, 2 days late |
| 🧩 `ValidParentheses` | Stack: matching brackets | 23 Oct | 🔶 23 Oct starter, understood · never redone (stub 0/18 not attempted 1 or 2 Nov) | +1 | **3 Nov** | 🟡 IN_PROGRESS · ⏰ due 24 Oct, 10 days overdue |
| 🧩 `MinStack` | Stack: auxiliary min stack (design) | 23 Oct | ✅ 23 Oct 10/10 · never redone | +1 | **4 Nov** | 🟡 IN_PROGRESS · ⏰ due 24 Oct, 11 days overdue |
| 🧩 `ScoreOfParentheses` | Stack: nesting depth / running score | 25 Oct | 🔶 25 Oct 37/37, written with help · never redone | +1 | **4 Nov** | 🟡 IN_PROGRESS · ⏰ due 26 Oct, 9 days overdue · follow-up questions pending |
| 🧩 `RemoveKAdjacentDuplicates` | Stack: count stack (run-length) | 29 Oct | ❌ 29 Oct 26/26 but the O(n) quiz scored 3/5 (conceptual) · never redone | +1 (reset) | **5 Nov** | 🟡 IN_PROGRESS · ⏰ due 30 Oct, 6 days overdue |
| 🐞 `Day03NextGreaterIndex` | Monotonic stack: next greater | 29 Oct | ✅ 29 Oct 37/37, both bugs found (only cosmetic slips) · never redone | +1 | **5 Nov** | 🟡 IN_PROGRESS · ⏰ due 30 Oct, 6 days overdue |
| 🧩 `AsteroidCollision` | Stack: collision simulation | 31 Oct | ✅ 31 Oct 28/28, no conceptual issue · never redone | +1 | **6 Nov** | 🟡 IN_PROGRESS · ⏰ due 1 Nov, queued 5 days |
| 🐞 `Day01ArrayStack` | Design: array-backed stack | 31 Oct | ✅ 31 Oct `Day01ArrayStackRedo7` clean cold 17/17 → moved up 3 → 7 | +7 | **8 Nov** | 🟡 IN_PROGRESS · due 7 Nov, waits 1 day (7 Nov holds two older items) |
| 🧩 `CarFleet` | Stack: sort by position, monotonic | not verified (2/37) | — | joins at +1 once verified | — | ⬜ NOT_STARTED |
| 🐞 `Day04LargestRectangle` | Monotonic stack: largest rectangle | not verified (15/36) | — | joins at +1 once verified | — | ⬜ NOT_STARTED |
| 🐞 `Day00BuggyExample` | Array scan: max with edge cases (warm-up) | not verified (4/10) | — | joins at +1 once verified | — | ⬜ NOT_STARTED |

> [!NOTE]
> **11 problems**: 8 scheduled, 3 not started. "Next due" is the day the redo is queued; when the cap pushes it, the Status says how many days it waited. No day holds more than 2 (3 Nov: 2, 4 Nov: 2, 5 Nov: 2, 6 Nov: 1, 8 Nov: 1). Updated by the 10 PM check on 2 Nov: the two redos were not attempted again, so the whole queue moved one more day.

## 🗓️ Next 7 days
| Date | Redo 1 | Redo 2 | Why |
|---|---|---|---|
| Tue 3 Nov | `Day02RpnEvaluator` (+1, late) | `ValidParentheses` (+1, late) | Not attempted on 1 or 2 Nov; the reset RPN redo and the most overdue item keep the first slots |
| Wed 4 Nov | `MinStack` (+1, late) | `ScoreOfParentheses` (+1, late) | Most overdue |
| Thu 5 Nov | `RemoveKAdjacentDuplicates` (+1, late) | `Day03NextGreaterIndex` (+1, late) | Both were due 30 Oct and waited behind older items |
| Fri 6 Nov | `AsteroidCollision` (+1, late) | `Day02RpnEvaluator` (+3) | `AsteroidCollision` was due 1 Nov; `Day02RpnEvaluator` (logged conceptual mistakes) wins the tie with `ValidParentheses`, both +3 after a 3 Nov pass |
| Sat 7 Nov | `ValidParentheses` (+3, late) | `MinStack` (+3) | `ValidParentheses` was due 6 Nov (1 day late); `MinStack` due 7 Nov, ahead of `Day01ArrayStack` |
| Sun 8 Nov | `Day01ArrayStack` (+7, late) | `ScoreOfParentheses` (+3, late) | Both were due 7 Nov (1 day late) |
| Mon 9 Nov | `RemoveKAdjacentDuplicates` (+3, late) | `Day03NextGreaterIndex` (+3, late) | Both were due 8 Nov; `AsteroidCollision` (+3, due 9 Nov) waits a day |

> [!WARNING]
> Everything after the first redo of each problem is a **projection that assumes every redo is a clean pass**. A 🔶 repeats the gap and a ❌ resets to day 1, and the queue rule moves the rest.

## 🔭 Projected calendar after 9 Nov
| Date | Redo 1 | Redo 2 |
|---|---|---|
| Tue 10 Nov | `AsteroidCollision` (+3, late) | free |
| Fri 13 Nov | `Day02RpnEvaluator` (+7) | free |
| Sat 14 Nov | `ValidParentheses` (+7) | `MinStack` (+7) |
| Sun 15 Nov | `ScoreOfParentheses` (+7) | free |
| Mon 16 Nov | `RemoveKAdjacentDuplicates` (+7) | `Day03NextGreaterIndex` (+7) |
| Tue 17 Nov | `AsteroidCollision` (+7) | free |
| Sun 22 Nov | `Day01ArrayStack` (+14) | free |
| Fri 27 Nov | `Day02RpnEvaluator` (+14) | free |
| Sat 28 Nov | `ValidParentheses` (+14) | `MinStack` (+14) |
| Sun 29 Nov | `ScoreOfParentheses` (+14) | free |
| Mon 30 Nov | `RemoveKAdjacentDuplicates` (+14) | `Day03NextGreaterIndex` (+14) |
| Tue 1 Dec | `AsteroidCollision` (+14) | free |
| Tue 22 Dec | `Day01ArrayStack` (+30) 🎓 | free |
| Sun 27 Dec | `Day02RpnEvaluator` (+30) 🎓 | free |
| Mon 28 Dec | `ValidParentheses` (+30) 🎓 | `MinStack` (+30) 🎓 |
| Tue 29 Dec | `ScoreOfParentheses` (+30) 🎓 | free |
| Wed 30 Dec | `RemoveKAdjacentDuplicates` (+30) 🎓 | `Day03NextGreaterIndex` (+30) 🎓 |
| Thu 31 Dec | `AsteroidCollision` (+30) 🎓 | free |

> [!NOTE]
> Total until everyone graduates: **38 redos** (8 problems × 5 steps, minus the 2 steps `Day01ArrayStack` already cleared), **29 of them in November on 18 days** (3-30 Nov), last graduation Thu 31 Dec. The 3 not-started problems add 5 redos each once verified.

## 🧾 History behind each row
| Problem | Events and their effect on the gap (source: [PROGRESS.md](../PROGRESS.md), [mistakes/dsa.md](mistakes/dsa.md)) |
|---|---|
| `Day01ArrayStack` | 23 Oct buggy round fixed with hints (start, gap 1) · 28 Oct cold redo ✅ 17/17, clean (1 → 3) · 31 Oct `Day01ArrayStackRedo7` ✅ clean 17/17 (3 → 7), due 7 Nov, queued to 8 Nov by the cap |
| `Day02RpnEvaluator` | 24 Oct buggy round fixed, hint needed for `-3` (start, gap 1) · 27 Oct `Day02RpnEvaluatorRedo` 44/44 but re-read the original (🔶, repeats gap 1) · 31 Oct `Day02RpnEvaluatorRedo7` ❌ 3 conceptual misses before it was fixed (operator fall-through, `pop() != 1` end check, missing null guard) → reset to day 1, due 1 Nov · 1 Nov redo not attempted, moved to 2 Nov · 2 Nov not attempted, moved to 3 Nov |
| `RemoveKAdjacentDuplicates` | 29 Oct 26/26 (start) · O(n) quiz 3/5, missed the amortised argument (❌ conceptual, day 1) · due 30 Oct, never redone |
| `Day03NextGreaterIndex` | 29 Oct 37/37, both bugs found, stray `main()` removed (cosmetic, not logged) · gap 1, due 30 Oct, never redone |
| `AsteroidCollision` | 30 Oct pushed 28/28, 31 Oct verified after two cosmetic fixes · gap 1, due 1 Nov, queued to 6 Nov |
| `ValidParentheses` | 23 Oct starter solution understood · gap 1, due 24 Oct, never redone |
| `MinStack` | 23 Oct 10/10 · gap 1, due 24 Oct, never redone |
| `ScoreOfParentheses` | 25 Oct 37/37, written with help, dry-ran line by line · gap 1, due 26 Oct, never redone |
| `CarFleet` · `Day04LargestRectangle` · `Day00BuggyExample` | not verified (2/37, 15/36, 4/10); join the schedule at gap 1 once verified |

> [!NOTE]
> **2 Nov, 22:35 IST late push (`0600df2`):** only Part B2 was touched. No DSA or buggy redo was graded (`CarFleetTest` 2/37, `Day04LargestRectangleTest` 15/36, `Day02RpnEvaluatorRedoNov01Test` 0/44, `ValidParenthesesRedoNov01Test` 0/18, all re-run), so every gap, due date and the 3-9 Nov calendar above stay exactly as the 10 PM check set them.
