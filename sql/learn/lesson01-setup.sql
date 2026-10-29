-- Lesson 01 setup: SELECT, WHERE, ORDER BY, LIMIT
-- Safe to run again and again: it rebuilds the schema learn_01 from scratch.
-- Run this in pgAdmin (Query Tool) on your scratch database, then open lesson01.md.

DROP SCHEMA IF EXISTS learn_01 CASCADE;
CREATE SCHEMA learn_01;
SET search_path TO learn_01;

-- Used by the worked example in lesson01.md
CREATE TABLE branches (
    branch_id    INT PRIMARY KEY,
    branch_name  VARCHAR(50) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    opened_year  INT NOT NULL
);

-- Used by the exercises
CREATE TABLE accounts (
    account_id   INT PRIMARY KEY,
    holder_name  VARCHAR(50) NOT NULL,
    branch_id    INT NOT NULL,
    account_type VARCHAR(10) NOT NULL,      -- SAVINGS, CURRENT, FIXED
    balance      NUMERIC(12,2) NOT NULL,
    status       VARCHAR(10) NOT NULL,      -- ACTIVE, CLOSED
    opened_on    DATE NOT NULL
);

INSERT INTO branches VALUES
    (1, 'Pune Main',   'Pune',     2005),
    (2, 'Mumbai Fort', 'Mumbai',   1998),
    (3, 'Nashik Road', 'Nashik',   2010),
    (4, 'Pune Camp',   'Pune',     2012),
    (5, 'Kolhapur',    'Kolhapur', 2018);

-- Tricky rows: ties on balance, an overdrawn account, closed accounts with money
INSERT INTO accounts VALUES
    (101, 'Asha Patil',      1, 'SAVINGS',   52000.00, 'ACTIVE', '2021-03-15'),
    (102, 'Rohan Deshmukh',  1, 'CURRENT',  134500.50, 'ACTIVE', '2020-07-01'),
    (103, 'Meera Joshi',     2, 'SAVINGS',   8200.00,  'ACTIVE', '2022-11-20'),
    (104, 'Vikram Shinde',   2, 'FIXED',    250000.00, 'ACTIVE', '2019-01-10'),
    (105, 'Sneha Kulkarni',  3, 'SAVINGS',   8200.00,  'ACTIVE', '2023-02-05'),
    (106, 'Aditya Pawar',    3, 'CURRENT',      0.00,  'CLOSED', '2018-09-30'),
    (107, 'Neha Gaikwad',    1, 'SAVINGS',   52000.00, 'ACTIVE', '2024-01-18'),
    (108, 'Karan Mehta',     2, 'CURRENT',  -1500.00,  'ACTIVE', '2021-06-12'),
    (109, 'Pooja Bhosale',   3, 'FIXED',    250000.00, 'ACTIVE', '2022-08-08'),
    (110, 'Sanjay More',     1, 'SAVINGS',   3100.75,  'CLOSED', '2022-05-25'),
    (111, 'Anita Rao',       2, 'SAVINGS',   97000.00, 'ACTIVE', '2020-12-01'),
    (112, 'Rahul Kadam',     3, 'CURRENT',  15250.00,  'ACTIVE', '2023-09-14');
