-- tabela role
CREATE TABLE `biblioteka`.`role` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));

-- tabela uzytkownicy_role
CREATE TABLE `biblioteka`.`uzytkownicy_role` (
  `ID_UZYTKOWNICY_ROLE` INT NOT NULL AUTO_INCREMENT,
  `FK_ROLE` INT NOT NULL,
  `FK_UZYTKOWNICY` INT NOT NULL,
  PRIMARY KEY (`ID_UZYTKOWNICY_ROLE`));

-- modyfikacja tabeli uzytkownicy pole pesel zmienione na varchar2  
ALTER TABLE `biblioteka`.`uzytkownicy` 
CHANGE COLUMN `TELEFON` `TELEFON` VARCHAR(15) NULL DEFAULT NULL ;

--- dodanie constraint tabel uzytkownicy i role
ALTER TABLE `biblioteka`.`uzytkownicy_role` 
CHANGE COLUMN `FK_UZYTKOWNICY` `FK_UZYTKOWNICY` INT(11) NOT NULL AFTER `ID_UZYTKOWNICY_ROLE`,
ADD INDEX `uzytkownicy_role_idx` (`FK_UZYTKOWNICY` ASC),
ADD INDEX `role_uzytkownicy_role_idx` (`FK_ROLE` ASC), 
COMMENT = 'Tabela łaczaca role i uzytkownikow' ;
ALTER TABLE `biblioteka`.`uzytkownicy_role` 
ADD CONSTRAINT `uzytkownicy_uzytkownicy_role`
  FOREIGN KEY (`FK_UZYTKOWNICY`)
  REFERENCES `biblioteka`.`uzytkownicy` (`ID_UZYTKOWNIKA`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `role_uzytkownicy_role`
  FOREIGN KEY (`FK_ROLE`)
  REFERENCES `biblioteka`.`role` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `biblioteka`.`uzytkownicy_role` 
DROP FOREIGN KEY `role_uzytkownicy_role`,
DROP FOREIGN KEY `uzytkownicy_uzytkownicy_role`;
ALTER TABLE `biblioteka`.`uzytkownicy_role` 
ADD CONSTRAINT `role_uzytkownicy_role`
  FOREIGN KEY (`FK_ROLE`)
  REFERENCES `biblioteka`.`role` (`ID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `uzytkownicy_uzytkownicy_role`
  FOREIGN KEY (`FK_UZYTKOWNICY`)
  REFERENCES `biblioteka`.`uzytkownicy` (`ID_UZYTKOWNIKA`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;   
 
-- dodanie wartosc do tebeli role
INSERT INTO `biblioteka`.`role` (`NAME`) VALUES ('ADMINISTARTOR');
INSERT INTO `biblioteka`.`role` (`NAME`) VALUES ('MODERATOR');
INSERT INTO `biblioteka`.`role` (`NAME`) VALUES ('UŻYTKOWNIK');

-- dodanie warośći 
INSERT INTO `biblioteka`.`uzytkownicy_role` (`FK_UZYTKOWNICY`, `FK_ROLE`) VALUES ('1', '1');
INSERT INTO `biblioteka`.`uzytkownicy_role` (`FK_UZYTKOWNICY`, `FK_ROLE`) VALUES ('2', '3');
INSERT INTO `biblioteka`.`uzytkownicy_role` (`FK_UZYTKOWNICY`, `FK_ROLE`) VALUES ('3', '2');

  
  