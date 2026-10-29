-- Lesson 03 exercises: aggregates, GROUP BY, HAVING
-- Write ONE query under each marker. Do not edit the "-- @ex N" lines.
-- Check with:  mvn test -Dtest=SqlLessonCheckTest -Dlesson=03

SET search_path TO learn_03;

-- @ex 1
-- Task: ONE row with three numbers: how many accounts exist, how many of them have a balance
--       (not NULL), and how many different account types there are.


-- @ex 2
-- Task: for each status: status, number of accounts, total balance. Sorted by status.


-- @ex 3
-- Task: for each branch_id that has accounts: branch_id, number of accounts, total balance,
--       highest balance. Sorted by branch_id. (Think about what SUM gives when every balance is NULL.)


-- @ex 4
-- Task: branch_id and total balance of ACTIVE accounts, only for branches whose ACTIVE total is
--       MORE than 250000. Biggest total first.


-- @ex 5
-- Task: for ACTIVE accounts only: account_type and the average balance rounded to 2 decimals.
--       Sorted by account_type.

