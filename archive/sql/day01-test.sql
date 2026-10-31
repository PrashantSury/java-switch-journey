-- Day 01 daily test: SQL (2 questions)
-- (sql/day01.sql already existed, so today's test lives in this file.)
-- Run the schema + INSERTs, then write your query under each question.
-- Watch for the tricky rows: NULL salaries, an employee with no department,
-- a department with no employees, salary ties, and duplicate names.

CREATE TABLE departments (
    dept_id   INT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL
);

CREATE TABLE employees (
    emp_id  INT PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    dept_id INT NULL REFERENCES departments(dept_id),
    salary  INT NULL
);

INSERT INTO departments (dept_id, dept_name) VALUES
    (1, 'Engineering'),
    (2, 'Sales'),
    (3, 'HR'),
    (4, 'Legal');          -- no employees at all

INSERT INTO employees (emp_id, name, dept_id, salary) VALUES
    (1, 'Asha',   1,    90000),
    (2, 'Ravi',   1,    90000),   -- ties with Asha for top in Engineering
    (3, 'Neha',   1,    75000),
    (4, 'Asha',   2,    60000),   -- same name as emp 1, different person
    (5, 'Karan',  2,    NULL),    -- salary unknown
    (6, 'Meera',  2,    55000),
    (7, 'Vikram', 3,    NULL),    -- HR's only employee, salary unknown
    (8, 'Pooja',  NULL, 120000),  -- not assigned to any department
    (9, 'Ravi',   1,    50000);   -- same name as emp 2, same department

-- Q1: For EVERY department (including ones with no employees), show
--     dept_name, headcount (number of employees in it) and avg_salary
--     (average of known salaries, rounded to 2 decimals).
--     A department with no employees must show headcount 0.
--     Sort by headcount descending, then dept_name ascending.
--     Think about: COUNT(*) vs COUNT(column) with a LEFT JOIN, and what AVG does with NULLs.
-- Your query:


-- Q2: List the highest-paid employee(s) in each department: dept_name, emp_id, name, salary.
--     Keep ALL employees who tie for the top salary.
--     Ignore employees with no department and ignore NULL salaries
--     (a department where every salary is NULL should not appear).
--     Sort by dept_name, then emp_id.
--     Try it first WITHOUT window functions (subquery or join on MAX), then with one if you like.
-- Your query:

