-- Lesson 03 setup: aggregates, GROUP BY, HAVING
-- Safe to run again and again: it rebuilds the schema learn_03 from scratch.

DROP SCHEMA IF EXISTS learn_03 CASCADE;
CREATE SCHEMA learn_03;
SET search_path TO learn_03;

-- Used by the worked example in lesson03.md
CREATE TABLE loans (
    loan_id        INT PRIMARY KEY,
    loan_type      VARCHAR(10) NOT NULL,   -- HOME, CAR, PERSONAL
    principal      INT NOT NULL,
    interest_rate  NUMERIC(4,2) NOT NULL
);

-- Used by the exercises
CREATE TABLE branches (
    branch_id   INT PRIMARY KEY,
    branch_name VARCHAR(50) NOT NULL
);

CREATE TABLE accounts (
    account_id   INT PRIMARY KEY,
    branch_id    INT NOT NULL REFERENCES branches(branch_id),
    account_type VARCHAR(10) NOT NULL,      -- SAVINGS, CURRENT, FIXED
    balance      NUMERIC(12,2) NULL,        -- NULL = not reconciled yet
    status       VARCHAR(10) NOT NULL       -- ACTIVE, CLOSED
);

INSERT INTO loans VALUES
    (1, 'HOME',     4500000, 8.50),
    (2, 'HOME',     6000000, 8.75),
    (3, 'CAR',       800000, 9.40),
    (4, 'PERSONAL',  200000, 12.00),
    (5, 'CAR',      1200000, 9.60),
    (6, 'HOME',     3000000, 8.40);

INSERT INTO branches VALUES
    (1, 'Pune Main'),
    (2, 'Mumbai Fort'),
    (3, 'Nashik Road'),
    (4, 'Kolhapur'),
    (5, 'Nagpur Central');                  -- no accounts at all

-- Tricky rows: NULL balances, a branch where EVERY balance is NULL, a branch with no accounts,
-- an overdrawn account, ties
INSERT INTO accounts VALUES
    (1,  1, 'SAVINGS',   52000.00, 'ACTIVE'),
    (2,  1, 'CURRENT',  134500.50, 'ACTIVE'),
    (3,  1, 'SAVINGS',       NULL, 'ACTIVE'),
    (4,  1, 'SAVINGS',    3100.75, 'CLOSED'),
    (5,  2, 'SAVINGS',    8200.00, 'ACTIVE'),
    (6,  2, 'FIXED',    250000.00, 'ACTIVE'),
    (7,  2, 'CURRENT',   -1500.00, 'ACTIVE'),
    (8,  2, 'SAVINGS',   97000.00, 'ACTIVE'),
    (9,  3, 'SAVINGS',       NULL, 'ACTIVE'),
    (10, 3, 'CURRENT',       NULL, 'CLOSED'),
    (11, 4, 'FIXED',    250000.00, 'ACTIVE'),
    (12, 4, 'SAVINGS',    8200.00, 'ACTIVE'),
    (13, 4, 'SAVINGS',    8200.00, 'CLOSED'),
    (14, 4, 'CURRENT',   15250.00, 'ACTIVE');
