-- Day 03 (Sunday) REVISION test: SQL (2 questions)
-- Revises Day 01 (top-N per group with ties, NULLs, empty groups) and
-- Day 02 (LEFT JOIN + COALESCE, filtering in ON vs WHERE, duplicates that are real rows).
-- Banking flavour, but in its own schema "day03" so it never touches your
-- Flyway-managed core tables. Run in pgAdmin against java_switch (PostgreSQL).
-- Write your query under each question (or paste into sql/day03-answers.md).
--
-- Tricky rows: a branch with no accounts, a branch whose only ACTIVE account has a
-- NULL balance, a CLOSED account with the biggest balance, a tie for top balance,
-- an overdrawn (negative) balance, a customer with no accounts, a customer whose
-- only transaction was REVERSED, a POSTED transaction with a NULL amount,
-- two identical-looking debits that are both real, and duplicate customer names.

CREATE SCHEMA IF NOT EXISTS day03;
SET search_path TO day03;

CREATE TABLE branches (
    branch_id   INT PRIMARY KEY,
    branch_name VARCHAR(50) NOT NULL,
    city        VARCHAR(50) NOT NULL
);

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL
);

CREATE TABLE accounts (
    account_id  INT PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customers(customer_id),
    branch_id   INT NOT NULL REFERENCES branches(branch_id),
    balance     INT NULL,                 -- NULL = not yet reconciled
    status      VARCHAR(10) NOT NULL      -- 'ACTIVE' or 'CLOSED'
);

CREATE TABLE transactions (
    txn_id     INT PRIMARY KEY,
    account_id INT NOT NULL REFERENCES accounts(account_id),
    txn_type   VARCHAR(10) NOT NULL,      -- 'CREDIT' or 'DEBIT'
    amount     INT NULL,                  -- NULL = amount not known yet
    status     VARCHAR(10) NOT NULL,      -- 'POSTED' or 'REVERSED'
    txn_date   DATE NOT NULL
);

INSERT INTO branches (branch_id, branch_name, city) VALUES
    (1, 'Camp',       'Pune'),
    (2, 'Hinjewadi',  'Pune'),
    (3, 'Fort',       'Mumbai'),
    (4, 'Sitabuldi',  'Nagpur');      -- no accounts at all

INSERT INTO customers (customer_id, name) VALUES
    (1, 'Aarav'),
    (2, 'Diya'),
    (3, 'Kabir'),
    (4, 'Isha'),
    (5, 'Rohan'),     -- no accounts at all
    (6, 'Aarav'),     -- same name as customer 1, different person
    (7, 'Meera');     -- only transaction is REVERSED

INSERT INTO accounts (account_id, customer_id, branch_id, balance, status) VALUES
    (101, 1, 1, 50000, 'ACTIVE'),
    (102, 2, 1, 50000, 'ACTIVE'),     -- ties with 101 for top in Camp
    (103, 3, 1, 20000, 'ACTIVE'),
    (104, 4, 2, NULL,  'ACTIVE'),     -- balance unknown
    (105, 6, 2, 15000, 'ACTIVE'),
    (106, 1, 2, 90000, 'CLOSED'),     -- biggest number, but CLOSED
    (109, 6, 2, -5000, 'ACTIVE'),     -- overdrawn
    (107, 7, 3, NULL,  'ACTIVE'),     -- Fort's only ACTIVE account, balance unknown
    (108, 3, 3, 70000, 'CLOSED');

INSERT INTO transactions (txn_id, account_id, txn_type, amount, status, txn_date) VALUES
    (1001, 101, 'CREDIT', 10000, 'POSTED',   '2026-10-19'),
    (1002, 101, 'DEBIT',   2500, 'POSTED',   '2026-10-20'),
    (1003, 106, 'CREDIT',  5000, 'POSTED',   '2026-10-01'),   -- account closed later, still counts
    (1004, 102, 'CREDIT',  7500, 'POSTED',   '2026-10-19'),
    (1005, 102, 'DEBIT',   1000, 'POSTED',   '2026-10-21'),
    (1006, 102, 'DEBIT',   1000, 'POSTED',   '2026-10-21'),   -- looks like 1005, but a real second debit
    (1007, 103, 'CREDIT',  NULL, 'POSTED',   '2026-10-22'),   -- amount not known yet
    (1008, 105, 'DEBIT',   3000, 'POSTED',   '2026-10-22'),
    (1009, 109, 'CREDIT',  3000, 'POSTED',   '2026-10-23'),
    (1010, 107, 'CREDIT',  8000, 'REVERSED', '2026-10-23'),   -- Meera's only transaction
    (1011, 104, 'DEBIT',   4000, 'REVERSED', '2026-10-24'),
    (1012, 104, 'CREDIT',  2000, 'POSTED',   '2026-10-24');

-- Q1 (revises Day 01): For EVERY branch, show the ACTIVE account(s) with the highest
--     known balance. If accounts tie, return all of them. Ignore CLOSED accounts and
--     NULL balances. A branch with no qualifying account must still appear exactly
--     once, with NULL account_id, customer name and balance.
--     Show branch_id, branch_name, account_id, name, balance,
--     sorted by branch_id, then account_id.



-- Q2 (revises Day 02): For EVERY customer (including those with no accounts), show
--     customer_id, name, posted_count (number of POSTED transactions across all their
--     accounts, ACTIVE or CLOSED, counting rows even if amount is NULL) and net_flow
--     (sum of known POSTED CREDIT amounts minus sum of known POSTED DEBIT amounts).
--     Customers with nothing to count must show posted_count 0 and net_flow 0, never NULL.
--     Sort by net_flow descending, then customer_id ascending.



-- Cleanup when you're done:
-- DROP SCHEMA day03 CASCADE;
