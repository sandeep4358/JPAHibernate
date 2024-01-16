
SELECT * FROM department

SELECT * FROM employee

SELECT * FROM purchase_order_items

DROP table department


SELECT * FROM employee

DELETE FROM employee WHERE empid IN (6)

UPDATE employee SET dept_id =5 WHERE  empid IN (7,8)
UPDATE employee SET dept_id =6 WHERE  empid IN (9,10)
UPDATE employee SET dept_id =7 WHERE  empid IN (11,12,13)

DESC post_comments

ALTER TABLE employee DROP COLUMN empid; 

ALTER TABLE employee DROP FOREIGN KEY department_id;  


SELECT * FROM department

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


CREATE TABLE `employee` (
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `fk_dept_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) NOT NULL,
  `employee_number` bigint(20) NOT NULL,
  KEY `FKdruh5dt7xmj3n939h6ttaluxo` (`fk_dept_id`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
  CONSTRAINT `FKdruh5dt7xmj3n939h6ttaluxo` FOREIGN KEY (`fk_dept_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
DROP TABLE user_account_posts

CREATE TABLE `department` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


#####Firstly, find out your FOREIGN KEY constraint name in this way:

SELECT
  TABLE_NAME,
  COLUMN_NAME,
  CONSTRAINT_NAME,   -- <<-- the one you want! 
  REFERENCED_TABLE_NAME,
  REFERENCED_COLUMN_NAME
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE
  REFERENCED_TABLE_NAME = 'employee'
  
ALTER TABLE employee DROP FOREIGN KEY FKdruh5dt7xmj3n939h6ttaluxo

#To check the log of the error in mysql
SHOW ENGINE INNODB STATUS

