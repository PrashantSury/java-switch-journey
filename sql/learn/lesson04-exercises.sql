-- Lesson 04 exercises: INNER JOIN and LEFT JOIN
-- Write ONE query under each marker. Do not edit the "-- @ex N" lines.
-- Check with:  mvn test -Dtest=SqlLessonCheckTest -Dlesson=04

SET search_path TO learn_04;

-- @ex 1
-- Task: account_id, full_name (the holder), balance for every account. Sorted by account_id.


-- @ex 2
-- Task: account_id, full_name, branch_name for ACTIVE accounts. Sorted by account_id.


-- @ex 3
-- Task: full_name and number of accounts for EVERY customer (0 if none). Sorted by customer_id.


-- @ex 4
-- Task: branch_name of every branch that has NO ACTIVE account (including branches with no
--       account at all). Sorted by branch_name.


-- @ex 5
-- Task: for EVERY customer: full_name and the total amount of their DEBIT transactions
--       across all their accounts (0 if there are none). Sorted by customer_id.

