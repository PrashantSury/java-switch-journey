-- Lesson 02 setup: NULL handling and CASE
-- Safe to run again and again: it rebuilds the schema learn_02 from scratch.

DROP SCHEMA IF EXISTS learn_02 CASCADE;
CREATE SCHEMA learn_02;
SET search_path TO learn_02;

-- Used by the worked example in lesson02.md
CREATE TABLE branches (
    branch_id    INT PRIMARY KEY,
    branch_name  VARCHAR(50) NOT NULL,
    manager_name VARCHAR(50) NULL,         -- NULL = no manager appointed
    closed_on    DATE NULL                 -- NULL = still open
);

-- Used by the exercises
CREATE TABLE customers (
    customer_id   INT PRIMARY KEY,
    full_name     VARCHAR(50) NOT NULL,
    phone         VARCHAR(15) NULL,
    email         VARCHAR(60) NULL,
    city          VARCHAR(30) NULL,
    kyc_status    VARCHAR(10) NULL,        -- VERIFIED, PENDING, REJECTED, or NULL = not started
    annual_income INT NULL
);

INSERT INTO branches VALUES
    (1, 'Pune Main',   'Sunita Apte',  NULL),
    (2, 'Mumbai Fort', NULL,           NULL),
    (3, 'Nashik Road', 'Dilip Nagare', '2024-03-31'),
    (4, 'Kolhapur',    NULL,           '2023-12-31');

-- Tricky rows: missing phone, missing email, both missing, no KYC status, zero income, NULL income
INSERT INTO customers VALUES
    (1,  'Asha Patil',      '9822011111', 'asha@mail.com',   'Pune',   'VERIFIED',  850000),
    (2,  'Rohan Deshmukh',  NULL,         'rohan@mail.com',  'Pune',   'VERIFIED',  NULL),
    (3,  'Meera Joshi',     '9822033333', NULL,              'Mumbai', 'PENDING',   420000),
    (4,  'Vikram Shinde',   NULL,         NULL,              'Mumbai', 'PENDING',   NULL),
    (5,  'Sneha Kulkarni',  '9822055555', 'sneha@mail.com',  'Nashik', NULL,        300000),
    (6,  'Aditya Pawar',    '9822066666', 'aditya@mail.com', 'Nashik', 'REJECTED',  0),
    (7,  'Neha Gaikwad',    NULL,         'neha@mail.com',   'Pune',   'VERIFIED',  1200000),
    (8,  'Karan Mehta',     '9822088888', NULL,              'Pune',   'VERIFIED',  650000),
    (9,  'Pooja Bhosale',   '9822099999', 'pooja@mail.com',  NULL,     'PENDING',   NULL),
    (10, 'Sanjay More',     NULL,         NULL,              NULL,     NULL,        NULL);
