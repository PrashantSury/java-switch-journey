# Day 36 · Fri 27 Nov · ~125 min (+15 buffer)

**Focus:** close the three open items before anything new: `Day06` last loop, Group Anagrams blanks (day 4), 🏦 Task 1.1 (day 4); Asteroid + CarFleet cold · **Done when:** `Day06FirstUniqueCodeTest` 20/20, `GroupAnagramsTest` 22/22, `AuthSchemaIT` 2/2, both redos pushed (even red) · Run `git pull` first · Stuck 15 min → ask Lumi.

## ✅ Today

| # | Track | Item | File | Tests | Time | Status |
|---|---|---|---|---|---|---|
| 1 | 🧩 | Group Anagrams (carried, day 4, full skeleton + one guiding question per blank) | `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` | 22/22 | 15-55 | ✅ `a7ba6d5` |
| 2 | 🏦 | Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 4, decision table) | `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` | 0/2 | 55-100 | 🟡 Q4–Q7 ✅, no code |
| 3 | 🐞 | Buggy slot (Fri, **`Buggy07` parked**: `Day06` is still open): `Day06` last loop (loop header given) | `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java` | 20/20 | 0-15 | ✅ |
| 4 | 🔁 | `AsteroidCollisionRedoNov17`, cold, 25-min timer | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | 0/28 | 100-125 | ⬜ wrote comments on the original |
| 5 | 🔁 | `CarFleetRedoNov20`, cold (evening, after the review) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | 37/37 | evening | 🔶 not cold (copy) |

> Short on time: item 3 first (one loop body, ~5 min) → push; then item 1's three blanks (~15 min) → push. That alone unblocks `Buggy07` and the next new problem.

## 🔎 Since yesterday

| Item | Result | Status |
|---|---|---|
| Student pushes since the Day 35 morning session | none (last student code `3a620f4`, Two Sum, 23 Nov 6:11 PM IST) | — |
| Day 35 evening review (`ec7bf21`, 26 Nov 8:05 PM IST) | all three tracks unscored, no work | — |
| 26 Nov 10 PM check (`592ef28`, 10:00 PM IST) | no activity; Asteroid + CarFleet moved to today | — |
| Chat answers (Q1-Q11 of day 35) | none on record → carried below with the same numbers | ⬜ |
| Student push `663077f` (4:52 PM IST) + `6e3e459` (4:56 PM IST) + Q1–Q11 in chat | graded in the afternoon review below | ✅ Day06 20/20, 🔶 CarFleet redo, 🟡 GroupAnagrams 20/22 |

<details><summary>📖 Review details</summary>

| Check (fresh clone, JDK 21.0.13, ~6:15 AM IST) | Result |
|---|---|
| `mvn test` | ✅ 728 run, 0 failures (green) |
| `mvn test -Popen` | ❌ 107 run / 91 red = `GroupAnagrams` 22 · `AsteroidCollisionRedoNov17` 28 · `CarFleetRedoNov20` 37 · `Day06FirstUniqueCode` 4 (16/20) |
| `GroupAnagramsTest` / `Day06FirstUniqueCodeTest` vs reference versions (not pushed) | 22/22 · 20/20; your files 0/22 · 16/20 |
| `mvn -f banking-app/pom.xml verify -DskipITs` | ✅ builds; ITs not run (no Docker on the review box); only `V1` in `db/migration` |
| Cosmetic fixes | none needed (no new code) |

</details>

## 1. 🧩 Group Anagrams (carried, day 4, ~40 min)

- **Goal:** one `HashMap<countKey, List<String>>` pass; key equal for anagrams, different for everything else.
- **File:** `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` (stub untouched since 24 Nov)
- **Run:** `mvn test -Dtest=GroupAnagramsTest`
- **Done when:** 22/22 pushed, with 3-5 lines of pseudocode, brute-force cost, key choice, and pattern / time / space lines that each say **because**.
- **Hint rule:** pseudocode first (5 min), copy the 🧱 skeleton, answer the 🧭 question for each blank; stuck 15 min on a blank → ask Lumi.
- **Answer:** Q1-Q3 before the 🔒 block.

<details><summary>📖 Spec and teaching (short recap; full spec in day33.md / day34.md, unchanged)</summary>

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


<details><summary>🧱 Full skeleton (same as day 3: open it after the pseudocode)</summary>

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


<details><summary>🧭 Day-4 help: one question per blank (answer it, then write the line)</summary>

