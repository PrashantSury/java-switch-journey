-- Lesson 05 exercises: subqueries and EXISTS
-- Write ONE query under each marker. Do not edit the "-- @ex N" lines.
-- Check with:  mvn test -Dtest=SqlLessonCheckTest -Dlesson=05

SET search_path TO learn_05;

-- @ex 1
-- Task: account_id, balance of accounts whose balance is above the average balance of ALL accounts.
--       Biggest balance first.


-- @ex 2
-- Task: full_name of customers who have at least one ACTIVE loan. Each customer once, sorted by full_name.


-- @ex 3
-- Task: account_id of accounts that have at least one POSTED transaction. Sorted by account_id.


-- @ex 4
-- Task: customer_id, full_name of customers who have NEVER been a guarantor on any loan.
--       Sorted by customer_id.


-- @ex 5
-- Task: full_name and total_balance (sum over all their accounts) for customers whose total
--       balance is above 100000. Biggest total first.

