CREATE TABLE `customer` (
 `id` mediumint(8) unsigned NOT NULL auto_increment,
 `firstName` varchar(255) default NULL,
 `lastName` varchar(255) default NULL,
 `birthdate` varchar(255),
 PRIMARY KEY (`id`)
 ) AUTO_INCREMENT=1;

 CREATE TABLE customer (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
birthdate DATE (),
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)