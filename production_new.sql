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

-- Dumping structure for table product_move_offical.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(36) NOT NULL,
  `firstname` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `modified_date` datetime DEFAULT current_timestamp(),
  `modified_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.customer: ~5 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `firstname`, `lastname`, `phone`, `address`, `created_date`, `created_by`, `modified_date`, `modified_by`) VALUES
	(1, 'Vũ Duy', 'Hoàng', '0977109838', 'Ngọc Quan, Lâm Thao, Lương Tài, Bắc Ninh', '2022-12-05 00:00:00', 'system', '2022-12-05 11:50:21', 'system'),
	(2, 'Phạm Hưng', 'Khang', '0234737311', 'Số 29, Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', '2022-12-19 15:45:27', 'system', '2022-12-20 17:00:40', NULL),
	(3, 'Trần Duy', 'Khánh', '0234737311', 'Số 30, Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', '2022-12-06 00:00:00', 'Nguyễn Văn Trường', '2022-12-06 00:00:00', 'Nguyễn Văn Trường'),
	(4, 'Trần Văn', 'Nam', '0546153054', 'Số 309, Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', '2022-12-06 00:00:00', 'Nguyễn Văn Trường', '2022-12-06 00:00:00', 'Nguyễn Văn Trường'),
	(5, 'Nguyễn Văn', 'Toàn', '0234753622', 'Số 31, Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', '2022-12-19 15:46:12', 'system', '2022-12-20 17:00:40', NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.errors
CREATE TABLE IF NOT EXISTS `errors` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(36) NOT NULL,
  `type` int(3) NOT NULL COMMENT 'Loại lỗi: lỗi động cơ, lỗi túi khí,... Lỗi khác',
  `product_batch` bigint(20) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `errors_ibfk_1` (`product_id`),
  CONSTRAINT `errors_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.errors: ~0 rows (approximately)
/*!40000 ALTER TABLE `errors` DISABLE KEYS */;
/*!40000 ALTER TABLE `errors` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.order_for_product
CREATE TABLE IF NOT EXISTS `order_for_product` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(36) NOT NULL,
  `customer_id` bigint(36) NOT NULL,
  `sell_by` bigint(36) NOT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`),
  KEY `order_for_product_ibfk_2` (`sell_by`),
  KEY `order_for_product_ibfk_3` (`customer_id`),
  CONSTRAINT `order_for_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `order_for_product_ibfk_2` FOREIGN KEY (`sell_by`) REFERENCES `user` (`id`),
  CONSTRAINT `order_for_product_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.order_for_product: ~9 rows (approximately)
/*!40000 ALTER TABLE `order_for_product` DISABLE KEYS */;
INSERT INTO `order_for_product` (`id`, `product_id`, `customer_id`, `sell_by`, `created_by`, `created_date`) VALUES
	(1, 1, 1, 1, 'system', '2020-01-20 16:58:26'),
	(2, 2, 1, 1, 'system', '2020-04-20 16:57:26'),
	(3, 3, 1, 1, 'system', '2020-04-20 16:56:26'),
	(4, 4, 1, 1, 'system', '2020-04-20 16:55:26'),
	(5, 5, 2, 1, 'system', '2020-12-20 16:54:26'),
	(6, 6, 2, 1, 'system', '2021-02-20 16:53:26'),
	(7, 7, 2, 1, 'system', '2021-11-20 16:52:26'),
	(8, 8, 2, 1, 'system', '2021-11-20 16:51:26'),
	(9, 9, 2, 0, 'system', '2021-12-20 23:31:01'),
	(10, 10, 3, 1, 'system', '2021-12-20 16:58:26'),
	(11, 11, 3, 1, 'system', '2022-03-20 16:57:26'),
	(12, 12, 3, 1, 'system', '2022-03-20 16:56:26'),
	(13, 13, 3, 1, 'system', '2022-05-20 16:55:26'),
	(14, 14, 4, 1, 'system', '2022-07-20 16:54:26'),
	(15, 15, 4, 1, 'system', '2022-07-20 16:53:26'),
	(16, 16, 4, 1, 'system', '2022-12-20 16:52:26');
