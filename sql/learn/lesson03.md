# 🎓 Lesson 03: aggregates, GROUP BY, HAVING

![Lesson](https://img.shields.io/badge/Lesson-03-blue) ![Time](https://img.shields.io/badge/time-20%20min-yellow) ![Schema](https://img.shields.io/badge/schema-learn__03-blue) ![DB](https://img.shields.io/badge/DB-PostgreSQL-blue)

> [!NOTE]
> ⏱ 20 minutes · schema `learn_03` · status: ⬜ Not started

## 🎯 What you will learn
- `COUNT`, `SUM`, `AVG`, `MIN`, `MAX` and how each one treats NULL.
- `COUNT(*)` vs `COUNT(column)` vs `COUNT(DISTINCT column)`.
- `GROUP BY` to get one row per group.
- `WHERE` (filters rows before grouping) vs `HAVING` (filters groups after).
- `ROUND`.

## 💡 Concept in 2 minutes
- An aggregate collapses many rows into one value.
- `COUNT(*)` counts rows. `COUNT(col)` counts rows where `col` is not NULL. `COUNT(DISTINCT col)` counts different non-NULL values.
- `SUM`, `AVG`, `MIN`, `MAX` ignore NULLs. If **every** value is NULL, the result is NULL (not 0).
- With `GROUP BY`, every column in `SELECT` must be either in the `GROUP BY` or inside an aggregate.
- Order of work: `FROM`, `WHERE`, `GROUP BY`, `HAVING`, `SELECT`, `ORDER BY`. That is why `HAVING` can use an aggregate and `WHERE` cannot.
- A group with no rows does not exist. `GROUP BY` can never show a branch that has no accounts (lesson 04 fixes that with a `LEFT JOIN`).
- `ROUND(AVG(x), 2)` rounds to 2 decimals.

## 🧰 Setup
Run `lesson03-setup.sql` in pgAdmin, then `SET search_path TO learn_03;`.
Tables: `loans` (worked example), `branches`, `accounts` (exercises).

## 🧪 Worked example (table `loans`)
Task: for each loan type with at least 2 loans, show the number of loans and the average principal.

```sql
SELECT loan_type,
       COUNT(*)                 AS loans,
       ROUND(AVG(principal), 0) AS avg_principal
FROM loans
GROUP BY loan_type
HAVING COUNT(*) >= 2
ORDER BY loan_type;
```
| loan_type | loans | avg_principal |
|---|---|---|
| CAR | 2 | 1000000 |
| HOME | 3 | 4500000 |

`PERSONAL` has only 1 loan, so `HAVING` removes that group.

## 📝 Exercises
Write your queries in `lesson03-exercises.sql`. Table: `accounts`
(`account_id`, `branch_id`, `account_type`, `balance`, `status`). `balance` can be NULL, and the `branches` table has a branch with no accounts.

### 🔹 Exercise 1
Return ONE row with three numbers, in this order: how many accounts exist, how many of them have a balance (not NULL), how many different account types there are.

**Expected:** 3 columns, 1 row.
<details><summary>Hint</summary>Three aggregates in one <code>SELECT</code>. Think about which of the three counts must name a column (to skip NULLs) and which one needs <code>DISTINCT</code>.</details>

### 🔹 Exercise 2
For each `status`, show the status, the number of accounts and the total balance. Sort by status.

**Expected:** 3 columns, 2 rows, in this order. ACTIVE comes first.
<details><summary>Hint</summary><code>GROUP BY status</code>. You get the NULL-ignoring behaviour of <code>SUM</code> for free.</details>

### 🔹 Exercise 3
For each `branch_id` that has accounts, show `branch_id`, number of accounts, total balance and highest balance. Sort by `branch_id`.

**Expected:** 4 columns, 4 rows, in this order. Branch 3 has accounts, but every balance there is NULL, so its total and highest balance are NULL. Branch 5 has no accounts and does not appear.
<details><summary>Hint</summary>Do not "fix" the NULL with <code>COALESCE</code>: the expected answer is NULL. Four items in <code>SELECT</code>, one <code>GROUP BY</code>.</details>

### 🔹 Exercise 4
Show `branch_id` and the total balance of its ACTIVE accounts, but only for branches whose ACTIVE total is MORE than 250000. Biggest total first.

**Expected:** 2 columns, 2 rows, in this order. The first is branch 2.
<details><summary>Hint</summary>Two filters at two different moments: ACTIVE filters rows (<code>WHERE</code>), the 250000 limit filters groups (<code>HAVING</code>).</details>

### 🔹 Exercise 5
For ACTIVE accounts only, show `account_type` and the average balance rounded to 2 decimals. Sort by `account_type`.

**Expected:** 2 columns, 3 rows, in this order. The CURRENT average is 49416.83. SAVINGS contains two NULL balances: they are not counted as 0.
<details><summary>Hint</summary><code>AVG</code> skips NULLs by itself. <code>ROUND(value, 2)</code> wraps the aggregate.</details>

## 🔎 Check your work
```bash
mvn test -Dtest=SqlLessonCheckTest -Dlesson=03
```

## 🏁 Done when

> [!IMPORTANT]
> All 5 exercises show `[PASS]`. Then tell Lumi.