| Blank | Ask yourself | Try it on |
|---|---|---|
| 1 | Which `char` values must be rejected? Write the condition that is `true` for them and `false` for every letter. | `'{'` → true · `'A'` → true · `'m'` → false · `'a'`/`'z'` → false |
| 2 | Which slot 0-25 holds the count for `c`? (Day06 and ValidAnagram used the same expression.) | `'a'` → 0 · `'c'` → 2 · `'z'` → 25 |
| 3 | What goes between two counts so `[1,11]` and `[11,1]` print differently? | `1?11?` vs `11?1?` |

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


## 2. 🏦 Banking: Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 4, ~45 min)

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

**Day-3/4 help: the decision table (your answers go in V2 as comments).**

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

- **Goal:** fix only the last loop: it must walk string positions `0..n-1`, not letters `0..25`. Open since 21 Nov (day 7).
- **File:** `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java`
- **Run:** `mvn test -Dtest=Day06FirstUniqueCodeTest`
- **Done when:** 20/20 pushed, with a symptom-group comment at the top of the method and one `// fix:` comment per change (three in total). Smallest change, no rewrite.
- **Why first:** Friday is a buggy day, but an open round blocks the next one: `Buggy07` (Arrays & Hashing) comes on the next buggy day (Tue 1 Dec) once this is ✅.
- **Answer:** Q8-Q11.

<details><summary>📖 Why it matters, the one-line note, checks</summary>

**Why it matters.** "Index of what?" is the bug behind half of all off-by-ones in interviews; naming the index (`letter` vs `pos`) is how seniors avoid it.

**Note.** Two indices never mix: the **letter index** (0-25) reads `count[]`; the **string position** (`0` to `s.length() - 1`) reads `s.charAt()`. The answer is a position, so the last loop walks positions.

```java
String s = "aabbc";
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
System.out.println(count[0] + " " + count[1] + " " + count[2]);   // 2 2 1
```

**Gotcha.** A bound of 26 on a length-4 string throws `StringIndexOutOfBoundsException`; on a 30-char string positions 26-29 are never read.

**Checks** = Q8-Q11 below.

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
| 1 | `AsteroidCollision` (+1, due since 1 Nov) | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | `mvn test -Dtest=AsteroidCollisionRedoNov17Test` | morning, 100-125 | 28/28, cold | ⬜ still stub at 10 PM → Sat 28 slot 1 |
| 2 | `CarFleet` (+1, due since 4 Nov) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | `mvn test -Dtest=CarFleetRedoNov20Test` | evening, after the review | 37/37, cold | 🔶 37/37, not cold (copy) |

- **Redo day reminder:** both are due today. Blank stub (tests verified), no look at `dsa/stack/AsteroidCollision.java` or `CarFleet.java`; a copy counts as not passed.
- Pattern line + time/space (each with a **because**) first, then 20-30 min on a timer. Push even if red: a red cold attempt is data, a skipped one is not.
- Missed again → Sat 28 Nov becomes Asteroid + CarFleet, and LargestRect + Day01 move to Sun 29.

## 📌 Pending (after today's items)

- `Buggy07` (Arrays & Hashing) · 🐞 · ⬜ unblocked, planned Tue 1 Dec
- `DailyTemperatures` pseudocode/brute-force comments (5 min) · 🧩 · ✅ `6e3e459` (27 Nov)
- Frequency-counting pack: `firstRepeated` implementation (15 min) + `int[26]` vs `HashMap` interview (5 min) · 🧩 · ⬜ (🔴 Weak)
- CarFleet single-pair follow-up; `ScoreOfParentheses` follow-ups; Two Sum `put` question (day 33 Q1) · 🧩 · ⬜


**Q answers (27 Nov chat).** Q1 **B** · Q2 **C** · Q3 **B** (plus the `Arrays.toString` / `List` fix) · Q4 race + unique index + `lower()` · Q5 **B** · Q6 **B** (`DataIntegrityViolationException`; default `@Transactional` isolation does not help) · Q7 **B** (Flyway checksum) · Q8 `n - 1` · Q9 a position in `codes` (`i` / `pos`) · Q10 🟡 partial (described the fixed `letter < codes.length()` loop; the original `< 26` throws `StringIndexOutOfBoundsException` on length 4 and never reaches index 28) · Q11 the `int[26]` counts are the valid key; a sum collides on `"ac"` / `"bb"`.

