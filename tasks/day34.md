# Day 34 · Wed 25 Nov · ~125 min (+15 buffer)

**Focus:** close Group Anagrams (day 2, stronger hints); 🏦 Task 1.1 carried; `Day06` last loop; Asteroid cold · **Done when:** `GroupAnagramsTest` 22/22, `AuthSchemaIT` 2/2, `Day06FirstUniqueCodeTest` 20/20, Asteroid redo pushed (even red) · Run `git pull` first · Stuck 15 min → ask Lumi.

## ✅ Today

| # | Track | Item | File | Tests | Time | Status |
|---|---|---|---|---|---|---|
| 1 | 🧩 | Group Anagrams (carried, day 2 of 2, guiding questions + skeleton) | `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` | 0/22 | 0-40 | ⬜ |
| 2 | 🏦 | Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 2) | `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` | 0/2 | 40-85 | 🟡 |
| 3 | 🐞 | Buggy slot (Wed, no new round): `Day06` last loop + frequency-counting check | `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java` | 16/20 | 85-100 | 🔴 |
| 4 | 🔁 | `AsteroidCollisionRedoNov17`, cold, 25-min timer | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | 0/28 | 100-125 | ⬜ |
| 5 | 🔁 | `CarFleetRedoNov20`, cold (after the review) | `src/main/java/com/prashant/dailytests/redo/CarFleetRedoNov20.java` | 0/37 | evening | ⬜ |

> Short on time: item 3 (`Day06` last loop, one line) → push, even red; then G1-G2 of Group Anagrams as comments (10 min).

## 🔎 Since yesterday

| Item | Result | Status |
|---|---|---|
| Student pushes since the Day 33 morning session | none (last student code `3a620f4`, Two Sum, 23 Nov 6:11 PM IST) | — |
| Day 33 evening review (`1d11de4`, 24 Nov ~8:00 PM IST) | all three tracks unscored, no work | — |
| Tue 24 Nov redos (Asteroid, CarFleet) | not attempted, no 10 PM check on record → moved to today, queue shifted one day (missed, not failed) | ❌ missed |
| Chat answers (Q1-Q11 of day 33) | none on record | ⬜ |

<details><summary>📖 Review details</summary>

| Check (fresh clone, JDK 21.0.13, ~6:15 AM IST) | Result |
|---|---|
| `mvn test` | ✅ 728 run, 0 failures (green) |
| `mvn test -Popen` | ❌ 107 run / 91 red = `GroupAnagrams` 22 · `AsteroidCollisionRedoNov17` 28 · `CarFleetRedoNov20` 37 · `Day06FirstUniqueCode` 4 (16/20) |
| `GroupAnagramsTest` vs a reference (not pushed) | 22/22; your stub 0/22 |
| `mvn -f banking-app/pom.xml verify -DskipITs` | ✅ builds; ITs not run (no Docker on the review box) |
| Cosmetic fixes | none needed |

No new problem today: Group Anagrams is open (golden rule). It is on day 2 of 2, so the hint level goes up: guiding questions now, the partial skeleton after 15 min stuck.

</details>

## 1. 🧩 Group Anagrams (carried, day 2 of 2, ~40 min)

- **Goal:** group anagrams with `HashMap<key, List<String>>`; the key must be equal for anagrams and different for everything else.
- **File:** `src/main/java/com/prashant/dsa/arrayshashing/GroupAnagrams.java` (stub untouched since 24 Nov)
- **Run:** `mvn test -Dtest=GroupAnagramsTest`
- **Done when:** 22/22 pushed, with 3-5 lines of pseudocode, brute force with its cost, key choice, and pattern / time / space lines that each say **because**.
- **Hint rule:** answer G1-G5 (below) as comments first; stuck 15 min → open the skeleton block, then ask Lumi. Today closes it (2-day limit).
- **Answer:** Q1-Q3 before the 🔒 block.

<details><summary>📖 Spec and teaching (recap + guiding questions)</summary>

**Why it matters.** Valid Anagram compared two strings; here n strings must be bucketed without comparing every pair. A **canonical key** turns "are these equivalent?" into "do these have the same key?", and a hash map does the grouping in one pass. Same idea as `GROUP BY` in SQL: the key is the grouping column.

