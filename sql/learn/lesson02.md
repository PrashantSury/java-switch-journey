# Lesson 02: NULL handling and CASE

⏱ 20 minutes · schema `learn_02` · status: ⬜ Not started

## What you will learn
- What NULL really means and why `= NULL` never works.
- `IS NULL`, `IS NOT NULL`, `IS DISTINCT FROM`.
- `COALESCE` to replace NULL with a default.
- `CASE WHEN ... THEN ... ELSE ... END` to turn values into labels.
- Where NULLs go when you sort.

## Concept in 2 minutes
- NULL means "unknown", not zero and not an empty string.
- Any comparison with NULL gives *unknown*, and `WHERE` keeps only rows where the condition is *true*.
  So `x = NULL`, `x <> 'A'` and `x NOT IN (...)` all silently drop rows where `x` is NULL.
- Test for NULL with `IS NULL` / `IS NOT NULL`.
- `a IS DISTINCT FROM b` is "not equal" that treats NULL like a normal value.
- `COALESCE(a, b, c)` returns the first value that is not NULL.
- `CASE` checks its `WHEN` branches from the top and takes the first one that is true. No branch true and no `ELSE` gives NULL.
- Sorting: in PostgreSQL NULLs count as the *biggest* value. `ASC` puts them last, `DESC` puts them first. Control it with `NULLS FIRST` / `NULLS LAST`.

## Setup
Run `lesson02-setup.sql` in pgAdmin, then `SET search_path TO learn_02;`.
Tables: `branches` (worked example) and `customers` (exercises).

## Worked example (table `branches`)
`manager_name` is NULL when no manager is appointed, `closed_on` is NULL while the branch is open.

```sql
SELECT branch_id, branch_name,
       COALESCE(manager_name, '(vacant)') AS manager
FROM branches
ORDER BY branch_id;
```
| branch_id | branch_name | manager |
|---|---|---|
| 1 | Pune Main | Sunita Apte |
| 2 | Mumbai Fort | (vacant) |
| 3 | Nashik Road | Dilip Nagare |
| 4 | Kolhapur | (vacant) |

```sql
SELECT branch_name,
       CASE WHEN closed_on IS NULL THEN 'OPEN' ELSE 'CLOSED' END AS state
FROM branches
ORDER BY branch_id;
```
Gives OPEN, OPEN, CLOSED, CLOSED.

The trap: `SELECT branch_name FROM branches WHERE manager_name <> 'Sunita Apte'` returns only **Nashik Road**.
Mumbai Fort and Kolhapur have no manager, so the comparison is *unknown* and they vanish.

## Exercises
Write your queries in `lesson02-exercises.sql`. Table: `customers`
(`customer_id`, `full_name`, `phone`, `email`, `city`, `kyc_status`, `annual_income`). Several columns contain NULLs on purpose.

### Exercise 1
Show `customer_id` and `full_name` of customers who have no phone number. Sort by `customer_id`.

**Expected:** 2 columns, 4 rows, in this order. The first is Rohan Deshmukh (2).
<details><summary>Hint</summary>Use <code>IS NULL</code>, never <code>= NULL</code>.</details>

### Exercise 2
Show `customer_id` and `kyc_status` of customers whose KYC is anything other than VERIFIED. Customers whose `kyc_status` is NULL (KYC not started) must be included. Sort by `customer_id`.

**Expected:** 2 columns, 6 rows, in this order. Two of the rows show NULL.
<details><summary>Hint</summary>Plain <code>&lt;&gt;</code> loses the NULL rows (see the trap above). Either add <code>OR ... IS NULL</code>, or look up <code>IS DISTINCT FROM</code>.</details>

### Exercise 3
Show `customer_id` and one column `contact`: the email if there is one, otherwise the phone, otherwise the text `NO CONTACT`. All 10 customers, sorted by `customer_id`.

**Expected:** 2 columns, 10 rows, in this order. Customer 3 shows a phone number, customers 4 and 10 show NO CONTACT.
<details><summary>Hint</summary><code>COALESCE</code> accepts as many arguments as you like and a text literal can be the last one.</details>

### Exercise 4
Show `customer_id` and `income_band`: HIGH if `annual_income` is 1,000,000 or more, MID if 400,000 or more, LOW for anything below that (0 counts as LOW), and UNKNOWN when the income is NULL. All 10 customers, sorted by `customer_id`.

**Expected:** 2 columns, 10 rows, in this order. 1 HIGH, 3 MID, 2 LOW, 4 UNKNOWN.
<details><summary>Hint</summary>Branches of a <code>CASE</code> are checked top to bottom, so order them from the most specific condition. Remember that a comparison with NULL is never true, so decide where the NULL case goes.</details>

### Exercise 5
Show `customer_id` and `annual_income` for all customers: highest income first, customers with no income (NULL) at the very end, and those NULL rows ordered by `customer_id`.

**Expected:** 2 columns, 10 rows, in this order. The first row is customer 7 (1200000), the last four rows are customers 2, 4, 9, 10.
<details><summary>Hint</summary>In PostgreSQL <code>DESC</code> puts NULLs first by default. Add <code>NULLS LAST</code> after <code>DESC</code>, then a second sort column.</details>

## Check your work
```bash
mvn test -Dtest=SqlLessonCheckTest -Dlesson=02
```

## Done when
All 5 exercises show `[PASS]`. Then tell Lumi.
