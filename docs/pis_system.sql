-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2025 at 08:32 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pis_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `accdetails`
--

CREATE TABLE `accdetails` (
  `id_user` int(255) NOT NULL,
  `NAME` varchar(251) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accdetails`
--

INSERT INTO `accdetails` (`id_user`, `NAME`, `username`, `password`, `role`) VALUES
(6, 'RINGO BALDIVINO', 'ringo13acc', 'rng123', 'admin'),
(7, 'ERIANN AYUBAN', 'yanyan', 'yan123', 'employee'),
(8, 'LAWRENCE DECANO', 'balong', 'baliw', 'employee'),
(9, 'JL PATUNGAN', 'lucas', 'lucas123', 'employee'),
(10, 'KRYSTALL LINGAD', 'krystall', 'krystall123', 'employee'),
(11, 'MARIE BUAGAS', 'marie', 'marie123', 'employee'),
(12, 'CHELSEA UMBAC', 'seya', 'seya123', 'employee'),
(13, 'XANDER ARMSTRONG', 'xan', 'xan123', 'employee'),
(14, 'RUZZEL DUMALAG', 'ruzz', 'ruzzel123', 'employee'),
(15, 'RINGO BALDIVINO', 'gho', 'ringo123', 'employee');

-- --------------------------------------------------------

--
-- Table structure for table `accessories`
--

CREATE TABLE `accessories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `design_style` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accessories`
--

INSERT INTO `accessories` (`id`, `name`, `type`, `design_style`, `material`, `color`, `price`) VALUES
(1, 'Heart Stud Earrings', 'Earrings', 'Minimalist', 'Stainless Steel', 'Rose Gold', 99.00),
(2, 'Crystal Pendant Choker', 'Necklace', 'Elegant', 'Velvet, Rhinestone', 'Black, Silver', 150.00);

-- --------------------------------------------------------

--
-- Table structure for table `clothing`
--

CREATE TABLE `clothing` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clothing`
--

INSERT INTO `clothing` (`id`, `name`, `type`, `size`, `gender`, `price`, `description`) VALUES
(1, 'Oversized Graphic Tee', 'Shirt', 'Large', 'MALE', 350.00, 'Soft cotton shirt with anime print'),
(2, 'Oversized Graphic Tee', 'Shirt', 'medium', 'FEMALE', 350.00, 'Soft cotton shirt with anime print');

-- --------------------------------------------------------

--
-- Table structure for table `design`
--

CREATE TABLE `design` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `notes` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `price` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `design`
--

INSERT INTO `design` (`id`, `name`, `notes`, `type`, `material`, `price`) VALUES
(1, 'LED Wall Scroll', 'Light-up anime poster for wall display', 'Wall Decor', 'Fabric, LED lights', 850),
(2, 'Shikishi Art Board', 'Traditional-style anime art board', 'Wall Decor', 'Cardboard, Ink Print', 400);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `food_type` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `date_added` date DEFAULT current_timestamp(),
  `expiration_date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `name`, `food_type`, `price`, `date_added`, `expiration_date`) VALUES
(1, 'ICE CREAM', 'TARO', 25.00, '1970-01-01', '1970-01-01'),
(2, 'ICE CREAM', 'UBE', 25.00, '2025-04-10', '2026-04-09'),
(3, 'ICE CREAM', 'CHEESE', 25.00, '1970-01-01', '1970-01-01'),
(4, 'ICE CREAM', 'BUBBLE GUM', 25.00, '1970-01-01', '1970-01-01'),
(5, 'ICE CREAM', 'CHEESE', 25.00, '1970-01-01', '1970-01-01'),
(6, 'ICE CREAM', 'CORN', 25.00, '1970-01-01', '1970-01-01'),
(7, 'ICE CANDY', 'CHOCOLATE', 10.00, '2025-06-10', '2025-04-03');

-- --------------------------------------------------------

--
-- Table structure for table `products_info`
--

CREATE TABLE `products_info` (
  `product_id` int(251) NOT NULL,
  `product_name` varchar(251) NOT NULL,
  `description` varchar(251) NOT NULL,
  `price` int(251) NOT NULL,
  `stock_quantity` int(251) NOT NULL,
  `date_added` date DEFAULT current_timestamp(),
  `category_name` varchar(251) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products_info`
--

INSERT INTO `products_info` (`product_id`, `product_name`, `description`, `price`, `stock_quantity`, `date_added`, `category_name`) VALUES
(16, 'MHA jacket', 'DEKU print on the back', 450, 15, '1970-01-01', 'ACCESSORIES'),
(17, 'ICE CREAM', 'MANGO', 25, 10, '2025-04-02', 'FOOD'),
(19, 'ICE CREAM', 'CHEESE', 25, 22, '1970-01-01', 'FOOD'),
(20, 'KEY CHAIN', 'ZORO', 50, 5, '2025-06-11', 'ACCESSORIES'),
(21, 'ICE CANDY', 'CHOCOLATE', 25, 12, '2025-04-03', 'FOOD'),
(22, 'ICE CANDY', 'UBE', 25, 10, '2025-07-16', 'FOOD'),
(23, 'ICE CANDY', 'BUBBLE GUM', 25, 12, '2025-05-28', 'FOOD'),
(24, 'ICE CREAM', 'CHOCOLATE', 30, 10, '2025-05-20', 'FOOD'),
(25, 'ONE PIECE', 'ZORO', 750, 15, '2025-06-25', 'CLOTHING'),
(27, 'ICE CREAM', 'CHOCOLATE', 30, 10, '1970-01-01', 'FOOD'),
(28, 'ONE PIECE action figure', 'ZORO THREE SWOED STYLE', 1500, 1, '1970-01-01', 'TOY'),
(29, 'ICE CANDY', 'TARO', 25, 10, '1970-01-01', 'FOOD'),
(30, 'ONE PIECE', 'WANTED POSTER LUFFY', 50, 30, '2025-02-25', 'DESIGN'),
(31, 'ONE PIECE', 'WANTED POSTER NAMI', 50, 30, '1970-01-01', 'DESIGN'),
(32, 'ONE PIECE', 'WANTED POSTER ZORO', 50, 30, '1970-01-01', 'DESIGN');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `Supplier_ID` int(11) NOT NULL,
  `Supplier_Name` varchar(255) NOT NULL,
  `Contact_Person` varchar(255) DEFAULT NULL,
  `Phone_Number` varchar(255) DEFAULT NULL,
  `Email_Address` varchar(100) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `supplydes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`Supplier_ID`, `Supplier_Name`, `Contact_Person`, `Phone_Number`, `Email_Address`, `Address`, `supplydes`) VALUES
(3, 'TechNova', '@technova', '9274455667', 'support@technova.com', '789 Silicon Ave., Makati', 'Supplier of computer hardware and electronics'),
(4, 'Fresh Harvest', '@freshharvestph', '9091889850', 'contact@freshharvest.com\'', '123 Mango St., Davao City', 'Supplier of fresh fruits and vegetables\''),
(5, 'BuildIt Co', '@builditPH', '9185567890', 'sales@builditco.com', 'Concrete Rd., Quezon City', 'Construction materials supplier'),
(6, 'Green Fields', '@greenfields', '9173344556', 'hello@greenfields.org', 'Lot 12 Farmville, Batangas', 'Organic farm produce and eco-friendly goods'),
(7, 'PaperTrail Corp', '@papertrailcorp', '9172233445', 'info@papertrail.com', '88 Office Park, Pasig City', 'Office and school supplies distributor'),
(8, 'TasteBuddy Foods', '@tastebuddy', '9186655443', 'orders@tastebuddy.com', 'Bldg. 3, Food St., Taguig', 'Distributor of ready-to-eat meals and snacks');

-- --------------------------------------------------------

--
-- Table structure for table `toy`
--

CREATE TABLE `toy` (
  `id` int(11) NOT NULL,
  `character_name` varchar(255) NOT NULL,
  `franchise` varchar(255) DEFAULT NULL,
  `height_cm` decimal(5,2) DEFAULT NULL,
  `articulation_points` int(11) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `toy`
--

INSERT INTO `toy` (`id`, `character_name`, `franchise`, `height_cm`, `articulation_points`, `material`, `release_date`, `price`) VALUES
(1, 'Levi Ackerman', 'Attack on Titan', 15.00, 12, 'PVC', '2023-04-13', 1200.00),
(2, 'Gojo Satoru', 'Jujutsu Kaisen', 18.00, 14, 'ABS/PVC', '2024-04-05', 1500.00),
(3, 'Levi Ackerman', 'Attack on Titan', 15.00, 12, 'PVC', '1970-01-01', 1200.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accdetails`
--
ALTER TABLE `accdetails`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `accessories`
--
ALTER TABLE `accessories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clothing`
--
ALTER TABLE `clothing`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `design`
--
ALTER TABLE `design`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products_info`
--
ALTER TABLE `products_info`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`Supplier_ID`);

--
-- Indexes for table `toy`
--
ALTER TABLE `toy`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accdetails`
--
ALTER TABLE `accdetails`
  MODIFY `id_user` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `accessories`
--
ALTER TABLE `accessories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `clothing`
--
ALTER TABLE `clothing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `design`
--
ALTER TABLE `design`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `products_info`
--
ALTER TABLE `products_info`
  MODIFY `product_id` int(251) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `Supplier_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `toy`
--
ALTER TABLE `toy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
