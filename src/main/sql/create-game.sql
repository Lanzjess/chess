--DROP TABLE `cchess`.`game`;

CREATE TABLE  `game` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `white` INT(10) UNSIGNED NOT NULL,
  `black` INT(10) UNSIGNED NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `draw_offer` VARCHAR(10),
  `start` DATETIME NOT NULL,
  `last_move` DATETIME,
  `notified` DATETIME,
  `fen` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX (`id`),
  INDEX (`white`),
  INDEX (`black`),
  FOREIGN KEY `game_white_user` (white) REFERENCES user (id),
  FOREIGN KEY `game_black_user` (black) REFERENCES user (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8
