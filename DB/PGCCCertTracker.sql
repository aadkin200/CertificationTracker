-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PGCCCertTracker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PGCCCertTracker` ;

-- -----------------------------------------------------
-- Schema PGCCCertTracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PGCCCertTracker` DEFAULT CHARACTER SET utf8 ;
USE `PGCCCertTracker` ;

-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User` ;

CREATE TABLE IF NOT EXISTS `User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(1000) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `admin` TINYINT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `active` TINYINT NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `certification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `certification` ;

CREATE TABLE IF NOT EXISTS `certification` (
  `id` INT NOT NULL,
  `User_id` INT NOT NULL,
  `company` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `date_obtained` DATETIME NULL,
  `date_expiration` DATETIME NULL,
  `certification_number` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_certification_User_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_certification_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `User`
-- -----------------------------------------------------
START TRANSACTION;
USE `PGCCCertTracker`;
INSERT INTO `User` (`id`, `username`, `password`, `email`, `first_name`, `last_name`, `admin`, `created_at`, `updated_at`, `active`, `role`) VALUES (1, 'zone', '$2a$12$hLPT8O2fXqjQiDR/kgPId.cEHolrRd9ZeDZ8aTgOzKDLpEYUdyClG', 'aadkin200@gmail.com', 'Alex', 'Adkins', 1, NULL, NULL, 1, 'Student');

COMMIT;


-- -----------------------------------------------------
-- Data for table `certification`
-- -----------------------------------------------------
START TRANSACTION;
USE `PGCCCertTracker`;
INSERT INTO `certification` (`id`, `User_id`, `company`, `name`, `date_obtained`, `date_expiration`, `certification_number`) VALUES (1, 1, 'CompTIA', 'Security+ CE', NULL, NULL, NULL);
INSERT INTO `certification` (`id`, `User_id`, `company`, `name`, `date_obtained`, `date_expiration`, `certification_number`) VALUES (2, 1, 'CompTIA', 'A+ CE', NULL, NULL, NULL);

COMMIT;