**Concept in one line.** Compute `key(word)` so `key(a) == key(b)` exactly when `a` and `b` are anagrams; then `map.computeIfAbsent(key, k -> new ArrayList<>()).add(word)`.

**Small example** (sample data, count key with `#` separators, only non-zero letters shown):

| word | counts | key (shortened) | bucket after the step |
|---|---|---|---|
| `eat` | a1 e1 t1 | `1#0#0#0#1#...#1#...` | A: [eat] |
| `tea` | a1 e1 t1 | same as `eat` | A: [eat, tea] |
| `tan` | a1 n1 t1 | different | A, B: [tan] |
| `ac` | a1 c1 | `1#0#1#...` | C: [ac] |
| `bb` | b2 | `0#2#0#...` | D: [bb] (a **sum** would have put it with `ac`: 196 = 196) |

```java
Map<String, List<String>> m = new HashMap<>();
m.computeIfAbsent("aet", k -> new ArrayList<>()).add("eat");
m.computeIfAbsent("aet", k -> new ArrayList<>()).add("tea");
m.computeIfAbsent("ant", k -> new ArrayList<>()).add("tan");
System.out.println(m);   // {aet=[eat, tea], ant=[tan]}  (HashMap order may differ)
```

**Why each row is in or out.** `tea` joins `eat` because every letter count matches; `bb` stays out of `ac`'s bucket because the key keeps *which* letters, not their total.

**Rules the tests enforce.** `null` array or `null` word → `IllegalArgumentException` · any char outside `'a'-'z'` → `IllegalArgumentException` · `""` is a valid word · duplicates kept · empty array → empty list · caller's array unchanged · 20 000 × 100 chars within 2 s.

**Guiding questions (answer as comment lines, in order):**
- **G1.** For `"eat"`, which 26 numbers describe it? Write the string you would build from them so `"tea"` produces the identical string.
- **G2.** Without a separator, `a=1,b=11` and `a=11,b=1` both print `111...`. What one character fixes that, and why?
- **G3.** Which `Map` method returns the existing list **or** creates and stores a new one in one call?
- **G4.** `groups.values()` is a `Collection` view of the map. How do you turn it into the `List<List<String>>` the method returns?
- **G5.** Where do the `null`-word check and the `'a'-'z'` check go so each character is looked at once?

**Gotchas.** `int[]` as a map key uses identity `equals`/`hashCode` (two equal arrays = two keys) · sorting `word.toCharArray()` is fine (it's a copy), sorting the caller's array is not · return `new ArrayList<>(...)`, never `null`.

**Brute force (you state the cost):** compare each word with one representative of every group so far. For n = 20 000 all-different words, how many checks, and how many character steps at k = 100?

**Follow-ups (interview).** Unicode nicknames: which key still works, and what do you normalise first? · 200 M words: how does the key become a partition key? · first-appearance group order: which map gives it?

</details>

<details><summary>🧱 Partial skeleton (open only after 15 min stuck)</summary>

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null) throw new IllegalArgumentException("strs must not be null");
    Map<String, List<String>> groups = new HashMap<>();
    for (String word : strs) {
        String key = keyOf(word);                                  // G1, G2, G5
        groups.______________(key, k -> new ArrayList<>()).add(word);   // G3
    }
    return ______________________;                                 // G4
}

private static String keyOf(String word) {
    // TODO: null check · int[26] counts with the 'a'-'z' check · join the counts with a separator
}
```

</details>

<details><summary>🔒 Open only after your attempt</summary>

**Optimised (count key).** Throw on `null` array → for each word: throw on `null`, count into `int[26]` (throw outside `'a'-'z'`), join the 26 counts with `#` → `computeIfAbsent(key, k -> new ArrayList<>()).add(word)` → return `new ArrayList<>(groups.values())`.

**Dry run** `["eat","tea","tan","ate","nat","bat"]` (sorted key shown for readability): `aet`→[eat] · `aet`→[eat,tea] · `ant`→[tan] · `aet`→[eat,tea,ate] · `ant`→[tan,nat] · `abt`→[bat] → 3 groups.

| Approach | Time | Space | Because |
|---|---|---|---|
| Brute force | O(n² · k) | O(n · k) | up to n groups per word, each check reads k letters (~2 × 10^8 checks × 100 for n = 20 000) |
| Sorted key | O(n · k log k) | O(n · k) | each word is sorted once; the map holds every word plus a k-length key |
| **Count key** | **O(n · k)** | O(n · k) | each word is read once (k) plus 26 counts joined; map holds all words and keys |

