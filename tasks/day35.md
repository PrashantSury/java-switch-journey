# Day 35 · Thu 26 Nov · ~125 min (+15 buffer)

**Focus:** close Group Anagrams with the full skeleton (day 3, over the 2-day limit); 🏦 Task 1.1 day 3; `Day06` last loop; Asteroid + CarFleet cold · **Done when:** `GroupAnagramsTest` 22/22, `AuthSchemaIT` 2/2, `Day06FirstUniqueCodeTest` 20/20, both redos pushed (even red) · Run `git pull` first · Stuck 15 min → ask Lumi.

## ✅ Today

| # | Track | Item | File | Tests | Time | Status |
|---|---|---|---|---|---|---|
| 1 | 🧩 | Group Anagrams (carried, day 3, **full skeleton**: fill 3 blanks + the comment lines) | `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` | 0/22 | 0-40 | ⬜ |
| 2 | 🏦 | Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 3, decision table) | `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` | 0/2 | 40-85 | 🟡 |
| 3 | 🐞 | Buggy slot (Thu, no new round): `Day06` last loop (loop header given) | `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java` | 16/20 | 85-100 | 🔴 |
| 4 | 🔁 | `AsteroidCollisionRedoNov17`, cold, 25-min timer | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | 0/28 | 100-125 | ⬜ |
| 5 | 🔁 | `CarFleetRedoNov20`, cold (evening, after the review) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | 0/37 | evening | ⬜ |

> Short on time: item 3 (one loop header, ~5 min) → push; then item 1's three blanks (~15 min) → push. Two green classes beat five red ones.

## 🔎 Since yesterday

| Item | Result | Status |
|---|---|---|
| Student pushes since the Day 34 morning session | none (last student code `3a620f4`, Two Sum, 23 Nov 6:11 PM IST) | — |
| Day 34 evening review (`2c36d76`, 25 Nov 8:02 PM IST) | all three tracks unscored, no work | — |
| 25 Nov 10 PM check | none on record; the evening review already moved Asteroid + CarFleet to today | — |
| Chat answers (Q1-Q11 of day 34) | none on record → carried below with the same numbers | ⬜ |

<details><summary>📖 Review details</summary>

| Check (fresh clone, JDK 21.0.13, ~6:15 AM IST) | Result |
|---|---|
| `mvn test` | ✅ 728 run, 0 failures (green) |
| `mvn test -Popen` | ❌ 107 run / 91 red = `GroupAnagrams` 22 · `AsteroidCollisionRedoNov17` 28 · `CarFleetRedoNov20` 37 · `Day06FirstUniqueCode` 4 (16/20) |
| `GroupAnagramsTest` vs a reference (not pushed, stub restored) | 22/22; your stub 0/22 |
| `mvn -f banking-app/pom.xml verify -DskipITs` | ✅ builds; ITs not run (no Docker on the review box) |
| Cosmetic fixes | none needed (no new code) |

No new DSA problem today (golden rule: Group Anagrams is open). It is now past the 2-day limit, so today gives the full skeleton: the structure is written, you fill the three lines that carry the idea and the comment lines that prove you own it.

</details>

## 1. 🧩 Group Anagrams (carried, day 3, ~40 min)

- **Goal:** one `HashMap<countKey, List<String>>` pass; key equal for anagrams, different for everything else.
- **File:** `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` (stub untouched since 24 Nov)
- **Run:** `mvn test -Dtest=GroupAnagramsTest`
- **Done when:** 22/22 pushed, with 3-5 lines of pseudocode, brute-force cost, key choice, and pattern / time / space lines that each say **because**.
- **Hint rule:** write the pseudocode first (5 min), then open 🧱 and copy the skeleton; stuck 15 min on a blank → ask Lumi.
- **Answer:** Q1-Q3 before the 🔒 block.

<details><summary>📖 Spec and teaching (short recap; full spec in day33.md / day34.md)</summary>

**Why it matters.** Bucketing n strings by equivalence without comparing every pair is the same move as `GROUP BY`: compute a canonical key, let a hash map do the grouping in one pass. In interviews the follow-up is always "what does your key cost, and can two different words collide?".

