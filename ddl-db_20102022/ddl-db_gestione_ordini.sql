-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.28 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database gestione_ordini
DROP DATABASE IF EXISTS `gestione_ordini`;
CREATE DATABASE IF NOT EXISTS `gestione_ordini` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestione_ordini`;

-- Dump della struttura di tabella gestione_ordini.order_detail
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id_detail` int NOT NULL AUTO_INCREMENT,
  `id_order` int NOT NULL,
  `id_product` int NOT NULL,
  `item_count` int NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_detail`),
  KEY `FK_detail_order_idx` (`id_order`),
  KEY `FK_DETAIL_PRODUCT_idx` (`id_product`),
  CONSTRAINT `FK_DETAIL_ORDER` FOREIGN KEY (`id_order`) REFERENCES `order_header` (`id_order`),
  CONSTRAINT `FK_DETAIL_PRODUCT` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestione_ordini.order_detail: ~0 rows (circa)

-- Dump della struttura di tabella gestione_ordini.order_header
DROP TABLE IF EXISTS `order_header`;
CREATE TABLE IF NOT EXISTS `order_header` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `order_date` datetime NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `status` varchar(45) NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `FK_order_header_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestione_ordini.order_header: ~0 rows (circa)

-- Dump della struttura di tabella gestione_ordini.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `description` varchar(255) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `availability` int unsigned NOT NULL,
  `create_user` int NOT NULL,
  `create_time` timestamp NOT NULL,
  `last_update_user` int DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `FK_PRODUCT_USER_idx` (`create_user`),
  KEY `FK_PRODUCT_USER_UPDATE_idx` (`last_update_user`),
  CONSTRAINT `FK_PRODUCT_USER_CREATE` FOREIGN KEY (`create_user`) REFERENCES `user` (`id_user`),
  CONSTRAINT `FK_PRODUCT_USER_UPDATE` FOREIGN KEY (`last_update_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestione_ordini.product: ~10 rows (circa)
INSERT INTO `product` (`id_product`, `code`, `description`, `cost`, `availability`, `create_user`, `create_time`, `last_update_user`, `last_update_time`) VALUES
	(1, '0000000001', 'Yogurt Greco Bianco', 1.94, 80, 6, '2022-09-26 22:00:00', NULL, NULL),
	(2, '0000000002', 'Tonno - Naturale, Pinna Gialla', 5.38, 59, 2, '2022-09-26 22:00:00', NULL, NULL),
	(3, '0000000003', 'Pomodoro - Grappolo, Maturo', 4.08, 48, 4, '2022-09-26 22:00:00', NULL, NULL),
	(4, '0000000004', 'Maiale - Salsiccia, Secca', 5.26, 100, 1, '2022-09-26 22:00:00', NULL, NULL),
	(5, '0000000005', 'Salsa - Messicana', 2.36, 104, 3, '2022-09-26 22:00:00', NULL, NULL),
	(6, '0000000006', 'Quaderno Righe', 3.12, 24, 3, '2022-09-26 22:00:00', NULL, NULL),
	(7, '0000000007', 'Ceci In Scatola', 4.02, 108, 9, '2022-09-26 22:00:00', NULL, NULL),
	(8, '0000000008', 'Gocciole - Biscotti', 1.47, 36, 8, '2022-09-26 22:00:00', NULL, NULL),
	(9, '0000000009', 'Patate', 2.99, 77, 2, '2022-09-26 22:00:00', NULL, NULL),
	(10, '0000000010', 'Matita - Gomma', 1.82, 16, 6, '2022-09-26 22:00:00', NULL, NULL);

-- Dump della struttura di tabella gestione_ordini.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cf` varchar(16) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestione_ordini.user: ~10 rows (circa)
INSERT INTO `user` (`id_user`, `username`, `password`, `name`, `last_name`, `email`, `cf`, `active`) VALUES
	(1, 'username1', 'password1', 'Battista', 'Maccari', 'email.1@lipari.com', 'LòSJNDFòSDNFJK', 0),
	(2, 'username2', 'password2', 'Innocenzo', 'Bruschetta', 'email.2@lipari.com', 'cf2', 0),
	(3, 'username3', 'password3', 'Frederico', 'Bormizzi', 'email.3@lipari.com', 'cf3', 0),
	(4, 'username4', 'password4', 'Amelia', 'Rosario', 'email.4@lipari.com', 'cf4', 0),
	(5, 'username5', 'password5', 'Clementino', 'Bettecchi', 'email.5@lipari.com', 'cf5', 1),
	(6, 'username6', 'password6', 'Elena', 'Tosi', 'email.6@lipari.com', 'cf6', 1),
	(7, 'username7', 'password7', 'Ilenia', 'Dorsy', 'email.7@lipari.com', 'cf7', 1),
	(8, 'username8', 'password8', 'Thor', 'Norreno', 'email.8@lipari.com', 'cf8', 1),
	(9, 'username9', 'password9', 'Romualdo', 'Russo', 'email.9@lipari.com', 'cf9', 0),
	(10, 'username10', 'password10', 'Levante', 'Mattei', 'email.10@lipari.com', 'cf10', 0),
	(12, 'EriCan', 'ErikaCanulli', 'Erika', 'Canulli', 'erikacanulli@gmail.com', 'cf12', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
