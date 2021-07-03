-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2019 at 10:04 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wedding`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `UserName`, `Password`) VALUES
(1, 'sharika', '202cb962ac59075b964b07152d234b70'),
(2, 'maliha', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL,
  `bookingDate` date NOT NULL,
  `bookingTime` time NOT NULL,
  `customer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingID`, `bookingDate`, `bookingTime`, `customer`) VALUES
(3, '2019-04-23', '12:00:00', NULL),
(4, '2019-04-23', '18:00:00', NULL),
(5, '2019-04-24', '12:00:00', NULL),
(6, '2019-04-24', '18:00:00', NULL),
(7, '2019-04-25', '12:00:00', NULL),
(8, '2019-04-25', '18:00:00', NULL),
(9, '2019-04-26', '12:00:00', NULL),
(10, '2019-04-26', '18:00:00', NULL),
(14, '2019-04-27', '12:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `confirmbooking`
--

CREATE TABLE `confirmbooking` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Mobile` int(11) NOT NULL,
  `GuestNumber` int(11) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Time` varchar(255) NOT NULL,
  `IDBooking` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `confirmbooking`
--

INSERT INTO `confirmbooking` (`ID`, `Name`, `Address`, `Email`, `Mobile`, `GuestNumber`, `Date`, `Time`, `IDBooking`) VALUES
(1, 'sas', 'sas', 'sas', 1, 1, 'sa', 'asa', 1),
(2, 'ss', 'ss', 'ss', 1, 1, 'dd', 'ww', 11),
(3, 'dd', 'ss', 'cc', 1, 1, 'dd', 'ff', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `ContactId` int(11) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Massage` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`ContactId`, `UserName`, `Email`, `Massage`) VALUES
(1, 'sasasa', 'sasasa', 'asasas'),
(2, 'sas', 'sasa', 'asas'),
(3, 'xs', 'cd', 'dsd'),
(4, 'ccx', 'xxc', 'xx'),
(5, 'sd', 'dsd', 'dds'),
(6, 'xz', 'zx', 'zx'),
(7, 'xz', 'zx', 'zx'),
(8, 'sas', 'aas', 'sa'),
(9, 'xz', 'xzx', 'xzx'),
(10, 'jj', 'jj', 'jj'),
(11, 'sas', 'esas', 'You pressed OK!'),
(12, 'ASAS', 'SAS', 'SASS'),
(13, '', '', ''),
(14, '', '', ''),
(15, 'asasa', '', ''),
(16, 'sasa', 'sasa', 'sasa'),
(17, 'sasa', 'sasa', 'sasa'),
(18, 'sasa', 'sasa', 'sasa'),
(19, 'sasa', 'sasa', 'sasa'),
(20, 'sasa', 'sasa', 'sasa'),
(21, 'sas', 'saa', 'sasa'),
(22, 'sas', 'saa', 'sasa'),
(23, 'sasasa', 'sdsd', 'sdd'),
(24, 'sas', 'sasa', 'sas'),
(25, 'sas', 'sasa', 'sas'),
(26, 'as', 'dsd', 'as'),
(27, 'as', 'dsd', 'as'),
(28, 'sa', 'ssd', 'sasa'),
(29, 'sa', 'ssd', 'sasa'),
(30, 'sasa', 'sas', 'as'),
(31, 'sas', 'saa', 'sasss'),
(32, 'sas', 'saa', 'sasss'),
(33, 'aa', 'aa', 'aa'),
(34, 'aa', 'aa', 'aa'),
(35, 'ss', 'dd', 'dd'),
(36, 'ss', 's', 'd'),
(37, 'k', 'k', 'k'),
(38, 'm', 'm', 'k'),
(39, 'k', 'k', 'l'),
(40, 'k', 'k', 'l'),
(41, 'jj', 'nn', 'nn'),
(42, 'jj', 'nn', 'nn'),
(43, 'jj', 'nn', 'nn');

-- --------------------------------------------------------

--
-- Table structure for table `photo`
--

CREATE TABLE `photo` (
  `photoID` int(11) NOT NULL,
  `photo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `photo`
--

INSERT INTO `photo` (`photoID`, `photo`) VALUES
(1, '1.jpg'),
(2, '2.jpg'),
(3, '3.jpeg'),
(4, '4.jpg'),
(5, '5.jpg'),
(6, '6.jpg'),
(7, '7.jpg'),
(8, '8.jpg'),
(9, '9.jpg'),
(10, '10.jpg'),
(11, '11.jpg'),
(12, '12.jpg'),
(13, '13.jpg'),
(14, '14.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `venueID` int(11) NOT NULL,
  `venueName` varchar(255) NOT NULL,
  `firstImage` varchar(255) NOT NULL,
  `secondImage` varchar(255) NOT NULL,
  `thirdImage` varchar(255) NOT NULL,
  `venueFacilities` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `venue`
--

INSERT INTO `venue` (`venueID`, `venueName`, `firstImage`, `secondImage`, `thirdImage`, `venueFacilities`) VALUES
(3, 'Indoor Decoration', 'indoor1.jpg', 'indoor2.jpg', 'indoor3.jpg', '    •  23,000 sq. ft. ballroom\r\n    • 3000 sq. ft. stage\r\n    • Fully air conditioned\r\n    • RGB Strip lighting\r\n    • No echoes\r\n    • Standby generator & IPS\r\n    • Fire extinguishing system\r\n    • Accommodation of 1000 people\r\n\r\n'),
(4, 'Outdoor Decoration', 'outdoor1.jpg', 'outdoor2.jpg', 'outdoor3.jpg', '• Open space environment\r\n• Luxurious fountain\r\n• Spacious car parking facility');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`),
  ADD UNIQUE KEY `customer` (`customer`);

--
-- Indexes for table `confirmbooking`
--
ALTER TABLE `confirmbooking`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`ContactId`);

--
-- Indexes for table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`photoID`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`venueID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `confirmbooking`
--
ALTER TABLE `confirmbooking`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `ContactId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `photo`
--
ALTER TABLE `photo`
  MODIFY `photoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `venue`
--
ALTER TABLE `venue`
  MODIFY `venueID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
