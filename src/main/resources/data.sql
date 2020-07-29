DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS company;

CREATE TABLE employee
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100),
    age INT,
    gender varchar(10),
    company_id INT
);

INSERT INTO employee(name, age, gender) VALUES
('AAAA','11','male'),
('BBBB','11','male'),
('CCCC','11','female'),
('DDDD','11','male'),
('EEEE','11','female'),
('FFFF','11','female'),
('GGGG','11','female'),
('HHHH','11','female');

CREATE TABLE company
(
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100)
);

INSERT INTO company(name) VALUES ('oocl');