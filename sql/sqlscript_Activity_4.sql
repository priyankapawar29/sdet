REM   Script: SQL_Activity_4
REM   SQL activity 4

-- Add the grade column
ALTER TABLE salesman ADD grade int;

-- Update the values in the grade column
UPDATE salesman SET grade=100;

-- Display data
SELECT * FROM salesman;
