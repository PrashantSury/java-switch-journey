-- Lesson 01 exercises: SELECT, WHERE, ORDER BY, LIMIT
-- Write ONE query under each marker. Do not delete or edit the "-- @ex N" lines:
-- the checker uses them to find your answers.
-- Tip: run lesson01-setup.sql first, then try your query in pgAdmin before checking.
-- Check with:  mvn test -Dtest=SqlLessonCheckTest -Dlesson=01

SET search_path TO learn_01;

-- @ex 1
-- Task: holder_name and balance of every account at branch 2, sorted by holder_name (A to Z).
SELECT holder_name, balance
FROM accounts
WHERE branch_id = 2
ORDER BY holder_name ASC;

-- @ex 2
-- Task: account_id, holder_name, account_type of ACTIVE accounts that are SAVINGS or FIXED
--       and were opened on or after 2022-01-01.
SELECT account_id,holder_name, account_type
FROM accounts
WHERE account_type IN ('SAVINGS','FIXED')
AND opened_on >= '2022-01-01'
AND status = 'ACTIVE';

-- @ex 3
-- Task: account_id, holder_name where the name contains "an" in any letter case. Sorted by account_id.
SELECT account_id,holder_name
FROM accounts
WHERE LOWER(holder_name) LIKE '%an%'
Order By account_id;

-- @ex 4
-- Task: account_id, balance of the top 3 ACTIVE accounts by balance. Ties: the older account wins.
SELECT account_id, balance
FROM accounts
WHERE status = 'ACTIVE'
ORDER BY balance DESC, opened_on ASC
LIMIT 3;

-- @ex 5
-- Task: the distinct branch_id values of ACTIVE accounts with balance below 10000, sorted ascending.
SELECT DISTINCT branch_id
FROM accounts
WHERE status = 'ACTIVE'
AND balance < 10000
ORDER BY branch_id;
