use posdb;

CREATE TABLE `carts` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `ownerFName` varchar(45) DEFAULT NULL,
  `ownerLName` varchar(45) DEFAULT NULL,
  `ownerEmail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `posdb`.`cartitems` (
  `cartItemId` INT NOT NULL AUTO_INCREMENT,
  `cartId` INT NULL,
  `ownerEmail` VARCHAR(45) NULL,
  `product_id` INT NULL,
  `product_name` VARCHAR(45) NULL,
  `price` FLOAT NULL,
  `order_qty` INT NULL,
  `order_subtotal` FLOAT NULL,
  PRIMARY KEY (`cartItemId`));