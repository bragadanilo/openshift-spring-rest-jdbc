CREATE SCHEMA `app-tomcat` ;

CREATE TABLE `app-tomcat`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `app-tomcat`.`person` (`name`, `email`) VALUES ('My Name', 'My@email.com');
INSERT INTO `app-tomcat`.`person` (`name`, `email`) VALUES ('Other Name', 'other@email.com');
