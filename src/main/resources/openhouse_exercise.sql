CREATE DATABASE IF NOT EXISTS `openhouseai_exercise`;
USE `openhouseai_exercise`;

DROP TABLE IF EXISTS `property`;
DROP TABLE IF EXISTS `action`;
DROP TABLE IF EXISTS `log`;

CREATE TABLE `log`
(
    `log_id` INT(11) NOT NULL AUTO_INCREMENT,
    `userId` VARCHAR(15) NOT NULL,
    `sessionId` VARCHAR(15) NOT NULL,

    CONSTRAINT `log_id_pk` PRIMARY KEY (`log_id`)
);


CREATE TABLE `action`
(
    `action_id` INT(11) NOT NULL AUTO_INCREMENT,
    `log_id` INT(11) NOT NULL,
    `time` DATE,
    `type` VARCHAR(10),

    CONSTRAINT `action_id_pk` PRIMARY KEY (`action_id`),
    CONSTRAINT `action_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `log` (`log_id`)
);

CREATE TABLE `property`
(
    `property_id` INT(11) NOT NULL AUTO_INCREMENT,
    `action_id` INT(11) NOT NULL,
    `location_x` INT(2),
    `location_y` INT(2),
    `viewed_id` VARCHAR(15),
    `pageFrom` VARCHAR(40),
    `pageTo` VARCHAR(40),

    CONSTRAINT `property_id_pk` PRIMARY KEY (`property_id`),
    CONSTRAINT `property_action_id_fk` FOREIGN KEY (`action_id`) REFERENCES `action` (`action_id`)
);