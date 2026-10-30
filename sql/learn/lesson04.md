# 🎓 Lesson 04: INNER JOIN and LEFT JOIN

![Lesson](https://img.shields.io/badge/Lesson-04-blue) ![Time](https://img.shields.io/badge/time-20%20min-yellow) ![Schema](https://img.shields.io/badge/schema-learn__04-blue) ![DB](https://img.shields.io/badge/DB-PostgreSQL-blue)

> [!IMPORTANT]
> Write 5 queries yourself on INNER JOIN and LEFT JOIN and run the checker: all 5 `[PASS]` completes the lesson.

> [!NOTE]
> **Legend:** `[PASS]` correct · `[FAIL]` expected rows next to yours · `[TODO]` empty slot · ⬜ Not started · 🟡 In progress · ✅ Completed and verified.
>
> ⏱ 20 minutes · schema `learn_04` · status: ⬜ Not started

## 🎯 What you will learn
- Connect tables with `JOIN ... ON`.
- The difference between `INNER JOIN` (only matches) and `LEFT JOIN` (everything on the left, matches if any).
- Join three or four tables in one query.
- Find "things with no match" (anti-join) with `LEFT JOIN ... IS NULL`.
- Why a filter in `ON` and the same filter in `WHERE` can give different results.

## 💡 Concept in 2 minutes
```text
FROM a
JOIN b ON b.a_id = a.id          -- INNER: rows with no partner disappear
LEFT JOIN c ON c.a_id = a.id     -- LEFT: rows of a always stay; c columns are NULL when no partner
```
- Use short aliases (`a`, `c`) and qualify every column (`a.balance`) once two tables are involved.
- One row on the left with 3 partners on the right becomes 3 rows. That is normal and it is why you sometimes need `GROUP BY`.
- After a `LEFT JOIN`, the right-side columns are NULL for rows with no partner. `WHERE right.id IS NULL` keeps exactly those rows (the anti-join).
- **`ON` vs `WHERE`:** a condition about the right table written in `WHERE` throws away the NULL rows, so your `LEFT JOIN` silently turns into an `INNER JOIN`. If the condition is part of "what counts as a match", put it in `ON`.
- `COUNT(right.id)` counts partners, `COUNT(*)` counts rows (a no-partner row still counts as 1).

## 🧰 Setup
Run `lesson04-setup.sql` in pgAdmin, then `SET search_path TO learn_04;`.
Tables: `borrowers` and `loans` (worked example), `branches`, `customers`, `accounts`, `transactions` (exercises).

## 🧪 Worked example (tables `borrowers` and `loans`)
`borrowers`: Prakash Rane (2 loans), Leena Kamat (1 loan), Girish Naik (no loan).

INNER JOIN, only borrowers who have a loan:
```sql
SELECT b.name, l.loan_id, l.amount
FROM borrowers b
JOIN loans l ON l.borrower_id = b.borrower_id
ORDER BY l.loan_id;
```
| name | loan_id | amount |
|---|---|---|
| Prakash Rane | 10 | 500000 |
| Prakash Rane | 11 | 90000 |
| Leena Kamat | 12 | 750000 |

LEFT JOIN, every borrower, with a loan count (Girish gets 0):
```sql
SELECT b.name, COUNT(l.loan_id) AS loans
FROM borrowers b
LEFT JOIN loans l ON l.borrower_id = b.borrower_id
GROUP BY b.borrower_id, b.name
ORDER BY b.borrower_id;
```
| name | loans |
|---|---|
| Prakash Rane | 2 |
| Leena Kamat | 1 |
| Girish Naik | 0 |

## 📝 Exercises
Write your queries in `lesson04-exercises.sql`. Tables:
`customers(customer_id, full_name)`, `branches(branch_id, branch_name)`,
`accounts(account_id, customer_id, branch_id, balance, status)`,
`transactions(txn_id, account_id, txn_type, amount)`.

### 🔹 Exercise 1
Show `account_id`, the holder's `full_name` and `balance` for every account. Sort by `account_id`.

**Expected:** 3 columns, 8 rows, in this order. The first row is 101 / Asha Patil / 52000.
<details><summary>Hint</summary>One <code>JOIN</code> from <code>accounts</code> to <code>customers</code> on the customer id.</details>

### 🔹 Exercise 2
Show `account_id`, `full_name` and `branch_name` for ACTIVE accounts only. Sort by `account_id`.

**Expected:** 3 columns, 6 rows, in this order. The first row is 101 / Asha Patil / Pune Main.
<details><summary>Hint</summary>Start from <code>accounts</code> and join two tables, one after the other. The status filter goes in <code>WHERE</code>.</details>

### 🔹 Exercise 3
Show `full_name` and the number of accounts for EVERY customer, including customers with no account (they get 0). Sort by `customer_id`.

**Expected:** 2 columns, 6 rows, in this order. Vikram Shinde has 0, Asha Patil and Meera Joshi and Aditya Pawar have 2.
<details><summary>Hint</summary>The customers table must be on the LEFT side. Count a column of the <em>accounts</em> table, not <code>*</code>. Group by the customer.</details>

### 🔹 Exercise 4
Show the `branch_name` of every branch that has NO ACTIVE account. This includes a branch with no account at all and a branch that only has CLOSED accounts. Sort by `branch_name`.

**Expected:** 1 column, 2 rows, in this order.
<details><summary>Hint</summary>Anti-join: <code>LEFT JOIN</code> from branches, keep rows where the account side is NULL. Where should "ACTIVE" go, in <code>ON</code> or in <code>WHERE</code>? Try both and compare the rows.</details>

### 🔹 Exercise 5
For EVERY customer, show `full_name` and the total amount of their DEBIT transactions across all their accounts. Customers with no debits (or no accounts) show 0. Sort by `customer_id`.

**Expected:** 2 columns, 6 rows, in this order. Asha Patil is the only one with a big number (two identical debits of 1200 are both real), Meera Joshi has 700, the other four show 0.
<details><summary>Hint</summary>Chain two <code>LEFT JOIN</code>s: customers, accounts, transactions. The DEBIT condition belongs to what counts as a match, so think about <code>ON</code>. Then <code>SUM</code> gives NULL for no match: wrap it with <code>COALESCE</code>.</details>

## 🔎 Check your work
```bash
mvn test -Dtest=SqlLessonCheckTest -Dlesson=04
```

## 🏁 Done when

> [!IMPORTANT]
> All 5 exercises show `[PASS]`. Then tell Lumi.
