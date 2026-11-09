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
| 🐞 `Day02RpnEvaluator` | Stack: expression evaluation | 5 Nov | ✅ 5 Nov `Day02RpnEvaluatorRedoNov01` (`800ad4f`): cold, **44/44, no hint**, none of the 3 conceptual misses of 31 Oct repeated (was ❌ 31 Oct, 3 conceptual misses) | +3 | **14 Nov** (due 8 Nov, queued 6 days) | 🟡 IN_PROGRESS · clean pass moved +1 → +3; the redo was 4 days late (due 1 Nov) |
| 🧩 `ValidParentheses` | Stack: matching brackets | 7 Nov | 🔶 7 Nov `ValidParenthesesRedoNov01` **18/18** (`3019054` / tip `f61c7d3`): null→IAE added **in the redo** after feedback — **still not cold-clean**; prior 6 Nov was 17/18 with guard on the wrong file | +1 (same gap) | **9 Nov** (due 8 Nov, not attempted) | 🟡 IN_PROGRESS · post-feedback fix · do **not** advance ladder until a later clean cold pass · cold redo on the blank `ValidParenthesesRedoNov08` (0/18), not attempted 8 Nov |
| 🧩 `MinStack` | Stack: auxiliary min stack (design) | 23 Oct | ✅ 23 Oct 10/10 · never redone (stub 0/10 not attempted 6, 7 or 8 Nov) | +1 | **9 Nov** | 🟡 IN_PROGRESS · ⏰ due 24 Oct · moved again with ValidParen |
| 🧩 `ScoreOfParentheses` | Stack: nesting depth / running score | 25 Oct | 🔶 25 Oct 37/37, written with help · never redone | +1 | **9 Nov** (due 26 Oct, queued) | 🟡 IN_PROGRESS · ⏰ due 26 Oct · waits behind ValidParen + MinStack · follow-up questions pending |
| 🧩 `RemoveKAdjacentDuplicates` | Stack: count stack (run-length) | 29 Oct | ❌ 29 Oct 26/26 but the O(n) quiz scored 3/5 (conceptual) · never redone | +1 (reset) | **10 Nov** (due 30 Oct, queued) | 🟡 IN_PROGRESS · ⏰ due 30 Oct · waits behind ValidParen + MinStack |
| 🐞 `Day03NextGreaterIndex` | Monotonic stack: next greater | 29 Oct | ✅ 29 Oct 37/37, both bugs found (only cosmetic slips) · never redone | +1 | **11 Nov** | 🟡 IN_PROGRESS · ⏰ due 30 Oct · queued behind ValidParen/MinStack/ScoreOf/RemoveK |
| 🧩 `AsteroidCollision` | Stack: collision simulation | 31 Oct | ✅ 31 Oct 28/28, no conceptual issue · never redone | +1 | **11 Nov** | 🟡 IN_PROGRESS · ⏰ due 1 Nov · queued with Day03 |
| 🐞 `Day01ArrayStack` | Design: array-backed stack | 31 Oct | ✅ 31 Oct `Day01ArrayStackRedo7` clean cold 17/17 → moved up 3 → 7 | +7 | **13 Nov** | 🟡 IN_PROGRESS · due 7 Nov · waits behind older items |
| 🧩 `CarFleet` | Stack: sort by position, monotonic | 3 Nov | 🔶 3 Nov 37/37 (`91cb817`), built with hints (pairing, exact cross-multiply); first solve, never redone | +1 | **4 Nov** (queued **12 Nov**) | 🟡 IN_PROGRESS · due 4 Nov, waits behind older items (cap 2 a day) |
| 🐞 `Day04LargestRectangle` | Monotonic stack: largest rectangle | 5 Nov | ✅ 5 Nov `d8306e2`: 15/36 → **36/36** in one push, three minimal changes; symptom table + `[2,1,2]` trace **graded in chat 7 Nov (supported)**; empty-stack width geometric why still soft | +1 | **12 Nov** (due 6 Nov, queued behind older items) | 🟡 IN_PROGRESS · joins the ladder · write-up graded supported |
| 🐞 `Day00BuggyExample` | Array scan: max with edge cases (warm-up) | 6 Nov | ✅ 6 Nov `c0f5d64`: **10/10** (null/empty IAE, MIN_VALUE seed, loop from 0); no written symptom groups | +1 | **7 Nov** (queued **13 Nov**) | 🟡 IN_PROGRESS · joins the ladder · queued behind older redos |

