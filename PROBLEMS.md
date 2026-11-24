# 🗂️ Problem tracker

Every problem, then a cheat sheet per pattern. Facts as of 24 Nov 2026; next redo dates are kept by the coach in `revision/redo-schedule.md`.

✅ completed · 🔴 revision required · ⬜ not started · 🔶 hints / after a fix · ❌ conceptual miss · E/M/H difficulty · blank = not recorded

## 📊 Summary
| Pattern | Done | Open | Problems |
|---|---|---|---|
| Stack (incl. monotonic stack) | 13 | 0 | ValidParentheses, MinStack, Evaluate RPN, GenerateParentheses, DailyTemperatures, CarFleet, LargestRectangle, AsteroidCollision, ScoreOfParentheses, RemoveKAdjacentDuplicates, NextGreaterIndex, DecodeString, ArrayStack |
| Arrays & Hashing | 3 | 1 + 1 buggy | ContainsDuplicate, ValidAnagram, TwoSum · open: GroupAnagrams, Day06FirstUniqueCode |
| Warm-up | 1 | 0 | Day00BuggyExample |

## 🧩 DSA problems (`src/main/java/com/prashant/dsa/<pattern>/`)
| # | Problem | LC | Diff | Pattern | File | Tests | Solved | Hint | Redos (file · date · result) |
|---|---|---|---|---|---|---|---|---|---|
| 1 | Valid Parentheses | 20 | E | Stack: matching brackets | [ValidParentheses](src/main/java/com/prashant/dsa/stack/ValidParentheses.java) | 20 (18 shared + 2 starter) | | | RedoNov01 · 7 Nov · 🔶 post-feedback · RedoNov08 · 12 Nov · ✅ |
| 2 | Min Stack | 155 | M | Stack: auxiliary min stack (design) | [MinStack](src/main/java/com/prashant/dsa/stack/MinStack.java) | 10 | | | RedoNov01 · 12 Nov · ✅ |
| 3 | Score of Parentheses | 856 | M | Stack: nesting depth / running score | [ScoreOfParentheses](src/main/java/com/prashant/dsa/stack/ScoreOfParentheses.java) | 37 | 25 Oct | 🔶 written with help | RedoNov16 · 16 Nov · 🔶 not cold |
| 4 | Remove All Adjacent Duplicates II | 1209 | M | Stack: count stack (run-length) | [RemoveKAdjacentDuplicates](src/main/java/com/prashant/dsa/stack/RemoveKAdjacentDuplicates.java) | 26 | 29 Oct | | RedoNov16 · 16 Nov · 🔶 not cold |
| 5 | Asteroid Collision | 735 | M | Stack: collision simulation | [AsteroidCollision](src/main/java/com/prashant/dsa/stack/AsteroidCollision.java) | 28 | 31 Oct | | RedoNov17 · open (0/28) |
| 6 | Car Fleet | 853 | M | Stack: sort by position, monotonic | [CarFleet](src/main/java/com/prashant/dsa/stack/CarFleet.java) | 37 | 3 Nov | 🔶 | RedoNov20 · open (0/37) |
| 7 | Daily Temperatures | 739 | M | Monotonic stack: next warmer day | [DailyTemperatures](src/main/java/com/prashant/dsa/stack/DailyTemperatures.java) | 18 | 12 Nov | | |
| 8 | Generate Parentheses | 22 | M | Backtracking with two counters | [GenerateParentheses](src/main/java/com/prashant/dsa/stack/GenerateParentheses.java) | 17 | 17 Nov | | |
| 9 | Contains Duplicate | 217 | E | Hash-set membership | [ContainsDuplicate](src/main/java/com/prashant/dsa/arrayshashing/ContainsDuplicate.java) | 17 | 19 Nov | 🔶 | |
| 10 | Valid Anagram | 242 | E | Frequency counting (`int[26]`) | [ValidAnagram](src/main/java/com/prashant/dsa/arrayshashing/ValidAnagram.java) | 18 | 19 Nov | ❌ sums → fixed | |
| 11 | Two Sum | 1 | E | Complement lookup (value → index map) | [TwoSum](src/main/java/com/prashant/dsa/arrayshashing/TwoSum.java) | 19 | 23 Nov | 🔶 | |
| 12 | Group Anagrams | 49 | M | Canonical key → list (hash map grouping) | [GroupAnagrams](src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java) | 22 | ⬜ open | | |

