# 📅 Day 28 (Thu 19 Nov): close Chapter 2, close Contains Duplicate, then Valid Anagram

![Week](https://img.shields.io/badge/Week-4-blue) ![Day](https://img.shields.io/badge/Day-28-blue) ![Slot](https://img.shields.io/badge/slot-6%20AM-yellow) ![Time](https://img.shields.io/badge/time-2%20h-green) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange)

> [!IMPORTANT]
> Today is a **closing day**. Three things have been open for two or three days, so today they come with the **strongest hints** (guiding questions, then a partial skeleton that is visible, not locked). 🌱 labs Chapter 2 **Task 6** + its interview question (closes the chapter). 🧩 **Contains Duplicate** (day 3, so it closes today with the skeleton), then **Valid Anagram** (new, unlocks only once Contains Duplicate is 17/17). 🐞 Thursday slot, no new round: `DailyTemperatures` comments, then `Day05DecodeString` with symptom hints. 🔁 Evening: cold redos `Day03NextGreaterIndex` + `AsteroidCollision`.

> [!NOTE]
> **Legend:** 🌅 morning · 🌱 Spring · 🧩 DSA · 🐞 buggy · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` (verified). Run `git pull` on **both** repos first. In `spring-boot-labs` stay on `my-solutions`.
>
> State at 6:10 AM IST (fresh clones in `/workspace/morning-day28`, JDK 21, Maven 3.9.6): **no student commits since the 18 Nov 10 PM check** in either repo (labs `my-solutions` tip `00bd2eb`, 17 Nov 9:33 PM IST; this repo's student code unchanged since `221069b`). Re-run: labs `Chapter02CheckTest` **15/19** (only `task6a`-`task6d` red), `ContainsDuplicateTest` 0/17, `Day05DecodeStringTest` 12/25, `Day03NextGreaterIndexRedoNov17Test` 0/37, `AsteroidCollisionRedoNov17Test` 0/28. Whole suite: 701 run, 95 red, which is exactly those four open files. Nothing new to grade.

## 🌅 Morning

### ⏱️ Time plan (120 min morning + evening redos)

| Minutes | Track | Item | Done when |
|---|---|---|---|
| 0-3 | 🌱 | `git pull` both repos; `git checkout my-solutions` in labs | clean pull |
| 3-20 | 🌱 | **Chapter 2 Task 6** with today's skeleton hint, then start the app and run the README curls | `task6a`-`task6d` green on pushed `my-solutions` → **19/19** |
| 20-35 | 🌱 | **Task 6 interview question**, three sentences + the senior add-on, typed in chat (graded there) | answered in chat → Chapter 2 ✅ |
| 35-55 | 🌱 | B2 **Q3 + Q6** and the one sentence "why the catch-all hid Spring's own answers" (in chat) | answered in chat |
| 55-70 | 🧩 | **Contains Duplicate** close (day 3): pseudocode comment, then fill the skeleton | `ContainsDuplicateTest` **17/17** pushed |
| 70-95 | 🧩 | **Valid Anagram** (Arrays & Hashing 2 of 9), only after 17/17 above. Pseudocode + brute force first | `ValidAnagramTest` **17/17** pushed (if not reached, it is Friday's first DSA item, not a new one) |
| 95-100 | 🐞 | `DailyTemperatures` brute-force + pseudocode **comments** (open since 12 Nov) | comment-only push |
| 100-115 | 🐞 | `Day05DecodeString` (day 3): symptom groups first, then today's hint questions | `Day05DecodeStringTest` **25/25** pushed |
| 115-120 | — | Push, buffer, hint requests | nothing left unpushed |
| Evening ③ (cap 2) | 🔁 | `Day03NextGreaterIndex` then `AsteroidCollision`, cold, 20-30 min each | see the redo table below |

> [!TIP]
> Stuck 15 minutes on any step? Ask for a hint. Push after each item, even if red. 3-5 lines of plain-English pseudocode before any Java, every time.

### 🌱 1. Chapter 2, Task 6 (Interview): the application class (~17 min + 15 min interview)

![Tests](https://img.shields.io/badge/Chapter02CheckTest-15%2F19-yellowgreen) ![Carry](https://img.shields.io/badge/open-day%203-orange)

📂 [`spring-boot-labs`](https://github.com/PrashantSury/spring-boot-labs) · branch `my-solutions` · `chapters/02-first-spring-boot-app/src/main/java/ledgerly/LedgerlyApplication.java` (the `// Task 6` comment is there; **not** `AccountController.java`). Tests: `mvn -pl chapters/02-first-spring-boot-app test`. Full lesson (why, concept, the four red tests, guide questions, knowledge checks): [day27.md Task 6](day27.md#-1-chapter-2-task-6-interview-the-application-class-25-min--15-min-interview).

**Why it matters (one line).** Tasks 1-5 passed without ever starting Spring. Task 6 is what makes the real app start, and "what does the main class switch on?" is the classic 3 AM question when a bean is "not found".

**The real output this morning (your code at `00bd2eb`):**

```text
task6a  FAIL  LedgerlyApplication is not a @SpringBootConfiguration. Which one annotation includes it?
task6b  FAIL  LedgerlyApplication does not enable auto-configuration
task6c  FAIL  LedgerlyApplication does not scan for components
task6d  FAIL  the app did not start: No qualifying bean of type 'ServletWebServerFactory' available
```

**Today's stronger hint (day 3: guiding questions, then a visible skeleton).**

1. Open the chapter README and read the line **"Interview question (task 6)"**. It names the annotation you need.
2. Write the one line first: "Spring Boot already ___, so I only add ___".
3. The change is **two lines**, one import and one annotation, both above `public class`:

```java
package ledgerly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.________;   // TODO: the annotation the README names

// TODO: one annotation here, nothing else
public class LedgerlyApplication {
  public static void main(String[] args) {
    SpringApplication.run(LedgerlyApplication.class, args);
  }
}
```

> [!WARNING]
> Gotchas: no `@EnableWebMvc` (it switches Boot's MVC defaults **off**), no `scanBasePackages`, no extra `@ComponentScan`, no `@Bean` for Tomcat. Spring Boot already provides all of that once the class is the right kind.

**Then:** `mvn -pl chapters/02-first-spring-boot-app spring-boot:run`, run the README curls on port **8081** (including `curl "localhost:8081/double?n=three"`; note the status and who produced it), stop the app.

**🎤 Interview question (chat, three sentences, aloud first).** *What does `@SpringBootApplication` switch on? Name the three annotations inside it and what each does. What happens if the controller class is in a package above the application class?* Senior add-on: *how would you see why an auto-configuration did or did not apply?* (Already pending in [interview-answers.md](../interview-answers.md) as Ch 2 Q4.)

**Knowledge checks** (answer in chat first):

1. `task6d` said "No qualifying bean of type `ServletWebServerFactory`". Which of the three jobs was missing?
   - A. configuration
   - B. auto-configuration
   - C. component scanning
2. `AccountController` lives in `ledgerly`, and you move `LedgerlyApplication` to `ledgerly.boot`. What happens?
   - A. Nothing; Boot scans the whole classpath
   - B. The app starts, but `AccountController` is not a bean, so `/accounts` returns 404
   - C. The app fails to compile
3. Which flag prints the auto-configuration condition report at startup?
   - A. `--trace-beans`
   - B. `--debug`
   - C. `--verbose`

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Answers.** (1) **B**: the web server factory is a bean that auto-configuration adds because Spring MVC and Tomcat are on the classpath. (2) **B**: component scanning starts at the application class's own package (`ledgerly.boot`) and goes down, never up. (3) **B**: `--debug` (or `debug=true`) prints the condition evaluation report: which auto-configurations matched, which did not, and why.

</details>

- [ ] One line first: "Spring Boot already ___, so I only add ___".
- [ ] `task6a`-`task6d` green → **19/19**. Push on `my-solutions`.
- [ ] App started, README curls run, app stopped.
- [ ] Interview question answered in chat.

### 🌱 1b. If Task 6 and its interview are done: B2 Q3 + Q6 (~20 min, in chat)

Pending since 3 Nov ([day10.md](day10.md), Part B2 spec, section 12 "Interview questions"). Answer aloud first, then type them:

- **Q3.** Why must you never copy `ex.getMessage()` of a JSON parse failure into the response? Where does the full cause go instead?
- **Q6.** You add `@ExceptionHandler(Exception.class)`. What breaks, and how do you avoid it?
- **One sentence:** why the catch-all hid Spring's own answers (405/415) in `course-practice`.

> [!TIP]
> Q6 and the one sentence are the same idea you just met in Task 6: *ask what Spring already handles, then add only what is missing.*

### 🧩 2. DSA: Contains Duplicate, closing (day 3, ~15 min)

![Type](https://img.shields.io/badge/type-DSA%20Arrays%20%26%20Hashing-blue) ![Tests](https://img.shields.io/badge/ContainsDuplicateTest-0%2F17-orange) ![Carry](https://img.shields.io/badge/carry--over-closing%20with%20skeleton-red)

> [!IMPORTANT]
> 📂 `src/main/java/com/prashant/dsa/arrayshashing/ContainsDuplicate.java` · tests `ContainsDuplicateTest` (17). Full 8-part spec: [day26.md](day26.md#-2-dsa-contains-duplicate-35-min). Level-1 questions: [day27.md](day27.md#-2-dsa-contains-duplicate-carried-over-day-2-of-2-35-min). Nothing stays open more than 2 days, so today the skeleton is open from the start. It counts as **solved with hints** (🔶), and it joins the redo ladder at +1 like any verified solve.

**Why it matters (one line).** It's the base of the whole Arrays & Hashing pattern: "have I seen this value before?" in one O(1)-average step instead of a re-scan.

**Small example, step by step** (`[7, 9, 9, 4]`):

| Step | x | seen before the step | Already there? | seen after |
|---|---|---|---|---|
| 1 | 7 | {} | no | {7} |
| 2 | 9 | {7} | no | {7, 9} |
| 3 | 9 | {7, 9} | **yes** → return `true` | — |

Output: `true`. The `4` is never read, because you stop at the first repeat.

**Guiding questions (2 min, answer in your head):** ① what one fact about earlier values do you need? ② which `java.util` collection answers "is x in here?" in O(1) on average? ③ what does that collection's `add` **return** when x is already there?

**Partial skeleton (visible today; you type every blank):**

```java
public boolean containsDuplicate(int[] nums) {
    if (nums == null) {
        throw new ____________________("nums must not be null");
    }
    Set<Integer> seen = new ______<>(nums.length);   // sized up front: no rehashing at 10^6
    for (int x : nums) {
        if (!seen.___(x)) {          // add returns ____ when x was already there
            return ____;
        }
    }
    return ____;
}
```

> [!WARNING]
> Gotchas: (1) don't sort `nums` itself; the suite checks that the caller's array is unchanged (sort a `clone()` if you choose the sorting variant, and say what that costs in space). (2) Two nested loops time out on the two 1 000 000-value tests. (3) Add the `java.util` imports.

- [ ] Pseudocode (3 lines) + brute-force comment, then pattern / time / space lines, each with **where** the cost comes from.
- [ ] `mvn test -Dtest=ContainsDuplicateTest` → **17/17**. Push.
- [ ] day26 knowledge checks 1-3 answered in chat.

### 🧩 3. DSA: Valid Anagram (new, Arrays & Hashing 2 of 9, ~25 min)

![Type](https://img.shields.io/badge/type-DSA%20Arrays%20%26%20Hashing-blue) ![Tests](https://img.shields.io/badge/ValidAnagramTest-17-lightgrey) ![Stub](https://img.shields.io/badge/stub-0%2F17-orange) ![Gate](https://img.shields.io/badge/unlocks-after%20ContainsDuplicate%2017%2F17-yellow)

> [!IMPORTANT]
> 📂 stub `src/main/java/com/prashant/dsa/arrayshashing/ValidAnagram.java` · tests `src/test/java/com/prashant/dsa/arrayshashing/ValidAnagramTest.java` (17, all with `@DisplayName`; checked against a reference solution that is **not** in the repo: reference 17/17, stub 0/17). **Start only after Contains Duplicate is 17/17 on your pushed code.** If the morning runs out, this is Friday's first DSA item (a carry-over, not a new problem). ✅ Done when 17/17 pass on your pushed code, with pseudocode + brute force first and pattern / time / space lines that each give a reason.

#### 1️⃣ Problem understanding (why it matters, then a worked example)
**Why it matters:** Contains Duplicate asked *"have I seen x?"*. Valid Anagram asks *"how many times have I seen x?"*. That one step, from a set to a **counter**, is the base of Group Anagrams, Top K Frequent and every sliding-window problem later.

**Story:** a fraud rule in beneficiary onboarding flags a new beneficiary nickname that is a rearranged copy of an existing one (`listen` vs `silent`), a known trick for slipping a mule account past a reviewer. The question: does `t` use exactly the same letters as `s`, each the same number of times?

| s | t | Output | Why |
|---|---|---|---|
| `anagram` | `nagaram` | `true` | a×3, n, g, r, m on both sides |
| `rat` | `car` | `false` | `t` has `c`, `s` has `t` |
| `aacc` | `ccac` | `false` | same letters, but a×2 vs a×1 |
| `""` | `""` | `true` | nothing to compare, so the counts trivially match |

#### 2️⃣ Input / output and constraints
- `boolean isAnagram(String s, String t)`.
- `null` for **either** argument → `IllegalArgumentException`.
- Only lowercase `'a'`-`'z'` (LeetCode's rule). Different lengths → `false`.
- 1 000 000 characters each must finish within 2 s.

#### 3️⃣ Pattern identification
**Arrays & Hashing: counting.** The cue is *"same items, any order, same number of times"*. Position doesn't matter, only **how many**. Counting turns "compare two arrangements" into "compare two tallies".

#### 4️⃣ Approach (brute force only; write this first)
Brute force: for each character of `s`, search `t` for an unused copy and cross it out. Write it as 3-5 plain-English lines, then answer in a comment: *how many steps for n = 1 000 000, and why do the two `large` tests fail with it?*

Hints, as questions:
1. Contains Duplicate kept a set. What do you need to keep **instead** when counts matter?
2. With only 26 possible letters, do you need a `HashMap` at all? What simpler structure has one slot per letter?
3. Can **one** tally do both strings: up for `s`, down for `t`? What must every slot be at the end?
4. Which cheap check before the loop answers `abc` / `abcc` immediately?

#### 5️⃣ Dry run of the optimised algorithm
Inside the locked block below.

#### 6️⃣ Java stub
In the repo: `throw new UnsupportedOperationException("TODO: Valid Anagram")`, comment lines waiting for pseudocode / brute force / pattern / time / space, and a `main` that prints two examples.

#### 7️⃣ Complexity
Brute force: you state it with the reason. Optimised: after your attempt, each with one sentence on where the cost comes from.

#### 8️⃣ Interview follow-ups
1. The input becomes any Unicode text (`"café"` vs `"éfac"`, emoji). What breaks in an `int[26]` solution, and what do you switch to? What about `char` vs code points?
2. `int[26]` vs `HashMap<Character, Integer>` vs sort both: compare time, extra memory and constant factors. Which do you pick for 10 million short nicknames a day?
3. Should `"Listen"` match `"silent"`? Where does normalisation (case, accents, spaces) belong in a banking service: in this method or before it, and why?
4. Group Anagrams (next week): what would you use as the **key** of the map?

**Knowledge checks:**

1. Which pair is **not** an anagram?
   - A. `listen` / `silent`
   - B. `aacc` / `ccaa`
   - C. `aacc` / `ccac`
   - D. `""` / `""`
2. One `int[26]` counter, `+1` for each letter of `s` and `-1` for each letter of `t`. When is the answer `true`?
   - A. when the sum of all slots is 0
   - B. when every slot is 0
   - C. when no slot is negative
   - D. when slot `'a'` is 0
3. Sorting both strings (as `char[]`) and comparing costs:
   - A. O(n) time, O(1) space
   - B. O(n log n) time, O(n) space for the two arrays
   - C. O(n²) time
   - D. O(log n) time

<details>
<summary><b>🔒 Open only after your attempt</b></summary>

**Optimised algorithm (counting array).**
1. If either is `null`, throw `IllegalArgumentException`. If lengths differ, return `false`.
2. `int[] count = new int[26]`.
3. For each index `i`: `count[s.charAt(i) - 'a']++` and `count[t.charAt(i) - 'a']--`.
4. If any slot is not 0, return `false`; otherwise `true`.

**Dry run** `s = "rat"`, `t = "car"` (only non-zero slots shown):

| i | s[i] | t[i] | count after the step |
|---|---|---|---|
| 0 | r | c | r:+1, c:-1 |
| 1 | a | a | r:+1, c:-1 (a went +1 then -1) |
| 2 | t | r | t:+1, c:-1 (r went back to 0) |
| end | | | `t` is +1 and `c` is -1, so **false** |

`aacc` / `ccac`: after the loop `a` is +1 and `c` is -1, so **false**. The **sum** of all slots is 0, which is why "sum is 0" (check 2A) is wrong.

**Complexity.** Time **O(n)**: one pass over both strings plus 26 fixed checks. Space **O(1)**: 26 ints, whatever n is. HashMap variant: O(n) time, O(k) space for k distinct characters, and it works for any alphabet. Sort variant: O(n log n) time, O(n) space for the two `char[]` copies.

**Answers.** (1) **C**. (2) **B**: a sum of 0 can hide +1/-1 pairs. (3) **B**.

</details>

- [ ] Pseudocode (3-5 lines) + brute-force comment with the 10^6 answer.
- [ ] Pattern / time / space lines, one reason each.
- [ ] `mvn test -Dtest=ValidAnagramTest` → **17/17**. Push.
- [ ] Knowledge checks 1-3 in chat before opening the locked block.

### 🐞 4. Thursday slot: write-ups, then the open round (~20 min)

> [!NOTE]
> Buggy rounds are Tuesday and Friday only, so there is **no new buggy file today**. Friday's round (Arrays & Hashing) is given only once `Day05DecodeString` is ✅. Otherwise Friday's slot finishes it.

**4a. `DailyTemperatures` comments (5 min).** 📂 `src/main/java/com/prashant/dsa/stack/DailyTemperatures.java` (code already ✅ 18/18). Above the Java, add:

- [ ] one brute-force comment line (the naive re-scan, its cost and why)
- [ ] 3-5 lines of plain-English pseudocode of **your** stack solution
- [ ] comment-only push

**4b. `Day05DecodeString` (day 3, 15 min).** Full spec: [day26.md](day26.md#-3-tuesday-buggy-round-day05decodestring-stack-20-min). 📂 `src/main/java/com/prashant/dailytests/Day05DecodeString.java`. Fix only; don't rewrite.

This morning's real failures (13 of 25), grouped by **symptom** (what you see, not where the bug is):

| Group | Failing tests (sample) | What you see |
|---|---|---|
| A | `example1` `3[a]2[bc]` → `bcbcaaa`; `prefixAndSuffix` `a2[b]c` → `bbac`; `twoGroups` | the right pieces, in the **wrong order** |
| B | `twoDigits` `10[a]` → `""`; `threeDigits`; `large`; `atTheLimit`; `multiDigitMix` | anything with a **2- or 3-digit** count comes out empty or far too short |
| C | `templateBomb` `1000[1000[1000[a]]]` → no exception | the output-limit guard never fires |

**Hint questions (day 3, use in order; still no line numbers):**
1. Group A: when a `]` closes, which text came **first** in the input: the text saved before the `[`, or the repeated body? Read the line that builds the new `current` and say aloud which part it puts first.
2. Group B: feed `"10[a]"` through the loop by hand. What is `k` after the `1`, and after the `0`? What should it be?
3. After a `[` has been pushed, what should `k` be for the **next** count? Try `"2[a]3[b]"` by hand once you've fixed question 2.
4. Group C: once group B is fixed, re-run. Does `templateBomb` still fail? (One fix can turn several groups green.)

- [ ] Symptom groups written as a comment **before** changing code (copy the table in your own words).
- [ ] Smallest fixes, one comment line each naming the test that led you there.
- [ ] **25/25**. Push.

### 🔁 Evening redos (cap 2, most overdue first, cold)

| Redo | File (blank stub from 17 Nov, still untouched) | Tests | Gap | Why now |
|---|---|---|---|---|
| 🐞 `Day03NextGreaterIndex` | `src/main/java/com/prashant/dailytests/redo/Day03NextGreaterIndexRedoNov17.java` | `mvn test -Dtest=Day03NextGreaterIndexRedoNov17Test` (0/37) | +1, due 30 Oct | most overdue; moved on 17 and 18 Nov |
| 🧩 `AsteroidCollision` | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | `mvn test -Dtest=AsteroidCollisionRedoNov17Test` (0/28) | +1, due 1 Nov | next most overdue |

> [!CAUTION]
> **Cold means cold.** Blank file, 25-minute timer, no peeking at `dailytests/Day03NextGreaterIndex`, `dsa/stack/AsteroidCollision` or `DailyTemperatures`. A redo whose body matches the original counts as **not passed** (the 16 Nov pair scored 2/10 for exactly that). A red push from memory beats a green copy.

- [ ] Each starts with a **pattern line + time and space comments** (one sentence each saying where the cost comes from), then 3-5 lines of pseudocode, then code.
- [ ] Push at the end of each, even if red.
- [ ] If neither lands tonight, the queue moves one more day (Fri 20: Day03 + Asteroid; CarFleet + LargestRect to Sat 21) per [redo-schedule.md](../revision/redo-schedule.md).

### 📦 Carried backlog (not for today unless a slot frees up)

| # | Item | Track | Status |
|---|---|---|---|
| 1 | `CarFleet` single-pair follow-up; PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) open since 6 Nov (your call: merge or close) | 🧩 | 🟡 IN_PROGRESS |
| 2 | Banking module 1 step 1, Drills 2 and 3 (parked; Spring slot is `spring-boot-labs`) | 🏦🌱 | ⬜ NOT_STARTED (parked) |
| 3 | `ScoreOfParentheses` follow-up questions (with its Tue 24 Nov redo) | 🧩 | ⬜ NOT_STARTED |
| 4 | Day 02 and Day 03 re-answers | 🌱 | 🟡 IN_PROGRESS |
| 5 | `Day00BuggyExample` symptom groups (write-up) | 🐞 | ⬜ NOT_STARTED |
| 6 | 🔁 `RemoveKAdjacentDuplicates` + `ScoreOfParentheses` cold redos (Tue 24 Nov, blank `...RedoNov23` stubs still to be created) | 🔁 | 🟡 IN_PROGRESS |
| 7 | Maven scopes: one applied question (`provided` in a WAR) at the next check | 🌱 | 🟡 IN_PROGRESS |
| 8 | Weak-topic packs 2 and 3 (HTTP semantics; `ResponseEntity` vs `@ResponseStatus`), from [day25.md](day25.md) | 🌱 | ⬜ NOT_STARTED |
| 9 | Labs README Task 5 tip rewording: waiting for your OK (labs repo not edited) | 🌱 | ⬜ waiting |

### ✅ Morning checklist

- [ ] Chapter 2 Task 6 pushed on `my-solutions` → **19/19**
- [ ] Task 6 interview question answered in chat
- [ ] `ContainsDuplicate` pseudocode + code pushed → **17/17**
- [ ] `ValidAnagram` pseudocode + code pushed → **17/17** (only after the line above)
- [ ] `DailyTemperatures` comments pushed
- [ ] `Day05DecodeString` symptom groups + fixes pushed → **25/25**
- [ ] Evening: the two cold redos

### 🧹 Housekeeping (Lumi, this morning)

| What | Detail |
|---|---|
| New stub + tests | `dsa/arrayshashing/ValidAnagram.java` (empty body, comment lines, `main`) and `ValidAnagramTest.java` (17 tests, normal / edge / failure / large, `@DisplayName` on each). Verified on the fresh clone: reference solution 17/17 (not pushed), stub 0/17 |
| Fresh-clone baseline | `mvn test` 701 run, 95 red = `ContainsDuplicate` 17 + `Day05DecodeString` 13 + redo stubs 37 + 28; nothing else broken |
| Trackers | `PROGRESS.md`: today's plan pointer, overall status, DSA table (Valid Anagram row), pending, next recommended, log row |
| Checked, unchanged | `interview-answers.md` already lists Ch 2 Q4 (Task 6) as pending; redo calendar unchanged (no redo graded since 12 Nov); no secrets; `target/` ignored |
| Flagged, not touched | PR [#1](https://github.com/PrashantSury/java-switch-journey/pull/1) (Lumi CarFleet comments) open 13 days; labs repo not edited |
