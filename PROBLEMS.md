# 🗂️ Problem tracker

One row per problem: what it is, where the code lives, how it went. **Next redo dates live only in [revision/redo-schedule.md](revision/redo-schedule.md)** (the single source for "what do I redo today?"), so this file never goes stale on dates. Detailed notes stay in [PROGRESS.md](PROGRESS.md).

> [!NOTE]
> **Legend:** ✅ completed · 🟡 in progress · 🔴 revision required · ⬜ not started · 🔶 solved with hints / after a fix · ❌ conceptual miss · E/M/H = Easy/Medium/Hard. A blank date means it is not recorded anywhere. Tests in the 🧩/🐞 tables are the original class; redo files are listed separately.
> **Update rule:** when a problem is verified, fill its row (date, tests, hint). When a redo is graded, add it to the Redos column. Facts as of **24 Nov 2026**.

## 📊 Summary
| Pattern | Done | Open | Problems |
|---|---|---|---|
| Stack (incl. monotonic stack) | 13 | 0 | ValidParentheses, MinStack, Evaluate RPN, GenerateParentheses, DailyTemperatures, CarFleet, LargestRectangle, AsteroidCollision, ScoreOfParentheses, RemoveKAdjacentDuplicates, NextGreaterIndex, DecodeString, ArrayStack |
| Arrays & Hashing | 3 | 1 + 1 buggy | ContainsDuplicate, ValidAnagram, TwoSum · open: GroupAnagrams, Day06FirstUniqueCode |
| Warm-up | 1 | 0 | Day00BuggyExample |

## 🧩 DSA problems (`src/main/java/com/prashant/dsa/<pattern>/`)
| # | Problem | LC | Diff | Pattern | File | Tests | Solved | Hint | Redos (file · date · result) |
|---|---|---|---|---|---|---|---|---|---|
| 1 | Valid Parentheses | 20 | E | Stack: matching brackets | [ValidParentheses](src/main/java/com/prashant/dsa/stack/ValidParentheses.java) | 2 | | | RedoNov01 · 7 Nov · 🔶 post-feedback · RedoNov08 · 12 Nov · ✅ |
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

---

## 📒 Pattern cheat sheets

### 🥞 Stack
- **When:** matching pairs (brackets, tags), "undo the last thing", nested structures (`3[a2[c]]`), evaluating expressions, collisions/cancellations between neighbours.
- **Template:**
  ```java
  Deque<Character> stack = new ArrayDeque<>();
  for (char c : s.toCharArray()) {
      if (opens(c)) stack.push(c);
      else if (stack.isEmpty() || stack.pop() != partner(c)) return false;
  }
  return stack.isEmpty();
  ```
- **Common bugs:** popping an empty stack (check `isEmpty()` first); forgetting the final `isEmpty()` check; operand order on pop (`b = pop(), a = pop()`, then `a - b`); using `Stack` (synchronized, legacy) instead of `ArrayDeque`.
- **Complexity line:** O(n) time *because each element is pushed once and popped at most once*; O(n) space *because the stack can hold every element*.

### 📉 Monotonic stack
- **When:** "next/previous greater or smaller element", "how many days until warmer", spans, largest rectangle.
- **Template (next greater, indices):**
  ```java
  int[] ans = new int[n]; Arrays.fill(ans, -1);
  Deque<Integer> st = new ArrayDeque<>();          // indices, values decreasing
  for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && a[i] > a[st.peek()]) ans[st.pop()] = i;
      st.push(i);
  }
  ```
- **Common bugs:** storing values instead of indices (you lose the distance); `>` vs `>=` with duplicates; in Largest Rectangle using the *current* height instead of the *popped* height, and the width when the stack becomes empty (`i`, not `i - st.peek() - 1`); forgetting the sentinel pass at the end.
- **Complexity line:** O(n) amortised *because every index is pushed once and popped at most once*.

### #️⃣ Arrays & Hashing
- **When:** "have I seen this before?" (hash set), "count how many of each" (frequency array/map), "find the partner that completes it" (complement map), "group things that are equivalent" (canonical key).
- **Templates:**
  ```java
  // seen-before
  Set<Integer> seen = new HashSet<>();
  for (int x : nums) if (!seen.add(x)) return true;      // add() returns false on duplicate
  // frequency, lowercase letters
  int[] count = new int[26];
  for (char c : s.toCharArray()) count[c - 'a']++;
  // complement: check BEFORE storing
  Map<Integer, Integer> idx = new HashMap<>();
  for (int i = 0; i < n; i++) {
      long need = (long) target - nums[i];
      if (need within int range && idx.containsKey((int) need)) return new int[]{idx.get((int) need), i};
      idx.put(nums[i], i);
  }
  // grouping by canonical key
  Map<String, List<String>> groups = new HashMap<>();
  groups.computeIfAbsent(key(s), k -> new ArrayList<>()).add(s);
  ```
- **Common bugs:** comparing character **sums** instead of counts (`ac` vs `bb`); walking the 26 letters when the question asks for a **string position** (second pass must go `i = 0..n-1`); storing before checking (returns `[i, i]`); `int` overflow in `target - x`; count keys without a separator (`1,11` vs `11,1`).
- **Complexity line:** O(n) time *because each element costs one O(1) average hash lookup*; O(n) space *because the set/map can hold every element* (O(1) for a fixed `int[26]`).

### 🌳 Backtracking (Generate Parentheses)
- **When:** "generate all valid ...", choices at each step with rules that prune bad branches.
- **Template:**
  ```java
  void build(StringBuilder sb, int open, int close, int n, List<String> out) {
      if (sb.length() == 2 * n) { out.add(sb.toString()); return; }
      if (open < n)     { sb.append('('); build(sb, open + 1, close, n, out); sb.deleteCharAt(sb.length() - 1); }
      if (close < open) { sb.append(')'); build(sb, open, close + 1, n, out); sb.deleteCharAt(sb.length() - 1); }
  }
  ```
- **Common bugs:** forgetting to undo the choice (`deleteCharAt`); pruning with `close < n` instead of `close < open`; building strings with `+` in every call.
- **Complexity line:** about O(4^n / √n) results (Catalan number), each O(n) to copy *because every valid string is built once*.
