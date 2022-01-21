-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema peliculasdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema peliculasdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `peliculasdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `peliculasdb` ;

-- -----------------------------------------------------
-- Table `peliculasdb`.`actores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculasdb`.`actores` (
  `idactores` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `nacionalidad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idactores`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peliculasdb`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculasdb`.`peliculas` (
  `idPeliculas` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(250) NULL DEFAULT NULL,
  `anio` INT NULL DEFAULT NULL,
  `duracion` INT NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `sinopsis` VARCHAR(45) NULL DEFAULT NULL,
  `genero` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idPeliculas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peliculasdb`.`pelicula_actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculasdb`.`pelicula_actor` (
  `idpeliculaActor` INT NOT NULL AUTO_INCREMENT,
  `actores_idactores` INT NOT NULL,
  `peliculas_idPeliculas` INT NOT NULL,
  PRIMARY KEY (`idpeliculaActor`, `actores_idactores`, `peliculas_idPeliculas`),
  INDEX `fk_peliculaactor_actores_idx` (`actores_idactores` ASC) VISIBLE,
  INDEX `fk_peliculaactor_peliculas1_idx` (`peliculas_idPeliculas` ASC) VISIBLE,
  CONSTRAINT `fk_peliculaactor_actores`
    FOREIGN KEY (`actores_idactores`)
    REFERENCES `peliculasdb`.`actores` (`idactores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_peliculaactor_peliculas1`
    FOREIGN KEY (`peliculas_idPeliculas`)
    REFERENCES `peliculasdb`.`peliculas` (`idPeliculas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
