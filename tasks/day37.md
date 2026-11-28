# Day 37 · Sat 28 Nov · ~125 min (+15 buffer)

**Focus:** weekend = no new problem: two cold redos (Asteroid, LargestRect), the 🔴 cold-recall pack, 🏦 Task 1.1 day 5 in four small green steps · **Done when:** both redos pushed (even red), `AuthSchemaIT` 2/2, Q1-Q7 answered in chat · Run `git pull` first · Stuck 15 min → ask Lumi.

## ✅ Today

| # | Track | Item | File | Tests | Time | Status |
|---|---|---|---|---|---|---|
| 1 | 🧩 | 🔴 Cold-recall pack (review, no new problem): Q1 cases + Q2 debug snippet, **after redo 1** | this file, item 1 | Q1-Q2 | 15 | ⬜ |
| 2 | 🏦 | Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 5, 4-step build order) | `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` | 0/2 | 45 | 🟡 |
| 3 | 🐞 | Buggy slot (Sat, no round): open write-ups Q6 (Day06 Q10 redo) + Q7 (Two Sum `put`) | chat | Q6-Q7 | 10 | ⬜ |
| 4 | 🔁 | `AsteroidCollisionRedoNov17`, cold, 25-min timer · **do this first** | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | 0/28 | 25 | ⬜ |
| 5 | 🔁 | `Day04LargestRectangleRedoNov28`, cold, 30-min timer (new blank stub) | `src/main/java/com/prashant/dailytests/redo/Day04LargestRectangleRedoNov28.java` | 0/36 | 30 | ⬜ |

> Short on time: row 4 (Asteroid cold, 25 min) → push even if red. It is due since 1 Nov; nothing else unlocks the cold-recall weak spot.

## 🔎 Since yesterday

| Item | Result | Status |
|---|---|---|
| `a7ba6d5` (27 Nov 9:33 PM IST) `GroupAnagrams` a-z IAE guard | 22/22 → verified DSA **11 of 45-50** | ✅ |
| Q10 re-answer in chat (9:34 PM IST) | still partial: exception type and the 30-char case → Q6 today | 🔶 |
| `AsteroidCollisionRedoNov17` | still the stub, 0/28 → slot 1 today | ⬜ |
| 🏦 Task 1.1 code (V2 + `AuthSchemaIT`) | not pushed; Q4-Q7 concepts ✅ | 🟡 |
| Commits after the 10 PM check (`477401a`) | none | — |

<details><summary>📖 Review details</summary>

| Check (fresh clone at `477401a`, JDK 21.0.13, ~6:15 AM IST) | Result |
|---|---|
| `mvn test` | ✅ 807 run, 0 failures (green) |
| `mvn test -Popen` | 64 run / 64 red = `AsteroidCollisionRedoNov17` 28 · `Day04LargestRectangleRedoNov28` 36 (new blank stub) |
| `Day04LargestRectangleTest` → `Day04LargestRectangleContract` (first redo, CONTRIBUTING rule) | original still **36/36**; redo test runs the same 36 cases; a reference version (not pushed) passes 36/36 |
| Banking | only `V1` in `db/migration`; `AuthSchemaIT` still the 2 `fail("TODO")` stubs; ITs not run (no Docker on the review box) |
| Cosmetic fixes | none needed (no new student code) |

</details>

## 1. 🧩 Cold-recall pack (weekend review, ~15 min)

- **Goal:** prove the Asteroid pattern lives in your head, not in the file: name the cases, then find a planted bug.
- **When:** **after** redo 1 is pushed. The snippet below is almost the whole algorithm; reading it first would make the redo a copy.
- **Do:** Q1 (3 cases, 5 min) → Q2 (failing input + smallest fix, 10 min). Answer in chat.
- **Done when:** Q1 names all three cases with what happens to the stack top and to the incoming asteroid; Q2 gives one failing input, expected vs actual, and a one-line fix.
- **Hint rule:** stuck 15 min → ask Lumi.

<details><summary>📖 Note and the debugging snippet (open after redo 1)</summary>

**Why it matters.** A redo checks memory of the *pattern*, not of the file. A copied green test is zero signal and repeats the gap; a red cold attempt tells us exactly what to fix. Three redos were copied (ScoreOf, RemoveK, CarFleet) and Asteroid has been skipped since 1 Nov, so this is the 🔴 weak spot.

**The pattern in one line.** Stack of survivors; a collision is only possible when the top moves right (`> 0`) and the incoming one moves left (`< 0`).

| Top vs incoming size | Stack | Incoming |
|---|---|---|
| ? | ? | ? |
| ? | ? | ? |
| ? | ? | ? |

(Fill the 3 rows in Q1.)

**Debugging snippet** (one planted bug, never told where):

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

