CREATE DATABASE IF NOT EXISTS `openhouseai_exercise`;
USE `openhouseai_exercise`;

DROP TABLE IF EXISTS `action`;
DROP TABLE IF EXISTS properties;
DROP TABLE IF EXISTS `log`;

CREATE TABLE `log`
(
    `log_id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(15) NOT NULL,
    `session_id` VARCHAR(15) NOT NULL,
    `save_date` DATETIME,
    `log_type` VARCHAR(10),

    PRIMARY KEY (`log_id`)
);

CREATE TABLE properties
(
    `properties_id` INT(11) NOT NULL AUTO_INCREMENT,
    `location_x` INT(2),
    `location_y` INT(2),
    `viewed_id` VARCHAR(15),
    `page_from` VARCHAR(40),
    `page_to` VARCHAR(40),

    PRIMARY KEY (properties_id)
);

CREATE TABLE `action`
(
    `action_id` INT(11) NOT NULL AUTO_INCREMENT,
    `properties_id` INT(11),
    `log_id` INT(11),
    `time` DATETIME,
    `type` VARCHAR(10),

    PRIMARY KEY (`action_id`),
    CONSTRAINT `action_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `log` (`log_id`),
    CONSTRAINT `action_properties_id_fk` FOREIGN KEY (`properties_id`) REFERENCES properties (properties_id)
);