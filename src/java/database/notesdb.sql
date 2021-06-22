DROP SCHEMA IF EXISTS `notesdb`;
CREATE SCHEMA IF NOT EXISTS `notesdb` DEFAULT CHARACTER SET latin1;
USE `notesdb`;

CREATE TABLE IF NOT EXISTS `notesdb`.`user` (
  `email` VARCHAR(40) NOT NULL,
  `active` TINYINT(1) NOT NULL DEFAULT '1',
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`email`)
);

CREATE TABLE `note` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `contents` varchar(20000) CHARACTER SET utf8 NOT NULL,
  `owner` varchar(40) NOT NULL,
  PRIMARY KEY (`note_id`),
  KEY `FK_Note_User` (`owner`),
  CONSTRAINT `FK_Note_User` FOREIGN KEY (`owner`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO `user` (`email`,`active`,`first_name`,`last_name`,`password`)
    VALUES
    ('sait.cprg.352+matilda@gmail.com', true, 'Matilda','Keybroke', 'password'),
    ('sait.cprg.352+anne@gmail.com', true, 'Anne','Teak', 'password');
    

INSERT INTO `note` (`title`, `contents`, `owner`)
    VALUES
    ('Quote #1', 'Writing is nature''s way of letting you know how sloppy your thinking is.', 'sait.cprg.352+anne@gmail.com'),
    ('Another quote', '"Java is to JavaScript as ham is to hamster." -  Jeremy Keith', 'sait.cprg.352+anne@gmail.com'),
    ('Matilda''s Note', 'Anne should not see this note. She stole my broccoli casserole recipe 8 years ago and claimed it was hers.', 'sait.cprg.352+matilda@gmail.com');