**G answers.** G2 `#` (any non-digit) · G3 `computeIfAbsent` · G4 `new ArrayList<>(groups.values())` · G5 inside `keyOf`, in the counting loop.

**Q answers.** Q1 **B** · Q2 **C** · Q3 **B**.

</details>

## 2. 🏦 Banking: Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, ~45 min)

- **Goal:** write `V2__create_auth_tables.sql` by hand: `users`, `roles`, `permissions`, `user_roles`, `role_permissions` in schema `auth`.
- **Files:** `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` (you create it) · `banking-app/src/test/java/com/prashant/banking/auth/AuthSchemaIT.java` (2 stub tests, bodies are yours).
- **Run:** `docker compose up -d` in `banking-app/`, then `mvn -f banking-app/pom.xml verify` (Docker running) or `AuthSchemaIT` from IntelliJ.
- **Done when:** `AuthSchemaIT` 2/2 and `BankingApplicationIT` 1/1 on `verify`.
- **First (10 min):** the 5 decisions as comment lines at the top of V2 (table list, PK type, case-insensitive username, password column, `BaseEntity` columns). No endpoints yet, so no method × outcomes grid row today; from Task 1.5 on, fill the grid and check what Spring already handles before any handler.
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

**Guiding questions for the 5 decisions (day-2 help, answers are yours):**
- What is the primary key of a join table like `user_roles`, and what stops the same pair being inserted twice?
- `BaseEntity` maps `created_at`, `updated_at`, `created_by`, `version`: which SQL types and `NOT NULL`s make `ddl-auto=validate` happy tomorrow?
- Which id goes into URLs and tokens (`id` or `public_id`), and why not the other one?
- `ON DELETE` for the join tables: what should happen to `user_roles` rows when a role is deleted?
- First test: which `information_schema` column and filter give exactly the five table names in `auth`?

**Gotchas**
- No password, hash or seed user in V2. Ever.
- `password_hash` holds a BCrypt string (60 chars), not the password.
- `ddl-auto=validate` will compare your Task 1.2 entities with this SQL, so names and types must match.
- If V2 already ran on your local DB and you change it: reset the dev DB or add V3.

**Checks (letters only)**
1. Why not `UNIQUE (username)`? A. slower · B. `Teller01` and `teller01` would both get in · C. Postgres forbids it
2. Two requests register `teller01` at the same moment and both pass `existsByUsername`. What stops the second one? A. `@Transactional` · B. the unique index · C. nothing
3. V2 ran yesterday. Today you need a new column. A. edit V2 · B. add V3 · C. `ddl-auto=update`

</details>

<details><summary>🔒 Open only after your attempt</summary>

**Check answers.** Q5 **B** (a plain `UNIQUE` compares bytes, so case variants both get in) · Q6 **B** (check-then-insert races between two transactions; only the index is atomic) · Q7 **B** (Flyway would fail the checksum on an edited V2; `ddl-auto=update` is off in this app).

**Q4 shape (60 s).** The service check is a read followed by a write, so two concurrent requests both see "free"; the unique index is enforced inside the database at insert time, for every writer (app, scripts, a second instance). Keep the service check only for a friendly message, and map `DuplicateKeyException` to 409.

</details>

## 3. 🐞 Buggy slot: `Day06` last loop + frequency-counting check (~15 min)

- **Goal:** fix only the last loop: it walks letters 0..25 instead of string positions 0..n-1. Open since 20 Nov, so the hint goes up (blank line below).
- **File:** `src/main/java/com/prashant/dailytests/Day06FirstUniqueCode.java`
- **Run:** `mvn test -Dtest=Day06FirstUniqueCodeTest`
- **Done when:** 20/20 pushed, with a symptom-group comment at the top of the method and one `// fix:` comment per change (three in total). Smallest change, no rewrite.
- **Answer:** fill the `"aabb"` trace rows 2-4, then Q8-Q11.

| `letter` | `codes.charAt(letter)` | `count[...]` | returns? |
|---|---|---|---|
| 0 | `'a'` | 2 | no |
| 1 | `'a'` | 2 | no |
| 2 | ? | ? | ? |
| 3 | ? | ? | ? |
| 4 | ? | ? | ? |

