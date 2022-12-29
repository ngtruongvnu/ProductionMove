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
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `modified_date` datetime DEFAULT current_timestamp(),
  `modified_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

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
  `product_batch` bigint(20) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `errors_ibfk_1` (`product_id`),
  KEY `errors_ibfk_2` (`product_batch`) USING BTREE,
  CONSTRAINT `errors_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `errors_ibfk_2` FOREIGN KEY (`product_batch`) REFERENCES `product_batches` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.errors: ~10 rows (approximately)
/*!40000 ALTER TABLE `errors` DISABLE KEYS */;
INSERT INTO `errors` (`id`, `product_id`, `type`, `product_batch`, `description`, `created_date`, `created_by`, `modified_date`, `modified_by`) VALUES
	(1, 1, 0, 1, 'xe gặp lỗi túi khí', '2022-12-25 12:55:37', NULL, '2022-12-25 12:55:38', NULL),
	(2, 2, 1, 1, 'xe gặp lỗi động cơ', '2022-12-25 12:56:16', NULL, '2022-12-25 12:56:16', NULL),
	(3, 3, 2, 1, 'xe gặp lỗi chân ga,chân phanh', '2022-12-25 12:56:38', NULL, '2022-12-25 12:56:39', NULL),
	(4, 4, 3, 1, 'xe gặp lỗi hệ thống điều khiển', '2022-12-25 12:59:29', NULL, '2022-12-25 12:59:30', NULL),
	(5, 5, 4, 1, 'xe gặp lỗi liên quan khác', '2022-12-25 13:00:17', NULL, '2022-12-25 13:00:18', NULL),
	(6, 14, 1, 2, 'xe gặp lỗi động cơ', '2022-12-25 13:11:33', NULL, '2022-12-25 13:11:34', NULL),
	(7, 15, 1, 2, 'xe gặp lỗi động cơ', '2022-12-25 13:12:17', NULL, '2022-12-25 13:12:17', NULL),
	(8, 19, 1, 2, 'xe gặp lỗi động cơ', '2022-12-25 13:12:48', NULL, '2022-12-25 13:12:48', NULL),
	(9, 9, 2, 2, 'xe gặp lỗi chân ga,chân phanh', '2022-12-26 10:33:24', NULL, '2022-12-26 10:33:24', NULL),
	(10, 10, 2, 2, 'xe gặp lỗi chân ga,chân phanh', '2022-12-26 10:34:01', NULL, '2022-12-26 10:34:01', NULL);