**Concept.** `key(a).equals(key(b))` exactly when `a` and `b` are anagrams; then `computeIfAbsent(key, k -> new ArrayList<>()).add(word)`.

**Small example** (count key, `#` separator, only first 3 slots shown):

| word | `count[a,b,c,...]` | key starts | bucket |
|---|---|---|---|
| `ac` | 1,0,1 | `1#0#1#...` | A: [ac] |
| `ca` | 1,0,1 | `1#0#1#...` | A: [ac, ca] |
| `bb` | 0,2,0 | `0#2#0#...` | B: [bb] (a **sum** key gives 196 for both `ac` and `bb`) |

```java
int[] c = new int[26];
for (char ch : "bb".toCharArray()) c[ch - 'a']++;
StringBuilder k = new StringBuilder();
for (int i = 0; i < 3; i++) k.append(c[i]).append('#');
System.out.println(k);   // 0#2#0#
```

**Why the separator.** Without `#`, counts `a=1,b=11` and `a=11,b=1` both print `111`; with it they are `1#11#` vs `11#1#`.

**Rules the tests enforce.** `null` array or word → `IllegalArgumentException` · char outside `'a'-'z'` → `IllegalArgumentException` · `""` valid · duplicates kept · empty array → empty list · caller's array unchanged · 20 000 × 100 chars within 2 s.

**Gotchas.** `int[]` as a key = identity `equals` (Q3) · never sort the caller's array · return `new ArrayList<>(groups.values())`, not the view, never `null`.

**Brute force (you state the cost).** Compare each word with one representative of every group so far: n = 20 000 all-different words, k = 100 → how many checks and character steps?

**Follow-ups.** Unicode nicknames (which key still works, what do you normalise first?) · first-appearance group order (which map?).

</details>

<details><summary>🧱 Full skeleton (day 3: open it after the pseudocode)</summary>

```java
// imports: java.util.ArrayList, HashMap, List, Map
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null) throw new IllegalArgumentException("strs must not be null");
    Map<String, List<String>> groups = new HashMap<>();
    for (String word : strs) {
        groups.computeIfAbsent(keyOf(word), k -> new ArrayList<>()).add(word);
    }
    return new ArrayList<>(groups.values());
}

private static String keyOf(String word) {
    if (word == null) throw new IllegalArgumentException("word must not be null");
    int[] count = new int[26];
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (/* blank 1: c is outside 'a'..'z' */) throw new IllegalArgumentException("only a-z: " + word);
        count[/* blank 2: slot for letter c */]++;
    }
    StringBuilder key = new StringBuilder();
    for (int n : count) {
        key.append(n).append(/* blank 3: separator, and why */);
    }
    return key.toString();
}
```

</details>

<details><summary>🔒 Open only after your attempt</summary>

**Blanks.** 1 `c < 'a' || c > 'z'` · 2 `c - 'a'` · 3 `'#'` (any non-digit; stops `1,11` and `11,1` from colliding).

**Dry run** `["eat","tea","tan","ate","nat","bat"]` (sorted key shown for readability): `aet`→[eat] · [eat,tea] · `ant`→[tan] · [eat,tea,ate] · [tan,nat] · `abt`→[bat] → 3 groups.

| Approach | Time | Space | Because |
|---|---|---|---|
| Brute force | O(n² · k) | O(n · k) | up to n groups per word, each check reads k letters (~2 × 10^8 checks × 100 for n = 20 000) |
| Sorted key | O(n · k log k) | O(n · k) | each word sorted once; map holds every word plus its key |
| **Count key** | **O(n · k)** | O(n · k) | each word read once (k) plus 26 counts joined; map holds all words and keys |

**Q answers.** Q1 **B** · Q2 **C** · Q3 **B**. Follow-ups: Unicode → sorted code-point key after `Normalizer` NFC; first-appearance order → `LinkedHashMap`.

</details>

## 2. 🏦 Banking: Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 3, ~45 min)

