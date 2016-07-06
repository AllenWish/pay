/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : outpay

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2016-07-06 22:58:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classification
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class1` varchar(64) NOT NULL,
  `class2` varchar(64) NOT NULL,
  `class3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for outpay
-- ----------------------------
DROP TABLE IF EXISTS `outpay`;
CREATE TABLE `outpay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `type` int(2) NOT NULL,
  `money` decimal(11,2) NOT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