/*!40000 ALTER TABLE `errors` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.order_for_product
CREATE TABLE IF NOT EXISTS `order_for_product` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(36) NOT NULL,
  `customer_id` bigint(36) NOT NULL,
  `sell_by` bigint(36) DEFAULT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`),
  KEY `order_for_product_ibfk_2` (`sell_by`),
  KEY `order_for_product_ibfk_3` (`customer_id`),
  CONSTRAINT `order_for_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `order_for_product_ibfk_2` FOREIGN KEY (`sell_by`) REFERENCES `user` (`id`),
  CONSTRAINT `order_for_product_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.order_for_product: ~16 rows (approximately)
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
	(16, 16, 4, 1, 'system', '2022-12-20 16:52:26'),
	(29, 53, 5, 6, NULL, '2022-12-27 10:59:24');
/*!40000 ALTER TABLE `order_for_product` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.productline_details
CREATE TABLE IF NOT EXISTS `productline_details` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `type` int(1) NOT NULL COMMENT 'loại xe: xe số sàn, xe số tự động',
  `category_car` int(2) NOT NULL COMMENT 'dòng xe: xe sang, xe thể thao, xe tải, ...',
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `img_url` varchar(256) DEFAULT NULL,
  `lenght` double DEFAULT NULL,
  `width` double unsigned DEFAULT NULL,
  `power` varchar(20) DEFAULT NULL,
  `displacement` int(6) DEFAULT NULL,
  `gearbox` varchar(50) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `engine` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.productline_details: ~10 rows (approximately)
/*!40000 ALTER TABLE `productline_details` DISABLE KEYS */;
INSERT INTO `productline_details` (`id`, `type`, `category_car`, `created_by`, `created_date`, `modified_by`, `modified_date`, `description`, `img_url`, `lenght`, `width`, `power`, `displacement`, `gearbox`, `seats`, `engine`, `name`) VALUES
	(1, 1, 0, 'system', '2022-12-19 23:13:53', NULL, '2022-12-19 23:13:53', 'xe số tự động, ô tô con', 'https://www.hyundai.com/content/dam/hyundai/ww/en/images/find-a-car/all-vehicles/sonata-dn8-quater-view.png', 2.825, 1.605, '179.5/6000', 2497, 'Hộp số tự động 6 cấp', 4, 'M20A-FKS', 'SONATA'),
	(2, 1, 0, 'system', '2022-12-20 11:46:44', NULL, '2022-12-20 11:46:47', 'xe số tự động, ô tô con', 'https://www.hyundai.com/content/dam/hyundai/ww/en/images/find-a-car/all-vehicles/accent-hc-quarter-view-silk-silver-pc.png', 2.55, 1.475, '132/5500', 1591, 'Hộp số tự động 6 cấp', 4, '2NR-FE', 'ACCENT'),
	(3, 1, 0, 'system', '2022-12-20 17:14:14', NULL, '2022-12-20 17:14:17', 'xe số tự động, ô tô con', 'https://www.hyundai.com/content/dam/hyundai/ww/en/images/find-a-car/all-vehicles/the-new-palisade-lx2-pe-quater-view-480x260.png', 4.9, 1.86, '179.5/6000', 2497, 'Hộp số tự động 8 cấp', 7, '3.5 LAMBDA II MPI', 'PALISADE'),
	(4, 1, 0, 'system', '2022-12-26 10:32:00', NULL, '2022-12-26 10:32:01', 'xe số tự động, ô tô con', 'http://mitsubishi-otohue.com/wp-content/uploads/2018/12/1642135848-ultimate-white-at-2x-minpng-768x513.png', 4.595, 1.75, '104/6000', 1955, 'Hộp số tự động 4 cấp', 7, '1.5L MIVEC', 'MITSUBISHI XPANDER'),
	(5, 1, 1, 'system', '2022-12-26 15:24:51', NULL, '2022-12-26 15:24:51', 'xe số tự động, xe bán tải', 'https://www.nissanvietnam.vn/images/specs_prices/2021/05/resized/4wd-cao-cap_1621576434.jpeg', 4.995, 1.86, '190/3750', 2298, 'Hộp số tự động 7 cấp', 4, '2.3L TWIN TURBO', 'NAVARA VL 4WD'),
	(6, 1, 1, 'system', '2022-12-26 15:26:43', NULL, '2022-12-26 15:26:44', 'xe số tự động, xe bán tải', 'https://www.nissanvietnam.vn/images/specs_prices/2021/05/resized/pro4x_1621576425.jpeg', 5.015, 1.865, '190/3750', 2298, 'Hộp số tự động 7 cấp', 4, '2.3L TWIN TURBO', 'NAVARA PRO-4X'),
	(7, 0, 2, 'system', '2022-12-26 15:27:04', NULL, '2022-12-26 15:27:04', 'xe số sàn, xe tải', 'https://trucknbus.hyundai.com/global/en/images/product/cars/hd36l/longer-cargo-bed.jpg', 5.31, 1.76, '130/3800', 2497, 'Hộp số tự động 4 cấp', 2, 'A2(D4CB)', 'HD36L'),
	(8, 0, 2, 'system', '2022-12-26 15:27:41', NULL, '2022-12-26 15:27:41', 'xe số sàn, xe tải', 'https://mb.cision.com/Public/17198/3411183/a6e120639730fc8c_org.jpg', 7.625, 2.425, '260/3800', 5899, 'Hộp số tự động 7 cấp', 2, 'D4DA-P', 'XCIENT FUEL CELL'),
	(9, 0, 3, 'system', '2022-12-26 15:30:45', NULL, '2022-12-26 15:30:46', 'xe số sàn, xe du lịch', 'https://dichvuthuexe.vn/wp-content/uploads/2020/06/Hyundai_Universe_Xpress_Noble_Bus.jpg', 11.73, 2.495, '380/1900', 12344, 'Hộp số tự động 7 cấp', 45, 'D6CC38', 'UNIVERSE'),
	(10, 0, 3, 'system', '2022-12-26 15:31:18', NULL, '2022-12-26 15:31:20', 'xe số sàn, xe du lịch', 'https://motorworldgroupsxm.com/wp-content/uploads/2020/06/Hyundai-County-Bus-Transparent-798x466.png', 7.11, 2.035, '130/2900', 3907, 'Hộp số tự động 7 cấp', 29, 'D4DD', 'COUNTY NEW BREEZE');
