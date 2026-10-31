-- Day 02 daily test: SQL (2 questions)
-- Run the schema + INSERTs, then write your query under each question.
-- Works in PostgreSQL / MySQL 8 (window functions allowed).
-- Watch for the tricky rows: a customer with no orders, a customer whose only
-- order is CANCELLED, NULL amounts, NULL city, exact ties, and a duplicated order line.

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    city        VARCHAR(50) NULL
);

CREATE TABLE orders (
    order_id    INT PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customers(customer_id),
    order_date  DATE NOT NULL,
    amount      INT NULL,
    status      VARCHAR(20) NOT NULL   -- 'DELIVERED', 'CANCELLED', 'PENDING'
);

INSERT INTO customers (customer_id, name, city) VALUES
    (1, 'Aarav',  'Pune'),
    (2, 'Diya',   'Pune'),
    (3, 'Kabir',  'Mumbai'),
    (4, 'Isha',   'Mumbai'),
    (5, 'Rohan',  'Pune'),     -- no orders at all
    (6, 'Sneha',  NULL),       -- city unknown
    (7, 'Aarav',  'Mumbai'),   -- same name as customer 1, different person
    (8, 'Tanvi',  'Delhi');    -- only order is CANCELLED

INSERT INTO orders (order_id, customer_id, order_date, amount, status) VALUES
    (101, 1, '2026-10-01', 500,  'DELIVERED'),
    (102, 1, '2026-10-03', 700,  'DELIVERED'),
    (103, 2, '2026-10-02', 1200, 'DELIVERED'),   -- ties with Aarav(1) total 1200 in Pune
    (104, 3, '2026-10-02', 900,  'DELIVERED'),
    (105, 3, '2026-10-05', NULL, 'PENDING'),     -- amount not known yet
    (106, 4, '2026-10-04', 300,  'DELIVERED'),
    (107, 4, '2026-10-04', 300,  'DELIVERED'),   -- same day, same amount (two real orders)
    (108, 4, '2026-10-06', 2000, 'CANCELLED'),   -- cancelled, must not count as spend
    (109, 6, '2026-10-07', 450,  'DELIVERED'),
    (110, 7, '2026-10-08', 600,  'PENDING'),
    (111, 8, '2026-10-09', 999,  'CANCELLED'),   -- Tanvi's only order
    (112, 7, '2026-10-08', 600,  'DELIVERED');   -- same day and amount as order 110

-- Q1: For EVERY customer (including those with no orders), show customer_id,
--     name, order_count (number of non-cancelled orders) and total_spend
--     (sum of known amounts of non-cancelled orders).
--     Customers with nothing to count must show order_count 0 and total_spend 0, never NULL.
--     Sort by total_spend descending, then customer_id ascending.



-- Q2: For each city, find the customer(s) with the highest total_spend
--     (non-cancelled orders, known amounts only). If customers tie, return all
--     of them. Ignore customers whose city is NULL and customers with total_spend 0.
--     Show city, customer_id, name, total_spend, sorted by city, then customer_id.



