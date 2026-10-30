# 🎓 Lesson 05: subqueries and EXISTS

![Lesson](https://img.shields.io/badge/Lesson-05-blue) ![Time](https://img.shields.io/badge/time-20%20min-yellow) ![Schema](https://img.shields.io/badge/schema-learn__05-blue) ![DB](https://img.shields.io/badge/DB-PostgreSQL-blue)

> [!IMPORTANT]
> Write 5 queries yourself on subqueries and EXISTS and run the checker: all 5 `[PASS]` completes the lesson.

> [!NOTE]
> **Legend:** `[PASS]` correct · `[FAIL]` expected rows next to yours · `[TODO]` empty slot · ⬜ Not started · 🟡 In progress · ✅ Completed and verified.
>
> ⏱ 20 minutes · schema `learn_05` · status: ⬜ Not started

## 🎯 What you will learn
- A scalar subquery (one value) inside `WHERE`.
- `IN (subquery)` for "is one of these".
- `EXISTS` / `NOT EXISTS` for "has at least one related row".
- The `NOT IN` + NULL trap.
- A subquery in `FROM` (a derived table).

## 💡 Concept in 2 minutes
- A subquery is a `SELECT` inside another query, written in brackets.
- **Scalar subquery:** returns one row and one column, so you can compare with it: `WHERE x > (SELECT AVG(x) FROM t)`.
- **`IN (SELECT ...)`:** true when the value is in the list the subquery returns. Duplicates in the list do not matter.
- **`EXISTS (SELECT 1 FROM ... WHERE inner.col = outer.col)`:** a *correlated* subquery that refers to the outer row. It is true when at least one inner row exists. What the inner `SELECT` returns does not matter.
- **`NOT IN` trap:** if the subquery returns even one NULL, `x NOT IN (...)` is never true, so you get **zero rows**. `NOT EXISTS` does not have this problem. Prefer `NOT EXISTS` for "has none".
- **Derived table:** `FROM (SELECT ... GROUP BY ...) AS t` lets you filter or join on an aggregate result, with a normal `WHERE`.

## 🧰 Setup
Run `lesson05-setup.sql` in pgAdmin, then `SET search_path TO learn_05;`.
Tables: `branches` and `staff` (worked example), `customers`, `accounts`, `transactions`, `loans` (exercises).

## 🧪 Worked example (tables `staff` and `branches`)
Salaries: 90000, 60000, 75000, 120000, 55000, 75000 (average about 79167).

Scalar subquery, staff earning more than the average:
```sql
SELECT staff_name, salary
FROM staff
WHERE salary > (SELECT AVG(salary) FROM staff)
ORDER BY salary DESC;
```
| staff_name | salary |
|---|---|
| Farah Sheikh | 120000 |
| Sunita Apte | 90000 |

EXISTS, branches that have somebody earning over 100000:
```sql
SELECT branch_name
FROM branches b
WHERE EXISTS (SELECT 1 FROM staff s
              WHERE s.branch_id = b.branch_id AND s.salary > 100000);
```
Gives `Mumbai Fort`.

## 📝 Exercises
Write your queries in `lesson05-exercises.sql`. Tables:
`customers(customer_id, full_name)`,
`accounts(account_id, customer_id, balance, status)`,
`transactions(txn_id, account_id, txn_type, amount, txn_status)`,
`loans(loan_id, customer_id, guarantor_id, amount, status)`.
Use a subquery in each answer (that is the point of the lesson), even where a join could also work.

### 🔹 Exercise 1
Show `account_id` and `balance` of accounts whose balance is above the average balance of ALL accounts. Biggest balance first.

**Expected:** 2 columns, 3 rows, in this order. The first row is 207 / 250000, and it is a CLOSED account (do not filter on status).
<details><summary>Hint</summary>The right-hand side of <code>&gt;</code> is a bracketed <code>SELECT AVG(...)</code> over the same table.</details>

### 🔹 Exercise 2
Show the `full_name` of customers who have at least one ACTIVE loan. Each customer appears once. Sort by `full_name`.

**Expected:** 1 column, 3 rows, in this order. Asha Patil has two ACTIVE loans but is listed once.
<details><summary>Hint</summary><code>customer_id IN (SELECT ... FROM loans WHERE ...)</code>. <code>IN</code> does not multiply rows the way a join would.</details>

### 🔹 Exercise 3
Show the `account_id` of accounts that have at least one POSTED transaction. Sort by `account_id`.

**Expected:** 1 column, 4 rows, in this order. Account 204 has a transaction, but it is REVERSED, so it is not in the result.
<details><summary>Hint</summary><code>EXISTS</code> with a subquery on <code>transactions</code> that links to the outer account and checks the transaction status.</details>

### 🔹 Exercise 4
Show `customer_id` and `full_name` of customers who have NEVER been a guarantor (`guarantor_id`) on any loan. Sort by `customer_id`.

**Expected:** 2 columns, 4 rows, in this order. The first is customer 4, Vikram Shinde. Some loans have no guarantor (NULL), keep that in mind.
<details><summary>Hint</summary>Try <code>NOT IN</code> first and look at the result. Then explain to yourself why it is empty, and fix it with <code>NOT EXISTS</code> (or filter the NULLs out of the subquery).</details>

### 🔹 Exercise 5
Show `full_name` and `total_balance` (the sum of the balances of all their accounts) for customers whose total balance is above 100000. Biggest total first.

**Expected:** 2 columns, 2 rows, in this order. The first is Aditya Pawar with 250000.
<details><summary>Hint</summary>First write the inner query: total balance per customer with <code>GROUP BY</code>. Put it in <code>FROM (...) AS t</code>, join it to <code>customers</code>, and filter with a normal <code>WHERE</code>. (A <code>HAVING</code>-based <code>IN</code> works too.)</details>

## 🔎 Check your work
```bash
mvn test -Dtest=SqlLessonCheckTest -Dlesson=05
```

## 🏁 Done when

> [!IMPORTANT]
> All 5 exercises show `[PASS]`. Then tell Lumi.
