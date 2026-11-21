# 📅 Day 29 (Fri 20 Nov): close Chapter 2's interview, start Chapter 3, Two Sum, Friday buggy round

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-29-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h-green) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Friday plan, one item per track. 🌱 The **Chapter 2 Task 6 interview answer** in chat comes first (it closes Chapter 2), then labs **Chapter 3 Tasks 1-2** (beans and the application context). 🧩 10-minute **frequency-counting debugging exercise**, then **Two Sum** (new, Arrays & Hashing 3 of 9). 🐞 `DailyTemperatures` comments (5 min), then the **Friday buggy round `Day06FirstUniqueCode`** (Arrays & Hashing). 🔁 Evening: cold redos `AsteroidCollision` + `CarFleet`.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first. In `spring-boot-labs` stay on `my-solutions`.
>
> State at ~6:20 AM IST (fresh clones in `/workspace/morning-day29`, JDK 21, Maven): **no student commits since the 19 Nov 10 PM check** in either repo (labs `my-solutions` tip `b4a3717`, 19 Nov 11:59 AM IST; this repo's tip `ef0f0c1` is the 10 PM record). No answers in chat after the evening review, so the Task 6 interview answer is still owed. Re-run: labs `Chapter02CheckTest` 19/19, `Chapter03CheckTest` **0/15** (untouched stub, as shipped); this repo 719 run / 28 red (only the `AsteroidCollisionRedoNov17` stub) before today's files; **795 run / 98 red** after them (Two Sum stub 19 + Day06 buggy 14 + CarFleet redo stub 37 + Asteroid redo stub 28).

## 🌅 Morning

### ⏱️ Time plan (120 min morning + evening redos)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-3 | 🌱 | `git pull` both repos; `git checkout my-solutions` in labs | clean pull |
| 3-15 | 🌱 | **Chapter 2 Task 6 interview answer** + day28 knowledge checks 1-3, in chat | answered → graded in chat → Chapter 2 ✅ |
| 15-60 | 🌱 | **Chapter 3 Tasks 1-2** (`@Component`, then a `@Bean` `Clock`). Stretch, only if both are green: Tasks 3 + 5 **together** | `task1a`-`task2b` green on pushed `my-solutions` (4/15) |
| 60-70 | 🧩 | Weak pack **debugging exercise** (sum vs every slot) + Valid Anagram knowledge checks 1-3, in chat | answered in chat |
| 70-100 | 🧩 | **Two Sum** (new, Arrays & Hashing 3 of 9): pseudocode + brute force first | `TwoSumTest` **19/19** pushed |
| 100-105 | 🐞 | `DailyTemperatures` brute-force + pseudocode **comments** (open since 12 Nov) | comment-only push |
| 105-118 | 🐞 | **`Day06FirstUniqueCode`** (Friday round): symptom-group comment **before** any fix | `Day06FirstUniqueCodeTest` **20/20** pushed (if not reached, it carries to Sat with stronger hints) |
| 118-120 | — | Push, buffer, hint requests | nothing left unpushed |
| Evening ③ (cap 2) | 🔁 | `AsteroidCollision` then `CarFleet`, cold, 20-30 min each | see the redo table below |

> [!TIP]
> Stuck 15 minutes on any step? Ask for a hint. Push after each item, even if red. 3-5 lines of plain-English pseudocode before any Java, every time.

### 🌱 1. Spring: close Chapter 2, then Chapter 3 Tasks 1-2 (~60 min)

![Ch2](https://img.shields.io/badge/Chapter02CheckTest-19%2F19-brightgreen) ![Ch3](https://img.shields.io/badge/Chapter03CheckTest-0%2F15-orange) ![Gate](https://img.shields.io/badge/Ch3%20unlocks-after%20the%20Ch2%20answer-yellow)

#### 1a. Chapter 2 Task 6 interview answer (in chat, ~12 min)

The code is done (19/19, `b4a3717`); the concept is not graded yet, and Chapter 2 is ✅ only once it is. Full question and the three knowledge checks: [day28.md Task 6](day28.md#-1-chapter-2-task-6-interview-the-application-class-17-min--15-min-interview). Say it aloud first, then type it:

- What does `@SpringBootApplication` switch on? Name the **three** annotations inside it and what each does.
- What happens if `AccountController` sits in a package **above** the application class?
- Senior add-on: how would you see **why** an auto-configuration did or did not apply?
- Knowledge checks 1-3 from day28 (A/B/C letters are enough).

#### 1b. Chapter 3: beans and the application context (Tasks 1-2, ~45 min)

📂 [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · branch `my-solutions` · `chapters/03-beans-and-the-application-context/` · you edit `FeeCalculator.java` and `BankConfig.java` today (each has a `// Task N` comment). Full lesson, demo output and traps: the [chapter README](https://github.com/PrashantSury/spring-boot-labs/blob/main/chapters/03-beans-and-the-application-context/README.md).

**Why it matters (one line).** Rohan's version does `new FeeCalculator()` 40 times a second and hard-codes `Clock.systemDefaultZone()` in five classes, so no test can freeze time. The application context fixes both from one place, and "what is a bean, and is a singleton bean thread-safe?" is asked in nearly every senior Spring round.

**The concept in two sentences.** A bean is an object Spring creates once, keeps in the application context and hands out. You put your own class in with a stereotype like `@Component` (found by component scanning); you put a class you don't own (`Clock`, `NumberFormat`) in with a `@Bean` method inside a `@Configuration` class.

**Small example (already finished in the chapter, read it, don't copy it):**

| Bean name | How it got there | Type |
|---|---|---|
| `auditLog` | `@Component` on `AuditLog` (default name: class name, lower-case first letter) | `AuditLog` |
| `rupeeFormat` | `@Bean` method `rupeeFormat()` in `DemoConfig` (name = method name) | `DecimalFormat` |
| `branchCodes` | `@Bean("branchCodes")` on a method called `codes()` (name from the annotation) | `List` |

**The real output this morning (stub, `BeanTour` and the check):**

```text
feeCalculator     NoSuchBeanDefinitionException: No qualifying bean of type 'ledgerly.FeeCalculator' available
bankClock zone    NoSuchBeanDefinitionException: No bean named 'bankClock' available
task1a  FAIL  the context has no bean of type FeeCalculator. Mark the class so component scanning finds it
task2a  FAIL  there is no bean named bankClock. Is the method annotated so it becomes a bean?
```

**Today's tasks:**

1. **Task 1, `@Component`.** Make `FeeCalculator` a bean found by component scanning. Write the one line first: *"Spring Boot already ___, so I only add ___"*.
2. **Task 2, `@Bean` for a JDK class.** In `BankConfig`, a `Clock` bean named `bankClock` for zone `Asia/Kolkata`.
3. **Stretch (only if 1-2 are green): Tasks 3 + 5 together.** Two named `InterestPolicy` beans and one `@Primary`. Task 3 alone turns the Task 5 check red with "found 2"; that is expected.

> [!WARNING]
> Gotchas: (1) a method in a `@Configuration` class is **not** a bean until it is annotated. (2) `@Component` goes on classes, never on `@Bean` methods. (3) Don't touch `FeeCalculator`'s scope; Task 4 checks it stays a singleton. (4) No new `@ComponentScan`: think about what Boot already scans (you just answered that in 1a).

**Run:** `mvn -pl chapters/03-beans-and-the-application-context test` and the tour: `mvn -q -pl chapters/03-beans-and-the-application-context compile exec:java "-Dexec.mainClass=ledgerly.BeanTour"`.

**🎤 Interview question (Task 6, later this chapter, now pending in [interview-answers.md](../interview-answers.md)).** *Spring beans are singletons by default. What does that mean, is it the same as the singleton pattern, does it make a bean thread-safe, and what is the difference between `@Component` and `@Bean`?* Two senior follow-ups are listed there too (a mutable field in a singleton `TransferService`; a prototype injected into a singleton).

**Knowledge checks** (answer in chat before the stretch):

1. `@Bean("branchCodes") List<String> codes()`. What is the bean's name?
   - A. `codes`
   - B. `branchCodes`
   - C. `list`
   - D. both `codes` and `branchCodes`
2. A singleton bean in Spring means:
   - A. one instance per JVM, like the Gang-of-Four pattern
   - B. one instance per application context
   - C. one instance per thread
   - D. one instance per HTTP request
3. You need a `Clock` bean. Why `@Bean` and not `@Component`?
   - A. `@Component` is slower
   - B. `Clock` is a JDK class you can't annotate, and it needs code (`Clock.system(...)`) to build
   - C. `@Bean` makes it a prototype
   - D. `@Component` can't be used in Spring Boot 4

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Answers.** (1) **B**: the name in the annotation wins over the method name. (2) **B**: one per context; two contexts in one JVM hold two copies. (3) **B**: you don't own the class, and building it takes code (`Clock.system(ZoneId.of("Asia/Kolkata"))`).

</details>

- [ ] Task 6 interview answer + knowledge checks 1-3 in chat → Chapter 2 ✅.
- [ ] One line first: "Spring Boot already ___, so I only add ___".
- [ ] `task1a`, `task1b`, `task2a`, `task2b` green → push on `my-solutions`.
- [ ] Ch 3 knowledge checks 1-3 in chat.
- [ ] Stretch: Tasks 3 + 5 green together.

### 🧩 2a. DSA warm-up: frequency-counting debugging exercise (~10 min)

From the 🔴 weak-topic pack: [day28.md](day28.md#-weak-topic-pack-frequency-counting-counts-not-sums), part 3. The snippet passes `anagram`/`nagaram`. In chat: one input it gets wrong, why, and the one-line fix. Then Valid Anagram knowledge checks 1-3 ([day28.md](day28.md#-3-dsa-valid-anagram-new-arrays--hashing-2-of-9-25-min)), letters only.

- [ ] Wrong input + why + one-line fix, in chat.
- [ ] Valid Anagram checks 1-3, in chat.

### 🧩 2b. DSA: Two Sum (new, Arrays & Hashing 3 of 9, ~30 min)

![Type](https://img.shields.io/badge/type-DSA%20Arrays%20%26%20Hashing-blue) ![Tests](https://img.shields.io/badge/TwoSumTest-19-lightgrey) ![Stub](https://img.shields.io/badge/stub-0%2F19-orange)

> [!IMPORTANT]
> 📂 stub `src/main/java/com/prashant/dsa/arrayshashing/TwoSum.java` · tests `src/test/java/com/prashant/dsa/arrayshashing/TwoSumTest.java` (19, all with `@DisplayName`; checked against a reference solution that is **not** in the repo: reference 19/19, stub 0/19). ✅ Done when 19/19 pass on your pushed code, with pseudocode + brute force first and pattern / time / space lines that each say **because**. If not finished today, it carries to Monday with guiding questions (weekends have no new problem).

#### 1️⃣ Problem understanding (why it matters, then a worked example)
**Why it matters:** Contains Duplicate remembered *whether* you'd seen a value (a set). Valid Anagram remembered *how many times* (a counter). Two Sum remembers *where* (a map from value to index). "Store what you've seen so the partner is one O(1) lookup away" is the move behind a large share of hashing questions.

**Story:** a customer disputes one card charge. Reconciliation has the pending authorisation amounts (in paise) and the disputed total. Find the two authorisations that add up to exactly that total and return their positions so the analyst can pull both records.

| nums | target | Output | Why |
|---|---|---|---|
| `[2, 7, 11, 15]` | 9 | `[0, 1]` | 2 + 7 |
| `[3, 2, 4]` | 6 | `[1, 2]` | 2 + 4; `[0, 0]` is wrong because one entry can't be used twice |
| `[3, 3]` | 6 | `[0, 1]` | two different entries with the same value |
| `[1, 2, 3, 4]` | 100 | `IllegalArgumentException` | no pair (repo rule) |

#### 2️⃣ Input / output and constraints
- `int[] twoSum(int[] nums, int target)` returns `[i, j]` with `i < j`.
- `null` → `IllegalArgumentException`. No pair (also empty or one element) → `IllegalArgumentException`.
- Tests with an answer have exactly one valid pair.
- Values and target cover the whole `int` range, and the sum must be **exact**: a pair that only "adds up" after int overflow wraps around is not a pair.
- Don't modify the caller's array. 1 000 000 values within 2 s.

#### 3️⃣ Pattern identification
**Arrays & Hashing: complement lookup.** The cue is *"find two items that combine to a target"*. For each `x`, the partner is fully determined (`target - x`), so the question becomes "have I already seen that exact value, and where?".

#### 4️⃣ Approach (brute force only; write this first)
Brute force: try every pair `i < j`. Write it as 3-5 plain-English lines, then answer in a comment: *how many pairs for n = 1 000 000, and why do the two `large` tests time out with it?*

Hints, as questions:
1. When you're at index `j`, which **one** value would complete the pair?
2. Contains Duplicate's set answered "seen it?". What extra fact do you need to store per value now, and which `java.util` structure holds a value **and** that fact?
3. Should you look up the partner **before** or **after** you store the current value? Try `[3, 2, 4]`, target 6, both ways.
4. `Integer.MAX_VALUE + 1` in `int` is what? How do you compute `target - x` so it can't wrap?
5. Sorting + two pointers also works. What does it cost you here (the indices, and the caller's array)?

#### 5️⃣ Dry run of the optimised algorithm
Inside the locked block below.

#### 6️⃣ Java stub
In the repo: `throw new UnsupportedOperationException("TODO: Two Sum")`, comment lines waiting for pseudocode / brute force / pattern / time / space (each with "because"), and a `main` with two examples.

#### 7️⃣ Complexity
Brute force: you state it with the reason. Optimised: after your attempt, each with one sentence on where the cost comes from.

#### 8️⃣ Interview follow-ups
1. The input is already **sorted**. Which approach do you switch to and what does it save? (That is Two Sum II, the Two Pointers tab later.)
2. 50 million amounts don't fit in one JVM's heap as a `HashMap<Integer, Integer>`. Roughly how much memory per entry does a boxed map cost, and what would you do instead (primitive map, sort + two pointers on disk, partition by `amount % k`)?
3. Return **all** pairs, not one, with duplicates allowed. What changes in what you store per value?
4. The amounts are `BigDecimal` rupees, not paise. What breaks in a hash lookup (`equals` vs `compareTo`, `2.0` vs `2.00`) and how do you normalise?

**Knowledge checks:**

1. `[3, 2, 4]`, target 6. A solution stores every value in the map **first**, then looks up `6 - x` for each `x`. What can go wrong?
   - A. nothing
   - B. at `x = 3` it finds its own 3 and returns `[0, 0]`
   - C. it throws `NullPointerException`
   - D. it returns `[1, 2]` twice
2. One pass with a `HashMap<Integer, Integer>` costs:
   - A. O(n) time on average, O(n) extra space
   - B. O(n log n) time, O(1) space
   - C. O(n²) time, O(1) space
   - D. O(1) time
3. `int need = target - x;` with `target = Integer.MIN_VALUE`, `x = Integer.MAX_VALUE` gives:
   - A. an `ArithmeticException`
   - B. `1`, because the subtraction wraps around
   - C. `-4294967295`
   - D. `0`

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Optimised algorithm (one pass, complement map).**
1. If `nums` is `null`, throw `IllegalArgumentException`.
2. `Map<Integer, Integer> seen` (value → first index), sized for `n`.
3. For each `j`: compute `need = (long) target - nums[j]`. If `need` fits in an `int` and `seen` has it at index `i`, return `[i, j]`.
4. Otherwise store `nums[j] → j` (keep the first index; `putIfAbsent`).
5. After the loop, throw `IllegalArgumentException` (no pair).

**Dry run** `[3, 2, 4]`, target 6:

| j | nums[j] | need | seen before the step | found? | seen after |
|---|---|---|---|---|---|
| 0 | 3 | 3 | {} | no (its own 3 is not stored yet) | {3→0} |
| 1 | 2 | 4 | {3→0} | no | {3→0, 2→1} |
| 2 | 4 | 2 | {3→0, 2→1} | **yes, at 1** → return `[1, 2]` | — |

Looking up **before** storing is what stops an element pairing with itself. `[3, 3]`: at j=1, need 3 is already stored at 0, so `[0, 1]`. `i < j` comes for free because `i` was stored earlier.

**Complexity.** Time **O(n)** on average because each element does one hash lookup and at most one insert, both O(1) on average. Space **O(n)** because in the worst case (pair at the end, or no pair) every value is stored. Brute force: O(n²) time because it checks n(n−1)/2 pairs (about 5 × 10^11 for n = 10^6), O(1) space. Sort + two pointers: O(n log n) time, O(n) space for the (value, index) copy you need to keep indices and leave the caller's array alone.

**Answers.** (1) **B**. (2) **A**. (3) **B**: `int` arithmetic wraps silently; compute in `long`.

</details>

- [ ] Pseudocode (3-5 lines) + brute-force comment with the 10^6 answer.
- [ ] Pattern / time / space lines, each with a "because".
- [ ] `mvn test -Dtest=TwoSumTest` → **19/19**. Push.
- [ ] Knowledge checks 1-3 in chat before opening the locked block.

### 🐞 3. Buggy slot: `DailyTemperatures` comments, then Friday's round (~18 min)

**3a. `DailyTemperatures` comments (5 min, open since 12 Nov).** 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` (code already ✅ 18/18). Above the Java, add:

- [ ] one brute-force comment line (the naive re-scan, its cost and why)
- [ ] 3-5 lines of plain-English pseudocode of **your** stack solution
- [ ] comment-only push

#### 3b. Friday buggy round: `Day06FirstUniqueCode` (Arrays & Hashing, ~13 min, may continue Saturday)

![Type](https://img.shields.io/badge/type-buggy%20Arrays%20%26%20Hashing-red) ![Tests](https://img.shields.io/badge/Day06FirstUniqueCodeTest-6%2F20%20as%20shipped-orange)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java` · tests `src/test/java/com/prashant/dailytests/Day06FirstUniqueCodeTest.java` (20, `@DisplayName` on each). The code **compiles**; some tests fail. Verified on the fresh clone: the correct version (not in the repo) passes 20/20; the shipped file passes 6/20. **Fix only, don't rewrite.** ✅ Done when 20/20 pass on your pushed code, with a symptom-group comment written **before** the first fix and one comment line per fix naming the test that led you there.

**Why it matters (one line).** It is this week's pattern (count per letter, then use the counts) in the interview format where you're handed someone else's code and a red suite. What the interviewer listens for is how you group the failures before touching code.

**Story.** Every settlement batch in a nightly file is tagged with one lowercase letter, its clearing-house code. A code that appears exactly once means the batch has no counter-batch, so an analyst looks at it first. Return the **index** of the first such batch, reading left to right; `-1` if every code repeats.

**Expected behaviour.**

| Situation | Required result |
|---|---|
| `codes` is `null` | `IllegalArgumentException` |
| any character outside `'a'`-`'z'` (uppercase, digit, space, `{`) | `IllegalArgumentException` |
| empty string | `-1` |
| every code appears 2+ times | `-1` |
| otherwise | the **smallest index** `i` whose code appears exactly once in the whole string ("first" means position in the string, not alphabetical order) |
| 1 000 000 codes | within 1 second |

**Test cases.**

| Group | Test | Input | Expected | What it checks |
|---|---|---|---|---|
| normal | `leetcode` | `"leetcode"` | `0` | first code already unique |
| normal | `loveleetcode` | `"loveleetcode"` | `2` | LeetCode example |
| normal | `allRepeat` | `"aabb"` | `-1` | nothing unique |
| normal | `ledgerly` | `"ledgerly"` | `2` | unique code in the middle |
| normal | `leftmostNotAlphabetical` | `"zxa"` | `0` | position beats alphabet |
| normal | `uniqueInTheMiddle` | `"dcbabcdz"` | `3` | two uniques, leftmost wins |
| normal | `settlementFile` | `"ppqqrstt"` | `4` | two uniques side by side |
| edge | `empty` | `""` | `-1` | no batches |
| edge | `single` | `"m"` | `0` | one batch |
| edge | `twoEqual` | `"kk"` | `-1` | smallest repeat |
| edge | `firstRepeatsAtEnd` | `"abca"` | `1` | a repeat far apart |
| edge | `uniqueLast` | `"aabbc"` | `4` | unique at the very end |
| edge | `threeTimes` | `"aaab"` | `3` | 3 copies is not "once" |
| edge | `alphabetOnce` | all 26 letters once | `0` | every slot is 1 |
| failure | `nullInput` | `null` | IAE | null guard |
| failure | `uppercase` / `digit` / `aboveZ` / `space` | `"abCd"`, `"ab1"`, `"ab{"`, `"a b"` | IAE | input validation |
| large | `large` | 1 000 000 codes | `999998` within 1 s | O(n) |

**How to work it (no shortcuts):**
1. Run the suite. Copy the red tests into a comment and **group them by symptom** (what you see: wrong index, `-1` where an index was expected, an exception of the wrong type...), not by where you think the bug is.
2. For each group, hand-trace the smallest red input through the code.
3. Smallest fix, re-run, next group. One fix can turn several groups green.

**Knowledge checks** (about the pattern):

1. Counting all `n` codes into an `int[26]` and then reading the counts once more costs:
   - A. O(n) time, O(1) extra space
   - B. O(n log n) time, O(n) space
   - C. O(26n) = O(n²) time
   - D. O(1) time
2. Why is a `HashSet<Character>` alone not enough for "appears exactly once"?
   - A. sets are slower than arrays
   - B. a set only says seen / not seen, so it can't tell 1 copy from 3
   - C. sets can't hold `char`
   - D. it is enough
3. The codes become any Unicode text (emoji included). What do you count with?
   - A. `int[26]`
   - B. `int[256]`
   - C. a `HashMap<Integer, Integer>` over `codePoints()`
   - D. `String.indexOf` in a loop

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Answers.** (1) **A**: two linear passes, and 26 slots whatever `n` is. (2) **B**: you could use two sets ("seen" and "seen twice"), but a counter says it directly. (3) **C**: `char` is a UTF-16 unit, so an emoji is two `char`s; code points keep it as one key.

</details>

- [ ] Symptom groups as a comment **before** changing code.
- [ ] Smallest fixes, one comment line each naming the test.
- [ ] **20/20**. Push.

### 🔁 Evening redos (cap 2, most overdue first, cold)

| Redo | File (blank stub) | Tests | Gap | Why now |
|---|---|---|---|---|
| 🧩 `AsteroidCollision` | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` (same blank stub, untouched since 17 Nov) | `mvn test -Dtest=AsteroidCollisionRedoNov17Test` (0/28) | +1, due 1 Nov | most overdue; missed 17, 18, 19 Nov |
| 🧩 `CarFleet` | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` (**new** blank stub, today) | `mvn test -Dtest=CarFleetRedoNov20Test` (0/37; same 37 tests as the original, verified 37/37 against your 3 Nov solution) | +1, due 4 Nov | next most overdue |

> [!CAUTION]
> **Cold means cold.** Blank file, 25-minute timer, no peeking at `dsa/stack/AsteroidCollision`, `dsa/stack/CarFleet`, PR #1 or day09.md. A redo whose body matches the original counts as **not passed** (the 16 Nov pair scored 2/10 for exactly that). A red push from memory beats a green copy.

- [ ] Each starts with a **pattern line + time and space comments** (one sentence each saying where the cost comes from), then 3-5 lines of pseudocode, then code.
- [ ] CarFleet: remember the exact comparison rule from your own mistake log entry of 3 Nov, not from the old file.
- [ ] Push at the end of each, even if red.
- [ ] If either misses tonight, the 10 PM check re-queues it first per [redo-schedule.md](../revision/redo-schedule.md) (missed is not failed).

### 📦 Carried backlog (not for today unless a slot frees up)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | B2 Q3 + Q6 + the one sentence "why the catch-all hid Spring's own answers" | 🌱 | ⬜ NOT_STARTED (weekend) |
| 2 | Weak-pack parts 1, 2, 4 (XOR question, Unicode implementation, 5-million-nickname scenario) | 🧩 | ⬜ NOT_STARTED (weekend) |
| 3 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) open since 6 Nov (your call: merge or close) | 🧩 | 🟡 IN_PROGRESS |
| 4 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 5 | `ScoreOfParentheses` follow-up questions (with its Wed 25 Nov redo) | 🧩 | ⬜ NOT_STARTED |
| 6 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 7 | `Day00BuggyExample` symptom groups (write-up) | 🐞 | ⬜ NOT_STARTED |
| 8 | Maven scopes: one applied question (`provided` in a WAR) at the next check | 🌱 | 🟡 IN_PROGRESS |
| 9 | Weak-topic packs 2 and 3 (HTTP semantics; `ResponseEntity` vs `@ResponseStatus`), from [day25.md](day25.md) | 🌱 | ⬜ NOT_STARTED |
| 10 | Labs README Task 5 tip rewording: waiting for your OK (labs repo not edited) | 🌱 | ⬜ waiting |

### ✅ Morning checklist

- [ ] Ch 2 Task 6 interview answer + checks in chat → Chapter 2 ✅
- [ ] Ch 3 Tasks 1-2 pushed on `my-solutions` (4/15 green); stretch Tasks 3 + 5
- [ ] Weak-pack debugging exercise + Valid Anagram checks in chat
- [ ] `TwoSumTest` **19/19** pushed
- [ ] `DailyTemperatures` comments pushed
- [ ] `Day06FirstUniqueCodeTest` **20/20** pushed (symptom groups first)
- [ ] Evening: Asteroid + CarFleet redos, cold, pushed even if red

### 🧹 Housekeeping (Lumi, this morning)

| What | Detail |
|---|---|
| New stub + tests | `dsa/arrayshashing/TwoSum.java` + `TwoSumTest.java` (19 tests, normal / edge / failure / large). Reference 19/19 (not pushed), stub 0/19; a version that computes the complement in `int` fails exactly the overflow test, as intended |
| New buggy round | `dailytests/Day06FirstUniqueCode.java` + test (20). Correct version (not pushed) 20/20, shipped file 6/20 |
| New redo stub | `dailytests/redo/CarFleetRedoNov20.java` (blank) + `CarFleetRedoNov20Test` (the original 37 tests, renamed). Your 3 Nov solution passes 37/37 against it; the stub 0/37 |
| Cosmetic, not logged | `PROGRESS.md` buggy heading now says Arrays & Hashing (was Stack). Removed the unused `import java.beans.PropertyEditorManager` (an IDE auto-import) from `dsa/stack/RemoveKAdjacentDuplicates.java` (26/26 unchanged) and an unused `java.util.Set` import from `GenerateParenthesesTest.java` |
| Trackers | `interview-answers.md`: Chapter 2 heading now 🟡 IN_PROGRESS (was ⬜ NOT_STARTED, but its code is 19/19); Chapter 3 Q1-Q3 added as pending. `revision/redo-schedule.md`: today's row names the CarFleet stub. `PROGRESS.md`: plan pointer, status, pending, next recommended, log |
| Checked, unchanged | No secrets; `target/` ignored; labs repo not edited (Chapter 3 stubs and tests already exist there) |
| Flagged, not touched | PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) (Lumi CarFleet comments) open 14 days |


## 🌙 Evening (20 Nov): review, scores, tonight and tomorrow

![Slot](https://img.shields.io/badge/slot-8%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-7%2F10-green) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey) ![Ch3](https://img.shields.io/badge/Chapter03CheckTest-15%2F15-brightgreen)

> [!NOTE]
> Checked at ~8 PM IST on fresh clones (JDK 21, Maven 3.9.6). Today's student commits: **labs `my-solutions` `e619f82` "chapter3 completed" (1:04 PM IST)** only. This repo: no student commits (only the three 6 AM session commits, tip `a9ec0d4`), so `TwoSum` (0/19), `Day06FirstUniqueCode` (6/20), the `DailyTemperatures` comments and both redo stubs (Asteroid 0/28, CarFleet 0/37) are untouched. Chat today: a Maven question at 12:16 PM IST (running `-Dtest=Chapter03CheckTest` from the repo root; answered) and a job-listing gap check (no roadmap change, as you asked). The Chapter 2 Task 6 interview answer, the Ch 3 knowledge checks and the DSA warm-up were **not answered in chat**. One conceptual mistake logged ([mistakes/spring.md](../revision/mistakes/spring.md), singleton thread-safety). Cosmetic, not logged (labs repo left as is): `@Component("feeCalculator")` and `@Bean(name="bankClock")` repeat the default names, `@Component` is indented, `@Scope (scopeName="prototype")` has a stray space (`@Scope("prototype")` is the usual form), and `interview-answer.md` has no newline at the end.

You went further than the plan in Spring: all six Chapter 3 tasks green on the first push, with no hint. DSA and buggy had no work today, so they can't be scored, and the "explain it" half is still the gap.

| Track | Score | Evidence (re-run tonight) |
|---|---|---|
| 🌱 Spring | **7/10** (concept 6 · implementation 9 · problem solving 7 · interview 5) | `Chapter03CheckTest` **15/15** on `e619f82` (planned: Tasks 1-2, 4/15). `@Component` on `FeeCalculator`; `@Bean` `Clock.system(ZoneId.of("Asia/Kolkata"))`; two named `InterestPolicy` beans with `@Primary` on savings (task5b: only one primary); `Receipt` prototype while the others stay singleton. Clean, minimal, nothing added that Spring already does. Points off: the written interview answer (Task 6) is 3 sentences (4-8 asked) and its thread-safety fix is wrong (**5/10**, below); Chapter 3 was started before the Chapter 2 Task 6 answer it was gated on, which is now owed for a third day. |
| 🧩 DSA | **can't be scored yet** (no work today; last 6) | `TwoSumTest` 0/19, untouched; warm-up (debugging exercise + Valid Anagram checks) not answered. |
| 🐞 Buggy | **can't be scored yet** (no work today; last 7) | `Day06FirstUniqueCodeTest` 6/20 as shipped; `DailyTemperatures` comments (open since 12 Nov) not pushed. |
| 🔁 Redos | none graded | `AsteroidCollisionRedoNov17` 0/28 and `CarFleetRedoNov20` 0/37 still blank; tonight's slot is still open. No ladder row changed. |

**Chapter 3 interview answer, graded 5/10.** (1) "One per application context, not the GoF pattern" ✅ exact. (2) "Not thread-safe" ✅, but "make deep copies of the mutable fields" ❌: the race is on the shared field itself, and copying doesn't stop two threads writing it. (3) Right rule (yours → `@Component`, JDK class → `@Bean`), but it misses *why*: scanning finds `@Component`; `@Bean` is for classes you don't own **or** that need code to build.

### 🗂️ Topic classification tonight

| Topic | Class | Why |
|---|---|---|
| Registering beans: `@Component`, `@Bean`, names, `@Primary`, prototype scope (code) | 🟢 Strong | all 15 checks green on the first push, no hint, minimal code |
| `@Component` vs `@Bean` (explaining the choice) | 🟡 Moderate | right rule, missing the "needs code to build" reason |
| **Singleton beans and shared mutable state (thread-safety)** | 🔴 **Weak** | conceptual miss in the written answer → pack below, logged in [mistakes/spring.md](../revision/mistakes/spring.md) |
| `@SpringBootApplication` (configuration + auto-configuration + component scan) | ⏳ Pending | code green since 19 Nov; the explanation (Ch 2 Task 6 answer) still not given |
| Frequency counting: counts, not sums | 🔴 Weak (unchanged) | 19 Nov pack: today's debugging exercise not attempted ([day28.md pack](day28.md#-weak-topic-pack-frequency-counting-counts-not-sums)) |
| `TwoSum`, `Day06FirstUniqueCode`, `DailyTemperatures` comments, Asteroid + CarFleet redos | ⏳ Pending | not started |
| HTTP semantics; `ResponseEntity` vs `@ResponseStatus` | 🔴 Weak (unchanged) | 16 Nov packs still unattempted |
| ⛔ Blocked | none | the 12:16 PM Maven error was the command, not a blocker; nothing is in the way |

### 🔴 Weak-topic pack: singleton beans and shared mutable state

**Why it matters (one line).** Every Ledgerly service is a singleton shared by all request threads; one field that a request writes is a real money bug (drifting totals, one customer's data in another's response), and "is a singleton bean thread-safe?" is asked in nearly every senior Spring round.

**Revision notes.**
- Singleton = **one object, many threads at once**. Method parameters and local variables live on each thread's own stack, so they are safe. **Fields** live on the shared object, so a field that requests write is a race.
- "Deep copy" protects you from someone *else* changing an object you hold. It does nothing when two threads update the **same field** (`total = total + x` is read, add, write: two threads can read the same old value and one update is lost).
- Fixes, best first: (1) **stateless**: no request data in fields; keep it in locals, the request DTO or the database. (2) **immutable** fields (`final`, set in the constructor, never changed). (3) a **thread-safe type** (`AtomicLong`, `LongAdder`, `ConcurrentHashMap`) or a lock (`synchronized`) around the whole read-modify-write. (4) a **narrower scope** (`request` / `prototype`) when the state really belongs to one call.
- For money totals that must survive restarts and many instances, none of the in-memory fixes is enough: the database (an atomic `UPDATE ... SET total = total + ?` or a lock on the row) is the source of truth.

| Field in a singleton | Shared? | Safe? | Fix |
|---|---|---|---|
| `private final Clock clock` (constructor) | yes | ✅ never written after startup | none |
| `private BigDecimal runningTotal` updated per request | yes | ❌ lost updates | local variable / DB, or `AtomicReference` / lock |
| `private Map<String, Account> cache = new HashMap<>()` written by requests | yes | ❌ corrupt map under concurrent writes | `ConcurrentHashMap` (and `computeIfAbsent`) |
| `int fee` local inside `feeFor(amount)` | no (per thread) | ✅ | none |

1. **Conceptual question.** A singleton `TransferService` has `private int transfersToday;` and does `transfersToday++` in `transfer()`. Two requests run it at the same moment, starting from 41. List the three steps inside `++` and show how the result can be 42 instead of 43. Would `volatile` fix it? Why or why not?
2. **Implementation exercise (10 min).** In a scratch class, write `DailyCounter` (a singleton-style object) with `increment()` and `get()` three ways: plain `int`, `synchronized` methods, `AtomicInteger`. Start 8 threads that each call `increment()` 100 000 times (an `ExecutorService` + `CountDownLatch` or `invokeAll`), print the three totals, and say in one sentence why the plain one is below 800 000. Pseudocode first.
3. **Debugging exercise.** Under load, customers sometimes see another customer's account number in their receipt. Find the bug and give the one-line fix:
   ```java
   @Service
   public class ReceiptService {
     private String currentAccount;              // set per request
     public String receiptFor(String account, int amount) {
       this.currentAccount = account;
       int fee = Math.max(amount / 100, 10);
       return "Receipt for " + currentAccount + ", fee " + fee;
     }
   }
   ```
4. **Interview scenario.** Ledgerly runs 3 instances behind a load balancer. A singleton `LimitService` keeps a `ConcurrentHashMap<String, Long>` of each customer's spend today and blocks transfers over ₹1 00 000. Is it thread-safe? Is it *correct*? What goes wrong across the 3 instances and after a restart, and where should the daily total really live (DB row with an atomic update, or Redis `INCRBY`)? Give the trade-off in two sentences.

### 🌙 Tonight (rest of the evening slot, in this order)

1. 🌱 **Chapter 2 Task 6 interview answer in chat** (~10 min: the three annotations inside `@SpringBootApplication`, a controller in a package above the app class, how to see why an auto-configuration did or didn't apply). Add the Ch 3 knowledge checks 1-3 (letters only). This closes Chapter 2, owed since 19 Nov.
2. 🧩 **Two Sum, start it** (~25 min): 3-5 lines of pseudocode + the brute-force comment (how many pairs for n = 1 000 000), then the map version if time. **Push even if red.** If it's not green tonight, it carries to Monday with guiding questions (weekends have no new problem).
3. 🐞 **`DailyTemperatures` comments** (5 min, comment-only push). Open since 12 Nov.
4. 🔁 **`AsteroidCollisionRedoNov17` cold** if time is left (25-minute timer, blank file, pattern line + time/space **with a "because"** first). Push even if red. CarFleet and `Day06FirstUniqueCode` wait: if they miss tonight, the 10 PM check re-queues them.

### 🔮 Tomorrow's focus (Sat 21 Nov), based on tonight

| Track | Focus | Why (from tonight's assessment) |
|---|---|---|
| 🌱 Spring | **No Chapter 4 yet.** Re-answer the Ch 3 interview question in chat (part 2: what actually makes a singleton safe), then the two senior follow-ups (Q2 `runningTotal` drift, Q3 prototype inside a singleton) and the pack's conceptual question. Ch 2 Task 6 answer first if it's still owed. Due mistake-log redo: Ch 2 Task 5 floor vs cap (`Math.max` vs `Math.min`, day 3 was 20 Nov). | The code is strong (15/15, no hint), so more code isn't the gap; explaining thread-safety and the main class is. Two interview answers are open, and Chapter 4 (`@Qualifier`, injection) builds on both. |
| 🧩 DSA | Weekend: no new problem. **Two Sum carry-over** (day 2 of 2, stronger hints: the level-1 questions, then the one-pass skeleton) if not green tonight; then the frequency-counting debugging exercise and Valid Anagram checks (10 min). Every complexity line gets a "because". | Two Sum is untouched, and the counting weak topic has had no practice since 19 Nov. Nothing stays open more than 2 days. |
| 🐞 Buggy | **`Day06FirstUniqueCode` carry-over** with stronger hints (symptom groups named for you, you write the fix + one-line comment per test), plus the `DailyTemperatures` comments if still missing. | The Friday round didn't start; the written symptom groups are still the debugging habit to build. |
| 🔁 Redos | Most overdue first, cold: **Asteroid** (due 1 Nov) and **CarFleet** (due 4 Nov) if they miss tonight; otherwise LargestRect + Day01 as queued. The 10 PM check sets the final pair. | per [redo-schedule.md](../revision/redo-schedule.md); missed is not failed, so no gap changes |
| 📆 Review | Weekly performance review at ~2 PM IST. | Sat routine |

> [!TIP]
> Today showed you can clear a whole chapter in one sitting when you start early. Tonight, spend the first 10 minutes talking, not coding: the Chapter 2 answer is three sentences, and it's the only thing between you and two closed chapters.

## 🌒 End of day

![Slot](https://img.shields.io/badge/slot-10%20PM-yellow) ![Spring](https://img.shields.io/badge/Spring-7%2F10-yellowgreen) ![DSA](https://img.shields.io/badge/DSA-unscored-lightgrey) ![Buggy](https://img.shields.io/badge/Buggy-unscored-lightgrey) ![Ch3](https://img.shields.io/badge/Chapter%203-15%2F15-brightgreen) ![Pending](https://img.shields.io/badge/pending-11-blue)

> [!NOTE]
> 10 PM check: **no student commits after the 8 PM review** in either repo (labs `my-solutions` still `e619f82`, 20 Nov 1:04 PM IST; this repo has no student commits today, tip `a9ec0d4` is the morning session). No answers in chat after the review, so the evening scores stand (Spring 7, DSA and Buggy unscored) and nothing new needed a test run (`TwoSum` 0/19, `Day06FirstUniqueCode` 6/20, Asteroid 0/28, CarFleet 0/37 as at 8 PM). The evening-review notes above were not pushed at 8 PM (the approval expired), so they go in with tonight's commits. Asteroid and CarFleet were not attempted, so the redo queue moved one slot ([redo-schedule.md](../revision/redo-schedule.md)). No new conceptual mistake, no cosmetic fix needed.

| Item | Track | Outcome | Status |
|---|---|---|---|
| Chapter 2 Task 6 interview question + Ch 3 knowledge checks 1-3 | 🌱 | not answered tonight (code is 19/19) | 🟡 IN_PROGRESS (first 10 minutes Sat 21 Nov, in chat) |
| Ch 3 interview re-answer + senior Q2/Q3 | 🌱 | not started (written answer 5/10) | 🔴 REVISION_REQUIRED (Sat 21 Nov, after the Ch 2 answer) |
| `TwoSum` (Arrays & Hashing 3 of 9) | 🧩 | not started, 0/19 | ⬜ NOT_STARTED (Sat 21 Nov, day 2 of 2, stronger hints) |
| Frequency-counting weak pack + Valid Anagram checks | 🧩 | not started | ⬜ NOT_STARTED (Sat 21 Nov, 10 min after Two Sum) |
| `Day06FirstUniqueCode` Friday buggy round | 🐞 | not started, 6/20 | ⬜ NOT_STARTED (Sat 21 Nov, stronger hints, symptom groups first) |
| `DailyTemperatures` comments | 🧩🐞 | not pushed | 🟡 IN_PROGRESS (Sat 21 Nov, 5 min) |
| 🔁 `AsteroidCollisionRedoNov17` cold | 🔁 | not attempted (17-20 Nov). Missed is not failed, so no gap changed | 🟡 IN_PROGRESS (Sat 21 Nov, slot 1) |
| 🔁 `CarFleetRedoNov20` cold | 🔁 | not attempted | 🟡 IN_PROGRESS (Sat 21 Nov, slot 2) |

> [!IMPORTANT]
> **First task Sat 21 Nov:** `git pull` both repos (this repo has Lumi's commits from tonight). Then the **Chapter 2 Task 6 interview answer in chat** (~10 min): the three annotations inside `@SpringBootApplication` and what each does, what happens when the controller is in a package above the application class, and how to see why an auto-configuration did or didn't apply (`--debug`), plus Ch 3 knowledge checks 1-3, letters only. That closes Chapter 2. Next: the **Ch 3 interview re-answer** (what really makes a singleton safe) + senior Q2/Q3; no Chapter 4 yet. 🧩 **Two Sum** carry-over with stronger hints, then the frequency-counting exercise + Valid Anagram checks. 🐞 `Day06FirstUniqueCode` with stronger hints + `DailyTemperatures` comments. 🔁 `AsteroidCollisionRedoNov17` + `CarFleetRedoNov20`, cold. 📆 Weekly review ~2 PM IST. **Pending items: 11** ([PROGRESS.md](../PROGRESS.md#-pending)).
