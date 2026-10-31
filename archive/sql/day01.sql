-- Day 1: SQL practice
-- Write each query under its question. Keep one file per day: day02.sql, day03.sql, ...

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary INT
);

-- Q1: Find the highest salary in each department.
-- SELECT department, MAX(salary) FROM employees GROUP BY department;