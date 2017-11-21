-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema winesdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `winesdb` ;

-- -----------------------------------------------------
-- Schema winesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `winesdb` DEFAULT CHARACTER SET utf8 ;
USE `winesdb` ;

-- -----------------------------------------------------
-- Table `wine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wine` ;

CREATE TABLE IF NOT EXISTS `wine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NULL,
  `bottle_size` DOUBLE NULL,
  `abv` DOUBLE NULL,
  `price` DECIMAL(8,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO wino@localhost;
 DROP USER wino@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'wino'@'localhost' IDENTIFIED BY 'wino';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'wino'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wine`
-- -----------------------------------------------------
START TRANSACTION;
USE `winesdb`;
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (1, 'Champagne Brut Yellow Label', 375, 12, 38.93);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (2, 'Veuve Clicquot Brut Chapagne', 375, 12, 27.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (3, 'Gabbiano Chianti Classico D.O.G.C.', 750, 13, 12.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (4, 'Risata Moscato D\'Asti', 750, 11, 11.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (5, 'Veuve Clicquot Brut Rose Chapagne', 750, 12.5, 12.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (6, 'Cupcake Vineyards Moscato D\'Asti', 750, 5.5, 10.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (7, 'Barefoot Bubbly Pink Moscato', 750, 9.58, 10.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (8, 'Barefoot Moscato', 750, 9, 5.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (9, 'Barefoot Red Moscato', 750, 9, 5.99);
INSERT INTO `wine` (`id`, `name`, `bottle_size`, `abv`, `price`) VALUES (10, 'Barefoot Pink Moscato', 750, 9.58, 5.99);

COMMIT;
