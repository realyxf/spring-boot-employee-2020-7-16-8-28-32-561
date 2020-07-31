CREATE TABLE employee
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100),
    age INT,
    gender varchar(10),
    company_id INT
);


CREATE TABLE company
(
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100)
);
