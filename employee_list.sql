DROP DATABASE IF EXISTS employee_list;
CREATE DATABASE employee_list;
USE employee_list; 
DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
 employeeID int primary key auto_increment,
 FirstName VARCHAR(50),
 LastName VARCHAR(50),
 Email VARCHAR(100), 
 PhoneNumber VARCHAR(20)
);

insert into employee values (null,
							"Fred", 
							"Flintstone", 
							"fred@email.com",
							"234-4567");

insert into employee values (null,
							"Barney", 
							"Ruble", 
							"barney@email.com",
							"444-4564");