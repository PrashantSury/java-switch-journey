# 🔁 DSA redo schedule

![Spaced repetition](https://img.shields.io/badge/redo-results--based%201%20%E2%86%92%203%20%E2%86%92%207%20%E2%86%92%2014%20%E2%86%92%2030-purple) ![Problems](https://img.shields.io/badge/problems-18-blue) ![Cap](https://img.shields.io/badge/cap-2%20redos%20per%20day-yellow) ![Start](https://img.shields.io/badge/start-1%20Nov%202026-blue)

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
| 🐞 `Day02RpnEvaluator` | Stack: expression evaluation | 5 Nov | ✅ 5 Nov `Day02RpnEvaluatorRedoNov01` (`800ad4f`): cold, **44/44, no hint**, none of the 3 conceptual misses of 31 Oct repeated (was ❌ 31 Oct, 3 conceptual misses) | +3 | **Mon 30 Nov** (due 8 Nov, queued; moved from 24, 26, 27, 28, 29 Nov by the missed pairs) | 🟡 IN_PROGRESS · clean pass moved +1 → +3; the redo was 4 days late (due 1 Nov) |
| 🧩 `ValidParentheses` | Stack: matching brackets | 12 Nov | ✅ 12 Nov `ValidParenthesesRedoNov08` **18/18** (`d6ca103`): cold on the blank file, null→IAE first try, no hint, no post-push fix (was 🔶 7 Nov post-feedback); complexity lines lack the one-sentence reasons (cosmetic) | +3 | **Sun 15 Nov** (queued **Tue 1 Dec** by the cap) | 🟡 IN_PROGRESS · clean pass moved +1 → +3 |
| 🧩 `MinStack` | Stack: auxiliary min stack (design) | 12 Nov | ✅ 12 Nov `MinStackRedoNov01` **10/10** (`d6ca103`): cold, parallel min stack, duplicates / `MIN_VALUE` safe, IllegalStateException on empty, pattern/time/space with reasons | +3 | **Sun 15 Nov** (queued **Tue 1 Dec** by the cap) | 🟡 IN_PROGRESS · first redo since 23 Oct, clean → +1 → +3 |
| 🧩 `ScoreOfParentheses` | Stack: nesting depth / running score | 16 Nov | 🔶 16 Nov `ScoreOfParenthesesRedoNov16` **37/37** (`d94f802`) but **not cold**: body identical to the original; no complexity reasons, no pseudocode (was 🔶 25 Oct, written with help) | +1 (repeat) | **Tue 17 Nov** (queued **Wed 2 Dec** by the cap) | 🟡 IN_PROGRESS · blank stub `redo/ScoreOfParenthesesRedoNov23` to be created · follow-up questions pending |
| 🧩 `RemoveKAdjacentDuplicates` | Stack: count stack (run-length) | 16 Nov | 🔶 16 Nov `RemoveKAdjacentDuplicatesRedoNov16` **26/26** (`d94f802`) but **not cold**: body + `Pair` identical to the original, imports the original class; the O(n) reason (29 Oct ❌) still unwritten | +1 (repeat) | **Tue 17 Nov** (queued **Wed 2 Dec** by the cap) | 🟡 IN_PROGRESS · blank stub `redo/RemoveKAdjacentDuplicatesRedoNov23` to be created · goes first on its day (logged conceptual mistake) |
| 🐞 `Day03NextGreaterIndex` | Monotonic stack: next greater | 19 Nov | ✅ 19 Nov `Day03NextGreaterIndexRedoNov17` **37/37** (`2c0c2fb`, 4:49 PM IST): cold on the blank stub, decreasing stack of indices, null → IAE, `Arrays.fill(-1)`; written from scratch (own names and messages, not a copy). Cosmetic gaps: pattern line says only "stack" (should be monotonic stack), time/space without reasons, no pseudocode | +3 | **Sun 22 Nov** (queued **Fri 4 Dec** by the cap) | 🟡 IN_PROGRESS · clean pass moved +1 → +3 (20 days late) |
| 🧩 `AsteroidCollision` | Stack: collision simulation | 31 Oct | ✅ 31 Oct 28/28, no conceptual issue · never redone. 27 Nov `663077f`: pseudocode comments were added to the **original** `dsa/stack/AsteroidCollision.java` (logic unchanged, original still **28/28**); `AsteroidCollisionRedoNov17` is still the blank stub (0/28, 2 failures + 26 errors) | +1 | **Sat 28 Nov** (due 1 Nov; still 0/28 at the 27 Nov 10 PM check: missed, not failed) | 🟡 IN_PROGRESS · ⏰ due 1 Nov · write the redo in `redo/AsteroidCollisionRedoNov17`, not the original |
| 🐞 `Day01ArrayStack` | Design: array-backed stack | 31 Oct | ✅ 31 Oct `Day01ArrayStackRedo7` clean cold 17/17 → moved up 3 → 7 | +7 | **Sun 29 Nov** (due 7 Nov, queued) | 🟡 IN_PROGRESS · due 7 Nov · waits behind older items |
| 🧩 `CarFleet` | Stack: sort by position, monotonic | 27 Nov | 🔶 27 Nov `CarFleetRedoNov20` **37/37** (`663077f`) but **not cold**: body identical to `dsa/stack/CarFleet.java` (same exception messages, validation order, `long[] {dist, spd}` stack, cross-multiply and merge comment); the same commit also pasted the same pseudocode onto the original (logic unchanged, original still 37/37). Copy is not a clean pass (rule 3: same gap). Was 🔶 3 Nov, first solve with hints | +1 (repeat) | **Sat 28 Nov** (queued **Sun 6 Dec**, slot 1, by the cap; 27 Nov 10 PM check) | 🟡 IN_PROGRESS · blank stub `redo/CarFleetRedoNov28` to be created by a morning session before its slot |
| 🐞 `Day04LargestRectangle` | Monotonic stack: largest rectangle | 5 Nov | ✅ 5 Nov `d8306e2`: 15/36 → **36/36** in one push, three minimal changes; symptom table + `[2,1,2]` trace **graded in chat 7 Nov (supported)**; empty-stack width geometric why still soft | +1 | **Sat 28 Nov** (due 6 Nov, queued behind older items) | 🟡 IN_PROGRESS · blank stub `redo/Day04LargestRectangleRedoNov28` + `Day04LargestRectangleContract` (36 cases) handed out 28 Nov · joins the ladder · write-up graded supported |
| 🐞 `Day00BuggyExample` | Array scan: max with edge cases (warm-up) | 6 Nov | ✅ 6 Nov `c0f5d64`: **10/10** (null/empty IAE, MIN_VALUE seed, loop from 0); no written symptom groups | +1 | **7 Nov** (queued **Sun 29 Nov**) | 🟡 IN_PROGRESS · joins the ladder · queued behind older redos |
| 🧩 `DailyTemperatures` | Monotonic stack: next warmer day (indices) | 12 Nov | ✅ 12 Nov `d6ca103` **18/18**, first verified solve; amortised time reason written; pseudocode comments ✅ 27 Nov `6e3e459` (match the code; cosmetic newline added in the grading commit) | +1 | **Fri 13 Nov** (queued **Mon 30 Nov**) | 🟡 IN_PROGRESS · joins the ladder (rule 9) |
| 🧩 `GenerateParentheses` | Backtracking with two counters (call stack as the stack) | 17 Nov | ✅ 17 Nov `221069b` **17/17**, first verified solve, 9/10: pseudocode + brute force first, reasons on time/space | +1 | **Wed 18 Nov** (queued **Thu 3 Dec**, most-overdue order) | 🟡 IN_PROGRESS · joins the ladder (rule 9) |
| 🧩 `ContainsDuplicate` | Arrays & Hashing: hash-set membership | 19 Nov | 🔶 19 Nov `eeb8bb9` **17/17**, first verified solve, closed on day 3 with the visible skeleton (solved with hints); `contains` + `add` instead of using `add`'s return value; time line without a reason | +1 | **Fri 20 Nov** (queued **Fri 4 Dec**, moved 27 Nov 10 PM; most-overdue order) | 🟡 IN_PROGRESS · joins the ladder (rule 9) |
| 🧩 `ValidAnagram` | Arrays & Hashing: frequency counting (`int[26]`) | 19 Nov | ❌ 19 Nov first push compared character **sums** (conceptual, logged in [mistakes/dsa.md](mistakes/dsa.md)); fixed after review in `97dbc9f` → **18/18** with the `ac`/`bb` collision test (`a4bd5b6`) | +1 (day 1) | **Fri 20 Nov** (queued **Thu 3 Dec**, slot 2; ahead of ContainsDuplicate because of the logged mistake) | 🟡 IN_PROGRESS · joins the ladder at day 1 |
| 🧩 `TwoSum` | Arrays & Hashing: complement lookup (value → index map) | 23 Nov | 🔶 23 Nov `3a620f4` **19/19**, first verified solve, closed on day 4 with the near-full skeleton (two blanks); pseudocode, brute-force cost and time/space **with reasons** written; no conceptual issue | +1 | **Tue 24 Nov** (queued **Sat 5 Dec**, moved 27 Nov 10 PM; most-overdue order) | 🟡 IN_PROGRESS · joins the ladder (rule 9) |
| 🐞 `Day06FirstUniqueCode` | Arrays & Hashing: frequency counting (first unique) | 27 Nov | ✅ 27 Nov `663077f` **20/20**: last loop bound `letter < 26` → `letter < codes.length()` (loop header had been given). Q8, Q9, Q11 right in chat; Q10 partial (answered about the fixed loop). Conceptual miss of 21 Nov is already logged | +1 | **Sat 28 Nov** (queued **Sat 5 Dec**, slot 2, by the cap; ahead of CarFleet: logged conceptual mistakes 21 + 27 Nov) | 🟡 IN_PROGRESS · joins the ladder (rule 9) |
| 🧩 `GroupAnagrams` | Arrays & Hashing: canonical key → list (`int[26]` count key + `#`) | 27 Nov | 🔶 27 Nov `a7ba6d5` **22/22**, first verified solve: count key + `#` separator, `LinkedHashMap` + `computeIfAbsent`, `O(n·k)` with a because; closed on day 4 with the full skeleton, a-z IAE guard added only after the review (20/22 → 22/22). No conceptual issue | +1 | **Sat 28 Nov** (queued **Sun 6 Dec**, slot 2; first free slot, rule 9) | 🟡 IN_PROGRESS · joins the ladder (rule 9) · blank stub + `GroupAnagramsContract` to be created before its slot |

> [!NOTE]
> **12 problems** (`DailyTemperatures` joined 12 Nov at +1), all scheduled. Earlier: **11 problems**, all scheduled (`Day00BuggyExample` joined 6 Nov at +1). "Next due" is the day the redo is queued; when the cap pushes it, the Status says how many days it waited. No day holds more than 2. Updated by the **7 Nov evening review**. ValidParen **18/18** 🔶 post-feedback (`3019054`, same +1 → due **8 Nov**); MinStack not attempted → moves to **8 Nov**. The **8 Nov 10 PM check** found neither 8 Nov redo attempted, so the queue moves one day: **Mon 9 Nov** evening is `ValidParentheses` then `MinStack`. **9 Nov evening review (~8 PM):** neither redo attempted yet (`ValidParenthesesRedoNov08` 0/18, `MinStackRedoNov01` 0/10); no row changed, both still due tonight. **9 Nov 10 PM check:** neither attempted, so the queue moves one more day: **Tue 10 Nov** evening is `ValidParentheses` then `MinStack`. **10 Nov evening review:** neither attempted yet, no row changed. **10 Nov 10 PM check:** neither attempted, so the queue moves one more day: **Wed 11 Nov** evening is `ValidParentheses` then `MinStack`. The calendar below assumes every redo is a clean pass except where marked 🔶.

> [!NOTE]
> **19 Nov evening review (~8 PM IST):** `Day03NextGreaterIndex` ✅ clean cold (+1 → +3; the existing Wed 25 Nov slot already assumed this). `ContainsDuplicate` (🔶) and `ValidAnagram` (❌, then fixed) join at +1 and take the first free slots (Tue 1 Dec, Wed 2 Dec; rule 9, never a third). **15 problems** on the ladder. `AsteroidCollision` is still due tonight.

> [!NOTE]
> **24 Nov morning (Day 33):** `TwoSum` ✅ verified 19/19 (`3a620f4`, 23 Nov 6:11 PM IST, near-full skeleton 🔶) joins at +1 and takes the first free slot after the shifted `ValidAnagram`/`ContainsDuplicate` pair (rule 9, never a third; about 6-7 Dec, projection to be rebuilt at the next evening review). Mon 23 Nov's pair was not attempted, so the queue moved one day (Asteroid + CarFleet today). **16 problems** on the ladder.

> [!NOTE]
> **25 Nov morning (Day 34):** no student commits since the Day 33 morning session and no 10 PM check on record for 24 Nov, so the missed Asteroid + CarFleet pair moved to today (same blank stubs, re-run 0/28 and 0/37) and every later slot moved one day (table above). Missed is not failed: no gap changed. **16 problems** on the ladder; projection to be rebuilt at the next evening review.

> [!NOTE]
> **25 Nov evening review (Day 34, ~8 PM IST):** no student commits on 25 Nov (tip `a06b007`, the morning session); `AsteroidCollisionRedoNov17` 0/28 and `CarFleetRedoNov20` 0/37 re-run on a fresh clone. Both missed again (not failed: no gap changed), so they move to **Thu 26 Nov** and every later slot moves one day. The shift is made now because the 24 Nov 10 PM check's records were never pushed; if either redo is pushed before the 10 PM check, that check grades it and pulls the queue back. Projection rebuilt with the same rules (2 a day, most overdue first, ties: logged mistake first, gaps from the pass date, every pass assumed clean): **74 redos from 26 Nov, 10 of them in November**, last graduation **Sat 30 Jan 2027** (`TwoSum`). **16 problems** on the ladder.

> [!NOTE]
> **26 Nov evening review (Day 35, ~8 PM IST):** no student commits on 26 Nov (tip `78404ba`, the morning session); `AsteroidCollisionRedoNov17` 0/28 and `CarFleetRedoNov20` 0/37 re-run on a fresh clone. Both missed again (not failed: no gap changed), so they move to **Fri 27 Nov** and every later slot moves one day; the projection moved one day with the same rules: **74 redos from 27 Nov, 8 of them in November**, last graduation **Sun 31 Jan 2027** (`TwoSum`). If either redo is pushed before the 10 PM check, that check grades it and pulls the queue back. **16 problems** on the ladder.

> [!NOTE]
> **27 Nov afternoon push review (Day 36, ~5:25 PM IST):** `663077f` + `6e3e459`. `CarFleetRedoNov20` **37/37** but not cold (body copied from the original) → 🔶, same gap +1, queued (Sat 28 already holds two). `AsteroidCollisionRedoNov17` still 0/28 (comments went into the original; missed, not failed). `Day06FirstUniqueCode` ✅ 20/20 joins at +1 (rule 9, first free slot, never a third). DailyTemperatures comments closed. The upcoming calendar and projection are **not rebuilt here**; the 8 PM / 10 PM routines place Asteroid, the CarFleet repeat stub, and Day06. **17 problems** on the ladder.

> [!NOTE]
> **27 Nov evening review (Day 36, ~8 PM IST):** no student commits after the afternoon grading (tip `84db3b6`); fresh clone re-run matches it (`GroupAnagrams` 20/22, `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 37/37 copy, `Day06` 20/20). `AsteroidCollision` stays due tonight (a push before the 10 PM check counts; if missed, that check moves it to Sat 28 and shifts the queue one day). `Day06FirstUniqueCode` (+1) and the `CarFleet` (+1 repeat) both fall due Sat 28 and take the first free day, **Sat 5 Dec** (Day06 first: logged conceptual mistake). The projection below 5 Dec still assumes the old Asteroid/CarFleet passes and is rebuilt at the Sunday 10 PM check. **17 problems** on the ladder.

> [!NOTE]
> **27 Nov 10 PM check (Day 36):** `a7ba6d5` (9:33 PM IST) adds the a-z IAE guard → `GroupAnagramsTest` **22/22** (`-Popen`), `mvn test` **807/807** green after removing it from `open-stubs.txt`. `GroupAnagrams` ✅ first verified solve (🔶 day-4 skeleton, guard after review) joins at +1 (rule 9) and takes the first free slot, **Sun 6 Dec**. `AsteroidCollisionRedoNov17` still 0/28 → missed, not failed: moves to **Sat 28 Nov** and every later slot moves one place (table below). Day06 Q10 partial logged in [mistakes/dsa.md](mistakes/dsa.md) (Day06 already at day 1, no change). The projection after 6 Dec is stale by one slot and is rebuilt at the Sunday 10 PM check. **18 problems** on the ladder.

## 🗓️ Next 7 days
| Date | Redo 1 | Redo 2 | Why |
|---|---|---|---|
| Thu 12 Nov | ✅ `ValidParentheses` (+1) clean cold 18/18 → +3 | ✅ `MinStack` (+1, late) clean cold 10/10 → +3 | Done by Prashant on a one-slot day (`d6ca103`, 9:01 PM IST) |
| Fri 13 Nov | on hold (one-slot day) | on hold | One slot: labs `task1c` |
| Sat 14 Nov | on hold (one-slot day) | on hold | One slot: Chapter 1 interview Q; no push landed |
| Sun 15 Nov | on hold (one-slot day) | on hold | One slot: interview + Ch 2 Task 1 (second push day); queue resumes Mon 16 Nov |
| Mon 16 Nov | 🔶 `ScoreOfParentheses` (+1) 37/37, not cold → repeat +1 | 🔶 `RemoveKAdjacentDuplicates` (+1) 26/26, not cold → repeat +1 | `d94f802`, 4:29 PM IST: bodies copied from the originals |
| Tue 17 Nov | ❌ `Day03NextGreaterIndex` not attempted → Wed 18 Nov | ❌ `AsteroidCollision` not attempted → Wed 18 Nov | Evening went to Ch 2 Task 5 fix (`00bd2eb`); queue moved one day at the 10 PM check |
| Wed 18 Nov | ❌ `Day03NextGreaterIndex` not attempted → Thu 19 Nov | ❌ `AsteroidCollision` not attempted → Thu 19 Nov | No student commits on 18 Nov; queue moved one day at the 10 PM check (missed, not failed: no gap changed) |
| **Thu 19 Nov** | ✅ `Day03NextGreaterIndex` (+1, late) clean cold **37/37** (`2c0c2fb`) → +3 | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Fri 20 Nov | 10 PM check: no student commits after the review; missed, not failed, so no gap changed and the queue moved one slot |
| **Fri 20 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Sat 21 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Sat 21 Nov | 10 PM check: no student commits after the review; missed, not failed, so no gap changed and the queue moved one slot |
| **Sat 21 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Sun 22 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Sun 22 Nov | 10 PM check: the only student commit was `41abb48` (`Day06`); missed, not failed, so no gap changed and the queue moved one slot |
| **Sun 22 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Mon 23 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Mon 23 Nov | 10 PM check: no student commits today; missed, not failed, so no gap changed and the queue moved one slot |
| **Mon 23 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Tue 24 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Tue 24 Nov | Only student commit: `3a620f4` (Two Sum, 6:11 PM IST); no 10 PM check on record, so the shift was made at the 24 Nov morning session (missed, not failed: no gap changed) |
| **Tue 24 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Wed 25 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Wed 25 Nov | No student commits on 24 Nov; no 10 PM check on record, so the shift was made at the 25 Nov morning session (missed, not failed: no gap changed) |
| **Wed 25 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Thu 26 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Thu 26 Nov | Evening review: no student commits on 25 Nov; missed, not failed, so no gap changed and the queue moved one slot (a push before the 10 PM check still counts) |
| **Thu 26 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28) → Fri 27 Nov | ❌ `CarFleet` (+1, late) not attempted (0/37) → Fri 27 Nov | Evening review: no student commits on 26 Nov; missed, not failed, so no gap changed and the queue moved one slot (a push before the 10 PM check still counts) |
| **Fri 27 Nov** | ❌ `AsteroidCollision` (+1, late) not attempted (0/28; comments went into the original) → Sat 28 Nov | 🔶 `CarFleetRedoNov20` **37/37** (`663077f`) but **not cold** (copy) → same gap +1, new blank stub, queued Sun 6 Dec | 10 PM check: only student commit after the review was `a7ba6d5` (GroupAnagrams guard); Asteroid missed, not failed, so no gap changed and the queue moved one slot |
| Sat 28 Nov | `AsteroidCollision` (+1, late) | `Day04LargestRectangle` (+1, late) | Due 1 Nov and 6 Nov |
| Sun 29 Nov | `Day01ArrayStack` (+7, late) | `Day00BuggyExample` (+1, late) | Due 7 Nov |
| Mon 30 Nov | `Day02RpnEvaluator` (+3, late) | `DailyTemperatures` (+1, late) | Due 8 Nov and 13 Nov |
| Tue 1 Dec | `ValidParentheses` (+3, late) | `MinStack` (+3, late) | Due 15 Nov |
| Wed 2 Dec | `RemoveKAdjacentDuplicates` (+1 repeat, late) | `ScoreOfParentheses` (+1 repeat, late) | Due 17 Nov (RemoveK first: logged conceptual mistake); stubs keep the planned `...RedoNov23` names |
| Thu 3 Dec | `GenerateParentheses` (+1, late) | `ValidAnagram` (+1, late) | Due 18 Nov and 20 Nov |
| Fri 4 Dec | `ContainsDuplicate` (+1, late) | `Day03NextGreaterIndex` (+3, late) | Due 20 Nov and 22 Nov |
| Sat 5 Dec | `TwoSum` (+1, late) | `Day06FirstUniqueCode` (+1, late) | Due 24 Nov and 28 Nov |
| Sun 6 Dec | `CarFleet` (+1 repeat, late) | `GroupAnagrams` (+1, late) | Both due 28 Nov (no logged mistake on either; CarFleet first, older problem); replaces the projected Day04 / Day00 (+3) pair |

> [!WARNING]
> Everything after the first redo of each problem is a **projection that assumes every redo is a clean pass**. A 🔶 repeats the gap and a ❌ resets to day 1, and the queue rule moves the rest.

## 🔭 Projected calendar after 5 Dec
> [!NOTE]
> Rebuilt at the **25 Nov evening review** after the 23, 24 and 25 Nov misses (same rules; every pass assumed clean). **26 Nov evening review:** the Thu 26 Nov pair was missed too, so every date below moved one day: 74 redos from 27 Nov, last graduation **Sun 31 Jan 2027**.

| Date | Redo 1 | Redo 2 |
|---|---|---|
| Sun 6 Dec | `Day04LargestRectangle` (+3, late) | `Day00BuggyExample` (+3, late) |
| Mon 7 Dec | `DailyTemperatures` (+3, late) | `RemoveKAdjacentDuplicates` (+3, late) |
| Tue 8 Dec | `ScoreOfParentheses` (+3, late) | `GenerateParentheses` (+3, late) |
| Wed 9 Dec | `ValidAnagram` (+3, late) | `Day02RpnEvaluator` (+7, late) |
| Thu 10 Dec | `ContainsDuplicate` (+3, late) | `ValidParentheses` (+7, late) |
| Fri 11 Dec | `TwoSum` (+3, late) | `MinStack` (+7, late) |
| Sat 12 Dec | `Day03NextGreaterIndex` (+7, late) | `AsteroidCollision` (+7) |
| Sun 13 Dec | `CarFleet` (+7, late) | `Day01ArrayStack` (+14, late) |
| Mon 14 Dec | `Day04LargestRectangle` (+7, late) | `Day00BuggyExample` (+7, late) |
| Tue 15 Dec | `RemoveKAdjacentDuplicates` (+7, late) | `DailyTemperatures` (+7, late) |
| Wed 16 Dec | `ScoreOfParentheses` (+7, late) | `GenerateParentheses` (+7, late) |
| Thu 17 Dec | `ValidAnagram` (+7, late) | `ContainsDuplicate` (+7) |
| Fri 18 Dec | `TwoSum` (+7) | free |
| Wed 23 Dec | `Day02RpnEvaluator` (+14) | free |
| Thu 24 Dec | `ValidParentheses` (+14) | free |
| Fri 25 Dec | `MinStack` (+14) | free |
| Sat 26 Dec | `AsteroidCollision` (+14) | `Day03NextGreaterIndex` (+14) |
| Sun 27 Dec | `CarFleet` (+14) | free |
| Mon 28 Dec | `Day04LargestRectangle` (+14) | `Day00BuggyExample` (+14) |
| Tue 29 Dec | `RemoveKAdjacentDuplicates` (+14) | `DailyTemperatures` (+14) |
| Wed 30 Dec | `ScoreOfParentheses` (+14) | `GenerateParentheses` (+14) |
| Thu 31 Dec | `ValidAnagram` (+14) | `ContainsDuplicate` (+14) |
| Fri 1 Jan | `TwoSum` (+14) | free |
| Tue 12 Jan | `Day01ArrayStack` (+30) 🎓 | free |
| Fri 22 Jan | `Day02RpnEvaluator` (+30) 🎓 | free |
| Sat 23 Jan | `ValidParentheses` (+30) 🎓 | free |
| Sun 24 Jan | `MinStack` (+30) 🎓 | free |
| Mon 25 Jan | `AsteroidCollision` (+30) 🎓 | `Day03NextGreaterIndex` (+30) 🎓 |
| Tue 26 Jan | `CarFleet` (+30) 🎓 | free |
| Wed 27 Jan | `Day04LargestRectangle` (+30) 🎓 | `Day00BuggyExample` (+30) 🎓 |
| Thu 28 Jan | `RemoveKAdjacentDuplicates` (+30) 🎓 | `DailyTemperatures` (+30) 🎓 |
| Fri 29 Jan | `ScoreOfParentheses` (+30) 🎓 | `GenerateParentheses` (+30) 🎓 |
| Sat 30 Jan | `ValidAnagram` (+30) 🎓 | `ContainsDuplicate` (+30) 🎓 |
| Sun 31 Jan | `TwoSum` (+30) 🎓 | free |

> [!NOTE]
> This calendar was rebuilt on **15 Nov (10 PM check)** with the same rule: 2 a day, the most overdue first (ties: a logged conceptual mistake first), each next gap counted from the pass date, every pass assumed clean. Total until everyone graduates: **55 redos from 16 Nov, 27 of them in November** (16-30 Nov), last graduation **Fri 15 Jan 2027**. The near-term rows moved because 14 and 15 Nov were one-slot days with no redos. **16 Nov update:** both 16 Nov redos were 🔶 (not cold), so they repeat +1 (22 Nov) and their later steps move: 26 Nov, 3/4 Dec, 17/18 Dec; **55 redos remain from 17 Nov**, last graduation **Sun 17 Jan 2027**. **18 Nov (Day 27 morning) rebuild:** the 17 Nov pair was not attempted, so every queued date moved one day and the whole calendar was re-simulated with the same rules (2 a day, most overdue first, gaps from the pass date, every pass assumed clean); `GenerateParentheses` now takes its place by due date (Tue 24 Nov) instead of the old 27 Nov free slot. **60 redos remain from 18 Nov**, last graduation **Tue 19 Jan 2027**. **18 Nov 10 PM check rebuild:** the 18 Nov pair was missed again (not failed, so no gap changed); every queued date moved one more day and the calendar was re-simulated with the same rules. **60 redos remain from 19 Nov**, last graduation **Wed 20 Jan 2027**. New problems (`ContainsDuplicate` onwards) join at +1 when verified and push later rows.

> **Tue 17 Nov, Day 26 morning:** `GenerateParentheses` ✅ (`221069b`, 17/17, graded 9/10) joins at +1, due Wed 18 Nov; 17-26 Nov already hold two older items each, so it takes the first free slot, **Fri 27 Nov** (rule 9: a free slot, never a third). Its later steps (+3, +7...) are added when that redo is graded. Tonight's blank stubs created, tests copied from the originals and verified against a reference on the box (37/37, 28/28; reference not pushed), red on the stubs: `Day03NextGreaterIndexRedoNov17`, `AsteroidCollisionRedoNov17`. No ladder step changed. Spec: [day26.md](../archive/tasks/day26.md#-evening-redos-cap-2-most-overdue-first-2030-min-each-cold).

## 🧾 History behind each row
| Problem | Events and their effect on the gap (source: [PROGRESS.md](../PROGRESS.md), [mistakes/dsa.md](mistakes/dsa.md)) |
|---|---|
| `Day01ArrayStack` | 23 Oct buggy round fixed with hints (start, gap 1) · 28 Oct cold redo ✅ 17/17, clean (1 → 3) · 31 Oct `Day01ArrayStackRedo7` ✅ clean 17/17 (3 → 7), due 7 Nov, queued to 9 Nov by the cap |
| `Day02RpnEvaluator` | 24 Oct buggy round fixed, hint needed for `-3` (start, gap 1) · 27 Oct `Day02RpnEvaluatorRedo` 44/44 but re-read the original (🔶, repeats gap 1) · 31 Oct `Day02RpnEvaluatorRedo7` ❌ 3 conceptual misses before it was fixed (operator fall-through, `pop() != 1` end check, missing null guard) → reset to day 1, due 1 Nov · 1 Nov redo not attempted, moved to 2 Nov · 2 Nov not attempted, moved to 3 Nov · 3 Nov not attempted, moved to 4 Nov · 4 Nov not attempted (the RPN redo had moved into the morning DSA slot), moved to 5 Nov · **5 Nov `Day02RpnEvaluatorRedoNov01` ✅ clean cold 44/44, no hint (`800ad4f`), moved +1 → +3, due 8 Nov** |
| `RemoveKAdjacentDuplicates` | 29 Oct 26/26 (start) · O(n) quiz 3/5, missed the amortised argument (❌ conceptual, day 1) · due 30 Oct · **16 Nov `RemoveKAdjacentDuplicatesRedoNov16` 26/26 🔶 (`d94f802`), copied from the original, not cold → repeat +1, queued 22 Nov** |
| `Day03NextGreaterIndex` | 29 Oct 37/37, both bugs found, stray `main()` removed (cosmetic, not logged) · gap 1, due 30 Oct, never redone |
| `AsteroidCollision` | 30 Oct pushed 28/28, 31 Oct verified after two cosmetic fixes · gap 1, due 1 Nov, queued to 8 Nov |
| `ValidParentheses` | 23 Oct starter solution understood · gap 1, due 24 Oct · 5 Nov evening not attempted → 6 Nov · 6 Nov `ValidParenthesesRedoNov01` 17/18 🔶 (`c0f5d64`; null guard on original in `ec608e3`) → same +1, due 7 Nov · **7 Nov `ValidParenthesesRedoNov01` 18/18 🔶** (`3019054`, null→IAE in the redo after feedback) → same +1, due 8 Nov · 8 Nov cold `ValidParenthesesRedoNov08` not attempted → 9 Nov · 9 and 10 Nov not attempted → 11 Nov · 11 Nov not attempted → on hold, earliest Sat 14 Nov | · **12 Nov `ValidParenthesesRedoNov08` ✅ clean cold 18/18 (`d6ca103`) → +3, due 15 Nov, queued 19 Nov**
| `MinStack` | 23 Oct 10/10 · gap 1, due 24 Oct, never redone · stub 0/10 not attempted 6–11 Nov → on hold, earliest Sat 14 Nov | · **12 Nov `MinStackRedoNov01` ✅ clean cold 10/10 (`d6ca103`) → +3, due 15 Nov, queued 19 Nov**
| `ScoreOfParentheses` | 25 Oct 37/37, written with help, dry-ran line by line · gap 1, due 26 Oct · **16 Nov `ScoreOfParenthesesRedoNov16` 37/37 🔶 (`d94f802`), copied from the original, not cold → repeat +1, queued 22 Nov** |
| `CarFleet` | 3 Nov 37/37 (`91cb817`), hint-assisted (🔶) · gap 1, due 4 Nov, queued to 9 Nov |
| `Day04LargestRectangle` | 5 Nov 36/36 (`d8306e2`, from 15/36), first verified solve, joins at +1 (due 6 Nov, queued 11 Nov by the cap) · symptom table + `[2,1,2]` graded in chat 7 Nov (supported); empty-stack width geometric why still soft |
| `Day00BuggyExample` | **6 Nov `c0f5d64` 10/10** verified · joins at +1 (due 7 Nov, queued 11 Nov by the cap) · no written symptom groups |
| `DailyTemperatures` | **12 Nov `d6ca103` 18/18**, first verified solve · joins at +1 (due 13 Nov, queued 18 Nov) · pseudocode / brute-force comments not written
| `Day03NextGreaterIndex` (19 Nov) | **19 Nov `Day03NextGreaterIndexRedoNov17` ✅ clean cold 37/37 (`2c0c2fb`) → +3**, due 22 Nov, queued 25 Nov |
| `ContainsDuplicate` | **19 Nov `eeb8bb9` 17/17** with the day-3 skeleton (🔶) · joins at +1 (due 20 Nov, queued Wed 2 Dec, first free slot) |
| `ValidAnagram` | 19 Nov first push used a character sum (❌ conceptual) · **`97dbc9f` int[26] count → 18/18** after review · joins at day 1 (due 20 Nov, queued Tue 1 Dec, first free slot) |

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
> **7 Nov, 6 AM morning session:** no student push overnight after `03a1373`. Queue unchanged: tonight still `ValidParentheses` (finish null in redo, stays 🔶) then `MinStack`. No new redo stubs; existing blank / partial files kept. Spec: [day16.md](../archive/tasks/day16.md).

> [!NOTE]
> **7 Nov, evening review (~8:00 PM IST):** tip `f61c7d3`. `ValidParenthesesRedoNov01` **18/18** after feedback (`3019054`, null→IAE in the redo) — **not** cold-clean, ladder stays at +1, next due **8 Nov**. `MinStackRedoNov01` not attempted (0/10) → moves to **8 Nov**. Queue rebuilt from Sun 8 Nov with the cap of 2. LargestRectangle write-up graded in chat (supported). No new conceptual mistake logged.

> [!NOTE]
> **8 Nov, 6 AM morning session:** no student push after `795b269` (last student code `3019054`). Queue unchanged: tonight `ValidParentheses` then `MinStack`. New blank stub `redo/ValidParenthesesRedoNov08.java` + `ValidParenthesesRedoNov08Test` (18 tests, verified against a local correct version that is not pushed; 0/18 on the stub), because `ValidParenthesesRedoNov01` already holds the 7 Nov answer and cannot be redone cold. `MinStackRedoNov01` stays the MinStack file (untouched, 0/10). Removed two stray wrapper lines left at the top and bottom of this file by an earlier push (cosmetic). Spec: [day17.md](../archive/tasks/day17.md).

> [!NOTE]
> **8 Nov, evening review (~7:58 PM IST):** tip `73a1fd7`. No student push after the morning session (`1af6500` / `73a1fd7`). `ValidParenthesesRedoNov08` still **0/18** (blank stub, not attempted). `MinStackRedoNov01` still **0/10** (not attempted). No ladder step changed; both remain due **tonight (8 Nov)**. Queue unchanged. No new conceptual mistake logged. Spec: [day17.md](../archive/tasks/day17.md).

> [!NOTE]
> **8 Nov, 10 PM check:** no student commits after the evening review (`b0ac31f` is the review itself; last student code still `3019054`) and no answers in chat. `ValidParenthesesRedoNov08` (0/18) and `MinStackRedoNov01` (0/10) were not attempted, so no ladder step changed and the queue was rebuilt from **Mon 9 Nov** with the cap of 2 and the most overdue first; the projected calendar moved one day (last graduation Tue 5 Jan). Housekeeping: removed extra blank lines between the notes. No new conceptual mistake.

> [!NOTE]
> **9 Nov, 6 AM morning session:** no student push after `e480448` (last student code `3019054`). Queue unchanged: tonight `ValidParenthesesRedoNov08` (0/18) then `MinStackRedoNov01` (0/10), both existing blank stubs, so no new redo files. Spec: [day18.md](../archive/tasks/day18.md).

> **10 Nov, 6 AM morning session:** no student push after `23af947` (last student code `3019054`). Queue unchanged: tonight `ValidParenthesesRedoNov08` (0/18) then `MinStackRedoNov01` (0/10), both existing blank stubs, so no new redo files. Spec: [day19.md](../archive/tasks/day19.md).

> **10 Nov, evening review (~8 PM):** no student push after `dc71902` (last student code `3019054`). Neither redo attempted yet (`ValidParenthesesRedoNov08` 0/18, `MinStackRedoNov01` 0/10); no row changed, both still due tonight.

> **10 Nov, 10 PM check:** no student commits after the evening review (`d311827` is the review itself; last student code still `3019054`) and no answers in chat. `ValidParenthesesRedoNov08` (0/18) and `MinStackRedoNov01` (0/10) were not attempted, so no ladder step changed and the whole queue moved one day: **Wed 11 Nov** starts with those two, `ScoreOfParentheses` + `RemoveKAdjacentDuplicates` move to Thu 12 Nov, last graduation Thu 7 Jan. No new conceptual mistake.

> **11 Nov, evening review (~8 PM):** no student push after `fae7a26` (last student code `3019054`). Neither redo attempted yet (`ValidParenthesesRedoNov08` 0/18, `MinStackRedoNov01` 0/10); no row changed, both still due tonight. From Thu 12 Nov the plan runs one-slot days (one item, labs first), so no redo is scheduled on those days; the 10 PM check moves the queue, ValidParen Nov08 first.

> **11 Nov, 10 PM check:** no student commits after the evening review (`757732e` / `18c09e3` are the review itself; last student code still `3019054`) and no answers in chat. `ValidParenthesesRedoNov08` (0/18) and `MinStackRedoNov01` (0/10) were not attempted, so no ladder step changed. One-slot days (from Thu 12 Nov) carry no redo, so the queue is on hold: it resumes with those two on the first normal-plan day, **Sat 14 Nov at the earliest**; every later row moved 3 days (last graduation Sun 10 Jan at the earliest). No new conceptual mistake.

> **12 Nov, late push review (`d6ca103`, 9:01 PM IST):** on a one-slot day Prashant did both queued redos cold: `ValidParenthesesRedoNov08` **18/18** (null→IAE first try; the 7 Nov post-feedback miss did not come back) and `MinStackRedoNov01` **10/10**. Both are ✅ clean passes (blank files, all green on the first push, no hint, no fix after feedback), so both move **+1 → +3**, due Sun 15 Nov and queued Thu 19 Nov behind more overdue items. `DailyTemperatures` (18/18) joins at +1 (due 13 Nov, queued Wed 18 Nov). Queue rebuilt from Sat 14 Nov (earliest normal-plan day), cap 2; full ladder re-simulated (last graduation Wed 13 Jan at the earliest). No new conceptual mistake. Spec: [day21.md](../archive/tasks/day21.md#-late-push-review-12-nov-901-pm-ist-dailytemperatures--both-redos).

> **Sat 14 Nov and Sun 15 Nov:** both were one-slot days with no redos assigned and none attempted. No ladder row changed.

> **Sun 15 Nov, Ch 2 Task 1 (`1ded3b3`, 8:35 AM IST):** the **second push day** landed (first was 12 Nov). The queue resumes **Mon 16 Nov** (first normal-plan day) with `ScoreOfParentheses` + `RemoveKAdjacentDuplicates`. Other queued dates stay as scheduled; the cap of 2 still applies, so items also listed on Mon 16 (`CarFleet`, `Day04LargestRectangle`) wait behind this pair. No ladder step changed. Spec: [day24.md](../archive/tasks/day24.md#-chapter-2-task-1-grade-1ded3b3-835-am-ist).

> **15 Nov, 10 PM check:** no student commits after the evening review and no redo attempted, so no ladder row changed. Housekeeping only: the near-term table had `CarFleet` + `Day04LargestRectangle` on Mon 16 Nov while the queue note said `ScoreOfParentheses` + `RemoveKAdjacentDuplicates`; both tables were rebuilt from Mon 16 Nov so they agree.

> **Mon 16 Nov, Day 25 morning:** the first normal-plan day. Redo stubs created for the evening (cap 2, most overdue first): `ScoreOfParenthesesRedoNov16` (0/37) and `RemoveKAdjacentDuplicatesRedoNov16` (0/26), tests verified against the original solutions. No ladder row changed until they are graded. Spec: [day25.md](../archive/tasks/day25.md#-evening-redos-cap-2-most-overdue-first-2030-min-each-cold).

> **Mon 16 Nov, afternoon check (`d94f802`, 4:29 PM IST):** both redos pass (`ScoreOfParenthesesRedoNov16` 37/37, `RemoveKAdjacentDuplicatesRedoNov16` 26/26), but each method body is identical to its `dsa/stack/` original (RemoveK even imports the original class), with no complexity reasons and no pseudocode. Rule 3 (passed after re-reading the original) → 🔶, **same +1 gap**: due Tue 17 Nov, queued **Sun 22 Nov** by the cap (17-21 Nov already hold older items). Projection after that rebuilt for these two only; last graduation moves to **Sun 17 Jan 2027**. No new conceptual mistake logged. Spec: [day25.md](../archive/tasks/day25.md#-afternoon-check-16-nov-435-pm-ist-8f48e9b--d94f802).

> **Tue 17 Nov, 10 PM check / Wed 18 Nov, Day 27 morning:** neither `Day03NextGreaterIndexRedoNov17` (0/37) nor `AsteroidCollisionRedoNov17` (0/28) was attempted (the evening went to the Ch 2 Task 5 fix, `00bd2eb`), so no ladder step changed and the queue moved one day: today is Day03 + Asteroid on the **same blank stubs** (re-run 0/37 and 0/28 this morning), then CarFleet + LargestRect Thu 19, Day01 + Day00 Fri 20, RPN + DailyTemperatures Sat 21, ValidParen + MinStack Sun 22, RemoveK + ScoreOf Mon 23 (stubs renamed in the plan to `...RedoNov23`), GenerateParentheses Tue 24. Spec: [day27.md](../archive/tasks/day27.md#-evening-redos-cap-2-most-overdue-first-cold).

> **Wed 18 Nov, 8 PM evening review:** no redo graded yet. `Day03NextGreaterIndexRedoNov17` (0/37) and `AsteroidCollisionRedoNov17` (0/28) are still blank, and tonight's slot is still open, so no ladder row changed. If neither lands by the 10 PM check, the queue moves one more day (Thu 19: Day03 + Asteroid; CarFleet + LargestRect Fri 20; and so on).

> **Wed 18 Nov, 10 PM check:** still no attempt on `Day03NextGreaterIndexRedoNov17` (0/37) or `AsteroidCollisionRedoNov17` (0/28), no student commits after the evening review. As the 8 PM note said, the queue moves one more day: **Thu 19 Nov** Day03 + Asteroid (same blank stubs), Fri 20 CarFleet + LargestRect, Sat 21 Day01 + Day00, Sun 22 RPN + DailyTemperatures, Mon 23 ValidParen + MinStack, Tue 24 RemoveK + ScoreOf (stub names stay `...RedoNov23`), Wed 25 GenerateParentheses + Day03 (+3). Missed ≠ failed: no ladder step changed; max 2 a day kept. Spec: [day27.md end of day](../archive/tasks/day27.md#-end-of-day).

> **Thu 19 Nov, 10 PM check:** no student commits after the evening review, so `AsteroidCollisionRedoNov17` (0/28) was not attempted for the third evening. Missed is not failed: no ladder step changed. As the 8 PM note said, Asteroid goes first on **Fri 20 Nov** (with CarFleet) and every later slot moves one place (LargestRect + Day01 Sat 21, Day00 + RPN Sun 22, DailyTemperatures + ValidParen Mon 23, MinStack + RemoveK Tue 24, ScoreOf + GenerateParentheses Wed 25, Day03 + Asteroid (+3) Thu 26). ValidAnagram and ContainsDuplicate now share **Wed 2 Dec**. The projected calendar was recomputed with the same rules (2 a day, most overdue first, ties: a logged mistake first, new problems in free slots, every pass assumed clean): **69 redos from 20 Nov, 22 of them in November**, last graduation **Wed 27 Jan 2027** (ContainsDuplicate; the older 13 problems all graduate by Thu 21 Jan). Spec: [day28.md end of day](../archive/tasks/day28.md#-end-of-day).

> **Fri 20 Nov, Day 29 morning:** no redo graded since the 10 PM check, so no ladder row changed. Tonight's pair stays `AsteroidCollisionRedoNov17` (same blank stub, re-run 0/28) + `CarFleet` on a new blank stub `redo/CarFleetRedoNov20` with the original 37 tests (verified 37/37 against the 3 Nov solution, stub 0/37). Spec: [day29.md](../archive/tasks/day29.md#-evening-redos-cap-2-most-overdue-first-cold).

> **Fri 20 Nov, 10 PM check:** no student commits after the evening review, so neither `AsteroidCollisionRedoNov17` (0/28) nor `CarFleetRedoNov20` (0/37) was attempted. Missed is not failed: no ladder step changed. Both go first on **Sat 21 Nov** (weekends are for redos), and every later slot moves one place (LargestRect + Day01 Sun 22, Day00 + RPN Mon 23, DailyTemperatures + ValidParen Tue 24, MinStack + RemoveK Wed 25, ScoreOf + GenerateParentheses Thu 26, Day03 + Asteroid (+3) Fri 27). ValidAnagram and ContainsDuplicate now share **Thu 3 Dec**. Every pass date moved by the same day, so the projected calendar moved one day with the same rules: **69 redos from 21 Nov, 20 of them in November**, last graduation **Thu 28 Jan 2027** (ContainsDuplicate). Spec: [day29.md end of day](../archive/tasks/day29.md#-end-of-day).

> **Sat 21 Nov, evening review (~8:05 PM IST):** no student commits today, so `AsteroidCollisionRedoNov17` (0/28) and `CarFleetRedoNov20` (0/37) are still blank. Nothing graded, no ladder row changed; both stay due tonight. If they are missed, the 10 PM check moves the queue one slot (missed is not failed).

> **Sat 21 Nov, 10 PM check:** the only student commit after the evening review is `41abb48` (9:21 PM IST, `Day06FirstUniqueCode`, 16/20, a buggy round, not a redo). `AsteroidCollisionRedoNov17` (0/28) and `CarFleetRedoNov20` (0/37) were not attempted again (Asteroid: 17-21 Nov). Missed is not failed: no ladder step changed. Both go first on **Sun 22 Nov** (weekends are for redos), and every later slot moves one place (LargestRect + Day01 Mon 23, Day00 + RPN Tue 24, DailyTemperatures + ValidParen Wed 25, MinStack + RemoveK Thu 26, ScoreOf + GenerateParentheses Fri 27, Day03 + Asteroid (+3) Sat 28). ValidAnagram and ContainsDuplicate now share **Fri 4 Dec**. Every pass date moved by the same day, so the projected calendar moved one day with the same rules (2 a day, most overdue first, ties: a logged mistake first, new problems in free slots, every pass assumed clean): **69 redos from 22 Nov, 18 of them in November**, last graduation **Fri 29 Jan 2027** (ContainsDuplicate). `Day06FirstUniqueCode` and `TwoSum` join the ladder only when verified. Spec: [day30.md end of day](../archive/tasks/day30.md#-end-of-day).

> **Sun 22 Nov, 10 PM check:** no student commits today and no chat answers, so `AsteroidCollisionRedoNov17` (0/28, missed 17-22 Nov) and `CarFleetRedoNov20` (0/37, missed 20-22 Nov) were not attempted. Missed is not failed: no ladder step changed. Both go first on **Mon 23 Nov**, and every later slot moves one place (LargestRect + Day01 Tue 24, Day00 + RPN Wed 25, DailyTemperatures + ValidParen Thu 26, MinStack + RemoveK Fri 27, ScoreOf + GenerateParentheses Sat 28, Day03 + Asteroid (+3) Sun 29). The projected calendar moved one day with the same rules (ValidAnagram + ContainsDuplicate now **Sat 5 Dec**): **69 redos from 23 Nov, 16 of them in November**, last graduation **Sat 30 Jan 2027** (ContainsDuplicate). Spec: [day31.md end of day](../archive/tasks/day31.md#-end-of-day).

> **Sat 28 Nov, Day 37 morning:** no student commits after the 10 PM check; today's pair unchanged (Asteroid + Day04). First redo of `Day04LargestRectangle`: `Day04LargestRectangleTest` became `Day04LargestRectangleContract` (36 cases, count unchanged) and the new blank stub `Day04LargestRectangleRedoNov28` (0/36) was added to `open-stubs.txt`; a reference version (not pushed) passes 36/36. No ladder step changed. Spec: [day37.md redos](../tasks/day37.md#-redos-cold-cap-2).
