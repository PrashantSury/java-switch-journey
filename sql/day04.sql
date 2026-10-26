-- Day 04 (Week 1, Monday) evening test: SQL (2 questions)
-- Topic: JOINs. INNER vs LEFT, filtering in ON vs WHERE, and the anti-join
-- ("customers who did NOT do X") with NOT EXISTS / LEFT JOIN ... IS NULL / NOT IN.
-- Banking flavour (loans and EMI payments), in its own schema "day04" so it never
-- touches your Flyway-managed core tables. Run in pgAdmin against java_switch (PostgreSQL).
-- Write your query under each question (or paste into sql/day04-answers.md).
--
-- Tricky rows: a loan with no payments at all, a loan whose only payment FAILED,
-- a SUCCESS payment with a NULL amount, two identical-looking payments that are both
-- real, a payment on the last day of the month and one on the first day of the next,
-- a SUCCESS payment with NULL loan_id (money in suspense, not matched to any loan),
-- a CLOSED loan that was paid, a customer with no loans, a customer with a NULL city,
-- two customers with the same name, and two loans tied on outstanding amount.

CREATE SCHEMA IF NOT EXISTS day04;
SET search_path TO day04;

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    city        VARCHAR(50) NULL          -- NULL = address not captured
);

CREATE TABLE loans (
    loan_id     INT PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customers(customer_id),
    loan_type   VARCHAR(10) NOT NULL,     -- 'HOME', 'CAR', 'PERSONAL', 'EDU'
    principal   INT NOT NULL,
    status      VARCHAR(10) NOT NULL      -- 'ACTIVE' or 'CLOSED'
);

CREATE TABLE emi_payments (
    payment_id INT PRIMARY KEY,
    loan_id    INT NULL REFERENCES loans(loan_id),  -- NULL = in suspense, not matched to a loan yet
    amount     INT NULL,                            -- NULL = amount not confirmed by the bank yet
    status     VARCHAR(10) NOT NULL,                -- 'SUCCESS', 'FAILED' or 'BOUNCED'
    paid_on    DATE NOT NULL
);

INSERT INTO customers (customer_id, name, city) VALUES
    (1, 'Aarav', 'Pune'),
    (2, 'Diya',  'Pune'),
    (3, 'Kabir', 'Mumbai'),
    (4, 'Isha',  NULL),        -- city not captured
    (5, 'Rohan', 'Nagpur'),    -- no loans at all
    (6, 'Aarav', 'Mumbai'),    -- same name as customer 1, different person
    (7, 'Meera', 'Pune'),      -- only a CLOSED loan
    (8, 'Neha',  'Pune');

INSERT INTO loans (loan_id, customer_id, loan_type, principal, status) VALUES
    (201, 1, 'HOME',     500000, 'ACTIVE'),
    (202, 1, 'CAR',      200000, 'ACTIVE'),   -- only payment FAILED
    (203, 2, 'PERSONAL', 100000, 'ACTIVE'),
    (204, 3, 'HOME',     800000, 'ACTIVE'),
    (205, 4, 'PERSONAL',  50000, 'ACTIVE'),   -- no payments at all
    (206, 6, 'CAR',      300000, 'ACTIVE'),
    (207, 7, 'PERSONAL',  60000, 'CLOSED'),
    (208, 8, 'EDU',      200000, 'ACTIVE'),
    (209, 8, 'CAR',      100000, 'CLOSED');

INSERT INTO emi_payments (payment_id, loan_id, amount, status, paid_on) VALUES
    (3001, 201, 20000, 'SUCCESS', '2026-10-05'),
    (3002, 202, 10000, 'FAILED',  '2026-10-05'),
    (3003, 203,  5000, 'SUCCESS', '2026-09-30'),
    (3004, 203,  5000, 'BOUNCED', '2026-10-30'),
    (3005, 204, 25000, 'SUCCESS', '2026-10-31'),   -- last day of October
    (3006, 204, 25000, 'SUCCESS', '2026-09-30'),
    (3007, 206, 15000, 'SUCCESS', '2026-11-01'),   -- first day of November
    (3008, 206, 15000, 'SUCCESS', '2026-11-01'),   -- looks like 3007, but a real second payment
    (3009, 208,  NULL, 'SUCCESS', '2026-09-15'),   -- amount not confirmed yet
    (3010, 209,  8000, 'SUCCESS', '2026-10-12'),   -- paid on a CLOSED loan
    (3011, NULL, 12000, 'SUCCESS', '2026-10-15'),  -- in suspense, no loan_id
    (3012, 207,  6000, 'SUCCESS', '2026-10-02');   -- Meera's CLOSED loan

-- Q1: For EVERY ACTIVE loan (including loans with no payments, or only failed ones),
--     show loan_id, customer name, loan_type, principal,
--     success_count (number of SUCCESS payments, counting a row even if its amount is NULL),
--     total_repaid  (sum of known SUCCESS amounts) and
--     outstanding   (principal - total_repaid).
--     Loans with nothing to count must show success_count 0 and total_repaid 0, never NULL,
--     and outstanding must never be NULL either. Ignore payments with NULL loan_id.
--     Sort by outstanding descending, then loan_id ascending.



-- Q2: Collections team list. Find customers who have at least one ACTIVE loan but made
--     NO SUCCESS payment in October 2026 (1 Oct to 31 Oct inclusive) on ANY of their
--     ACTIVE loans. A payment on a CLOSED loan does not count; a payment with NULL loan_id
--     belongs to nobody. Each customer appears once.
--     Show customer_id, name, and city (show 'UNKNOWN' when city is NULL),
--     sorted by customer_id.
--     Bonus: write it twice, once with NOT EXISTS and once with NOT IN, and explain why
--     the naive NOT IN version (subquery over emi_payments.loan_id) returns a different result.



-- Cleanup when you're done:
-- DROP SCHEMA day04 CASCADE;