## 🕔 Afternoon push review (27 Nov, ~5:25 PM IST)

> Graded `663077f` (4:52 PM IST) and `6e3e459` (4:56 PM IST), plus Q1–Q11 in chat. Fresh clone, JDK 21.0.13. Student logic was not changed. One cosmetic fix: missing newline at the end of `DailyTemperatures.java`. The 🌙 Evening and 🌒 End of day tables below are left for the 8 PM / 10 PM routines.

### 🧪 Tests (fresh clone)

| Suite | Result | Note |
|---|---|---|
| `Day06FirstUniqueCodeTest` | **20/20** ✅ | last loop bound `letter < codes.length()` |
| `GroupAnagramsTest` | **20/22** 🟡 | `uppercase`, `otherCharacters`: AIOOBE (index -31), tests expect IAE |
| `CarFleetRedoNov20Test` | **37/37** | body copied from `dsa/stack/CarFleet.java` → not a cold pass |
| `CarFleetTest` | **37/37** | original: comments only, logic unchanged |
| `AsteroidCollisionRedoNov17Test` | 0/28 (2 fail, 26 errors) | still the blank stub (`UnsupportedOperationException`) |
| `AsteroidCollisionTest` | **28/28** | original: comment-only pseudocode added, logic unchanged |
| `DailyTemperaturesTest` | **18/18** | pseudocode comments added; they match the code |
| `mvn test` | **785/785** green | Day06 and CarFleet redo removed from `open-stubs.txt`; `-Popen` is 50 run / 30 red (GroupAnagrams 20/22, Asteroid 0/28) |

### 🧩 Group Anagrams (quality)

Count-key `"#c0#c1...#c25"` with a clear one-to-one argument (the `#` stops `1,11` vs `11,1`), `LinkedHashMap` + `computeIfAbsent`, null guards, `O(n·k)` / `O(n·k)` with a because. The day-4 skeleton's blank 1 (reject a char outside `'a'-'z'` with IAE) was skipped, so `'B'` does `freq[-31]++` and throws AIOOBE.

### 🔁 Redos

- **CarFleet:** 37/37 but **not cold**. Exception messages, validation order, `long[] {dist, spd}` stack, cross-multiply test and `// else: merges into the fleet ahead` are identical to the original (the same commit also pasted the same pseudocode onto `CarFleet.java`). Copy counts as not a cold pass: 🔶, same gap +1 (rule 3). A new blank stub is needed for the next attempt.
- **Asteroid:** the redo file is still the stub. Pseudocode comments were added to the original (logic unchanged, 28/28 still green). Missed is not failed; still +1, still due. Write it in `AsteroidCollisionRedoNov17.java`, not the original.

### 📝 Scores (rubric in [PROGRAM.md](../docs/PROGRAM.md#-evening-scoring-rubric); afternoon, for the 8 PM review to keep or adjust)

| Track | Score /10 | Evidence |
|---|---|---|
| 🧩 DSA | **8** (🟢 Strong) | 🧠 concept **9**: Q1–Q3 exact, `#` separator and `int[]` identity key understood. 🛠️ implementation **7**: 20/22, core grouping is clean, missing IAE guard. 🧩 problem solving **7**: own `buildKey` helper, but day 4 with the full skeleton and blank 1 skipped. ⏱️ complexity **9**: `O(n·k)` defended. 🎤 interview **9**: Q1–Q3 ready out loud. DailyTemperatures comments ✅ |
| 🏦 Banking | **—** unscored | Q4–Q7 all correct (race, `lower(username)`, default isolation, Flyway checksum), but Task 1.1 code (V2 + `AuthSchemaIT`) was not pushed, so there is no implementation evidence. Not inflated to a concept-only mark |
| 🐞 Buggy | **8** (🟢 Strong) | 🧠 concept **7**: Q8, Q9, Q11 right; Q10 partial (answered about the fixed loop). 🛠️ implementation **9**: 20/20, one-line bound fix. 🐞 debugging **8**: localised the 26-vs-n bound, smallest change. 🎤 interview **7**: Q10 did not state the original failures (`charAt(4)` on length 4; stops at 25, misses 28) |

No new conceptual mistakes logged (the Day06 index mix-up is already in [mistakes/dsa.md](../revision/mistakes/dsa.md) from 21 Nov; he fixed the code. The CarFleet copy is a process miss, not a new concept miss).

### ➡️ Still to do (8 PM review can confirm tonight's order)