- **Goal:** write `V2__create_auth_tables.sql` by hand: `users`, `roles`, `permissions`, `user_roles`, `role_permissions` in schema `auth`.
- **Files:** `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` (you create it) · `banking-app/src/test/java/com/prashant/banking/auth/AuthSchemaIT.java` (2 stub tests, bodies are yours).
- **Run:** `docker compose up -d` in `banking-app/`, then `mvn -f banking-app/pom.xml verify` (Docker running) or `AuthSchemaIT` from IntelliJ.
- **Done when:** `AuthSchemaIT` 2/2 and `BankingApplicationIT` 1/1 on `verify`.
- **First (10 min):** fill the decision table below as comment lines at the top of V2, then the SQL. No endpoint yet, so no grid row; from Task 1.5, fill the method × outcomes grid and check what Spring already handles before adding any handler.
- **Interview:** why a unique index on `lower(username)`, and not an `existsByUsername` check in the service?

<details><summary>📖 Teaching (why it matters, concept, small example with output, gotchas, 2-3 checks)</summary>

**Why it matters.** Every rule later ("only the owner", "a checker approves") needs users and permissions. And Flyway checksums a migration once it has run, so the shape you pick today is the one you live with. You change it with a V3, never by editing V2.

**The concept.** Users get roles, roles get permissions (two join tables). The token will carry the **permissions**, because "may this user read accounts?" is about a permission, not a job title.

**Small example.** A case-insensitive unique username:

```sql
CREATE TABLE auth.users (
  id            BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  public_id     UUID         NOT NULL UNIQUE,
  username      VARCHAR(50)  NOT NULL,
  password_hash VARCHAR(100) NOT NULL,
  enabled       BOOLEAN      NOT NULL DEFAULT TRUE
  -- + the BaseEntity columns: created_at, updated_at, created_by, version
);
CREATE UNIQUE INDEX ux_users_username_lower ON auth.users (lower(username));
```

| Insert | Result |
|---|---|
| `'Teller01'` | ✅ 1 row |
| `'teller01'` | ❌ `duplicate key value violates unique constraint "ux_users_username_lower"` |
| `'teller02'` | ✅ 1 row: `lower` differs |

Row 2 is out because `lower('teller01') = lower('Teller01')`. In `JdbcTemplate` that error arrives as `DuplicateKeyException`, which is what your second test expects.

**Day-3 help: the decision table (your answers go in V2 as comments).**

| Decision | Question that settles it |
|---|---|
| Tables | Which five, all in schema `auth`? |
| PK type | `BaseEntity` holds the id as which Java type, so which SQL identity type? |
| Join-table PK | What composite key on `user_roles (user_id, role_id)` stops the same pair twice? |
| `ON DELETE` | Role deleted → what happens to its `user_roles` / `role_permissions` rows? |
| Username | `UNIQUE (username)` or a unique index on `lower(username)`? (check 1) |
| Password | Which column name, and why 60+ chars (BCrypt) and never the password itself? |
| `BaseEntity` columns | `created_at`/`updated_at` (`Instant` → `TIMESTAMPTZ NOT NULL`), `created_by` (`VARCHAR(100)`, nullable), `version` (`BIGINT NOT NULL`): on which tables? |

**Gotchas**
- No password, hash or seed user in V2. Ever.
- `password_hash` holds a BCrypt string (60 chars), not the password.
- `ddl-auto=validate` will compare your Task 1.2 entities with this SQL, so names and types must match.
- If V2 already ran on your local DB and you change it: reset the dev DB or add V3.

**Checks (letters only)** = Q5-Q7 below.

</details>

<details><summary>🔒 Open only after your attempt</summary>

**Check answers.** Q5 **B** (a plain `UNIQUE` compares bytes, so case variants both get in) · Q6 **B** (check-then-insert races between two transactions; only the index is atomic) · Q7 **B** (Flyway would fail the checksum on an edited V2; `ddl-auto=update` is off in this app).

**Q4 shape (60 s).** The service check is a read followed by a write, so two concurrent requests both see "free"; the unique index is enforced inside the database at insert time, for every writer (app, scripts, a second instance). Keep the service check only for a friendly message, and map `DuplicateKeyException` to 409.

</details>

## 3. 🐞 Buggy slot: `Day06` last loop (~15 min)