> [!NOTE]
> **11 problems**, all scheduled (`Day00BuggyExample` joined 6 Nov at +1). "Next due" is the day the redo is queued; when the cap pushes it, the Status says how many days it waited. No day holds more than 2. Updated by the **7 Nov evening review**. ValidParen **18/18** 🔶 post-feedback (`3019054`, same +1 → due **8 Nov**); MinStack not attempted → moves to **8 Nov**. The **8 Nov 10 PM check** found neither 8 Nov redo attempted, so the queue moves one day: **Mon 9 Nov** evening is `ValidParentheses` then `MinStack`. **9 Nov evening review (~8 PM):** neither redo attempted yet (`ValidParenthesesRedoNov08` 0/18, `MinStackRedoNov01` 0/10); no row changed, both still due tonight. The calendar below assumes every redo is a clean pass except where marked 🔶.

## 🗓️ Next 7 days
| Date | Redo 1 | Redo 2 | Why |
|---|---|---|---|
| Mon 9 Nov | `ValidParentheses` (+1, 🔶 re-queue; blank `ValidParenthesesRedoNov08`) | `MinStack` (+1, late) | Neither attempted 8 Nov; ValidParen same gap after 7 Nov post-feedback 18/18; MinStack still never redone |
| Tue 10 Nov | `ScoreOfParentheses` (+1, late) | `RemoveKAdjacentDuplicates` (+1, late) | Due 26 Oct and 30 Oct |
| Wed 11 Nov | `Day03NextGreaterIndex` (+1, late) | `AsteroidCollision` (+1, late) | Due 30 Oct and 1 Nov |
| Thu 12 Nov | `CarFleet` (+1, late) | `Day04LargestRectangle` (+1, late) | Due 4 Nov and 6 Nov |
| Fri 13 Nov | `Day00BuggyExample` (+1, new 6 Nov) | `Day01ArrayStack` (+7, late) | Day00 queued; Day01 due 7 Nov |
| Sat 14 Nov | `Day02RpnEvaluator` (+3, late) | free | Due 8 Nov |
| Sun 15 Nov | `Day03NextGreaterIndex` (+3) | `AsteroidCollision` (+3) | Projection if 11 Nov clean |

> [!WARNING]
> Everything after the first redo of each problem is a **projection that assumes every redo is a clean pass**. A 🔶 repeats the gap and a ❌ resets to day 1, and the queue rule moves the rest.

## 🔭 Projected calendar after 15 Nov
| Date | Redo 1 | Redo 2 |
|---|---|---|
| Mon 16 Nov | `CarFleet` (+3) | `Day04LargestRectangle` (+3) |
| Wed 18 Nov | `Day02RpnEvaluator` (+7) | free |
| Thu 19 Nov | `ValidParentheses` (+7) | `MinStack` (+7) |
| Fri 20 Nov | `ScoreOfParentheses` (+7) | `RemoveKAdjacentDuplicates` (+7) |
| Sat 21 Nov | `Day03NextGreaterIndex` (+7) | `AsteroidCollision` (+7) |
| Sun 22 Nov | `CarFleet` (+7) | `Day04LargestRectangle` (+7) |
| Wed 25 Nov | `Day01ArrayStack` (+14) | free |
| Wed 2 Dec | `Day02RpnEvaluator` (+14) | free |
| Thu 3 Dec | `ValidParentheses` (+14) | `MinStack` (+14) |
| Fri 4 Dec | `ScoreOfParentheses` (+14) | `RemoveKAdjacentDuplicates` (+14) |
| Sat 5 Dec | `Day03NextGreaterIndex` (+14) | `AsteroidCollision` (+14) |
| Sun 6 Dec | `CarFleet` (+14) | `Day04LargestRectangle` (+14) |
| Fri 25 Dec | `Day01ArrayStack` (+30) 🎓 | free |
| Fri 1 Jan | `Day02RpnEvaluator` (+30) 🎓 | free |
| Sat 2 Jan | `ValidParentheses` (+30) 🎓 | `MinStack` (+30) 🎓 |
| Sun 3 Jan | `ScoreOfParentheses` (+30) 🎓 | `RemoveKAdjacentDuplicates` (+30) 🎓 |
| Mon 4 Jan | `Day03NextGreaterIndex` (+30) 🎓 | `AsteroidCollision` (+30) 🎓 |
| Tue 5 Jan | `CarFleet` (+30) 🎓 | `Day04LargestRectangle` (+30) 🎓 |

> [!NOTE]
> This calendar was rebuilt on 5 Nov with a simple rule: 2 a day, the most overdue first, each next gap counted from the pass date. Total until everyone graduates: **47 redos from 6 Nov, 28 of them in November** (6-30 Nov), last graduation Mon 4 Jan 2027. **8 Nov 10 PM:** both 8 Nov redos were missed, so every date above moved one day: about **52 redos from 9 Nov** on the full ladder (11 problems, `Day00BuggyExample` included; the table lists 44 because it leaves out some +3 steps and `Day00BuggyExample` after +1), **25 of them in 9-30 Nov**, last graduation **Tue 5 Jan 2027**.

