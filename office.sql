use employee;
create table employee(
EmployeeId INT,
Name VARCHAR(50) NOT NULL,
Designation VARCHAR(50),
Salary INT,
ManagerId INT ,
DepartmentId INT
);
INSERT INTO employee (EmployeeId, Name, Designation, Salary, ManagerId, DepartmentId)
VALUES
    (1, 'Mom', 'dev', '100', null,1),
    (2, 'Dad', 'dev', '202', null,2),
    (3,'Krish', 'payroll', '12',1,4),
    (4,'vishu', 'editor','10000',2,3);
    select * from employee;
    
create table Dept (
DeptId INT,
Name VARCHAR(50) NOT NULL
);

INSERT INTO Dept (DeptId, Name)
VALUES
(1,'HR'),
(2, 'Dev'),
(3,'GD'),
(4,'payroll');


select * from Dept;

USE employee;


SELECT * FROM employee;
SELECT * FROM Dept;

SELECT e.EmployeeId, e.Name , e.Designation, e.ManagerId , d.DeptName
FROM employee e
JOIN Dept d ON e.DepartmentId = d.DeptId;





    

