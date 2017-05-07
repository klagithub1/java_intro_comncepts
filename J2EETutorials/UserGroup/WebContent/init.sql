-- phpMyAdmin SQL Dump
-- version 3.3.8
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2011 at 05:39 AM
-- Server version: 5.1.52
-- PHP Version: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `soen387_usergroup`
--

-- --------------------------------------------------------

--
-- Table structure for table `usergroup_group`
--

CREATE TABLE IF NOT EXISTS `usergroup_group` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `usergroup_group`
--


-- --------------------------------------------------------

--
-- Table structure for table `usergroup_invite`
--

CREATE TABLE IF NOT EXISTS `usergroup_invite` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `groupID` int(12) NOT NULL,
  `recipientID` int(12) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `usergroup_invite`
--


-- --------------------------------------------------------

--
-- Table structure for table `usergroup_user`
--

CREATE TABLE IF NOT EXISTS `usergroup_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `usergroup_user`
--