## 🧾 History behind each row
| Problem | Events and their effect on the gap (source: [PROGRESS.md](../PROGRESS.md), [mistakes/dsa.md](mistakes/dsa.md)) |
|---|---|
| `Day01ArrayStack` | 23 Oct buggy round fixed with hints (start, gap 1) · 28 Oct cold redo ✅ 17/17, clean (1 → 3) · 31 Oct `Day01ArrayStackRedo7` ✅ clean 17/17 (3 → 7), due 7 Nov, queued to 9 Nov by the cap |
| `Day02RpnEvaluator` | 24 Oct buggy round fixed, hint needed for `-3` (start, gap 1) · 27 Oct `Day02RpnEvaluatorRedo` 44/44 but re-read the original (🔶, repeats gap 1) · 31 Oct `Day02RpnEvaluatorRedo7` ❌ 3 conceptual misses before it was fixed (operator fall-through, `pop() != 1` end check, missing null guard) → reset to day 1, due 1 Nov · 1 Nov redo not attempted, moved to 2 Nov · 2 Nov not attempted, moved to 3 Nov · 3 Nov not attempted, moved to 4 Nov · 4 Nov not attempted (the RPN redo had moved into the morning DSA slot), moved to 5 Nov · **5 Nov `Day02RpnEvaluatorRedoNov01` ✅ clean cold 44/44, no hint (`800ad4f`), moved +1 → +3, due 8 Nov** |
| `RemoveKAdjacentDuplicates` | 29 Oct 26/26 (start) · O(n) quiz 3/5, missed the amortised argument (❌ conceptual, day 1) · due 30 Oct, never redone |
| `Day03NextGreaterIndex` | 29 Oct 37/37, both bugs found, stray `main()` removed (cosmetic, not logged) · gap 1, due 30 Oct, never redone |
| `AsteroidCollision` | 30 Oct pushed 28/28, 31 Oct verified after two cosmetic fixes · gap 1, due 1 Nov, queued to 8 Nov |
| `ValidParentheses` | 23 Oct starter solution understood · gap 1, due 24 Oct · 5 Nov evening not attempted → 6 Nov · 6 Nov `ValidParenthesesRedoNov01` 17/18 🔶 (`c0f5d64`; null guard on original in `ec608e3`) → same +1, due 7 Nov · **7 Nov `ValidParenthesesRedoNov01` 18/18 🔶** (`3019054`, null→IAE in the redo after feedback) → same +1, due 8 Nov · 8 Nov cold `ValidParenthesesRedoNov08` not attempted → 9 Nov |
| `MinStack` | 23 Oct 10/10 · gap 1, due 24 Oct, never redone · stub 0/10 not attempted 6–8 Nov → due 9 Nov |
| `ScoreOfParentheses` | 25 Oct 37/37, written with help, dry-ran line by line · gap 1, due 26 Oct, never redone |
| `CarFleet` | 3 Nov 37/37 (`91cb817`), hint-assisted (🔶) · gap 1, due 4 Nov, queued to 9 Nov |
| `Day04LargestRectangle` | 5 Nov 36/36 (`d8306e2`, from 15/36), first verified solve, joins at +1 (due 6 Nov, queued 11 Nov by the cap) · symptom table + `[2,1,2]` graded in chat 7 Nov (supported); empty-stack width geometric why still soft |
| `Day00BuggyExample` | **6 Nov `c0f5d64` 10/10** verified · joins at +1 (due 7 Nov, queued 11 Nov by the cap) · no written symptom groups |

> [!NOTE]
> **2 Nov, 22:35 IST late push (`0600df2`):** only Part B2 was touched. No DSA or buggy redo was graded (`CarFleetTest` 2/37, `Day04LargestRectangleTest` 15/36, `Day02RpnEvaluatorRedoNov01Test` 0/44, `ValidParenthesesRedoNov01Test` 0/18, all re-run), so every gap, due date and the 3-9 Nov calendar above stay exactly as the 10 PM check set them.

> [!NOTE]
> **3 Nov, 17:37 IST push (`91cb817`):** `CarFleet` verified 37/37 with hints, so it joins at gap 1 as 🔶 (due 4 Nov). Both 4 Nov and 5 Nov already hold 2 older redos and 6 Nov, 7 Nov, 8 Nov and 9 Nov are full or hold more overdue items, so it takes the free slot on Tue 10 Nov. The cap of 2 a day is kept. Nothing else moved: the two 3 Nov redos are still due tonight.

