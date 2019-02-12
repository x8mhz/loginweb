/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Fabricio Ramos
 * Created: 12/02/2019
 */

CREATE TABLE `loginweb`.`usuario` (
  `GUID` VARCHAR(40) NOT NULL,
  `NOME` VARCHAR(45) NOT NULL,
  `LOGIN` VARCHAR(45) NOT NULL,
  `SENHA` VARCHAR(45) NULL,
  PRIMARY KEY (`GUID`));