1. Group Anagrams: reject a char outside `'a'-'z'` with `IllegalArgumentException` → 22/22.
2. Asteroid redo in `AsteroidCollisionRedoNov17.java` (blank stub, cold, no peeking at the original).
3. Banking Task 1.1: write `V2__create_auth_tables.sql` and `AuthSchemaIT` (Q4–Q7 already stand).
4. `Buggy07` is unblocked, planned Tue 1 Dec.

## 🌙 Evening (filled by the evening review)

| Track | Score /10 | Evidence |
|---|---|---|
| 🧩 DSA | **8** 🟢 (kept from the afternoon) | concept 9 · impl 7 · problem solving 7 · complexity 9 · interview 9 → 8.2. `GroupAnagramsTest` **20/22** re-run: count key + `#` separator right, IAE guard for non-`a-z` still missing (day 4, full skeleton). Redos are the gap: CarFleet copied, Asteroid 0/28 |
| 🏦 Banking | **—** unscored | Q4–Q7 correct, but no V2 / `AuthSchemaIT` code pushed; `verify -DskipITs` ✅, **integration tests not run** (no Docker on the review box) |
| 🐞 Buggy | **8** 🟢 (kept) | concept 7 · impl 9 · debugging 8 · interview 7 → 7.75. `Day06FirstUniqueCodeTest` **20/20**; loop header was given; Q10 still partial |

| Topic | Class |
|---|---|
| Anagram key design (`int[26]` + `#`, array identity) · Flyway / unique index / race (Q4–Q7) | 🟢 Strong |
| Frequency counting (up from 🔴) · spec guards (non-`a-z` IAE) · loop index vs position (Q10) | 🟡 Moderate |
| 🔁 Cold recall: redos copied or skipped (ScoreOf, RemoveK, CarFleet copied; Asteroid due since 1 Nov) | 🔴 Weak (same miss 3+ times) |
| 🏦 Task 1.1 code (V2 + `AuthSchemaIT`) | ⬜ Pending · nothing Blocked |

