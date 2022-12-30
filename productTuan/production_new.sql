-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.9.1-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for product_move_offical
CREATE DATABASE IF NOT EXISTS `product_move_offical` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `product_move_offical`;

-- Dumping structure for table product_move_offical.product_batches
CREATE TABLE IF NOT EXISTS `product_batches` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `quantity` int(10) NOT NULL,
  `produced_at` bigint(36) NOT NULL COMMENT 'sản xuất bởi cơ sở sản xuất nào?',
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `productline_detail_id` bigint(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_batches_ibfk_1` (`produced_at`),
  KEY `product_batches_ibfk_2` (`productline_detail_id`),
  CONSTRAINT `product_batches_ibfk_1` FOREIGN KEY (`produced_at`) REFERENCES `user` (`id`),
  CONSTRAINT `product_batches_ibfk_2` FOREIGN KEY (`productline_detail_id`) REFERENCES `productline_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='Lô hàng sản xuất bởi cơ sở sản xuất';

-- Dumping data for table product_move_offical.product_batches: ~10 rows (approximately)
/*!40000 ALTER TABLE `product_batches` DISABLE KEYS */;
INSERT INTO `product_batches` (`id`, `quantity`, `produced_at`, `created_by`, `created_date`, `modified_by`, `modified_date`, `productline_detail_id`) VALUES
	(1, 10, 1, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00', 1),
	(2, 10, 1, 'system', '2022-12-19 17:32:23', NULL, '2022-12-19 17:32:25', 2),
	(3, 10, 1, 'system', '2022-12-19 17:35:23', 'system', '2022-12-06 00:00:00', 3),
	(4, 10, 1, 'system', '2022-12-19 17:36:23', NULL, '2022-12-19 17:32:25', 4),
	(5, 10, 1, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00', 5),
	(6, 10, 5, 'system', '2022-12-19 17:37:23', NULL, '2022-12-19 17:32:25', 6),
	(7, 10, 5, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00', 7),
	(8, 10, 5, 'system', '2022-12-19 17:38:23', NULL, '2022-12-19 17:32:25', 8),
	(9, 10, 5, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00', 9),
	(10, 10, 5, 'system', '2022-12-19 17:39:23', NULL, '2022-12-19 17:32:25', 10);
/*!40000 ALTER TABLE `product_batches` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