<details><summary>📖 Why this slot today, and the frequency-counting note</summary>

**Why.** Wednesday has no buggy round; the slot goes to open work, and `Day06` is the open 🐞 item (Friday's round waits until it is ✅). Frequency counting is 🔴 Weak, so the weak-pack conceptual question (Q11) rides along; the pack's debugging snippet is this exact loop, so it is not repeated.

**Note.** Two indices never mix in a frequency table: the **letter index** (0-25) reads `count[]`; the **string position** (0 to `s.length() - 1`) reads `s.charAt()`. The answer is a string position, so the last loop walks positions.

```java
String s = "aabbc";
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
System.out.println(count[0] + " " + count[1] + " " + count[2]);   // 2 2 1
```

**Gotcha.** A loop bound of 26 on a string of length 4 throws `StringIndexOutOfBoundsException`; on a 30-char string it never reaches positions 26-29.

</details>

<details><summary>🧱 Stronger hint (open after 10 min stuck)</summary>

```java
for (int ___ = 0; ___ < ____________; ___++) {
    if (count[codes.charAt(___) - 'a'] == 1) {
        return ___;
    }
}
```

</details>

<details><summary>🔒 Open only after your push</summary>

Q8 `n - 1` · Q9 a position in `codes` (`i` / `pos`) · Q10 row 4: `charAt(4)` on length 4 → `StringIndexOutOfBoundsException`; 30 chars: the loop stops at 25, never reads 28, returns a wrong answer · Q11 the `int[26]` counts: `"ab"`/`"ba"` really are anagrams; a sum also matches `"ac"`/`"bb"`, which are not.

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
- Pattern line + time/space (each with a **because**) first, then 20-30 min on a timer. Push even if red.
- Missed again tonight → the queue moves one more day (Thu 26 Nov would become Asteroid + CarFleet).

## 📌 Pending (after today's items)

- `DailyTemperatures` pseudocode/brute-force comments (5 min) · 🧩 · 🟡 open since 12 Nov
- Frequency-counting pack: `firstRepeated` implementation (15 min) + `int[26]` vs `HashMap` interview (5 min) · 🧩 · ⬜ (🔴 Weak)
- CarFleet single-pair follow-up · 🧩 · 🟡
- `ScoreOfParentheses` follow-ups, Two Sum `put` question (day 33 Q1) · 🧩 · ⬜

## 🌙 Evening (filled by the evening review)

| Track | Score /10 | Evidence |
|---|---|---|
| 🧩 DSA | | |
| 🏦 Banking | | |
| 🐞 Buggy | | |

| Tonight (in order) | Tomorrow |
|---|---|
| 1. ... | ... |

## 🌒 End of day (filled by the 10 PM check)

| Time (IST) | What changed | Result |
|---|---|---|
| | | |

<details><summary>🧹 Coach notes (state, housekeeping)</summary>

- State at ~6:15 AM IST (fresh clone, JDK 21.0.13): tip `1d11de4` (Day 33 evening review); no student commits since `3a620f4` (23 Nov). `mvn test` 728/728 green; `-Popen` 107 run / 91 red (the four open files). `open-stubs.txt` unchanged (no new stub, nothing passed).
- Tue 24 Nov had no 10 PM check on record; the missed Asteroid + CarFleet pair moved to today and the later queue moved one day in [redo-schedule.md](../revision/redo-schedule.md) (Thu 26 LargestRect + Day01 · Fri 27 Day00 + RPN · Sat 28 DailyTemps + ValidParen).
- `banking-app/TASKS.md`: Task 1.1 ⬜ → 🟡 (assigned, carried). No new stubs needed (`AuthSchemaIT` stubs exist). No new conceptual mistakes; nothing logged.
- Housekeeping: `tasks/day29.md` → `archive/tasks/day29.md` (last 5 days kept); links re-pointed.
- Group Anagrams hits its 2-day limit today; if still open tonight, Thu morning reviews it with the full skeleton and no new problem until it is ✅. Verified NeetCode count stays **10** of 45-50.
- Legend: 🧩 DSA · 🏦 Banking · 🐞 buggy slot · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 5, Day 34.

</details>
