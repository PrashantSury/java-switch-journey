# Lesson 01: SELECT, WHERE, ORDER BY, LIMIT

⏱ 15 minutes · schema `learn_01` · status: ⬜ Not started

## What you will learn
- Pick columns with `SELECT` and rows with `WHERE`.
- Combine conditions with `AND`, `OR`, `IN`, `BETWEEN`, `LIKE` / `ILIKE`.
- Sort with `ORDER BY` (more than one column, `ASC` / `DESC`).
- Keep the first rows with `LIMIT`, and remove repeats with `DISTINCT`.

## Concept in 2 minutes
```text
SELECT   <columns>        -- what you want to see
FROM     <table>          -- where it lives
WHERE    <condition>      -- which rows survive
ORDER BY <columns>        -- in what order
LIMIT    <n>;             -- how many rows at most
```
- SQL reads it in this order: `FROM`, `WHERE`, `SELECT`, `ORDER BY`, `LIMIT`.
- `AND` binds tighter than `OR`. When you mix them, use brackets: `a AND (b OR c)`.
- `LIKE` is case-sensitive in PostgreSQL, `ILIKE` ignores case. `%` means "any text", `_` means "one character".
- Without `ORDER BY`, the row order is **not guaranteed**. `LIMIT` without `ORDER BY` gives you random rows.
- When two rows tie on the sort column, add a second sort column so the result is always the same.

## Setup
1. Open pgAdmin, open a Query Tool on your scratch database, and run `lesson01-setup.sql`.
2. It creates the schema `learn_01` with the tables `branches` (worked example) and `accounts` (exercises).
3. In the Query Tool run `SET search_path TO learn_01;` once so you can write plain table names.

## Worked example (table `branches`)
Task: the 2 newest branches that are in Pune, or were opened before 2000.

```sql
SELECT branch_name, city
FROM branches
WHERE city = 'Pune' OR opened_year < 2000
ORDER BY opened_year DESC
LIMIT 2;
```
Result:

| branch_name | city |
|---|---|
| Pune Camp | Pune |
| Pune Main | Pune |

`Mumbai Fort` (1998) also matched the `WHERE`, but it is the oldest, so `LIMIT 2` after the sort drops it.

## Exercises
Write your queries in `lesson01-exercises.sql`, under the matching `-- @ex N` line. Table: `accounts`
(`account_id`, `holder_name`, `branch_id`, `account_type`, `balance`, `status`, `opened_on`).
Column names in your result do not matter, but the column ORDER does.

### Exercise 1
Show `holder_name` and `balance` of every account at branch 2, sorted by `holder_name` A to Z.

**Expected:** 2 columns, 4 rows, in this order. The first row is Anita Rao.
<details><summary>Hint</summary>One condition in <code>WHERE</code>, then <code>ORDER BY</code> on the text column.</details>

### Exercise 2
Show `account_id`, `holder_name`, `account_type` of ACTIVE accounts whose type is SAVINGS or FIXED and that were opened on or after 2022-01-01.

**Expected:** 3 columns, 4 rows, any order. There is one FIXED row.
<details><summary>Hint</summary>Dates compare like numbers (<code>opened_on &gt;= DATE '2022-01-01'</code>). Use <code>IN (...)</code> or brackets around the <code>OR</code>, otherwise a CLOSED account sneaks in.</details>

### Exercise 3
Show `account_id` and `holder_name` for accounts whose holder name contains the letters "an" in any letter case (the first letter of a name counts too). Sort by `account_id`.

**Expected:** 2 columns, 4 rows, in this order. The last row is Anita Rao (111).
<details><summary>Hint</summary>Look at the difference between <code>LIKE</code> and <code>ILIKE</code>, and put <code>%</code> on both sides of the text.</details>

### Exercise 4
Show `account_id` and `balance` of the 3 ACTIVE accounts with the biggest balance. If two accounts have the same balance, the account that was opened earlier comes first.

**Expected:** 2 columns, 3 rows, in this order. The first two rows have the same balance (250000).
<details><summary>Hint</summary><code>ORDER BY</code> accepts a list: first the balance (biggest first), then a second column to break the tie. <code>LIMIT</code> comes last.</details>

### Exercise 5
Show the different `branch_id` values of ACTIVE accounts whose balance is below 10000. Each branch should appear once, sorted ascending.

**Expected:** 1 column, 2 rows, in this order. Branch 2 holds two such accounts but must show up only once.
<details><summary>Hint</summary>Put <code>DISTINCT</code> right after <code>SELECT</code>.</details>

## Check your work
From the repository root:
```bash
mvn test -Dtest=SqlLessonCheckTest -Dlesson=01
```
Details (database password, Windows commands) are in [README.md](README.md). `[PASS]` is green, `[TODO]` means the slot is still empty.

## Done when
All 5 exercises show `[PASS]`. Then tell Lumi and she will mark Lesson 01 as completed in `PROGRESS.md`.
