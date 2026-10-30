-- Lesson 02 exercises: NULL handling and CASE
-- Write ONE query under each marker. Do not edit the "-- @ex N" lines.
-- Check with:  mvn test -Dtest=SqlLessonCheckTest -Dlesson=02

SET search_path TO learn_02;

-- @ex 1
-- Task: customer_id, full_name of customers with NO phone number. Sorted by customer_id.
   SELECT customer_id, full_name
   FROM customers
   WHERE phone is null
   Order By customer_id;

-- @ex 2
-- Task: customer_id, kyc_status of customers whose KYC is anything other than VERIFIED,
--       including those whose kyc_status is NULL. Sorted by customer_id.
SELECT customer_id, kyc_status
FROM customers
WHERE kyc_status !='VERIFIED' OR kyc_status is null
ORDER BY customer_id;

-- @ex 3
-- Task: customer_id and contact. contact = the email if there is one, otherwise the phone,
--       otherwise the text NO CONTACT. All customers, sorted by customer_id.
SELECT customer_id, COALESCE(email,phone, 'NO CONTACT') as contact
FROM customers
ORDER BY customer_id;

-- @ex 4
-- Task: customer_id and income_band. HIGH = income of 1,000,000 or more, MID = 400,000 or more,
--       LOW = anything below that (zero included), UNKNOWN = income is NULL. Sorted by customer_id.
SELECT
    customer_id,
    CASE
        WHEN annual_income IS NULL THEN 'UNKNOWN'
        WHEN annual_income >= 1000000 THEN 'HIGH'
        WHEN annual_income >= 400000 THEN 'MID'
        ELSE 'LOW'
        END AS income_band
FROM customers
ORDER BY customer_id;

-- @ex 5
-- Task: customer_id, annual_income for all customers, highest income first, NULL incomes at the END,
--       ties (the NULLs) by customer_id.
SELECT customer_id, annual_income
FROM customers
ORDER BY
    annual_income DESC NULLS LAST,
    customer_id ASC;