**Senior follow-up.** The spec allows `Integer.MIN_VALUE`. What does `-a` give for it, and how would you compare sizes safely?

</details>

<details><summary>🔒 Open only after your attempt</summary>

- **Q1.** top smaller → pop it, incoming keeps going (loop again) · equal → pop it **and** incoming dies · top bigger → stack unchanged, incoming dies.
- **Q2.** `[5, -5]`: expected `[]`, the snippet returns `[-5]`. The equal branch pops but never kills the incoming asteroid. Fix: `else if (stack.peek() == -a) { stack.pop(); alive = false; }`.
- **Q3 (after redo 2).** The stack keeps, below each index, the nearest shorter bar on its left. Empty below the popped bar = no bar to its left is shorter than `h`, so the rectangle of height `h` stretches from index 0 to `i - 1`: width `i`.
- **Follow-up.** `-Integer.MIN_VALUE` overflows back to `Integer.MIN_VALUE` (negative), so `peek() < -a` is false for every top. Compare as `long`: `(long) stack.peek() < -(long) a`.

</details>

## 2. 🏦 Banking: Task 1.1 V2 auth tables + `AuthSchemaIT` (carried, day 5, ~45 min)

- **Goal:** write `V2__create_auth_tables.sql` by hand: `users`, `roles`, `permissions`, `user_roles`, `role_permissions` in schema `auth`.
- **Files:** `banking-app/src/main/resources/db/migration/V2__create_auth_tables.sql` (you create it) · `banking-app/src/test/java/com/prashant/banking/auth/AuthSchemaIT.java` (2 stub tests, bodies are yours).
- **Run:** Docker Desktop running, then `mvn -f banking-app/pom.xml verify` or `AuthSchemaIT` from IntelliJ.
- **Done when:** `AuthSchemaIT` 2/2 and `BankingApplicationIT` 1/1 on `verify`.
- **First:** the decision table as comment lines at the top of V2. No endpoint yet, so no method × outcomes grid row; from Task 1.5, fill the grid and check what Spring already handles before adding any handler.
- **Day 5 change:** build it in the 4 steps below, each one ends green or with one specific red. Push after step 2 even if steps 3-4 wait.
- **Interview:** why a unique index on `lower(username)`, and not an `existsByUsername` check in the service? (✅ answered 27 Nov; today's checks are Q4-Q5)

<details><summary>🪜 Day-5 help: build order (guiding questions, the SQL and test bodies stay yours)</summary>

| Step | Do (~min) | Check before moving on |
|---|---|---|
| 1 | V2 with the decision comments + `auth.users` + the `lower(username)` index (10). `users` is ~80 % in the teaching example: add the 4 `BaseEntity` columns | `verify`: `BankingApplicationIT` still 1/1 (Flyway applied V2) |
| 2 | Test 2 body (10): insert `Teller01`, then `teller01`; assert the exception (Q4) | `usernameIsUniqueIgnoringCase` green → **push** |
| 3 | `roles`, `permissions` (same shape, `name` unique), then `user_roles`, `role_permissions` (10) | each join table: which composite PK, which two FKs, what `ON DELETE`? |
| 4 | Test 1 body (10): list the table names in schema `auth` and compare with the five expected (Q5) | `AuthSchemaIT` 2/2 + `BankingApplicationIT` 1/1 → push |

- **Keep V2 editable:** until 1.1 is ✅, run it only through `verify` (Testcontainers builds a fresh DB each run). If V2 already ran on your local `5433` DB and you change it, Flyway's checksum fails: `docker compose down -v` and start again.
- **Test 2 questions:** which `JdbcTemplate` method runs an `INSERT` with `?` parameters? Which `public_id` value can you generate in Java for each row? Which JUnit 5 assertion checks "this lambda throws X"?
- **Test 1 questions:** which `information_schema.tables` columns hold the schema and the table name? Which `JdbcTemplate` method returns a `List<String>` for one column? Why compare as a `Set` and not as an ordered list?
- **Placeholder hash only:** a fixed string such as `'$2a$10$placeholder...'`, never a real password.

</details>

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

**Decision table (your answers go in V2 as comments).**

| Decision | Question that settles it |
|---|---|
| Tables | Which five, all in schema `auth`? |
| PK type | `BaseEntity` holds the id as which Java type, so which SQL identity type? |
| Join-table PK | What composite key on `user_roles (user_id, role_id)` stops the same pair twice? |
| `ON DELETE` | Role deleted → what happens to its `user_roles` / `role_permissions` rows? |
| Username | `UNIQUE (username)` or a unique index on `lower(username)`? |
| Password | Which column name, and why 60+ chars (BCrypt) and never the password itself? |
| `BaseEntity` columns | `created_at`/`updated_at` (`Instant` → `TIMESTAMPTZ NOT NULL`), `created_by` (`VARCHAR(100)`, nullable), `version` (`BIGINT NOT NULL`): on which tables? |

**Gotchas**
- No password, hash or seed user in V2. Ever.
- `password_hash` holds a BCrypt string (60 chars), not the password.
- `ddl-auto=validate` will compare your Task 1.2 entities with this SQL, so names and types must match.
- If V2 already ran on your local DB and you change it: reset the dev DB or add V3.

**Checks (from TASKS.md, ✅ answered 27 Nov: B · B · B)**
1. Why not `UNIQUE (username)`? A. slower · B. `Teller01` and `teller01` would both get in · C. Postgres forbids it
2. Two requests register `teller01` at the same moment and both pass `existsByUsername`. What stops the second one? A. `@Transactional` · B. the unique index · C. nothing
3. V2 ran yesterday. Today you need a new column. A. edit V2 · B. add V3 · C. `ddl-auto=update`

</details>

<details><summary>🔒 Open only after your attempt</summary>

- **Q4 B.** Postgres raises SQLState `23505`; Spring's `SQLExceptionTranslator` (behind `JdbcTemplate`) turns it into `DuplicateKeyException`, a subclass of `DataIntegrityViolationException`. Asserting the Spring type keeps the test independent of the driver (`PSQLException` is the cause, not the thrown type).
- **Q5.** "Contains these five" still passes if a stray sixth table (a typo, a leftover) lands in `auth`; exact `Set` equality catches it, and order from `information_schema` is not guaranteed.
- **Q4 (27 Nov) shape, 60 s.** The service check is a read then a write, so two concurrent requests both see "free"; the unique index is enforced inside the database at insert time, for every writer. Keep the service check only for a friendly message and map `DuplicateKeyException` to 409.

</details>

## 3. 🐞 Buggy slot: open write-ups (Sat, no round, ~10 min)

- **Goal:** close two open answers so nothing old rides into next week.
- **Q6:** Day06 Q10 in one line each: what the **original** `letter < 26` loop does on a length-4 string, and on a 30-char string whose unique code is at position 28.
- **Q7:** Two Sum (day 33 Q1): why `put` overwriting a duplicate value never breaks the one-pair answer, and what you would store for "all pairs".
- **Done when:** both answered in chat with the exact exception class and a concrete example.
- **Next round:** `Buggy07` (Arrays & Hashing) comes Tue 1 Dec; nothing blocks it.

<details><summary>📖 One-line note for Q6</summary>

**Which object is indexed decides the exception.** `int[] count` out of range → `ArrayIndexOutOfBoundsException`; `String.charAt(i)` out of range → `StringIndexOutOfBoundsException`. Too-far bound (26 > length) = exception; too-short bound (26 < length) = no exception, a silent wrong answer.

```java
"abcd".charAt(4);   // java.lang.StringIndexOutOfBoundsException: Index 4 out of bounds for length 4
int[] count = new int[26];
count[26]++;        // java.lang.ArrayIndexOutOfBoundsException: Index 26 out of bounds for length 26
```

</details>

<details><summary>🔒 Open only after your attempt</summary>

- **Q6.** Length 4: the loop reaches `charAt(4)` → `StringIndexOutOfBoundsException`. 30 chars: the loop stops at 25, never reads 28, returns a wrong index (or -1) with no exception.
- **Q7.** The scan checks the map **before** `put`, so the first copy is always found by the second one (`[3,3]`, target 6 → `[0,1]`); later overwrites only move to a newer index the answer no longer needs. For all pairs: `Map<Integer, List<Integer>>` (value → every index) or a count map when only the number of pairs matters.

</details>

## ❓ Questions to answer in chat

| # | For | Question (short; letters only for MCQs) |
|---|---|---|
| Q1 | 🧩 | Asteroid: the 3 cases when a left-mover meets a right-moving top (after redo 1) |
| Q2 | 🧩 | Debug snippet: one failing input (expected vs actual) + smallest fix |
| Q3 | 🔁 | LargestRect: why is the width `i` when the stack is empty after a pop? (after redo 2) |
| Q4 | 🏦 | Second `teller01` insert via `JdbcTemplate`: what is thrown? (A-C) |
| Q5 | 🏦 | Test 1: why exact `Set` equality and not "contains the five"? (1 line) |
| Q6 | 🐞 | Day06 Q10 again: original `< 26` loop on length 4, and position 28 of 30 |
| Q7 | 🧩 | Two Sum: why `put` overwriting duplicates never breaks it; what to store for all pairs |

<details><summary>📖 Full question text and options</summary>

1. In Asteroid Collision, a left-moving asteroid meets a right-moving stack top. Name the three size cases (top smaller / equal / bigger) and say what happens to the stack and to the incoming asteroid in each.
2. The debugging snippet in item 1 has one planted bug. Give one input that fails, the expected and the actual output, and the smallest fix.
3. In Largest Rectangle, after popping bar `h` at index `i`, the width is `i` if the stack is empty, else `i - stack.peek() - 1`. Explain the empty case geometrically: what does an empty stack say about every bar to the left of the popped one?
4. Your test inserts `Teller01`, then `teller01`, with `jdbc.update(...)`. The second call throws: A. `org.postgresql.util.PSQLException` directly · B. `DuplicateKeyException` (a `DataIntegrityViolationException`), translated by Spring from SQLState 23505 · C. nothing, it returns 0 rows
5. In `v2CreatesFiveAuthTables`, why compare the table names as an exact `Set` and not with "contains these five"?
6. Day06: in one line each, what does the **original** last loop (`letter < 26`) do (a) on a 4-character string, (b) on a 30-character string whose unique code is at position 28? Name the exact exception class.
7. Two Sum: why does `map.put(nums[i], i)` overwriting an earlier duplicate never break the single-pair answer? What would you store if the question asked for all pairs?

</details>

## 🔁 Redos (cold, cap 2)

| # | Redo | Stub | Run | When | Done when | Status |
|---|---|---|---|---|---|---|
| 1 | `AsteroidCollision` (+1, due since 1 Nov) | `src/main/java/com/prashant/dailytests/redo/AsteroidCollisionRedoNov17.java` | `mvn test -Dtest=AsteroidCollisionRedoNov17Test` | morning, first | 28/28, cold | ⬜ 0/28 |
| 2 | `Day04LargestRectangle` (+1, due since 6 Nov, buggy round: write the whole method) | `src/main/java/com/prashant/dailytests/redo/Day04LargestRectangleRedoNov28.java` | `mvn test -Dtest=Day04LargestRectangleRedoNov28Test` | after item 2, or evening | 36/36, cold | ⬜ 0/36 |

- **Redo day reminder:** both are cold. New blank stubs, tests verified; do not open `dsa/stack/AsteroidCollision.java`, `dailytests/Day04LargestRectangle.java` or old day files. A copy counts as not passed.
- Pattern line + time/space (each with a **because**) + 3-5 lines of pseudocode first, then 20-30 min on a timer. Push even if red.
- Missed → Sun 29 becomes Asteroid + Day04 and Day01 + Day00 move to Mon 30.

## 📌 Pending (after today's items)

- `Buggy07` (Arrays & Hashing) · 🐞 · ⬜ planned Tue 1 Dec
- Next new DSA problem (Arrays & Hashing 5 of 9) · 🧩 · ⬜ Mon 30 Nov
- Frequency-counting pack: `firstRepeated` (15 min) + `int[26]` vs `HashMap` interview (5 min) · 🧩 · ⬜
- CarFleet single-pair follow-up; `ScoreOfParentheses` follow-ups · 🧩 · ⬜

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

- State ~6:15 AM IST: fresh clone at `477401a` (Day 36 10 PM check), no student commits after `a7ba6d5`. JDK 21.0.13: `mvn test` 807/807 green; `-Popen` 64 run / 64 red (Asteroid redo 28 + new Day04 redo 36).
- Golden rule: Saturday → no new DSA problem, no `Buggy07`; DSA slot = 🔴 cold-recall pack from the day 36 evening; buggy slot = open write-ups. Task 1.1 stays 🟡 in `banking-app/TASKS.md` (day 5; stubs already exist, nothing new created; no SQL or test logic written for him).
- Pack order changed on purpose: the debug snippet shows the Asteroid algorithm, so it comes **after** the cold redo.
- Redo 2: first redo of `Day04LargestRectangle` → `Day04LargestRectangleTest` turned into `Day04LargestRectangleContract` (36 cases, count unchanged) + 2 subclasses; new blank stub `Day04LargestRectangleRedoNov28` (added to `open-stubs.txt`); a reference version (not pushed) passes 36/36.
- Housekeeping: `tasks/day32.md` → `archive/tasks/day32.md` (last 5 kept: day33-37); its relative links and the two links in `archive/progress-2026-11.md` re-pointed.
- No new conceptual mistakes; nothing logged. Redo queue unchanged ([redo-schedule.md](../revision/redo-schedule.md)).
- Legend: 🧩 DSA · 🏦 Banking · 🐞 buggy slot · 🔁 redo · ⬜ `NOT_STARTED` · 🟡 `IN_PROGRESS` · ✅ `COMPLETED` · 🔴 `REVISION_REQUIRED` · ⛔ `BLOCKED`. Week 6, Day 37.

</details>
