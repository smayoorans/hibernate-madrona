DROP TABLE IF EXISTS `hibernate_test.employee`;

CREATE TABLE `hibernate_test`.`employee` (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) default NULL,
   age INT  default NULL,
   PRIMARY KEY (id)
);