-- Lesson 05 setup: subqueries and EXISTS
-- Safe to run again and again: it rebuilds the schema learn_05 from scratch.

DROP SCHEMA IF EXISTS learn_05 CASCADE;
CREATE SCHEMA learn_05;
SET search_path TO learn_05;

-- Used by the worked example in lesson05.md
CREATE TABLE branches (
    branch_id   INT PRIMARY KEY,
    branch_name VARCHAR(50) NOT NULL
);

CREATE TABLE staff (
    staff_id   INT PRIMARY KEY,
    staff_name VARCHAR(50) NOT NULL,
    branch_id  INT NOT NULL REFERENCES branches(branch_id),
    salary     INT NOT NULL
);

-- Used by the exercises
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    full_name   VARCHAR(50) NOT NULL
);

CREATE TABLE accounts (
    account_id  INT PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customers(customer_id),
    balance     NUMERIC(12,2) NULL,         -- NULL = not reconciled yet
    status      VARCHAR(10) NOT NULL        -- ACTIVE, CLOSED
);

CREATE TABLE transactions (
    txn_id     INT PRIMARY KEY,
    account_id INT NOT NULL REFERENCES accounts(account_id),
    txn_type   VARCHAR(10) NOT NULL,        -- CREDIT, DEBIT
    amount     INT NOT NULL,
    txn_status VARCHAR(10) NOT NULL         -- POSTED, REVERSED
);

CREATE TABLE loans (
    loan_id      INT PRIMARY KEY,
    customer_id  INT NOT NULL REFERENCES customers(customer_id),
    guarantor_id INT NULL REFERENCES customers(customer_id),   -- NULL = no guarantor
    amount       INT NOT NULL,
    status       VARCHAR(10) NOT NULL       -- ACTIVE, CLOSED
);

INSERT INTO branches VALUES
    (1, 'Pune Main'),
    (2, 'Mumbai Fort'),
    (3, 'Nashik Road');

INSERT INTO staff VALUES
    (1, 'Sunita Apte',   1, 90000),
    (2, 'Dilip Nagare',  1, 60000),
    (3, 'Ravi Menon',    2, 75000),
    (4, 'Farah Sheikh',  2, 120000),
    (5, 'Omkar Tilak',   3, 55000),
    (6, 'Leela Kamble',  3, 75000);

INSERT INTO customers VALUES
    (1, 'Asha Patil'),
    (2, 'Rohan Deshmukh'),
    (3, 'Meera Joshi'),
    (4, 'Vikram Shinde'),
    (5, 'Sneha Kulkarni'),
    (6, 'Aditya Pawar'),
    (7, 'Neha Gaikwad');

-- Tricky rows: a NULL balance, a CLOSED account with the biggest balance, accounts with no transactions
INSERT INTO accounts VALUES
    (201, 1,  52000.00, 'ACTIVE'),
    (202, 1,   8200.00, 'ACTIVE'),
    (203, 2, 134500.00, 'ACTIVE'),
    (204, 3,  97000.00, 'ACTIVE'),
    (205, 3,      0.00, 'CLOSED'),
    (206, 5,  15250.00, 'ACTIVE'),
    (207, 6, 250000.00, 'CLOSED'),
    (208, 7,       NULL, 'ACTIVE');

-- Tricky rows: account 204 has ONLY a reversed transaction
INSERT INTO transactions VALUES
    (1, 201, 'CREDIT',  5000, 'POSTED'),
    (2, 201, 'DEBIT',   1200, 'POSTED'),
    (3, 203, 'CREDIT', 20000, 'POSTED'),
    (4, 204, 'DEBIT',    700, 'REVERSED'),
    (5, 206, 'CREDIT',  3000, 'POSTED'),
    (6, 207, 'DEBIT',  50000, 'POSTED');

-- Tricky rows: several loans have NO guarantor (NULL), a customer with two ACTIVE loans
INSERT INTO loans VALUES
    (1, 1, 2,    500000, 'ACTIVE'),
    (2, 2, NULL, 200000, 'CLOSED'),
    (3, 3, 1,    750000, 'ACTIVE'),
    (4, 5, NULL, 120000, 'ACTIVE'),
    (5, 1, 3,     90000, 'CLOSED'),
    (6, 1, 3,     30000, 'ACTIVE');
