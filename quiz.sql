-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2020 at 11:15 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `content` varchar(200) NOT NULL,
  `ans` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `username` varchar(32) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`content`, `ans`, `date`, `username`, `id`) VALUES
('Ten tui la gi?', 'Tran<br>Hoang<br>[ans]Phuc<br>ABC', '2000-10-28', 'ab', 1),
('Ho tui la gi?', '[ans]Tran<br>Hoang<br>Phuc<br>ABC', '2000-10-28', 'ab', 2),
('Chu Lot tui la gi?', 'Tran<br>[ans]Hoang<br>Phuc<br>ABC', '2000-10-28', 'abc', 3),
('Tolo tui la gi?', 'Tran<br>Hoang<br>Phuc<br>[ans]ABC', '2000-10-28', 'abc', 4);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role` int(11) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `role`, `email`) VALUES
('12', 'c8fa19914eaf71d140dd0fba93b7d285', 1, '1@gmail.com'),
('ab', 'e10adc3949ba59abbe56e057f20f883e', 1, 'ab@gmail.com'),
('abc', 'e10adc3949ba59abbe56e057f20f883e', 1, 'a@gmail.com'),
('abcd', 'e10adc3949ba59abbe56e057f20f883e', 0, 'abc@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