- **Goal:** fix only the last loop: it must walk string positions `0..n-1`, not letters `0..25`. Open since 21 Nov (day 6), so the loop header is given below.
- **File:** `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java`
- **Run:** `mvn test -Dtest=Day06FirstUniqueCodeTest`
- **Done when:** 20/20 pushed, with a symptom-group comment at the top of the method and one `// fix:` comment per change (three in total). Smallest change, no rewrite.
- **Answer:** the `"aabb"` trace rows 2-4 (in day34.md item 3), then Q8-Q11.

<details><summary>📖 Why this slot today, and the one-line note</summary>

**Why.** Thursday has no buggy round; the slot goes to open work, and `Day06` blocks Friday's `Buggy07`. Frequency counting is 🔴 Weak, so Q11 rides along.

**Note.** Two indices never mix: the **letter index** (0-25) reads `count[]`; the **string position** (`0` to `s.length() - 1`) reads `s.charAt()`. The answer is a position, so the last loop walks positions.

```java
String s = "aabbc";
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
System.out.println(count[0] + " " + count[1] + " " + count[2]);   // 2 2 1
```

**Gotcha.** A bound of 26 on a length-4 string throws `StringIndexOutOfBoundsException`; on a 30-char string positions 26-29 are never read.

</details>

<details><summary>🧱 Strongest hint (header given; the body is yours)</summary>

```java
for (int pos = 0; pos < codes.length(); pos++) {
    // which count do you read for the code at pos, and what do you return when it is 1?
}
```

</details>

<details><summary>🔒 Open only after your push</summary>

Q8 `n - 1` · Q9 a position in `codes` (`pos`) · Q10 row 4: `charAt(4)` on length 4 → `StringIndexOutOfBoundsException`; 30 chars: the loop stops at 25, never reads 28, returns a wrong answer · Q11 the `int[26]` counts: `"ab"`/`"ba"` really are anagrams; a sum also matches `"ac"`/`"bb"`, which are not.

</details>

## ❓ Questions to answer in chat

| # | For | Question (short; letters only for MCQs) |
|---|---|---|
| Q1 | 🧩 | Sum-of-codes key for `["ac","bb"]` gives? (A-D) |
| Q2 | 🧩 | Sorted-key time for n words of length k? (A-D) |
| Q3 | 🧩 | `map.get(new int[]{1,2})` after `put(new int[]{1,2}, x)`? (A-D) |
| Q4 | 🏦 | Why a unique index on `lower(username)`, not `existsByUsername`? (60 s or 3 lines) |
| Q5 | 🏦 | Why not `UNIQUE (username)`? (A-C) |
| Q6 | 🏦 | Two concurrent `teller01` registrations: what stops the second? (A-C) |
| Q7 | 🏦 | V2 ran; you need a new column. (A-C) |
| Q8 | 🐞 | Positions in a string of length n run from 0 to ___ |
| Q9 | 🐞 | The last loop variable stands for ___ (better name ___) |
| Q10 | 🐞 | Row 4 on length 4, and a unique code at position 28 of 30? |
| Q11 | 🐞 | `"ab"`/`"ba"` same `int[26]`; `"ac"`/`"bb"` same sum: which is a valid anagram key? |

<details><summary>📖 Full question text and options</summary>

1. Key = sum of character codes. For `["ac", "bb"]` the result is: A. two groups · B. one group `["ac","bb"]`, which is wrong · C. an exception · D. empty
2. Sorted-key approach, n words of length up to k. Time is: A. O(n) · B. O(n · k) · C. O(n · k log k) · D. O(n² · k)
3. `map.put(new int[]{1,2}, x); map.get(new int[]{1,2})` returns: A. `x` · B. `null`, because arrays use identity `equals`/`hashCode` · C. an exception · D. `x` only if both arrays are `final`
4. Why a unique index on `lower(username)`, and not an `existsByUsername` check in the service? (60 s out loud, or 3 lines)
5. Why not `UNIQUE (username)`? A. slower · B. `Teller01` and `teller01` would both get in · C. Postgres forbids it
6. Two requests register `teller01` at the same moment and both pass `existsByUsername`. What stops the second one? A. `@Transactional` · B. the unique index · C. nothing
7. V2 ran yesterday; today you need a new column. A. edit V2 · B. add V3 · C. `ddl-auto=update`
8. The method returns a **position in `codes`**. Positions in a string of length `n` run from `0` to ___.
9. So the last loop variable stands for ___ (and a better name for it is ___).
10. What happens at row 4 when `codes.length()` is 4, and on a 30-character string whose unique code sits at position 28?
11. Why does `"ab"` vs `"ba"` give the same `int[26]` while `"ac"` vs `"bb"` give the same sum? Which one is a valid anagram key, and why?

