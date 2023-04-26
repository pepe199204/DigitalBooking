-- drop schema ``0521PTC6N2db_GRUPO8``;
-- drop database ``0521PTC6N2db_GRUPO8``;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ``0521PTC6N2db_GRUPO8``
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ``0521PTC6N2db_GRUPO8``
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `0521PTC6N2db_GRUPO8` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `0521PTC6N2db_GRUPO8` ;

-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `descripcion` TEXT(300) NULL,
  `url_imagen` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`paises` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
   PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`provincias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `id_pais` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

ALTER TABLE provincias
ADD FOREIGN KEY (id_pais)
REFERENCES paises(id);
-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`ciudades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `id_provincia` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

ALTER TABLE ciudades
ADD FOREIGN KEY (id_provincia)
REFERENCES provincias(id);

-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `id_categoria` INT NOT NULL,
  `id_ciudad` INT NOT NULL,
  `url_imagen_principal` MEDIUMTEXT NOT NULL,
  `ubicacion` VARCHAR(100) NOT NULL,
  `descripcion` TEXT(300) NULL,
  `politicas` LONGTEXT NULL,
  PRIMARY KEY (`id`)) 
ENGINE = InnoDB;

ALTER TABLE productos
ADD FOREIGN KEY (id_ciudad)
REFERENCES ciudades(id);
ALTER TABLE productos
ADD FOREIGN KEY (id_categoria)
REFERENCES categorias(id);


-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`imagenes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NULL,
  `url_imagen` MEDIUMTEXT NOT NULL,
  `id_producto` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_producto_idx` (`id_producto` ASC) ,
  CONSTRAINT `id`
    FOREIGN KEY (`id_producto`)
    REFERENCES `0521PTC6N2db_GRUPO8`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`caracteristicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`caracteristicas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `url_icono` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `0521PTC6N2db_GRUPO8`.`caracteristicas_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `0521PTC6N2db_GRUPO8`.`caracteristicas_producto` (
  `id` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `id_caracteristica` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
ALTER TABLE 0521PTC6N2db_GRUPO8.caracteristicas_producto
ADD FOREIGN KEY (id_producto)
REFERENCES productos(id);

ALTER TABLE 0521PTC6N2db_GRUPO8.caracteristicas_producto
ADD FOREIGN KEY (id_caracteristica)
REFERENCES caracteristicas(id);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
