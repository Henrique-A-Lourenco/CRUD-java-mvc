CREATE SCHEMA `cadastro` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `cadastro`.`clientes` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL,
  `cep` CHAR(8) NULL,
  `numero` VARCHAR(15) NULL,
  `logradouro` VARCHAR(150) NULL,
  `bairro` VARCHAR(100) NULL,
  `cidade` VARCHAR(50) NULL,
  `uf` CHAR(2) NULL,
  PRIMARY KEY (`idcliente`));
