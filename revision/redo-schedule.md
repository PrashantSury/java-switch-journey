# 🔁 DSA redo schedule

![Spaced repetition](https://img.shields.io/badge/redo-results--based%201%20%E2%86%92%203%20%E2%86%92%207%20%E2%86%92%2014%20%E2%86%92%2030-purple) ![Problems](https://img.shields.io/badge/problems-11-blue) ![Cap](https://img.shields.io/badge/cap-2%20redos%20per%20day-yellow) ![Start](https://img.shields.io/badge/start-1%20Nov%202026-blue)

> [!IMPORTANT]
> Every DSA problem and buggy round is redone cold, and **the result of each redo decides the next gap**: 1 → 3 → 7 → 14 → 30 days, at most **2 redos a day**, so the backlog never lands on one day and each pattern gets time to stick. This file is the single source for "what do I redo today?"; conceptual mistakes still go to [mistakes/dsa.md](mistakes/dsa.md).

> [!NOTE]
> **Legend:** 🧩 DSA · 🐞 buggy round · 🔁 redo · ✅ clean pass · 🟠 pass with a hint or a fix · ❌ conceptual miss · ⬜ not started · 🔵 ready for revision · 🔴 overdue · 🎓 graduated. Other logs: [mistake-log index](mistake-log.md) · [PROGRESS.md](../PROGRESS.md). Results-based gaps approved by Prashant on 31 Oct 2026.

## 📏 Rules
| # | Rule |
|---|---|
| 1 | **The ladder:** 1 → 3 → 7 → 14 → 30 days. A gap is counted from the **day of the last pass** (the first solve, or the latest redo), so a late redo pushes the next date later. A newly verified solve starts at gap 1. |
| 2 | **✅ Clean cold pass** (all tests pass, blank file, no hint, no peeking, no fix needed): move up **one step**; next due = pass date + the new gap. |
| 3 | **🟠 Pass with a hint, or only after a fix** (passed after a review round or after re-reading the original): **repeat the same gap**. |
| 4 | **❌ Conceptual miss** (a conceptual mistake, logged in [mistakes/dsa.md](mistakes/dsa.md)): **reset to day 1**, due the day after it is verified. Cosmetic slips don't reset anything. |
| 5 | **Skip to 30:** two clean passes in a row, each at least **14 days** after the previous pass, go straight to the 30-day gap. A clean pass at the 30-day gap = graduation 🎓. |
| 6 | **How to redo:** blank file, timed at **20-30 minutes**. Before any code, write the **pattern line** and the **time and space complexity** at the top as comments. |
| 7 | **Cap:** at most **2 redos per day**. A problem that just reset to day 1 keeps its day-1 date; the other slot, and every other day, goes to the **most overdue** (ties: problems with a logged conceptual mistake first). The rest wait in the queue. |
| 8 | **Buggy rounds** (`Day0N...` in `dailytests`) follow exactly the same schedule. A redo file (`...Redo`, `...Redo7`) is a redo of its problem, not a new problem. |
| 9 | **New problems** join at gap 1 the day they are verified and take a free slot, never a third one. |
| 10 | **Mistake logs:** the day-3 and day-7 columns in [mistakes/dsa.md](mistakes/dsa.md) are only the first checkpoints. The next-due dates in this file replace them. |

> [!TIP]
> Redo checklist: ① blank file ② 3 comment lines: pattern, time, space ③ set a 25-minute timer ④ `mvn test -Dtest=<Problem>Test` ⑤ all green and no hint = ✅ (step up), all green after a hint or fix = 🟠 (same gap), a conceptual slip = ❌ (day 1; log it in [mistakes/dsa.md](mistakes/dsa.md)).

## 📋 The schedule
| Problem | Pattern | Last verified | Last result | Current gap | Next due | Status |
|---|---|---|---|---|---|---|
| 🐞 `Day02RpnEvaluator` | Stack: expression evaluation | 31 Oct | ❌ 31 Oct `Day02RpnEvaluatorRedo7`: 3 conceptual misses (15/44, 43/44, then 44/44 after fixes) | +1 (reset) | **1 Nov** | 🔵 Ready for revision · on time, reset slot |
| 🧩 `ValidParentheses` | Stack: matching brackets | 23 Oct | 🟠 23 Oct starter, understood · never redone | +1 | **1 Nov** | 🔴 Due 24 Oct, 8 days overdue |
| 🧩 `MinStack` | Stack: auxiliary min stack (design) | 23 Oct | ✅ 23 Oct 10/10 · never redone | +1 | **2 Nov** | 🔴 Due 24 Oct, 9 days overdue |
| 🧩 `ScoreOfParentheses` | Stack: nesting depth / running score | 25 Oct | 🟠 25 Oct 37/37, written with help · never redone | +1 | **2 Nov** | 🔴 Due 26 Oct, 7 days overdue · follow-up questions pending |
| 🧩 `RemoveKAdjacentDuplicates` | Stack: count stack (run-length) | 29 Oct | ❌ 29 Oct 26/26 but the O(n) quiz scored 3/5 (conceptual) · never redone | +1 (reset) | **3 Nov** | 🔴 Due 30 Oct, 4 days overdue |
| 🐞 `Day03NextGreaterIndex` | Monotonic stack: next greater | 29 Oct | ✅ 29 Oct 37/37, both bugs found (only cosmetic slips) · never redone | +1 | **3 Nov** | 🔴 Due 30 Oct, 4 days overdue |
| 🧩 `AsteroidCollision` | Stack: collision simulation | 31 Oct | ✅ 31 Oct 28/28, no conceptual issue · never redone | +1 | **4 Nov** | 🔴 Due 1 Nov, queued 3 days |
| 🐞 `Day01ArrayStack` | Design: array-backed stack | 31 Oct | ✅ 31 Oct `Day01ArrayStackRedo7` clean cold 17/17 → moved up 3 → 7 | +7 | **7 Nov** | 🔵 Ready for revision · on time |
| 🧩 `CarFleet` | Stack: sort by position, monotonic | not verified (2/37) | — | joins at +1 once verified | — | ⬜ Not started |
| 🐞 `Day04LargestRectangle` | Monotonic stack: largest rectangle | not verified (15/36) | — | joins at +1 once verified | — | ⬜ Not started |
| 🐞 `Day00BuggyExample` | Array scan: max with edge cases (warm-up) | not verified (4/10) | — | joins at +1 once verified | — | ⬜ Not started |

> [!NOTE]
> **11 problems**: 8 scheduled, 3 not started. "Next due" is the day the redo is queued; when the cap pushes it, the Status says how many days it waited. No day holds more than 2 (1 Nov: 2, 2 Nov: 2, 3 Nov: 2, 4 Nov: 1, 7 Nov: 1).

## 🗓️ Next 7 days
| Date | Redo 1 | Redo 2 | Why |
|---|---|---|---|
| Sun 1 Nov | `Day02RpnEvaluator` (+1) | `ValidParentheses` (+1, late) | Reset after the 31 Oct conceptual misses, then the most overdue |
| Mon 2 Nov | `MinStack` (+1, late) | `ScoreOfParentheses` (+1, late) | Most overdue |
| Tue 3 Nov | `RemoveKAdjacentDuplicates` (+1, late) | `Day03NextGreaterIndex` (+1, late) | Both were due 30 Oct (gap 1 after the 29 Oct solve) and waited behind older items |
| Wed 4 Nov | `AsteroidCollision` (+1, late) | `Day02RpnEvaluator` (+3) | `AsteroidCollision` was due 1 Nov; `Day02RpnEvaluator` +3 after its 1 Nov pass |
| Thu 5 Nov | `ValidParentheses` (+3, late) | `MinStack` (+3) | `ValidParentheses` was due 4 Nov (1 day late); `MinStack` due 5 Nov |
| Fri 6 Nov | `ScoreOfParentheses` (+3, late) | `RemoveKAdjacentDuplicates` (+3) | `ScoreOfParentheses` was due 5 Nov (1 day late); `RemoveKAdjacentDuplicates` due 6 Nov |
| Sat 7 Nov | `Day03NextGreaterIndex` (+3, late) | `Day01ArrayStack` (+7) | `Day03NextGreaterIndex` was due 6 Nov (1 day late); `Day01ArrayStack` +7 after its 31 Oct clean pass |

> [!WARNING]
> Everything after the first redo of each problem is a **projection that assumes every redo is a clean pass**. A 🟠 repeats the gap and a ❌ resets to day 1, and the queue rule moves the rest.

## 🔭 Projected calendar after 7 Nov
| Date | Redo 1 | Redo 2 |
|---|---|---|
| Sun 8 Nov | `AsteroidCollision` (+3, late) | free |
| Wed 11 Nov | `Day02RpnEvaluator` (+7) | free |
| Thu 12 Nov | `ValidParentheses` (+7) | `MinStack` (+7) |
| Fri 13 Nov | `RemoveKAdjacentDuplicates` (+7) | `ScoreOfParentheses` (+7) |
| Sat 14 Nov | `Day03NextGreaterIndex` (+7) | free |
| Sun 15 Nov | `AsteroidCollision` (+7) | free |
| Sat 21 Nov | `Day01ArrayStack` (+14) | free |
| Wed 25 Nov | `Day02RpnEvaluator` (+14) | free |
| Thu 26 Nov | `ValidParentheses` (+14) | `MinStack` (+14) |
| Fri 27 Nov | `RemoveKAdjacentDuplicates` (+14) | `ScoreOfParentheses` (+14) |
| Sat 28 Nov | `Day03NextGreaterIndex` (+14) | free |
| Sun 29 Nov | `AsteroidCollision` (+14) | free |
| Mon 21 Dec | `Day01ArrayStack` (+30) 🎓 | free |
| Fri 25 Dec | `Day02RpnEvaluator` (+30) 🎓 | free |
| Sat 26 Dec | `ValidParentheses` (+30) 🎓 | `MinStack` (+30) 🎓 |
| Sun 27 Dec | `RemoveKAdjacentDuplicates` (+30) 🎓 | `ScoreOfParentheses` (+30) 🎓 |
| Mon 28 Dec | `Day03NextGreaterIndex` (+30) 🎓 | free |
| Tue 29 Dec | `AsteroidCollision` (+30) 🎓 | free |

> [!NOTE]
> Total until everyone graduates: **38 redos** (8 problems × 5 steps, minus the 2 steps `Day01ArrayStack` already cleared), **30 of them in November on 19 of 30 days**, last graduation Tue 29 Dec. The 3 not-started problems add 5 redos each once verified.

## 🧾 History behind each row
| Problem | Events and their effect on the gap (source: [PROGRESS.md](../PROGRESS.md), [mistakes/dsa.md](mistakes/dsa.md)) |
|---|---|
| `Day01ArrayStack` | 23 Oct buggy round fixed with hints (start, gap 1) · 28 Oct cold redo ✅ 17/17, clean (1 → 3) · 31 Oct `Day01ArrayStackRedo7` ✅ clean 17/17 (3 → 7), next due 7 Nov |
| `Day02RpnEvaluator` | 24 Oct buggy round fixed, hint needed for `-3` (start, gap 1) · 27 Oct `Day02RpnEvaluatorRedo` 44/44 but re-read the original (🟠, repeats gap 1) · 31 Oct `Day02RpnEvaluatorRedo7` ❌ 3 conceptual misses before it was fixed (operator fall-through, `pop() != 1` end check, missing null guard) → reset to day 1, due 1 Nov |
| `RemoveKAdjacentDuplicates` | 29 Oct 26/26 (start) · O(n) quiz 3/5, missed the amortised argument (❌ conceptual, day 1) · due 30 Oct, never redone |
| `Day03NextGreaterIndex` | 29 Oct 37/37, both bugs found, stray `main()` removed (cosmetic, not logged) · gap 1, due 30 Oct, never redone |
| `AsteroidCollision` | 30 Oct pushed 28/28, 31 Oct verified after two cosmetic fixes · gap 1, due 1 Nov |
| `ValidParentheses` | 23 Oct starter solution understood · gap 1, due 24 Oct, never redone |
| `MinStack` | 23 Oct 10/10 · gap 1, due 24 Oct, never redone |
| `ScoreOfParentheses` | 25 Oct 37/37, written with help, dry-ran line by line · gap 1, due 26 Oct, never redone |
| `CarFleet` · `Day04LargestRectangle` · `Day00BuggyExample` | not verified (2/37, 15/36, 4/10); join the schedule at gap 1 once verified |
