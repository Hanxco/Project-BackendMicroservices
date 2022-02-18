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

-- TRABAJO FINAL

CREATE SCHEMA IF NOT EXISTS `usuariosdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `usuariosdb` ;

-- -----------------------------------------------------
-- Table `usuariosdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuariosdb`.`users` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `enable` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `usuariosdb`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuariosdb`.`authorities` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `usuariosdb`.`users_has_authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuariosdb`.`users_has_authorities` (
  `Users_idUsuario` INT NOT NULL,
  `Authorities_idRol` INT NOT NULL,
  PRIMARY KEY (`Users_idUsuario`, `Authorities_idRol`),
  INDEX `fk_Users_has_Authorities_Authorities1_idx` (`Authorities_idRol` ASC) VISIBLE,
  INDEX `fk_Users_has_Authorities_Users1_idx` (`Users_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_Authorities_Authorities1`
    FOREIGN KEY (`Authorities_idRol`)
    REFERENCES `usuariosdb`.`authorities` (`idRol`),
  CONSTRAINT `fk_Users_has_Authorities_Users1`
    FOREIGN KEY (`Users_idUsuario`)
    REFERENCES `usuariosdb`.`users` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `usuariosdb`.`criticas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuariosdb`.`criticas` (
  `idcriticas` INT NOT NULL AUTO_INCREMENT,
  `peliculaId` INT NOT NULL,
  `valoracion` VARCHAR(1500) NULL DEFAULT NULL,
  `nota` INT NOT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idcriticas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `usuariosdb`.`criticas-users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuariosdb`.`users_criticas` (
  `Usuario_idUsuario` INT NOT NULL,
  `Criticas_idCriticas` INT NOT NULL,
  PRIMARY KEY (`Usuario_idUsuario`, `Criticas_idCriticas`),
  INDEX `fk_Criticas-users_Criticas1_idx` (`Criticas_idCriticas` ASC) VISIBLE,
  INDEX `fk_Criticas-users_Users1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Criticas-users_Criticas1`
    FOREIGN KEY (`Criticas_idCriticas`)
    REFERENCES `usuariosdb`.`criticas` (`idcriticas`),
  CONSTRAINT `fk_Criticas-users_Users1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `usuariosdb`.`users` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
