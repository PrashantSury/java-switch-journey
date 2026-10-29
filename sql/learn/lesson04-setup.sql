-- Lesson 04 setup: INNER JOIN and LEFT JOIN
-- Safe to run again and again: it rebuilds the schema learn_04 from scratch.

DROP SCHEMA IF EXISTS learn_04 CASCADE;
CREATE SCHEMA learn_04;
SET search_path TO learn_04;

-- Used by the worked example in lesson04.md
CREATE TABLE borrowers (
    borrower_id INT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL
);

CREATE TABLE loans (
    loan_id     INT PRIMARY KEY,
    borrower_id INT NOT NULL REFERENCES borrowers(borrower_id),
    amount      INT NOT NULL
);

-- Used by the exercises
CREATE TABLE branches (
    branch_id   INT PRIMARY KEY,
    branch_name VARCHAR(50) NOT NULL
);

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    full_name   VARCHAR(50) NOT NULL
);

CREATE TABLE accounts (
    account_id  INT PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customers(customer_id),
    branch_id   INT NOT NULL REFERENCES branches(branch_id),
    balance     INT NOT NULL,
    status      VARCHAR(10) NOT NULL       -- ACTIVE, CLOSED
);

CREATE TABLE transactions (
    txn_id     INT PRIMARY KEY,
    account_id INT NOT NULL REFERENCES accounts(account_id),
    txn_type   VARCHAR(10) NOT NULL,       -- CREDIT, DEBIT
    amount     INT NOT NULL
);

INSERT INTO borrowers VALUES
    (1, 'Prakash Rane'),
    (2, 'Leena Kamat'),
    (3, 'Girish Naik');                     -- has no loan

INSERT INTO loans VALUES
    (10, 1, 500000),
    (11, 1, 90000),
    (12, 2, 750000);

INSERT INTO branches VALUES
    (1, 'Pune Main'),
    (2, 'Mumbai Fort'),
    (3, 'Nashik Road'),
    (4, 'Kolhapur'),                        -- no accounts at all
    (5, 'Nagpur Central');                  -- only a CLOSED account

-- Tricky rows: a customer with no accounts, a customer with two accounts in different branches,
-- accounts with no transactions, two identical debits that are BOTH real
INSERT INTO customers VALUES
    (1, 'Asha Patil'),
    (2, 'Rohan Deshmukh'),
    (3, 'Meera Joshi'),
    (4, 'Vikram Shinde'),                   -- no accounts
    (5, 'Sneha Kulkarni'),
    (6, 'Aditya Pawar');

INSERT INTO accounts VALUES
    (101, 1, 1,  52000, 'ACTIVE'),
    (102, 1, 2,   8200, 'ACTIVE'),          -- no transactions
    (103, 2, 1, 134500, 'ACTIVE'),
    (104, 3, 2,  97000, 'ACTIVE'),
    (105, 3, 2,      0, 'CLOSED'),          -- no transactions
    (106, 5, 3,  15250, 'ACTIVE'),
    (107, 6, 3, 250000, 'ACTIVE'),
    (108, 6, 5,      0, 'CLOSED');          -- no transactions

INSERT INTO transactions VALUES
    (1, 101, 'CREDIT',  5000),
    (2, 101, 'DEBIT',   1200),
    (3, 101, 'DEBIT',   1200),
    (4, 103, 'CREDIT', 20000),
    (5, 104, 'DEBIT',    700),
    (6, 106, 'CREDIT',  3000),
    (7, 107, 'CREDIT', 10000);