/*!40000 ALTER TABLE `productline_details` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.products: ~53 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `status`, `place`, `warranty_period`, `warranty_from`, `product_batch_id`, `product_code`, `created_by`, `created_date`, `modified_by`, `modified_date`, `product_detail_id`, `user_id`, `warranty_count`) VALUES
	(1, 0, 1, 2, '2022-12-19 12:12:45', 1, 100, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(2, 0, 1, 2, '2022-12-19 12:12:45', 1, 101, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(3, 0, 1, 2, '2022-12-19 12:12:45', 1, 102, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(4, 0, 1, 2, '2022-12-19 12:12:45', 1, 103, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(5, 0, 1, 2, '2022-12-19 12:12:45', 1, 104, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(6, 0, 1, 2, '2022-12-19 12:12:45', 1, 105, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(7, 0, 1, 2, '2022-12-19 12:12:45', 1, 106, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(8, 0, 1, 2, '2022-12-19 12:12:45', 1, 107, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 1, 1, 0),
	(9, 0, 1, 2, '2022-12-19 12:12:45', 1, 108, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 4, 1, 0),
	(10, 0, 1, 2, '2022-12-19 12:12:45', 1, 109, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 4, 1, 0),
	(11, 0, 1, 2, '2022-12-19 12:12:45', 2, 110, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(12, 0, 1, 2, '2022-12-19 12:12:45', 2, 111, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(13, 0, 1, 2, '2022-12-19 12:12:45', 2, 112, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(14, 0, 1, 2, '2022-12-19 12:12:45', 2, 113, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 3, 1, 0),
	(15, 0, 1, 2, '2022-12-19 12:12:45', 2, 114, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 3, 1, 0),
	(16, 0, 1, 2, '2022-12-19 12:12:45', 2, 115, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 2, 0),
	(17, 0, 1, 2, '2022-12-19 12:12:45', 2, 116, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(18, 0, 1, 2, '2022-12-19 12:12:45', 2, 117, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 2, 1, 0),
	(19, 0, 1, 2, '2022-12-19 12:12:45', 2, 118, 'system', '2022-12-18 12:12:45', 'system', '2022-12-18 12:12:45', 3, 1, 0),
	(20, 0, 2, 2, '2022-12-26 16:45:43', 2, 119, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 3, 1, 0),
	(21, 0, 3, 2, '2022-12-26 16:45:43', 3, 120, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(22, 0, 3, 2, '2022-12-26 16:45:43', 3, 121, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(23, 0, 3, 2, '2022-12-26 16:45:43', 3, 122, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(24, 0, 3, 2, '2022-12-26 16:45:43', 3, 123, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(25, 0, 3, 2, '2022-12-26 16:45:43', 3, 124, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(26, 0, 3, 2, '2022-12-26 16:45:43', 3, 125, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(27, 0, 3, 2, '2022-12-26 16:45:43', 3, 126, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(28, 0, 3, 2, '2022-12-26 16:45:43', 3, 127, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(29, 0, 3, 2, '2022-12-26 16:45:43', 3, 128, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(30, 0, 3, 2, '2022-12-26 16:45:43', 3, 129, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 4, 1, 0),
	(31, 0, 4, 2, '2022-12-26 16:45:43', 7, 130, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(32, 0, 4, 2, '2022-12-26 16:45:43', 7, 131, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(33, 0, 4, 2, '2022-12-26 16:45:43', 7, 132, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(34, 0, 4, 2, '2022-12-26 16:45:43', 7, 133, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(35, 0, 4, 2, '2022-12-26 16:45:43', 7, 134, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(36, 0, 4, 2, '2022-12-26 16:45:43', 7, 135, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(37, 0, 4, 2, '2022-12-26 16:45:43', 7, 136, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(38, 0, 4, 2, '2022-12-26 16:45:43', 7, 137, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(39, 0, 4, 2, '2022-12-26 16:45:43', 7, 138, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(40, 9, 4, 2, '2022-12-26 16:45:43', 8, 139, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 5, 1, 0),
	(41, 9, 5, 2, '2022-12-26 16:45:43', 8, 140, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(42, 9, 5, 2, '2022-12-26 16:45:43', 8, 141, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(43, 9, 5, 2, '2022-12-26 16:45:43', 8, 142, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(44, 9, 5, 2, '2022-12-26 16:45:43', 8, 143, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(45, 9, 5, 2, '2022-12-26 16:45:43', 8, 144, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(46, 9, 5, 2, '2022-12-26 16:45:43', 8, 145, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(47, 9, 5, 2, '2022-12-26 16:45:43', 8, 146, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(48, 9, 5, 2, '2022-12-26 16:45:43', 8, 147, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(49, 0, 5, 2, '2022-12-26 16:45:43', 9, 148, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(50, 5, 11, 2, '2022-12-26 16:45:43', 9, 149, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(51, 0, 5, 2, '2022-12-26 16:45:43', 9, 150, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 1, 0),
	(52, 2, 7, 2, '2022-12-26 16:45:43', 9, 151, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 3, 0),
	(53, 2, 7, 2, '2022-12-26 16:45:43', 9, 152, 'system', '2022-12-26 16:46:02', 'system', '2022-12-26 16:46:03', 6, 3, 0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

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

-- Dumping structure for table product_move_offical.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL COMMENT 'Vai trò trong hệ thống:\n0 : Admin\n1 : Cơ sở sản xuất\n2 : Trung tâm bảo hành\n3 : Đại lý phân phối',
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `role`, `user_name`, `password`, `img_url`, `created_by`, `created_date`, `modified_by`, `modified_date`, `first_name`, `last_name`) VALUES
	(1, 0, 'hungdz123', '123456', 'abc.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Trương Đức', 'Hùng'),
	(2, 1, 'minhpc123', '123456', 'mingimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Nguyễn Nhật', 'Minh'),
	(3, 2, 'khangpubg', '123456', 'khangimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Phạm Hưng', 'Khang'),
	(4, 3, 'truongtt1', '123456', 'truongimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Nguyễn Văn', 'Trường'),
	(5, 1, 'hieu123', '123456', 'hieuimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Bùi Xuân', 'Hiếu'),
	(6, 3, 'trong123', '123456', 'trongimage.jpg', 'system', '2022-12-05 00:00:00', 'system', '2022-12-05 00:00:00', 'Trần Viết', 'Trọng');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table product_move_offical.warehouse
CREATE TABLE IF NOT EXISTS `warehouse` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(36) NOT NULL,
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `modified_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `warehouse_ibfk_1` (`user_id`),
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table product_move_offical.warehouse: ~11 rows (approximately)
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` (`id`, `user_id`, `address`, `created_by`, `created_date`, `modified_by`, `modified_date`) VALUES
	(1, 1, 'Ngọc Quan, Lâm Thao, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(2, 1, 'Ngọc Quan, Lâm Thao, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(3, 1, 'Đạo Sử, Thị Trấn Thứa, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(4, 1, 'Đạo Sử, Thị Trấn Thứa, Lương Tài, Bắc Ninh', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(5, 2, 'Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(6, 2, 'Phạm Văn Đồng, Mai Dịch, Cầu Giấy, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(7, 3, 'Hồ Tùng Mậu, Cầu Giấy, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(8, 3, 'Hồ Tùng Mậu, Cầu Giấy, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(9, 3, 'Phạm Văn Đồng, Xuân Đỉnh, Bắc Từ Liêm, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(10, 3, 'Phạm Văn Đồng, Xuân Đỉnh, Bắc Từ Liêm, Hà Nội', 'system', '2022-12-19 23:28:04', NULL, '2022-12-19 23:28:04'),
	(11, 6, 'Bạch Mai, Hai Bà Trưng, Hà Nội', NULL, '2022-12-26 17:38:46', NULL, NULL),
	(12, 5, 'Bạch Mai, Hai Bà Trưng, Hà Nội', NULL, '2022-12-29 16:09:23', NULL, NULL);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
