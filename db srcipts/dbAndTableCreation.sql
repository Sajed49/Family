create database familyDB;

CREATE TABLE `familyDB`.`address` (
	`address_id` INT NOT NULL AUTO_INCREMENT ,
	`street` VARCHAR(120) NOT NULL DEFAULT '' ,
	`city` VARCHAR(25) NOT NULL DEFAULT '' ,
	`state` VARCHAR(25) NOT NULL DEFAULT '' ,
	`country` VARCHAR(25) NOT NULL DEFAULT '' ,
	`zip` VARCHAR(25) NOT NULL DEFAULT '' ,
	`is_deleted` TINYINT NOT NULL DEFAULT false ,
PRIMARY KEY (`address_id`)
) ENGINE = InnoDB;

CREATE TABLE `familyDB`.`adult` (
	`adult_id` INT NOT NULL AUTO_INCREMENT ,
	`first_name` VARCHAR(30) NOT NULL DEFAULT '' ,
	`last_name` VARCHAR(30) NULL DEFAULT NULL ,
	`address_id` INT NOT NULL ,
	`is_deleted` TINYINT NOT NULL DEFAULT false ,
PRIMARY KEY (`adult_id`),
FOREIGN KEY (`address_id`) REFERENCES `address`(`address_id`)
) ENGINE = InnoDB;

CREATE TABLE `familyDB`.`child` (
	`child_id` INT NOT NULL AUTO_INCREMENT ,
	`adult_id` INT NOT NULL ,
	`first_name` VARCHAR(30) NOT NULL DEFAULT '' ,
	`last_name` VARCHAR(30) NULL DEFAULT NULL ,
	`is_deleted` TINYINT NOT NULL DEFAULT false ,
PRIMARY KEY (`child_id`),
FOREIGN KEY (`adult_id`) REFERENCES `adult`(`adult_id`)
) ENGINE = InnoDB;


