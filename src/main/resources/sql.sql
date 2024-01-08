
SELECT * FROM department

DROP TABLE department

SELECT * FROM employee

DELETE FROM employee WHERE empid IN (6)

UPDATE employee SET dept_id =5 WHERE  empid IN (7,8)
UPDATE employee SET dept_id =6 WHERE  empid IN (9,10)
UPDATE employee SET dept_id =7 WHERE  empid IN (11,12,13)

DESC employee

SHOW CREATE TABLE employee;

CREATE TABLE `employee` (
  `empid` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `fk_dept_id` bigint DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `FKdruh5dt7xmj3n939h6ttaluxo` (`fk_dept_id`),
  CONSTRAINT `FKdruh5dt7xmj3n939h6ttaluxo` FOREIGN KEY (`fk_dept_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `department` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
