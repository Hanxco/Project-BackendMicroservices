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
  `fechaNacimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idactores`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
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
  `sinopsis` VARCHAR(2500) NULL DEFAULT NULL,
  `genero` VARCHAR(250) NULL DEFAULT NULL,
  `image` VARCHAR(1500) NULL DEFAULT NULL,
  PRIMARY KEY (`idPeliculas`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peliculasdb`.`peliculas_actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peliculasdb`.`peliculas_actor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `actoreses_idactores` INT NOT NULL,
  `pelicula_id_peliculas` INT NOT NULL,
  PRIMARY KEY (`id`, `actoreses_idactores`, `pelicula_id_peliculas`),
  INDEX `fk_peliculaactor_actores_idx` (`actoreses_idactores` ASC) VISIBLE,
  INDEX `fk_peliculaactor_peliculas1_idx` (`pelicula_id_peliculas` ASC) VISIBLE,
  CONSTRAINT `fk_peliculaactor_actores`
    FOREIGN KEY (`actoreses_idactores`)
    REFERENCES `peliculasdb`.`actores` (`idactores`),
  CONSTRAINT `fk_peliculaactor_peliculas1`
    FOREIGN KEY (`pelicula_id_peliculas`)
    REFERENCES `peliculasdb`.`peliculas` (`idPeliculas`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
