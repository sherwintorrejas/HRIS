-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2023 at 01:44 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hris`
--

-- --------------------------------------------------------

--
-- Table structure for table `hris_emp`
--

CREATE TABLE `hris_emp` (
  `emp_id` int(50) NOT NULL,
  `emp_lname` varchar(50) NOT NULL,
  `emp_fname` varchar(50) NOT NULL,
  `emp_position` varchar(50) NOT NULL,
  `emp_address` varchar(100) NOT NULL,
  `emp_status` varchar(20) NOT NULL,
  `emp_gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hris_emp`
--

INSERT INTO `hris_emp` (`emp_id`, `emp_lname`, `emp_fname`, `emp_position`, `emp_address`, `emp_status`, `emp_gender`) VALUES
(2, 'alright', 'niceone', 'OFFICIALS', 'erer', 'Single', 'Male'),
(3, 'Laroa', 'Ryan Ky', 'BHW', 'Cuanos', 'Single', 'Male'),
(16, 'ere', 'rewrewr', 'BHW', 'erewr', 'Married', 'Male'),
(17, 'rerer', 'erer', 'BHW', 'erere', 'Single', 'Male'),
(19, 'ewrewr', 'erewr', 'OFFICIALS', 'erewrwer', 'Married', 'Male'),
(20, 'quines', 'james', 'BHW', 'sfdasafasf', 'Married', 'Male'),
(23, 'da', 'aa', 'Manager ', 'd', 'Single', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_acc`
--

CREATE TABLE `tbl_acc` (
  `emp_id` int(50) NOT NULL,
  `a_fname` varchar(50) NOT NULL,
  `a_lname` varchar(50) NOT NULL,
  `a_username` varchar(50) NOT NULL,
  `a_password` varchar(100) NOT NULL,
  `a_address` varchar(100) NOT NULL,
  `a_email` varchar(50) NOT NULL,
  `a_gender` varchar(10) NOT NULL,
  `a_position` varchar(20) NOT NULL,
  `a_nationality` varchar(50) NOT NULL,
  `a_DOB` varchar(100) NOT NULL,
  `a_image` longblob NOT NULL,
  `a_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_acc`
--

INSERT INTO `tbl_acc` (`emp_id`, `a_fname`, `a_lname`, `a_username`, `a_password`, `a_address`, `a_email`, `a_gender`, `a_position`, `a_nationality`, `a_DOB`, `a_image`, `a_status`) VALUES
(3, 'quines', 'Ernest', 'mike', 'testpass', 'tungkill', 'tungkill', 'Male', 'Tanod', 'Philippines', 'Mon Jun 12 11:05:36 SGT 2023', 0x6e756c6c, ''),
(9, 'rrewre', '43rewd', 'ernest', '123456', 'dfdf', 'dfdf', 'Male', 'BHW', 'American Samoa', 'Tue Apr 11 00:00:00 SGT 2023', 0x6e756c6c, 'Active'),
(14, 'wad', 'adw', 'testt', '$2a$10$1pzztVOFhgFP1kNAiGUt.u4cLOayUjvoGoVXlvzd6OFh/oCqPdnxS', 'sdaw', 'sdaw', 'Male', 'Manager ', 'Afghanistan', 'Wed May 17 00:00:00 SGT 2023', 0x6e756c6c, 'Active'),
(15, 'a', 'a', 'a', '$2a$10$S7NBoRQOFjjXMOf2NM1jP.aK0pKpPv7mWi.blZM1FtIIWNoVFnNhK', 'a', 'a', 'Male', 'Manager ', 'Afghanistan', 'Fri May 05 00:00:00 SGT 2023', 0x6e756c6c, 'Pending'),
(16, 'a', 'a', 'a', '$2a$10$h3lsQvy4dBnXUqXwapTwduWOPnAcx.k/l8hQsncoEE80bULS4P3Ce', 'a', 'a', 'Male', 'Manager ', 'Afghanistan', 'Fri May 05 00:00:00 SGT 2023', 0x6e756c6c, 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_emp`
--

CREATE TABLE `tbl_emp` (
  `emp_Id` int(20) NOT NULL,
  `emp_lname` int(11) NOT NULL,
  `emp_Name` varchar(20) NOT NULL,
  `emp_Job` varchar(20) NOT NULL,
  `emp_gender` varchar(10) NOT NULL,
  `emp_stat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `timeinput`
--

CREATE TABLE `timeinput` (
  `Ts_id` int(50) NOT NULL,
  `T_date` varchar(50) NOT NULL,
  `T_In` varchar(20) NOT NULL,
  `T_out` varchar(20) NOT NULL,
  `T_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `timeinput`
--

INSERT INTO `timeinput` (`Ts_id`, `T_date`, `T_In`, `T_out`, `T_id`) VALUES
(1, 'Tue May 16 20:22:52 SGT 2023', '08:22 AM', '10:22 PM', 1),
(2, 'Sun Mar 12 20:19:52 SGT 2023', '08:19 AM', '12:19 PM', 2),
(123, 'Fri May 12 00:00:00 SGT 2023', '07:09 PM', '07:09 PM', 123);

-- --------------------------------------------------------

--
-- Table structure for table `timesheet_employee`
--

CREATE TABLE `timesheet_employee` (
  `T_id` int(50) NOT NULL,
  `Ts_id` int(50) NOT NULL,
  `T_month` varchar(20) NOT NULL,
  `T_year` varchar(20) NOT NULL,
  `emp_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `timesheet_employee`
--

INSERT INTO `timesheet_employee` (`T_id`, `Ts_id`, `T_month`, `T_year`, `emp_id`) VALUES
(1, 1, '', '', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hris_emp`
--
ALTER TABLE `hris_emp`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `tbl_acc`
--
ALTER TABLE `tbl_acc`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `tbl_emp`
--
ALTER TABLE `tbl_emp`
  ADD PRIMARY KEY (`emp_Id`);

--
-- Indexes for table `timeinput`
--
ALTER TABLE `timeinput`
  ADD PRIMARY KEY (`Ts_id`),
  ADD KEY `T_id` (`T_id`);

--
-- Indexes for table `timesheet_employee`
--
ALTER TABLE `timesheet_employee`
  ADD PRIMARY KEY (`T_id`),
  ADD KEY `timesheet_employee` (`emp_id`) USING BTREE,
  ADD KEY `timesheet_employee_ibfk_1` (`Ts_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hris_emp`
--
ALTER TABLE `hris_emp`
  MODIFY `emp_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `tbl_acc`
--
ALTER TABLE `tbl_acc`
  MODIFY `emp_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_emp`
--
ALTER TABLE `tbl_emp`
  MODIFY `emp_Id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `timeinput`
--
ALTER TABLE `timeinput`
  MODIFY `Ts_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- AUTO_INCREMENT for table `timesheet_employee`
--
ALTER TABLE `timesheet_employee`
  MODIFY `T_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `timesheet_employee`
--
ALTER TABLE `timesheet_employee`
  ADD CONSTRAINT `emp_id` FOREIGN KEY (`emp_id`) REFERENCES `hris_emp` (`emp_id`),
  ADD CONSTRAINT `timesheet_employee_` FOREIGN KEY (`T_id`) REFERENCES `timeinput` (`Ts_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
