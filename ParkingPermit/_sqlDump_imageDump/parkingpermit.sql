use parkingpermit;

CREATE TABLE `studentparking` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `make` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `platenumber` varchar(6) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


INSERT INTO `studentparking` (firstname, lastname, make, model, color, platenumber) VALUES 
('Bob','McGillings','Ford','Econo-Van','Blue','ESR456'),
('Tina','Beltcher','VW','Rabbit','Blue','AKR253'),
('Chris','ODoud','Fiat','500L','Black','FDR427'),
('Sammy','Hoffler','Dodge','Ram Truck','Grey','DZQ509'),
('Joaxin','Trejas','Honda','Civic','Royal Blue','RBX438'),
('Linda','Goldberg','Range Rover','HSE','Grey','XER837'),
('Garry','Kemitzer','Yugo','Ciao','Cream','LXR141'),
('David','Bryne','Piech','Mark GT','Silver','WKP923'),
('Richard','Lion','VW','Beetle','Bottle Green','JGF741'),
('Paul','Ziloulska','Chevy','Silverado 1500','White','KRW572');