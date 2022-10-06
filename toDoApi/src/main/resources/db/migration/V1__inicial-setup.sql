CREATE TABLE `atividade` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(200) NOT NULL,
    `finalizada` TINYINT NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB DEFAULT CHARSET=latin1;