</details>

## 🔁 Redos (cold, cap 2)

| # | Redo | Stub | Run | When | Done when | Status |
|---|---|---|---|---|---|---|
| 1 | `AsteroidCollision` (+1, due since 1 Nov) | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | `mvn test -Dtest=AsteroidCollisionRedoNov17Test` | morning, 100-125 | 28/28, cold | ⬜ |
| 2 | `CarFleet` (+1, due since 4 Nov) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | `mvn test -Dtest=CarFleetRedoNov20Test` | evening, after the review | 37/37, cold | ⬜ |

- **Cold means cold:** blank stub (tests verified), no look at `dsa/stack/AsteroidCollision.java` or `CarFleet.java`; a copy counts as not passed.
- Pattern line + time/space (each with a **because**) first, then 20-30 min on a timer. Push even if red: a red cold attempt is data, a skipped one is not.
- Missed again tonight → the queue moves one more day (Fri 27 Nov would become Asteroid + CarFleet).

## 📌 Pending (after today's items)

- `DailyTemperatures` pseudocode/brute-force comments (5 min) · 🧩 · 🟡 open since 12 Nov
- Frequency-counting pack: `firstRepeated` implementation (15 min) + `int[26]` vs `HashMap` interview (5 min) · 🧩 · ⬜ (🔴 Weak)
- CarFleet single-pair follow-up · 🧩 · 🟡
- `ScoreOfParentheses` follow-ups, Two Sum `put` question (day 33 Q1) · 🧩 · ⬜

## 🌙 Evening (filled by the evening review)

| Track | Score /10 | Evidence |
|---|---|---|
| 🧩 DSA | — (unscored) | No student code today: `GroupAnagramsTest` 0/22 (stub untouched since 24 Nov), no Q1-Q3 answers; last score 6 (23 Nov) |
| 🏦 Banking | — (unscored) | No `V2__create_auth_tables.sql` (only V1 in `db/migration`); `AuthSchemaIT` 0/2, Task 1.1 stays 🟡; no Q4-Q7 answers |
| 🐞 Buggy | — (unscored) | `Day06FirstUniqueCodeTest` 16/20, unchanged since `41abb48` (21 Nov); no Q8-Q11; last score 5 |

| Tonight (in order) | Tomorrow |
|---|---|
| 1. 🐞 `Day06` last loop → 20/20 (one loop header is given; ~5 min) → push | Fri 27 Nov, **light day, 3 items max:** 🐞 `Day06` if still red (`Buggy07` stays parked until it is ✅) |
| 2. 🧩 Group Anagrams: 3-5 pseudocode lines, then the 3 blanks → 22/22 → push | 🧩 Group Anagrams if still open (same skeleton, no new problem) |
| 3. 🔁 `CarFleetRedoNov20` cold, only if time (a push before 10 PM still counts) | 🔁 Asteroid + CarFleet cold (moved to Fri 27 Nov); 🏦 Task 1.1 only if the first two are green |

<details><summary>📋 Review details (26 Nov, ~8 PM IST)</summary>