> [!NOTE]
> **3 Nov, 10 PM check:** no commits after the 8 PM evening review (`28516c6` is the review itself) and no answers in chat, so nothing new to test. `Day02RpnEvaluatorRedoNov01` (0/44) and `ValidParenthesesRedoNov01` (0/18) were not attempted on 3 Nov, so the whole queue moves one more day: 4 Nov starts with those two, `CarFleet` is queued to Wed 11 Nov, and the last graduation is Mon 4 Jan.

> [!NOTE]
> **4 Nov, 10 PM check:** no commits after the 8 PM evening review (`210d691` is the review itself, and the only commit today before it is the 6 AM session `4d1db80`) and no answers in chat, so nothing new to test and no redo to grade. `Day02RpnEvaluatorRedoNov01` (0/44, planned for the morning DSA slot) and `ValidParenthesesRedoNov01` (0/18) were not attempted a fourth time, so the whole queue moves one more day: 5 Nov starts with those two, `CarFleet` is queued to Thu 12 Nov, and the last graduation is Tue 5 Jan. No ladder step changed.

> [!NOTE]
> **5 Nov, 10 PM check:** no commits after the 8 PM evening review (`56ff10f` is the review itself; the last code push today is `d8306e2`) and no answers in chat, so nothing new to test. `ValidParenthesesRedoNov01` (0/18) was not attempted tonight, so no ladder step changed; the queue was rebuilt from 6 Nov with the cap of 2 and the most overdue first (6 Nov starts with `ValidParentheses` and `MinStack`).

> [!NOTE]
> **6 Nov, catch-up evening review (~8:30 PM IST):** tip `ec608e3`. `ValidParenthesesRedoNov01` is **17/18** post-feedback (null→IAE still missing in the redo file) — **not** cold-clean, ladder stays at +1. `MinStackRedoNov01` not attempted. `Day00BuggyExample` joins at +1. Queue rebuilt from Sat 7 Nov with the cap of 2. No new conceptual mistake logged. CarFleet comment PR #1 remains open on a side branch.

> [!NOTE]
> **7 Nov, 6 AM morning session:** no student push overnight after `03a1373`. Queue unchanged: tonight still `ValidParentheses` (finish null in redo, stays 🔶) then `MinStack`. No new redo stubs; existing blank / partial files kept. Spec: [day16.md](../tasks/day16.md).

> [!NOTE]
> **7 Nov, evening review (~8:00 PM IST):** tip `f61c7d3`. `ValidParenthesesRedoNov01` **18/18** after feedback (`3019054`, null→IAE in the redo) — **not** cold-clean, ladder stays at +1, next due **8 Nov**. `MinStackRedoNov01` not attempted (0/10) → moves to **8 Nov**. Queue rebuilt from Sun 8 Nov with the cap of 2. LargestRectangle write-up graded in chat (supported). No new conceptual mistake logged.

> [!NOTE]
> **8 Nov, 6 AM morning session:** no student push after `795b269` (last student code `3019054`). Queue unchanged: tonight `ValidParentheses` then `MinStack`. New blank stub `redo/ValidParenthesesRedoNov08.java` + `ValidParenthesesRedoNov08Test` (18 tests, verified against a local correct version that is not pushed; 0/18 on the stub), because `ValidParenthesesRedoNov01` already holds the 7 Nov answer and cannot be redone cold. `MinStackRedoNov01` stays the MinStack file (untouched, 0/10). Removed two stray wrapper lines left at the top and bottom of this file by an earlier push (cosmetic). Spec: [day17.md](../tasks/day17.md).

> [!NOTE]
> **8 Nov, evening review (~7:58 PM IST):** tip `73a1fd7`. No student push after the morning session (`1af6500` / `73a1fd7`). `ValidParenthesesRedoNov08` still **0/18** (blank stub, not attempted). `MinStackRedoNov01` still **0/10** (not attempted). No ladder step changed; both remain due **tonight (8 Nov)**. Queue unchanged. No new conceptual mistake logged. Spec: [day17.md](../tasks/day17.md).

> [!NOTE]
> **8 Nov, 10 PM check:** no student commits after the evening review (`b0ac31f` is the review itself; last student code still `3019054`) and no answers in chat. `ValidParenthesesRedoNov08` (0/18) and `MinStackRedoNov01` (0/10) were not attempted, so no ladder step changed and the queue was rebuilt from **Mon 9 Nov** with the cap of 2 and the most overdue first; the projected calendar moved one day (last graduation Tue 5 Jan). Housekeeping: removed extra blank lines between the notes. No new conceptual mistake.

> [!NOTE]
> **9 Nov, 6 AM morning session:** no student push after `e480448` (last student code `3019054`). Queue unchanged: tonight `ValidParenthesesRedoNov08` (0/18) then `MinStackRedoNov01` (0/10), both existing blank stubs, so no new redo files. Spec: [day18.md](../tasks/day18.md).