/*!40000 ALTER TABLE `order_for_product` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.productline_details
CREATE TABLE IF NOT EXISTS `productline_details` (
  `id` bigint(36) NOT NULL,
  `type` int(1) NOT NULL COMMENT 'loại xe: xe số sàn, xe số tự động',
  `category_car` int(2) NOT NULL COMMENT 'dòng xe: xe sang, xe thể thao, xe tải, ...',
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `img_url` varchar(256) DEFAULT NULL,
  `lenght` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `power` int(11) NOT NULL,
  `momentum` int(11) NOT NULL,
  `gearbox` int(11) NOT NULL,
  `seats` int(11) NOT NULL,
  `engine` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.productline_details: ~3 rows (approximately)
/*!40000 ALTER TABLE `productline_details` DISABLE KEYS */;
INSERT INTO `productline_details` (`id`, `type`, `category_car`, `created_by`, `created_date`, `modified_by`, `modified_date`, `description`, `img_url`, `lenght`, `width`, `power`, `momentum`, `gearbox`, `seats`, `engine`, `name`) VALUES
	(0, 1, 0, 'system', '2022-12-19 23:13:53', NULL, '2022-12-19 23:13:53', 'xe số tự động, ô tô con', 'bwm1.jpg', 3, 2, 100, 100, 100, 4, 'xxxxx', 'BWM F01'),
	(1, 0, 0, 'system', '2022-12-20 11:46:44', NULL, '2022-12-20 11:46:47', 'xe số sàn, ô tô con', NULL, 3, 2, 100, 100, 100, 4, 'xxxxx', 'BWM F02'),
	(2, 3, 3, 'system', '2022-12-20 17:14:14', NULL, '2022-12-20 17:14:17', 'xe số tự động, xe du lịch', NULL, 6, 2, 100, 100, 100, 29, 'xxxxx', 'BWM F03');