- **Today's commits (IST):** one, `78404ba` (6:11 AM, Day 35 morning session by Lumi). No student code since `3a620f4` (TwoSum, 23 Nov 6:11 PM IST). No chat answers on record (Q1-Q11 open).
- **Fresh clone, JDK 21.0.13:** `mvn test` ✅ **728 run, 0 failures, 0 errors** (green, no break). `mvn test -Popen` ❌ 107 run / 91 red = `GroupAnagrams` 0/22 · `AsteroidCollisionRedoNov17` 0/28 · `CarFleetRedoNov20` 0/37 · `Day06FirstUniqueCode` 16/20. Nothing passed, so `open-stubs.txt` and PROBLEMS.md are unchanged.
- **Banking:** no Docker on the review box → `mvn -f banking-app/pom.xml verify -DskipITs` ✅ BUILD SUCCESS; **integration tests not run**. No student code to review. TASKS.md unchanged (1.1 🟡).
- **Topics:** 🟢 Strong: Stack (13 done; redos overdue). 🟡 Moderate: Arrays & Hashing basics (ContainsDuplicate, TwoSum with hints); interview explanation (5/10, 23 Nov). 🔴 Weak: frequency counting / letter index vs string position (ValidAnagram sums, Day06 last loop). ⬜ Pending: Group Anagrams, Banking Task 1.1, `Day06`, Asteroid + CarFleet redos. ⛔ Blocked: none.
- **Redos:** Asteroid + CarFleet not attempted → Fri 27 Nov; every later slot and the projection moved one day (74 redos from 27 Nov, last graduation Sun 31 Jan 2027) in [redo-schedule.md](../revision/redo-schedule.md). No conceptual mistake logged (no new work). No cosmetic fixes (no new code).
- **Pattern to name:** 4 days without a student push. The plan is now lighter on purpose: tonight's item 1 alone (~5 min) is a real win and keeps the streak.

</details>

<details><summary>🔴 Weak pack: frequency counting (10 min total)</summary>

**Note.** A count array answers "how many of each letter"; its index is a **letter** (`c - 'a'`, 0-25). The answer to "where" is a **position** in the string (`0` to `n - 1`). Read counts by letter, walk the string by position.

**Conceptual (1 line):** `"abc"` and `"cab"` give the same `int[26]`. Why does that make `Arrays.toString(count)` a safe `HashMap` key while `count` itself is not?

**Implementation (5 min):** `boolean sameLetters(String a, String b)` with one `int[26]`: `++` for `a`, `--` for `b`, then check every slot is 0. Pseudocode first (3 lines).

**Debugging (2 min):** what breaks here, and on which input?

```java
int[] count = new int[26];
for (char c : s.toCharArray()) count[c - 'a']++;
for (int i = 0; i < 26; i++) if (count[s.charAt(i) - 'a'] == 1) return i;
return -1;
```

</details>

## 🌒 End of day (filled by the 10 PM check)

| Time (IST) | What changed | Result |
|---|---|---|
| 10:00 PM | No student pushes or chat answers since the 8:05 PM review (tip `ec7bf21`); last student code still `3a620f4` (23 Nov). | Nothing new to verify; records unchanged (Day06 16/20, Group Anagrams 0/22, Asteroid + CarFleet redos on Fri 27). **Tomorrow's first task (Fri 27):** 🐞 Day06 last loop, then push. |

<details><summary>🧹 Coach notes (state, housekeeping)</summary>

- State at ~6:15 AM IST (fresh clone, JDK 21.0.13): tip `2c36d76` (Day 34 evening review); no student commits since `3a620f4` (23 Nov). `mvn test` 728/728 green; `-Popen` 107 run / 91 red (the four open files). `GroupAnagramsTest` re-verified 22/22 against a reference (not pushed). `open-stubs.txt` unchanged (no new stub, nothing passed).
- No 10 PM check on record for 25 Nov; the evening review had already moved Asteroid + CarFleet to today, so no further shift. Fri 27 LargestRect + Day01 · Sat 28 Day00 + RPN · Sun 29 DailyTemps + ValidParen stand ([redo-schedule.md](../revision/redo-schedule.md)).
- `banking-app/TASKS.md`: Task 1.1 stays 🟡 (day 3). No new stubs needed (`AuthSchemaIT` stubs exist). No new conceptual mistakes; nothing logged.
- Housekeeping deferred: `tasks/day30.md` → `archive/tasks/` needs a file delete, which today's single `push_files` commit can't do; six day files kept until a session that can move it.
- Friday 27 Nov is a buggy day: `Buggy07` (Arrays & Hashing) only once `Day06` is ✅; otherwise the slot stays on `Day06`. No new DSA problem until Group Anagrams is ✅.
- Pattern to name: 3 days without a student push. If ~2 h is too much this week, item 3 + item 1's blanks (~20 min) keep the streak.
- Legend: 🧩 DSA · 🏦 Banking · 🐞 buggy slot · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 5, Day 35.

</details>
