-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2022 at 06:48 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `order_placed_date` date DEFAULT NULL,
  `shipping_address` varchar(255) DEFAULT NULL,
  `total` double DEFAULT 0,
  `card_number` varchar(255) NOT NULL,
  `order_shipped_date` date DEFAULT NULL,
  `order_delivered_date` int(11) DEFAULT NULL,
  `order_canceled` smallint(6) NOT NULL DEFAULT 0,
  `id_item1` int(11) DEFAULT NULL,
  `id_item2` int(11) DEFAULT NULL,
  `id_item3` int(11) DEFAULT NULL,
  `id_item4` int(11) DEFAULT NULL,
  `id_item5` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id_order`, `id_user`, `order_placed_date`, `shipping_address`, `total`, `card_number`, `order_shipped_date`, `order_delivered_date`, `order_canceled`, `id_item1`, `id_item2`, `id_item3`, `id_item4`, `id_item5`) VALUES
(1, 1, NULL, 'Test Address Place', 12.99, '73279731971397', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL),
(13, 1, '2022-12-12', 'sdfdfsddsfdsfd', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(14, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(15, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(16, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(17, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 1, 0, 0, 0, 0, 0),
(18, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(19, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(20, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(21, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(22, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 4, 0, 0, 4, 0),
(23, 1, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 4, 0, 0, 0, 4),
(24, 1, '2022-12-12', 'place', 9, '5555555555555555', NULL, NULL, 0, 4, 4, 0, 0, 0),
(25, 4, '2022-12-12', 'place', 0, '5555555555555555', NULL, NULL, 0, 0, 0, 0, 0, 0),
(26, 4, '2022-12-12', 'place', 18, '5555555555555555', NULL, NULL, 0, 4, 0, 0, 5, 0),
(27, 4, '2022-12-12', 'place', 18.98, '5555555555555555', NULL, NULL, 0, 4, 0, 0, 5, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_item1` (`id_item1`),
  ADD KEY `id_item2` (`id_item2`),
  ADD KEY `id_item3` (`id_item3`),
  ADD KEY `id_item4` (`id_item4`),
  ADD KEY `id_item5` (`id_item5`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `id_item1` FOREIGN KEY (`id_item1`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `id_item2` FOREIGN KEY (`id_item2`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `id_item3` FOREIGN KEY (`id_item3`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `id_item4` FOREIGN KEY (`id_item4`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `id_item5` FOREIGN KEY (`id_item5`) REFERENCES `products` (`id_product`),
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