/*!40000 ALTER TABLE `productline_details` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint(36) NOT NULL,
  `status` int(2) NOT NULL,
  `place` bigint(36) NOT NULL,
  `warranty_period` int(2) NOT NULL,
  `warranty_from` datetime DEFAULT current_timestamp(),
  `product_batch_id` bigint(36) NOT NULL,
  `product_code` bigint(36) NOT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `product_detail_id` bigint(36) NOT NULL,
  `user_id` bigint(36) NOT NULL,
  `warranty_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_code` (`product_code`),
  KEY `products_user` (`user_id`),
  KEY `products_ibfk_1` (`product_detail_id`),
  KEY `products_ibfk_2` (`place`),
  KEY `products_ibfk_3` (`product_batch_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`product_detail_id`) REFERENCES `productline_details` (`id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`place`) REFERENCES `warehouse` (`id`),
  CONSTRAINT `products_ibfk_3` FOREIGN KEY (`product_batch_id`) REFERENCES `product_batches` (`id`),
  CONSTRAINT `products_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.products: ~19 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `status`, `place`, `warranty_period`, `warranty_from`, `product_batch_id`, `product_code`, `created_by`, `created_date`, `modified_by`, `modified_date`, `product_detail_id`, `user_id`, `warranty_count`) VALUES
	(0, 0, 1, 2, '2022-12-19 12:12:45', 0, 100, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(1, 0, 1, 2, '2022-12-19 12:12:45', 0, 101, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(2, 0, 1, 2, '2022-12-19 12:12:45', 0, 102, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(3, 0, 1, 2, '2022-12-19 12:12:45', 0, 103, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(4, 0, 1, 2, '2022-12-19 12:12:45', 0, 104, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(5, 0, 1, 2, '2022-12-19 12:12:45', 0, 105, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(6, 0, 1, 2, '2022-12-19 12:12:45', 0, 106, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(7, 0, 1, 2, '2022-12-19 12:12:45', 0, 107, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(8, 0, 1, 2, '2022-12-19 12:12:45', 0, 108, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(9, 0, 1, 2, '2022-12-19 12:12:45', 0, 109, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 0, 1, 0),
	(10, 0, 1, 2, '2022-12-19 12:12:45', 1, 110, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(11, 0, 1, 2, '2022-12-19 12:12:45', 1, 111, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(12, 0, 1, 2, '2022-12-19 12:12:45', 1, 112, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(13, 0, 1, 2, '2022-12-19 12:12:45', 1, 113, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(14, 0, 1, 2, '2022-12-19 12:12:45', 1, 114, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(15, 0, 1, 2, '2022-12-19 12:12:45', 1, 115, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(16, 0, 1, 2, '2022-12-19 12:12:45', 1, 116, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(17, 0, 1, 2, '2022-12-19 12:12:45', 1, 117, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(18, 0, 1, 2, '2022-12-19 12:12:45', 1, 118, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.product_batches
CREATE TABLE IF NOT EXISTS `product_batches` (
  `id` bigint(36) NOT NULL,
  `quantity` int(10) NOT NULL,
  `produced_at` bigint(36) NOT NULL COMMENT 'sản xuất bởi cơ sở sản xuất nào?',
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `product_batches_ibfk_1` (`produced_at`),
  CONSTRAINT `product_batches_ibfk_1` FOREIGN KEY (`produced_at`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Lô hàng sản xuất bởi cơ sở sản xuất';

-- Dumping data for table product_move_offical.product_batches: ~10 rows (approximately)
/*!40000 ALTER TABLE `product_batches` DISABLE KEYS */;
INSERT INTO `product_batches` (`id`, `quantity`, `produced_at`, `created_by`, `created_date`, `modified_by`, `modified_date`) VALUES
	(0, 10, 1, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00'),
	(1, 10, 0, 'system', '2022-12-19 17:32:23', NULL, '2022-12-19 17:32:25'),
	(2, 10, 1, 'system', '2022-12-19 17:35:23', 'system', '2022-12-06 00:00:00'),
	(3, 10, 0, 'system', '2022-12-19 17:36:23', NULL, '2022-12-19 17:32:25'),
	(4, 10, 1, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00'),
	(5, 10, 0, 'system', '2022-12-19 17:37:23', NULL, '2022-12-19 17:32:25'),
	(6, 10, 1, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00'),
	(7, 10, 0, 'system', '2022-12-19 17:38:23', NULL, '2022-12-19 17:32:25'),
	(8, 10, 1, 'system', '2022-12-06 00:00:00', 'system', '2022-12-06 00:00:00'),
	(9, 10, 0, 'system', '2022-12-19 17:39:23', NULL, '2022-12-19 17:32:25');
/*!40000 ALTER TABLE `product_batches` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(36) NOT NULL,
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Vai trò trong hệ thống:\n0 : Admin\n1 : Cơ sở sản xuất\n2 : Trung tâm bảo hành\n3 : Đại lý phân phối',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `img_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `role`, `user_name`, `password`, `img_url`, `created_by`, `created_date`, `modified_by`, `modified_date`, `first_name`, `last_name`) VALUES
	(0, '0', 'hungdz123', '123456', 'abc.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Trương Đức', 'Hùng'),
	(1, '1', 'minhpc123', '123456', 'mingimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Nguyễn Nhật', 'Minh'),
	(2, '2', 'khangpubg', '123456', 'khangimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Phạm Hưng', 'Khang'),
	(3, '3', 'truongtt1', '123456', 'truongimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Nguyễn Văn', 'Trường');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.warehouse
CREATE TABLE IF NOT EXISTS `warehouse` (
  `id` bigint(36) NOT NULL,
  `user_id` bigint(36) NOT NULL,
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `warehouse_ibfk_1` (`user_id`),
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.warehouse: ~6 rows (approximately)
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` (`id`, `user_id`, `address`, `created_by`, `created_date`, `modified_by`, `modified_date`) VALUES
	(0, 1, 'Ngọc Quan, Lâm Thao, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(1, 1, 'Ngọc Quan, Lâm Thao, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(2, 2, 'Đạo Sử, Thị Trấn Thứa, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(3, 2, 'Đạo Sử, Thị Trấn Thứa, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(4, 3, 'Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(5, 3, 'Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
