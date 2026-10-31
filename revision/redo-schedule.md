# 🔁 DSA redo schedule

![Spaced repetition](https://img.shields.io/badge/redo-%2B1%20%2B3%20%2B7%20%2B14%20%2B30-purple) ![Problems](https://img.shields.io/badge/problems-11-blue) ![Cap](https://img.shields.io/badge/cap-2%20redos%20per%20day-yellow) ![Start](https://img.shields.io/badge/start-1%20Nov%202026-blue)

> [!IMPORTANT]
> Every DSA problem and buggy round is redone cold at **+1, +3, +7, +14 and +30 days** after its last verified solve, at most **2 redos a day**, so the backlog never lands on one day and each pattern gets time to stick. This file is the single source for "what do I redo today?"; conceptual mistakes still go to [mistakes/dsa.md](mistakes/dsa.md).

> [!NOTE]
> **Legend:** 🧩 DSA · 🐞 buggy round · 🔁 redo · ✅ passed (all tests) · ❌ miss · ⬜ not started · 🔵 ready for revision · 🔴 overdue · 🎓 graduated. Other logs: [mistake-log index](mistake-log.md) · [PROGRESS.md](../PROGRESS.md).

## 📏 Rules
| # | Rule |
|---|---|
| 1 | **Intervals:** redo cold at +1, +3, +7, +14 and +30 days after the **last verified solve** (the solve that opened the cycle: the first all-pass, or the first all-pass after a miss). Offsets are always counted from that solve, not from the previous redo. |
| 2 | **A miss resets:** anything short of all tests passing (or needing the original open, or a hint) is a miss. The problem goes back to **+1 day**, and the day it is finally verified becomes the new last verified solve. |
| 3 | **How to redo:** blank file, no peeking, timed at **20-30 minutes**. Before any code, write the **pattern line** and the **time and space complexity** at the top as comments. |
| 4 | **Graduation:** after the +30 pass the problem graduates 🎓 and leaves the schedule. |
| 5 | **Cap:** at most **2 redos per day**. If more are due, take the most overdue first; the rest wait in the queue and move to the next free day. |
| 6 | **Tie-break:** a date already written in an open mistake-log row (conceptual mistake) is kept first; the remaining slots go to the most overdue. |
| 7 | **Late passes absorb offsets:** a pass on day +N clears every offset up to N. The next due date is the next offset after the pass, but if that is only 1 day away it is skipped to the following offset (never the same problem on 2 days in a row). |
| 8 | **Buggy rounds** (`Day0N...` in `dailytests`) follow exactly the same schedule. A redo file (`...Redo`, `...Redo7`) is a redo of its problem, not a new problem. |
| 9 | **New problems:** a not-started problem joins the schedule the day it is verified (first redo at +1); it takes a free slot, never a third one. |

> [!TIP]
> Redo checklist: ① blank file ② 3 comment lines: pattern, time, space ③ set a 25-minute timer ④ `mvn test -Dtest=<Problem>Test` ⑤ all green = ✅ pass, anything else = ❌ miss (log the conceptual part in [mistakes/dsa.md](mistakes/dsa.md)).

## 📋 The schedule
| Problem | Pattern | Last verified | Current interval | Next due | Status |
|---|---|---|---|---|---|
| 🧩 `RemoveKAdjacentDuplicates` | Stack: count stack (run-length) | 29 Oct | +3 (step 2 of 5) | **1 Nov** | 🔵 Ready for revision · pinned by the mistake log (also the O(n) quiz, scored 3/5) |
| 🐞 `Day02RpnEvaluator` | Stack: expression evaluation | 31 Oct (reset, fixed in 3 review rounds) | +1 (step 1 of 5) | **1 Nov** | 🔵 Ready for revision · the 24 Oct, 27 Oct and 31 Oct rows all end in the 3 Nov and 7 Nov redos |
| 🧩 `ValidParentheses` | Stack: matching brackets | 23 Oct | +1 (step 1 of 5, never redone) | **2 Nov** | 🔴 Overdue 9 days · oldest first |
| 🧩 `MinStack` | Stack: auxiliary min stack (design) | 23 Oct | +1 (step 1 of 5, never redone) | **2 Nov** | 🔴 Overdue 9 days · oldest first |
| 🧩 `ScoreOfParentheses` | Stack: nesting depth / running score | 25 Oct (written with help) | +1 (step 1 of 5, never redone) | **3 Nov** | 🔴 Overdue 8 days · follow-up questions still pending |
| 🐞 `Day03NextGreaterIndex` | Monotonic stack: next greater | 29 Oct | +3 (step 2 of 5) | **4 Nov** | 🔵 Ready for revision · nominal 1 Nov, queued 3 days |
| 🧩 `AsteroidCollision` | Stack: collision simulation | 31 Oct | +1 (step 1 of 5) | **4 Nov** | 🔵 Ready for revision · nominal 1 Nov, queued 3 days |
| 🐞 `Day01ArrayStack` | Design: array-backed stack | 23 Oct (cold passes 28 Oct and 31 Oct) | +14 (step 4 of 5) | **6 Nov** | 🔵 Ready for revision · +1, +3 and +7 cleared |
| 🧩 `CarFleet` | Stack: sort by position, monotonic | not verified (2/37) | joins at +1 once verified | — | ⬜ Not started |
| 🐞 `Day04LargestRectangle` | Monotonic stack: largest rectangle | not verified (15/36) | joins at +1 once verified | — | ⬜ Not started |
| 🐞 `Day00BuggyExample` | Array scan: max with edge cases (warm-up) | not verified (4/10) | joins at +1 once verified | — | ⬜ Not started |

> [!NOTE]
> **11 problems**: 8 scheduled, 3 not started. No day holds more than 2 "next due" items (1 Nov: 2, 2 Nov: 2, 3 Nov: 1, 4 Nov: 2, 6 Nov: 1).

## 🗓️ Next 7 days
| Date | Redo 1 | Redo 2 | Why |
|---|---|---|---|
| Sun 1 Nov | `RemoveKAdjacentDuplicates` (+3) | `Day02RpnEvaluator` (+1) | Mistake-log date and the reset after the 31 Oct miss |
| Mon 2 Nov | `ValidParentheses` (+1, late) | `MinStack` (+1, late) | Most overdue |
| Tue 3 Nov | `Day02RpnEvaluator` (+3) | `ScoreOfParentheses` (+1, late) | Mistake-log date, then next most overdue |
| Wed 4 Nov | `Day03NextGreaterIndex` (+3, late) | `AsteroidCollision` (+1, late) | Both were due 1 Nov and waited in the queue |
| Thu 5 Nov | `RemoveKAdjacentDuplicates` (+7) | free | Mistake-log date |
| Fri 6 Nov | `Day01ArrayStack` (+14) | `ValidParentheses` (+14) | Due after the 2 Nov pass |
| Sat 7 Nov | `Day02RpnEvaluator` (+7) | `MinStack` (+14) | Mistake-log date; `MinStack` waited from 6 Nov |

> [!WARNING]
> From 3 Nov on, rows are projected assuming every redo passes. A miss moves that problem back to +1 and everything shifts by the queue rule.

## 🔭 Projected calendar after 7 Nov
| Date | Redo 1 | Redo 2 |
|---|---|---|
| Sun 8 Nov | `ScoreOfParentheses` (+14) | `AsteroidCollision` (+7, 1 day late) |
| Thu 12 Nov | `RemoveKAdjacentDuplicates` (+14) | `Day03NextGreaterIndex` (+14) (its +7 on 5 Nov is absorbed by the 4 Nov pass) |
| Sat 14 Nov | `Day02RpnEvaluator` (+14) | `AsteroidCollision` (+14) |
| Sun 22 Nov | `ValidParentheses` (+30) 🎓 | `MinStack` (+30) 🎓 |
| Mon 23 Nov | `Day01ArrayStack` (+30, 1 day late) 🎓 | free |
| Tue 24 Nov | `ScoreOfParentheses` (+30) 🎓 | free |
| Sat 28 Nov | `RemoveKAdjacentDuplicates` (+30) 🎓 | `Day03NextGreaterIndex` (+30) 🎓 |
| Mon 30 Nov | `Day02RpnEvaluator` (+30) 🎓 | `AsteroidCollision` (+30) 🎓 |

## 🧾 History behind each row
| Problem | Events (source: [PROGRESS.md](../PROGRESS.md), [mistakes/dsa.md](mistakes/dsa.md)) | Mistake-log dates kept |
|---|---|---|
| `Day01ArrayStack` | 23 Oct buggy round fixed with hints (17/17) · 28 Oct cold redo ✅ 17/17 (5 days after, 2 days late) · 31 Oct `Day01ArrayStackRedo7` ✅ 17/17 cold, no conceptual issue | 28 Oct and 30 Oct done (30 Oct ran on 31 Oct); next +14 = 6 Nov |
| `Day02RpnEvaluator` | 24 Oct buggy round fixed, hint needed for `-3` · 27 Oct `Day02RpnEvaluatorRedo` ❌ (44/44 but re-read the original) · 31 Oct `Day02RpnEvaluatorRedo7` ❌ 15/44, then 43/44, then ✅ 44/44 after three review rounds, so the cycle resets with 31 Oct as the last verified solve | 27 Oct, 31 Oct done; **3 Nov** and **7 Nov** kept (they are exactly +3 and +7 from 31 Oct) |
| `Day03NextGreaterIndex` | 29 Oct 37/37, both bugs found, stray `main()` removed (cosmetic, not logged) | 1 Nov and 5 Nov from the PROGRESS backlog: 1 Nov slips to 4 Nov (cap), the 5 Nov step is absorbed |
| `RemoveKAdjacentDuplicates` | 29 Oct 26/26, "why is the count stack O(n)" quiz 3/5 | **1 Nov** and **5 Nov** kept |
| `AsteroidCollision` | 30 Oct pushed 28/28, 31 Oct verified after two cosmetic fixes (no conceptual issue) | none |
| `ValidParentheses` | 23 Oct starter solution understood, no cold redo yet | none |
| `MinStack` | 23 Oct 10/10 | none |
| `ScoreOfParentheses` | 25 Oct 37/37, written with help, dry-ran line by line | none |
| `CarFleet` | stub only, 2/37 (stub tests that pass by accident don't count) | none |
| `Day04LargestRectangle` | not attempted, 15/36 | none |
| `Day00BuggyExample` | warm-up round from the project setup, unfixed, 4/10 | none |
