# 📅 Day 32 (Mon 23 Nov): catch-up Monday — Ch 3 re-answer, Two Sum with a near-full skeleton, Day06 last loop, Asteroid cold

![Week](https://img.shields.io/badge/week-5-blue) ![Day](https://img.shields.io/badge/day-32-blue) ![Type](https://img.shields.io/badge/type-catch--up%20weekday-orange) ![Spring](https://img.shields.io/badge/Spring-Ch%203%20re--answer-orange) ![DSA](https://img.shields.io/badge/TwoSum-0%2F19%20carry--over-orange) ![Buggy](https://img.shields.io/badge/Day06-16%2F20-orange) ![Redos](https://img.shields.io/badge/redos-Asteroid%20%2B%20CarFleet-purple) ![DSA%20count](https://img.shields.io/badge/DSA%20verified-9%20of%2045--50-informational)

> [!IMPORTANT]
> Monday, but a **catch-up** Monday: three items have been open for days, so nothing new opens until they close (golden rule: never start problem N+1 while N is unfinished; no Chapter 4 while Chapter 3's answer is 🔴). No buggy round (those are Tue/Fri); the 15-min buggy slot goes to the open `Day06` fix. **Done when:** the Ch 3 re-answer is graded ≥ 7 in chat, `TwoSumTest` **19/19** and `Day06FirstUniqueCodeTest` **20/20** are pushed, and `AsteroidCollisionRedoNov17` is pushed cold (even red).

> [!NOTE]
> **Legend:** 🌱 Spring (`spring-boot-labs`) · 🧩 DSA · 🐞 buggy slot · 🔁 redo · ✅ done · ❌ missed · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 5, Day 32. Sections: 🌅 Morning, 🌙 Evening, 🌒 End of day.

## 🌅 Morning

> [!NOTE]
> State at ~6:15 AM IST (fresh clone, JDK 21, Maven): **no student commits since `41abb48`** (21 Nov 9:21 PM IST, `Day06` 16/20) in this repo, and labs `my-solutions` is still `e619f82` (20 Nov 1:04 PM IST). No chat answers on Sunday. Full re-run: **795 run / 88 red**, exactly the four open files (`TwoSum` 0/19, `Day06FirstUniqueCode` 16/20, `AsteroidCollisionRedoNov17` 0/28, `CarFleetRedoNov20` 0/37); everything else green. Nothing to grade, no redo pushed, no cosmetic fixes, no new mistakes. **Housekeeping:** Sunday's whole record ([day31.md](day31.md) morning, evening review and 10 PM check, plus the matching `PROGRESS.md` and `redo-schedule.md` updates) never reached the repo (push approval expired); it goes in with this commit. The revision-schedule mirror table in `PROGRESS.md` was also out of date (still showed the Sun 22 pair as due); it now matches [redo-schedule.md](../revision/redo-schedule.md).

> [!TIP]
> **Short on time? The 15-minute minimum:** item 3 (`Day06` last loop) → push, even red. One small push beats a perfect plan that doesn't start. Ask me for a hint after 15 minutes stuck on any step.

### ⏱️ Time plan (120 min)

| Min | Track | Item | Done when |
|---|---|---|---|
| 0-20 | 🌱 | **Ch 3 interview re-answer**, part 2 + part 3, in chat (warm-up demo below first) | graded in chat |
| 20-30 | 🌱 | Senior **Q2** + **Q3**, then the floor-vs-cap line | graded in chat; ≥ 7 overall unlocks Chapter 4 tomorrow |
| 30-65 | 🧩 | **Two Sum** carry-over: guiding questions → pseudocode → near-full skeleton → retype from a blank method | `TwoSumTest` **19/19** pushed |
| 65-80 | 🐞 | Buggy slot (Monday, no new round): **`Day06FirstUniqueCode`** last loop only + symptom-group comment + one comment per fix | `Day06FirstUniqueCodeTest` **20/20** pushed |
| 80-105 | 🔁 | **`AsteroidCollisionRedoNov17`** cold, 25-min timer | pushed, even red |
| 105-120 | 🧩 | Buffer: `DailyTemperatures` comments (5 min) → frequency-counting pack exercise ([day28.md](../archive/tasks/day28.md#-weak-topic-pack-frequency-counting-counts-not-sums)) | pushed / answered |
| Evening | 🔁 | **`CarFleetRedoNov20`** cold (after the review) | pushed, even red |

> [!NOTE]
> Spring gets 30 min instead of ~60 because today's Spring work is an answer, not code; the time goes to the two code items that are past their 2-day limit.

---

### 🌱 1. Spring: Chapter 3 re-answer + senior Q2/Q3 (~30 min, in chat)

**Why it matters.** Your Chapter 3 code was 15/15 on the first push. What's open is the explanation, and "is a singleton bean thread-safe, and how do you fix it?" is asked in nearly every senior Spring loop, usually as "our totals drift under load, why?". Chapter 4 opens once this is graded 7 or more.

**The concept in two sentences.** A singleton bean is **one object** shared by every request thread. Whatever that object keeps in a **field** is shared; whatever a method keeps in a **local variable** is not.

**Warm-up demo (2 min, just read it).** A bean-like class with one field, called from two threads:

```java
class FeeTotals {                       // imagine @Service, singleton scope
    private long total;
    void add(long fee) { total += fee; }
}
// two threads, each calls bean.add(1) 100 000 times on the SAME instance
```

Actual output from two runs on the box this morning:

```text
expected 200000, got 112964
expected 200000, got 111910
```

Row by row, one lost update (`total` starts at 5):

| Step | Thread 1 | Thread 2 | `total` in memory |
|---|---|---|---|
| 1 | reads 5 | | 5 |
| 2 | | reads 5 | 5 |
| 3 | writes 5 + 1 = 6 | | 6 |
| 4 | | writes 5 + 1 = 6 | **6** (should be 7) |

**Gotchas.** A one-thread unit test never shows this; it only appears under concurrent load. And it gets worse, not better, with more instances behind a load balancer.

**Your answer (in chat, questions in [day30.md §1](day30.md#-1-spring-close-chapter-2s-interview-re-answer-chapter-3-35-min-no-new-chapter)):**
- **Part 2:** using the table above, say *why* `total += fee` races (where the field lives vs where a local lives), then give **two real fixes**.
- **Part 3:** `@Component` vs `@Bean`: the rule **and the why** (what finds each one; when you *must* use `@Bean`).
- **Q2:** singleton `TransferService` with `private BigDecimal runningTotal` drifts under load. Why, and two fixes with trade-offs; one must survive **3 instances and a restart**.
- **Q3:** a prototype `Receipt` injected through a singleton's constructor. New receipt per transfer? If not, two ways to get one per call.
- **Floor vs cap (one line each):** (a) "1% but **at least** ₹10" → `Math.___(amount / 100, 10)`; (b) "2% but **at most** ₹500" → `Math.___(amount * 2 / 100, 500)`; (c) how you decide before typing.

**Knowledge checks (letters only):**
1. In the demo, which change alone makes the output always 200000 in one JVM?
   - A. mark `total` `volatile` · B. make `total` an `AtomicLong` and call `addAndGet` · C. make the bean `@Lazy` · D. make `add` `private`
2. Three instances of the service run behind a load balancer. Which fix keeps one correct total?
   - A. `synchronized add` · B. `AtomicLong` · C. a single DB row updated with `total = total + ?` · D. `ThreadLocal<Long>`
3. Where does a local variable declared inside a singleton's method live?
   - A. on the heap, shared · B. in the bean's field table · C. on the calling thread's own stack · D. in the application context

---

### 🧩 2. DSA: Two Sum (Arrays & Hashing 3 of 9), **carry-over** with a near-full skeleton (~35 min)

![Tests](https://img.shields.io/badge/TwoSumTest-0%2F19-orange) ![Hint](https://img.shields.io/badge/hint-near--full%20skeleton-yellow) ![Status](https://img.shields.io/badge/new%20today-no%20(carry--over)-lightgrey)

> [!IMPORTANT]
> Not a new problem: Two Sum was assigned Fri 20 Nov and is past its 2-day limit, so per the pace rule the hint level goes all the way up. **Group Anagrams (A&H 4 of 9) is the next new problem, the day after `TwoSumTest` is 19/19.** Full spec, story and rules: [day29.md, Two Sum](day29.md) and the Javadoc in `src/main/java/com/prashant/dsa/arrayshashing/TwoSum.java`.

**Why it matters.** Contains Duplicate remembered *whether* you'd seen a value, Valid Anagram *how many times*. Two Sum remembers *where*: value → index. "Store what you've seen so the partner is an O(1) lookup" is the core move of the hashing pattern.

**Step 1: guiding questions (5 min, answer in a comment at the top of the method).**
1. You're at index `i` with value `nums[i]`. What exact value must the partner have?
2. What should the map remember so that, when you meet the partner later, you can return **both** indices?
3. Check first, then store, or store first, then check? Try both on `[3, 2, 4]`, target 6: which order returns `[0, 0]`?
4. Target `-1`, values `Integer.MAX_VALUE` and `Integer.MIN_VALUE`: what type must the "needed partner" be computed in so it can't wrap around?

**Step 2: 3-5 lines of plain-English pseudocode + the brute-force comment** (already templated in the stub).

<details><summary>Step 3: stronger hint, the skeleton (open after answering the four questions)</summary>

Only two lines are blank. Fill them, run the tests, then **delete the method body and retype it from a blank method** without looking (that's the part that makes it stick).

```java
public int[] twoSum(int[] nums, int target) {
    if (nums == null) throw new IllegalArgumentException("nums must not be null");
    Map<Integer, Integer> seen = new HashMap<>();          // value -> index where we saw it
    for (int i = 0; i < nums.length; i++) {
        long need = (long) target - nums[i];               // why long? (question 4)
        if (need >= Integer.MIN_VALUE && need <= Integer.MAX_VALUE) {
            Integer j = ______________________;           // BLANK 1: have we already seen the partner?
            if (j != null) return new int[]{j, i};         // j < i, so already ascending
        }
        ______________________;                            // BLANK 2: remember this value (keep the first index)
    }
    throw new IllegalArgumentException("no pair adds up to " + target);
}
```

Imports: `java.util.Map`, `java.util.HashMap`.

</details>

<details><summary>Open only after your attempt: dry run and complexity</summary>

`nums = [3, 2, 4]`, `target = 6`:

| `i` | `nums[i]` | `need` | `seen` before | partner found? | `seen` after |
|---|---|---|---|---|---|
| 0 | 3 | 3 | `{}` | no (3 isn't stored yet, so no `[0,0]`) | `{3:0}` |
| 1 | 2 | 4 | `{3:0}` | no | `{3:0, 2:1}` |
| 2 | 4 | 2 | `{3:0, 2:1}` | **yes, `j = 1`** | return `[1, 2]` |

Checking **before** storing is what stops an element pairing with itself.

| Approach | Time | Space | Note |
|---|---|---|---|
| Brute force, every pair | O(n²) because each of n values is compared with up to n others | O(1) | 10¹² comparisons at n = 10⁶: the 2-second test fails |
| Sort + two pointers | O(n log n) because of the sort | O(n) because you must copy (array can't be modified) and keep original indices | loses indices without extra work |
| **One-pass hash map** | **O(n) because each value is looked up and stored once, both O(1) on average** | **O(n) because the map can hold up to n entries** | the answer |

</details>

**Complexity lines with a "because"** (your 🟡 recurring gap): write the `Time:` and `Space:` comments with the reason, not just the letter.

**Knowledge checks (letters only):**
1. `[3, 3]`, target 6, and you **store before you check**. What comes back?
   - A. `[0, 1]` · B. `[0, 0]` · C. exception · D. `[1, 1]`
2. Why is the map `value → index` rather than `index → value`?
   - A. Java maps can't use ints as keys · B. you look up by the value you need, and you need its index back · C. it uses less memory · D. it keeps the order
3. Worst-case time of `HashMap.get` with Java 8+ treeified buckets, all keys colliding:
   - A. O(1) · B. O(log n) · C. O(n) · D. O(n log n)

---

### 🐞 3. Buggy slot (Monday, no new round): `Day06FirstUniqueCode` last loop (~15 min)

![Tests](https://img.shields.io/badge/Day06FirstUniqueCodeTest-16%2F20-orange) ![Status](https://img.shields.io/badge/status-REVISION__REQUIRED-red)

**Why it matters.** Your first two fixes (`&&` → `||`, the counting loop from `i = 0`) are right. The last loop is the same frequency-counting gap as Valid Anagram: pass 2 has to answer a question about **string positions**, and that sets what the loop index means.

**Small example, the actual output of your current code (`41abb48`):**

| Input | Expected | Your code returns |
|---|---|---|
| `"leetcode"` | 0 | 0 ✅ |
| `"aab"` | 2 | 2 ✅ (by luck) |
| `"aabb"` | -1 | `StringIndexOutOfBoundsException: Index 4 out of bounds for length 4` ❌ |

**Trace `"aabb"` by hand** (fill the table on paper):

| `letter` | `codes.charAt(letter)` | `count[...]` | returns? |
|---|---|---|---|
| 0 | ? | ? | ? |
| 1 | ? | ? | ? |
| 2 | ? | ? | ? |
| 3 | ? | ? | ? |
| 4 | ? | ? | ? |

Then answer in one line each: (1) What does `letter` stand for in this loop: a letter of the alphabet or a position in the string? (2) What should it stand for, given what the method returns? (3) So what is the loop's correct upper bound?

**Rules:** change **only the last loop** (smallest change, no rewrite). Add the symptom-group comment at the top of the method (which failing tests share one cause) and one `// fix:` comment per change (three in total). Push → 20/20.

**Gotcha:** a loop that passes `"leetcode"` and `"aab"` can still be wrong. Short strings (fewer than 26 characters) and long ones (`large`, 999 998) are where the index meaning shows.

---

### 🔁 Redos (cap 2, most overdue first, **cold only**)

| # | Redo | Stub (blank, tests verified) | Due since | When | Done when |
|---|---|---|---|---|---|
| 1 | `AsteroidCollision` (+1, late) | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | 1 Nov (assigned 17 Nov) | morning, 80-105 | `AsteroidCollisionRedoNov17Test` 28/28 |
| 2 | `CarFleet` (+1, late) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | 4 Nov (assigned 20 Nov) | evening, after the review | `CarFleetRedoNov20Test` 37/37 |

> [!WARNING]
> 🔁 **Cold means cold.** Open the blank stub, close every other tab, and don't look at `dsa/stack/AsteroidCollision.java` or `CarFleet.java`. Start with a pattern line and time/space (each with a **because**), then 20-30 min on a timer. Push even if red. A redo that matches the original solution counts as **not passed** and repeats the same gap.

---

### 📦 Carried backlog (in order, after today's items)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `DailyTemperatures` pseudocode/brute-force comments (5 min) | 🧩 | 🟡 open since 12 Nov |
| 2 | Frequency-counting weak pack (debugging exercise + Valid Anagram checks) | 🧩 | ⬜ (🔴 Weak, missed twice) |
| 3 | HTTP semantics / `ResponseEntity` packs | 🌱 | ⬜ (🔴 Weak, from 16 Nov) |
| 4 | CarFleet single-pair follow-up | 🧩 | 🟡 |
| 5 | B2 Q3/Q6, `ScoreOfParentheses` follow-ups, Day 02/03 re-answers | 🎤 | ⬜ |
| 6 | Banking module 1 | 🏦 | parked |

**Pending items: 10** (full list in [PROGRESS.md](../PROGRESS.md#-pending)).

### 📊 Monday DSA count

| Verified NeetCode problems | Target by mid-Jan 2027 | Still needed | Weeks left (to Thu 14 Jan) | Pace needed | Verified this week so far |
|---|---|---|---|---|---|
| **9** (7 Stack + Contains Duplicate + Valid Anagram) | 45-50 | 36-41 | about 7.4 | about **5-5.5 a week** | 0 (Two Sum would make it 10) |

> [!NOTE]
> At the measured pace (about 2.3 a week) the goal lands around March 2027. Closing Two Sum today and then one new problem each weekday is what keeps 45-50 reachable.
