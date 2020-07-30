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

INSERT INTO employee(name, age, gender, company_id) VALUES
('AAAA','11','male','1'),
('BBBB','11','male','1'),
('CCCC','11','female','1'),
('DDDD','11','male','1'),
('EEEE','11','female','2'),
('FFFF','11','female','2'),
('GGGG','11','female','2'),
('HHHH','11','female','2');

CREATE TABLE company
(
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100)
);

INSERT INTO company(name) VALUES ('oocl') , VALUES ('tw');