| Tonight (in order, ~35 min) | Tomorrow (Sat 28) |
|---|---|
| 1. `GroupAnagrams`: reject a char outside `'a'-'z'` with IAE → 22/22, push (~5 min) · 2. `AsteroidCollisionRedoNov17` cold, 25-min timer: pattern + time/space lines with a **because**, 3-5 lines of pseudocode, then Java; push even if red · 3. Q10 again in one line: what does the **original** `letter < 26` loop do on a length-4 string, and on a code at position 28? · (Task 1.1 only if you still have energy; otherwise it is tomorrow's first item) | 🏦 Task 1.1 V2 + `AuthSchemaIT` (day 5) · 🔴 cold-recall pack (below, ~15 min) · redos `Day04LargestRectangle` + `Day01ArrayStack` (Asteroid takes slot 1 if missed tonight) |

<details><summary>🔴 Weak-topic pack: cold recall (for tomorrow morning)</summary>

- **Note:** a redo checks memory of the *pattern*, not the file. Copying the original gives green tests and zero signal, so it repeats the gap. Cold = blank file, original closed, pattern line first. A red cold attempt is useful data; a copied green one isn't.
- **Conceptual (5 min):** Asteroid Collision: name the 3 cases when a left-mover meets the stack top (top smaller / equal / bigger), and say what happens to the stack and to the incoming asteroid in each.
- **Implementation (15-25 min):** tonight's `AsteroidCollisionRedoNov17` (if it is still red, finish it cold; no new file).
- **Debugging (10 min):** find the bug, write the failing input and the smallest fix:

```java
for (int a : asteroids) {
    boolean alive = true;
    while (alive && !stack.isEmpty() && stack.peek() > 0 && a < 0) {
        if (stack.peek() < -a) stack.pop();
        else if (stack.peek() == -a) stack.pop();
        else alive = false;
    }
    if (alive) stack.push(a);
}
```

</details>

## 🌒 End of day (filled by the 10 PM check)

| Time (IST) | What changed | Result |
|---|---|---|
| 9:33 PM | `a7ba6d5`: `GroupAnagrams` rejects a char outside `'a'-'z'` with IAE | ✅ `GroupAnagramsTest` **22/22** · removed from `open-stubs.txt` · `mvn test` **807/807** green · PROBLEMS ✅ 27 Nov · verified DSA **11** · joins redo ladder at +1 (Sun 6 Dec) |
| 9:34 PM | Q10 re-answer in chat: "It will return arrayindexoutofbounexception" | 🔶 still partial: `charAt(4)` on a length-4 String throws `StringIndexOutOfBoundsException` (not AIOOBE); 30 chars → loop stops at 25, silently returns a wrong answer · logged in [mistakes/dsa.md](../revision/mistakes/dsa.md) |
| 10 PM | Scores re-checked against the rubric | DSA **8** kept (implementation 7 → 8, avg 8.4) · Buggy **8** kept (Q10 still partial) · 🏦 unscored (Task 1.1 not pushed) |
| 10 PM | `AsteroidCollisionRedoNov17` still the stub (0/28) | Missed, not failed → **Sat 28** slot 1; queue moved one slot ([redo-schedule.md](../revision/redo-schedule.md)) |
| ➡️ Sat 28 | **First task:** 🔴 cold-recall pack, starting with the cold Asteroid redo in `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` (blank file, original closed, pattern + time/space with a because, 3-5 lines pseudocode, 25-min timer, push even if red; `mvn test -Dtest=AsteroidCollisionRedoNov17Test`) | Then 🏦 Task 1.1 (day 5) · redo 2 `Day04LargestRectangle` · Q10 in one line (which object is indexed, too far vs too short) |

<details><summary>🧹 Coach notes (state, housekeeping)</summary>

- 10 PM check: fresh clone `/workspace/q36-10pm` at `a7ba6d5` (only student commit after `939bae6`). `mvn test -Popen -Dtest=GroupAnagramsTest` 22/22; after removing the line, `mvn test` 807/807 green; `mvn test -Popen` 28 run / 28 red (2 fail, 26 errors, Asteroid redo). Guard reviewed: correct, logic otherwise unchanged; no cosmetic fixes needed. No banking commits; ITs not run (no Docker). GroupAnagrams redo needs a blank stub + `GroupAnagramsContract` before Sun 6 Dec; CarFleet needs `CarFleetRedoNov28`.
- Afternoon grading ~5:25 PM IST: see [the review above](#-afternoon-push-review-27-nov-525-pm-ist).
- Evening review ~8 PM IST: tip `84db3b6`, no student commits after the afternoon grading; no new chat answers on record (the parent-chat transcript tool was not available to the review). Fresh clone, JDK 21.0.13: `mvn test` 785/785 green; `-Popen` 50 run / 30 red (`GroupAnagrams` 20/22, `AsteroidCollisionRedoNov17` 0/28); `Day06` 20/20, `CarFleetRedoNov20` 37/37, `CarFleet` 37/37, `AsteroidCollision` 28/28, `DailyTemperatures` 18/18; banking `verify -DskipITs` ✅, ITs not run (no Docker). Scores kept (rubric average). No cosmetic fixes, no new mistakes logged. Redos: Asteroid still due tonight; Day06 (+1) and CarFleet (+1 repeat, new stub `CarFleetRedoNov28` needed) placed on Sat 5 Dec.
- State at ~6:15 AM IST (fresh clone, JDK 21.0.13): tip `592ef28` (Day 35 10 PM check); no student commits since `3a620f4` (23 Nov). `mvn test` 728/728 green; `-Popen` 107 run / 91 red (the four open files). `GroupAnagramsTest` 22/22 and `Day06FirstUniqueCodeTest` 20/20 re-verified against reference versions (not pushed). `open-stubs.txt` unchanged.
- Golden rule: no new DSA problem (Group Anagrams open, day 4, past the 2-day limit → full skeleton + per-blank questions); no `Buggy07` on this Friday (`Day06` open); Task 1.1 stays 🟡 in `banking-app/TASKS.md` (day 4, stubs already exist).
- Housekeeping: `tasks/day30.md` and `day31.md` → `archive/tasks/` (last 5 kept: day32-36); links in `day32.md`, `interview-answers.md`, `redo-schedule.md`, `archive/progress-2026-11.md` re-pointed.
- No new conceptual mistakes; nothing logged. Redo queue unchanged (Asteroid + CarFleet today, [redo-schedule.md](../revision/redo-schedule.md)).
- Pattern to name: no student push since Mon 23 Nov. Item 3 alone (~5 min) breaks the streak and unblocks `Buggy07` (Tue 1 Dec).
- Legend: 🧩 DSA · 🏦 Banking · 🐞 buggy slot · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 6, Day 36.

</details>