## 🐞 Buggy rounds (`src/main/java/com/prashant/dailytests/`)
| Round | Problem | LC | Diff | Pattern | Tests | Fixed | Hint | Redos (file · date · result) |
|---|---|---|---|---|---|---|---|---|
| [Day00BuggyExample](src/main/java/com/prashant/dailytests/Day00BuggyExample.java) | max with edge cases (warm-up) | | E | Array scan | 10 | 6 Nov | | |
| [Day01ArrayStack](src/main/java/com/prashant/dailytests/Day01ArrayStack.java) | array-backed stack | | E | Design: array stack | 17 | | 🔶 | Redo · 28 Oct · ✅ · Redo7 · 31 Oct · ✅ |
| [Day02RpnEvaluator](src/main/java/com/prashant/dailytests/Day02RpnEvaluator.java) | Evaluate Reverse Polish Notation | 150 | M | Stack: expression evaluation | 44 | | 🔶 | Redo · 🟡 re-read original · Redo7 · 31 Oct · ❌ then fixed · RedoNov01 · 5 Nov · ✅ |
| [Day03NextGreaterIndex](src/main/java/com/prashant/dailytests/Day03NextGreaterIndex.java) | next greater element (indices) | | M | Monotonic stack | 37 | 29 Oct | | RedoNov17 · 19 Nov · ✅ |
| [Day04LargestRectangle](src/main/java/com/prashant/dailytests/Day04LargestRectangle.java) | Largest Rectangle in Histogram | 84 | H | Monotonic stack | 36 | 5 Nov | | |
| [Day05DecodeString](src/main/java/com/prashant/dailytests/Day05DecodeString.java) | Decode String | 394 | M | Stack of (count, text) | 25 | 19 Nov | 🔶 | |
| [Day06FirstUniqueCode](src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java) | first index whose code appears once | | E | Frequency counting | 20 | 🔴 16/20 | | |

## 📒 Cheat sheets

| Pattern | Use when | Core move | Classic bug | Complexity (because) |
|---|---|---|---|---|
| 🥞 Stack | matching pairs, undo-last, nesting (`3[a2[c]]`), expressions, neighbour collisions | push openers; on a closer, pop and compare; end with `isEmpty()` | popping an empty stack; skipping the final `isEmpty()`; RPN operand order (`b = pop(), a = pop()`, then `a - b`); legacy `Stack` instead of `ArrayDeque` | O(n) time, each item pushed once and popped at most once; O(n) space, the stack may hold everything |
| 📉 Monotonic stack | next/previous greater or smaller, days until warmer, spans, largest rectangle | stack of **indices**, values decreasing; while `a[i] > a[peek]`, pop and answer it with `i` | storing values not indices; `>` vs `>=` on duplicates; Largest Rectangle: use the **popped** height, width `i` when the stack is empty; forgetting the final sentinel pass | O(n) amortised, every index pushed once and popped at most once |
| #️⃣ Hash set | "seen before?" | `if (!seen.add(x)) return true;` | `contains` + `add` = two lookups | O(n) time, one O(1) average lookup per item; O(n) space |
| #️⃣ Frequency count | anagrams, first unique, counts | `int[26] count; count[c - 'a']++` | comparing **sums** (`ac` vs `bb`); second pass over the 26 letters instead of string positions `i = 0..n-1` | O(n) time; O(1) space for a fixed `int[26]` |
| #️⃣ Complement map | pair that sums to target | for each `i`: `need = (long) target - nums[i]`; **check** the map, **then** `put(nums[i], i)` | storing before checking (`[i, i]`); `int` overflow in `target - x` | O(n) time, one lookup per item; O(n) space |
| #️⃣ Canonical key | group equivalent items (anagrams) | `groups.computeIfAbsent(key(s), k -> new ArrayList<>()).add(s)` | count key without a separator (`1,11` vs `11,1`); `int[]` as a map key (identity `equals`) | O(n·k) count key, O(n·k log k) sorted key; O(n·k) space |
| 🌳 Backtracking | generate all valid strings/sets with pruning rules | choose → recurse → undo; Generate Parentheses: add `(` if `open < n`, `)` if `close < open` | forgetting to undo (`deleteCharAt`); pruning with `close < n`; string `+` in every call | about O(4^n/√n) results (Catalan), each O(n) to copy |
