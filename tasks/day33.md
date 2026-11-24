# 📅 Day 33 (Tue 24 Nov): Two Sum closed → Group Anagrams; Ch 3 re-answer in writing; Day06 last loop; Asteroid cold

![Week](https://img.shields.io/badge/week-5-blue) ![Day](https://img.shields.io/badge/day-33-blue) ![Type](https://img.shields.io/badge/type-weekday-blue) ![Spring](https://img.shields.io/badge/Spring-Ch%203%20re--answer-orange) ![DSA](https://img.shields.io/badge/GroupAnagrams-0%2F22%20new-blue) ![Buggy](https://img.shields.io/badge/Day06-16%2F20-orange) ![Redos](https://img.shields.io/badge/redos-Asteroid%20%2B%20CarFleet-purple) ![DSA%20count](https://img.shields.io/badge/DSA%20verified-10%20of%2045--50-informational)

> [!IMPORTANT]
> **Two Sum is closed** (19/19 on your push, see the review below), so the DSA track moves to the next new problem: **Group Anagrams** (Arrays & Hashing 4 of 9). Spring and buggy stay on their open items (golden rule: no Chapter 4 while Chapter 3's answer is 🔴; **no new Tuesday buggy round while `Day06` is 🔴**). **Done when:** Ch 3 re-answer written (or answered in chat) and graded ≥ 7, `GroupAnagramsTest` **22/22**, `Day06FirstUniqueCodeTest` **20/20**, `AsteroidCollisionRedoNov17` pushed cold (even red).

> [!NOTE]
> **Legend:** 🌱 Spring (`spring-boot-labs`) · 🧩 DSA · 🐞 buggy slot · 🔁 redo · ✅ done · ❌ missed · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 5, Day 33. Sections: 🌅 Morning, 🌙 Evening, 🌒 End of day.

## 🌅 Morning

> [!NOTE]
> State at ~6:15 AM IST (fresh clone, JDK 21, Maven). One student commit since the Day 32 morning session: **`3a620f4` "TwoSum.Java"** (Mon 23 Nov, 6:11 PM IST). No Day 32 evening review or 10 PM check was recorded, and no graded Ch 3 answer is on record, so that item is still open. Labs `my-solutions` is still `e619f82` (20 Nov 1:04 PM IST). Full re-run before today's files: **795 run / 69 red**, exactly three open files (`Day06FirstUniqueCode` 16/20, `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 0/37); **`TwoSumTest` 19/19** ✅. Mon 23 Nov redos (Asteroid, CarFleet) were not attempted → moved to today, queue shifted one day (missed, not failed: no gap changed).

### 🔎 Review: your Two Sum push (`3a620f4`)

| Check | Result |
|---|---|
| `mvn test -Dtest=TwoSumTest` | ✅ **19/19** (incl. both 1 000 000-value tests and the overflow cases) |
| Pseudocode before Java | ✅ 5 clear lines, check-then-store order right |
| Brute force with the 10^6 cost | ✅ "about n²/2 = 5 × 10^11 checks" with the reason |
| Pattern / time / space **with a because** | ✅ all three, and the time line says *where* the cost comes from (one visit + O(1) average map ops). Your recurring "no because" gap did **not** show up here. |
| Overflow | ✅ `long complement` + range check before the `(int)` cast |
| Hint level | 🔶 solved with the near-full skeleton (two blanks), so it joins the redo ladder at **+1** with "pass with a hint" |
| Conceptual mistakes | none, nothing logged |

**Status:** `TwoSum` ⬜ → ✅ **COMPLETED** (🔶 with hints). Verified NeetCode count: **10** of the 45-50 target.

**Cosmetic fix I made (no action needed):** your notes block sat at column 0 as a `/** ... */` Javadoc; it is now an indented `/* ... */` comment, plus a blank line after the imports.

**One question to answer in chat (2 min, interview-style):** you wrote `seen.put(nums[i], i)`. With `[1, 5, 1, 5]`, the second `1` overwrites index 0 with 2. Why does that never break **this** problem (hint: how many valid pairs are there, and when do you check?), and in the "return **all** pairs" follow-up, what would you store per value instead?

> [!TIP]
> **Short on time? The 15-minute minimum:** item 3 (`Day06` last loop) → push, even red. Ask me for a hint after 15 minutes stuck on any step.

### ⏱️ Time plan (about 105 min + 15 buffer, lighter day)

| Min | Track | Item | Done when |
|---|---|---|---|
| 0-25 | 🌱 | **Ch 3 re-answer, written** in [interview-answers.md](../interview-answers.md) (warm-ups first) | pushed (or answered in chat), graded ≥ 7 |
| 25-65 | 🧩 | **Group Anagrams** (new, A&H 4 of 9): pseudocode + brute force + key choice first | `GroupAnagramsTest` **22/22** pushed |
| 65-80 | 🐞 | Buggy slot (no new round: `Day06` is 🔴): **`Day06FirstUniqueCode`** last loop | `Day06FirstUniqueCodeTest` **20/20** pushed |
| 80-105 | 🔁 | **`AsteroidCollisionRedoNov17`** cold, 25-min timer | pushed, even red |
| 105-120 | — | Buffer: the Two Sum chat question above, or `DailyTemperatures` comments (5 min) | optional |
| Evening | 🔁 | **`CarFleetRedoNov20`** cold (after the review) | pushed, even red |

> [!NOTE]
> Spring gets ~25 min, not ~60, because its open item is an answer, not code. Writing it in the repo means it can be graded even if we don't chat today. Chapter 4 opens the day it scores ≥ 7.

---

### 🌱 1. Spring: Chapter 3 re-answer, in writing (~25 min)

**Why it matters.** "Is a singleton bean thread-safe?" is asked in nearly every senior Spring loop, usually disguised as "our totals drift under load". Your code for Chapter 3 was 15/15; the open part is the explanation, and it has been open since 20 Nov.

**First, ask what Spring already does for you (1 min, one line each):**
1. Does Spring make a singleton bean's **fields** thread-safe? (yes / no)
2. What *does* Spring give you per request for free? (think: method locals, request-scoped beans, `@Transactional` + the DB)

**Warm-up: three tiny examples (3 min, say "races" or "safe" and why):**

```java
@Service class A { private long total;               void add(long f) { total += f; } }
@Service class B { private final Clock clock;        long now() { return clock.millis(); } }   // set once in the constructor
@Service class C {                                   long fee(long amt) { long f = amt / 100; return Math.max(f, 10); } }
```

| Bean | Shared field written by request threads? | Your verdict |
|---|---|---|
| `A` | ? | ? |
| `B` | ? | ? |
| `C` | ? | ? |

<details><summary>Check the warm-up after you fill the table</summary>

`A` races: one `total` on the heap, every thread does read-add-write. `B` is safe: the field is `final` and only read. `C` is safe: `f` is a local on each thread's own stack.

</details>

**Now write the answers** under the Chapter 3 section of [interview-answers.md](../interview-answers.md) (replace each `_Answer:_` line), 4-8 sentences total for Q1:
- **Q1 part 2:** *why* `total += fee` races (where a field lives vs where a local lives), then **two real fixes**.
- **Q1 part 3:** `@Component` vs `@Bean`: the rule **and the why** (what finds each one; when you *must* use `@Bean`).
- **Q2:** singleton `TransferService` with `private BigDecimal runningTotal` drifts under load. Why, plus two fixes with trade-offs; one must survive **3 instances and a restart**.
- **Q3:** prototype `Receipt` injected through a singleton's constructor: new receipt per transfer? If not, two ways to get one per call.
- **Floor vs cap (one line each):** (a) "1% but **at least** ₹10" → `Math.___(amount / 100, 10)`; (b) "2% but **at most** ₹500" → `Math.___(amount * 2 / 100, 500)`.

**Knowledge checks (letters only, in chat or under the answers):**
1. Which change alone makes `A` correct inside **one** JVM? A. `volatile long total` · B. `AtomicLong` + `addAndGet` · C. `@Lazy` · D. make `add` `private`
2. Three instances behind a load balancer: which keeps **one** correct total? A. `synchronized add` · B. `AtomicLong` · C. one DB row updated with `total = total + ?` · D. `ThreadLocal<Long>`
3. A prototype bean injected into a singleton's constructor is created: A. once per call · B. once, when the singleton is built · C. once per request · D. never

---

### 🧩 2. DSA: Group Anagrams (new, Arrays & Hashing 4 of 9, ~40 min)

![Type](https://img.shields.io/badge/type-DSA%20Arrays%20%26%20Hashing-blue) ![Tests](https://img.shields.io/badge/GroupAnagramsTest-22-lightgrey) ![Stub](https://img.shields.io/badge/stub-0%2F22-orange)

> [!IMPORTANT]
> 📂 stub `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` · tests `src/test/java/com/prashant/dsa/arrayshashing/GroupAnagramsTest.java` (22, all with `@DisplayName`; checked against two reference solutions that are **not** in the repo, a sorted-key and a count-key version: both 22/22, stub 0/22; a count key built **without separators** fails exactly one test, on purpose). ✅ Done when 22/22 pass on your pushed code, with pseudocode + brute force + key choice first, and pattern / time / space lines that each say **because**. If not finished today, it carries to Wed with guiding questions and then a partial skeleton (never open more than 2 days).

#### 1️⃣ Problem understanding
**Why it matters:** Valid Anagram compared **two** strings. Here you compare **n** strings with each other, and comparing every pair is too slow. The move is to give each string a **key** (a fingerprint) so anagrams share a key and nothing else does, then let a `HashMap<key, List<String>>` group them. This is exactly the weak spot in your Valid Anagram miss (character **sums** threw information away), now one level up.

**Story:** the fraud team wants every batch of new beneficiary nicknames bucketed so rearranged copies ("listen", "silent", "enlist") land with one reviewer.

| Input | Output (any order) | Why |
|---|---|---|
| `["eat","tea","tan","ate","nat","bat"]` | `[["eat","tea","ate"],["tan","nat"],["bat"]]` | same letters, same counts |
| `[""]` | `[[""]]` | the empty string is a valid word |
| `["ac","bb"]` | `[["ac"],["bb"]]` | equal letter sums (97+99 = 98+98) but different letters |
| `["ab","ba","ab"]` | `[["ab","ba","ab"]]` | duplicates are kept |

#### 2️⃣ Input / output and constraints
- `List<List<String>> groupAnagrams(String[] strs)`. Groups in any order; words inside a group in any order.
- `null` array or `null` element → `IllegalArgumentException`. Any character outside `'a'-'z'` → `IllegalArgumentException`.
- Empty array → empty list (never `null`). Every input word appears in exactly one group.
- Don't modify the caller's array. 20 000 words of length 100 within 2 s.

#### 3️⃣ Pattern identification
**Arrays & Hashing: group by a canonical key.** The cue is *"bucket items that are equal under some rule"*. If you can compute a value that is the **same for every member of a bucket and different across buckets**, a map from that value to a list does all the grouping in one pass.

#### 4️⃣ Approach (brute force only; write this first)
Brute force: for each word, compare it with one word from every group found so far (using your Valid Anagram check); add it to the first match, or start a new group. Write it as 3-5 plain-English lines, then answer in a comment: *for n = 20 000 words that are all different, roughly how many anagram checks is that, and how many character steps if each check reads 100 letters?*

Hints, as questions:
1. Two words are anagrams exactly when ___ ? Name **two** different values you could compute from one word that are equal for all its anagrams.
2. Your Valid Anagram first push used a **sum**. Why can a sum never be a key here? (`"ac"` vs `"bb"`.)
3. If your key is the 26 counts joined into a string, does `a=1, b=11` look different from `a=11, b=1`? What fixes that?
4. Can you use an `int[]` directly as a `HashMap` key? What do `equals` and `hashCode` do on arrays?
5. Sorting each word gives a key too. Which is cheaper for words of length 100: sorting or counting? State both costs in terms of `n` and `k`.

#### 5️⃣ Dry run of the optimised algorithm
Inside the locked block below.

#### 6️⃣ Java stub
In the repo: `throw new UnsupportedOperationException("TODO: Group Anagrams")`, comment lines waiting for pseudocode / brute force / **key choice** / pattern / time / space (each with "because"), and a `main` with two examples.

#### 7️⃣ Complexity
Brute force: you state it with the reason. Optimised: after your attempt. Time depends on **two** sizes (n words, k letters), so say which part of the work each one comes from.

#### 8️⃣ Interview follow-ups
1. Nicknames can be any Unicode (Hindi, uppercase, accents). Which key still works, and what do you normalise first?
2. 200 million nicknames don't fit in one JVM's heap. How would you group them anyway? (Think: the key becomes a partition / shuffle key.)
3. You chose `HashMap<String, List<String>>`. What does it cost when it resizes, and when would you pass an initial capacity?
4. Return groups in **first-appearance order**. What single change to your map choice gives you that?

**Knowledge checks (letters only, before opening the locked block):**

1. Key = sum of character codes. For `["ac", "bb"]` the result is:
   - A. two groups · B. one group `["ac","bb"]`, which is wrong · C. an exception · D. empty
2. Sorted-key approach, n words of length up to k. Time is:
   - A. O(n) · B. O(n · k) · C. O(n · k log k) · D. O(n² · k)
3. `map.put(new int[]{1,2}, x); map.get(new int[]{1,2})` returns:
   - A. `x` · B. `null`, because arrays use identity `equals`/`hashCode` · C. an exception · D. `x` only if both arrays are `final`

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Optimised algorithm (count key).**
1. If `strs` is `null`, throw `IllegalArgumentException`.
2. `Map<String, List<String>> groups = new HashMap<>()`.
3. For each word: if `null`, throw. Count letters into `int[26]` (throw on anything outside `'a'-'z'`).
4. Build the key from the 26 counts **with a separator** (e.g. `"1#11#0#..."`), so `a=1,b=11` and `a=11,b=1` differ.
5. `groups.computeIfAbsent(key, x -> new ArrayList<>()).add(word)`.
6. Return `new ArrayList<>(groups.values())`.

(Sorted-key variant: step 3-4 become `char[] c = word.toCharArray(); Arrays.sort(c); key = new String(c);` on a **copy**, so the caller's strings are untouched anyway.)

**Dry run** `["eat","tea","tan","ate","nat","bat"]` (sorted key shown, it's shorter to read):

| word | key | groups after the step |
|---|---|---|
| eat | aet | {aet: [eat]} |
| tea | aet | {aet: [eat, tea]} |
| tan | ant | {aet: [eat, tea], ant: [tan]} |
| ate | aet | {aet: [eat, tea, ate], ant: [tan]} |
| nat | ant | {aet: [eat, tea, ate], ant: [tan, nat]} |
| bat | abt | {aet: [...], ant: [...], abt: [bat]} → 3 groups |

**Complexity.**

| Approach | Time | Space | Why |
|---|---|---|---|
| Brute force (compare with each group) | O(n² · k) | O(n · k) | up to n groups to check per word, each check reads k letters: about 2 × 10^8 checks × 100 letters for n = 20 000 |
| Sorted key | O(n · k log k) | O(n · k) | each of n words is sorted (k log k); the map stores every word plus a key of length k |
| **Count key** | **O(n · (k + 26))** = O(n · k) | O(n · k) | each word is read once (k) and its 26 counts joined once; the map holds all words and keys |

**Answers.** (1) **B**: a sum throws information away, so different words collide. (2) **C**. (3) **B**: `int[]` inherits `Object.equals`/`hashCode` (identity), so use `Arrays.toString(count)`, a separator-joined string, or `List<Integer>`.

</details>

- [ ] Pseudocode (3-5 lines) + brute-force comment with the n = 20 000 numbers.
- [ ] Key choice comment: what key, and why two non-anagrams can never share it.
- [ ] Pattern / time / space lines, each with a "because" (name where n and k come from).
- [ ] `mvn test -Dtest=GroupAnagramsTest` → **22/22**. Push.
- [ ] Knowledge checks 1-3 in chat before opening the locked block.

---

### 🐞 3. Buggy slot (Tuesday, no new round): `Day06FirstUniqueCode` last loop (~15 min)

![Tests](https://img.shields.io/badge/Day06FirstUniqueCodeTest-16%2F20-orange) ![Status](https://img.shields.io/badge/status-REVISION__REQUIRED-red)

> [!IMPORTANT]
> Tuesday is a buggy-round day, but the track still has `Day06` at 🔴 (open since Fri 20 Nov), so per the rules it comes first and **no new round** is added today. Friday's round (Arrays & Hashing) comes only once `Day06` is ✅.

**Where you are:** your first two fixes are right. The last loop is the one open piece (that was already named on Day 32, so this is not a new hint). It has been open past the 2-day limit, so here is a stronger nudge: the first rows of the `"aabb"` trace, filled in.

| `letter` | `codes.charAt(letter)` | `count[...]` | returns? |
|---|---|---|---|
| 0 | `'a'` | 2 | no |
| 1 | `'a'` | 2 | no |
| 2 | ? | ? | ? |
| 3 | ? | ? | ? |
| 4 | ? | ? | ? |

Fill rows 2-4 on paper. Then one line each:
1. The method returns a **position in `codes`**. Positions in a string of length `n` run from `0` to ___.
2. So the loop variable stands for ___ (and a better name for it is ___).
3. What happens at row 4 when `codes.length()` is 4, and what happens on a 30-character string where the unique code sits at position 28?

**Rules:** change **only** what's needed (smallest change, no rewrite). Add the symptom-group comment at the top of the method (which failing tests share one cause) and one `// fix:` comment per change (three in total). Push → 20/20.

---

### 🔁 Redos (cap 2, most overdue first, **cold only**)

| # | Redo | Stub (blank, tests verified) | Due since | When | Done when |
|---|---|---|---|---|---|
| 1 | `AsteroidCollision` (+1, late) | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | 1 Nov (assigned 17 Nov) | morning, 80-105 | `AsteroidCollisionRedoNov17Test` 28/28 |
| 2 | `CarFleet` (+1, late) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | 4 Nov (assigned 20 Nov) | evening, after the review | `CarFleetRedoNov20Test` 37/37 |

> [!WARNING]
> 🔁 **Cold means cold.** Open the blank stub, close every other tab, and don't look at `dsa/stack/AsteroidCollision.java` or `CarFleet.java`. Start with a pattern line and time/space (each with a **because**), then 20-30 min on a timer. Push even if red. **A redo whose code matches the original solution counts as not passed** and repeats the same gap.

---

### 📦 Carried backlog (in order, after today's items)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `DailyTemperatures` pseudocode/brute-force comments (5 min) | 🧩 | 🟡 open since 12 Nov |
| 2 | Frequency-counting weak pack (debugging exercise + Valid Anagram checks); Group Anagrams' key question covers half of it | 🧩 | ⬜ (🔴 Weak) |
| 3 | HTTP semantics / `ResponseEntity` packs | 🌱 | ⬜ (🔴 Weak, from 16 Nov) |
| 4 | CarFleet single-pair follow-up | 🧩 | 🟡 |
| 5 | B2 Q3/Q6, `ScoreOfParentheses` follow-ups, Day 02/03 re-answers, Two Sum `put` question | 🎤 | ⬜ |
| 6 | Banking module 1 | 🏦 | parked |

**Pending items: 10** (Two Sum closed, Group Anagrams opened; full list in [PROGRESS.md](../PROGRESS.md#-pending)).

### 🧹 Housekeeping (done by me)
- `TwoSum.java`: notes block re-indented as a normal comment (was a column-0 Javadoc), blank line after imports. Tests still 19/19.
- Mon 23 Nov had no evening review or 10 PM check on record; its outcome (Two Sum 19/19, nothing else) is recorded here and in `PROGRESS.md`, and the redo queue was shifted one day in [redo-schedule.md](../revision/redo-schedule.md).
- Re-run after today's files: **817 run / 91 red** = `GroupAnagrams` 22 (new stub) + `Day06` 4 + Asteroid 28 + CarFleet 37; everything else green.
