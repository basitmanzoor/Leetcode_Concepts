# Write your MySQL query statement below
SELECT employee_id, 
    CASE
        WHEN employee_id % 2 = 0 then 0
        WHEN name like 'M%' then 0
        else salary
    END AS bonus
from Employees order by employee_id;