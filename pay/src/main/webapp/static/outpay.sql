/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : outpay

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2016-07-14 22:36:54
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
-- Records of classification
-- ----------------------------
INSERT INTO `classification` VALUES ('1', '1', '1', '11');
INSERT INTO `classification` VALUES ('2', '吼吼', '1哈哈', '1');

-- ----------------------------
-- Table structure for outpay
-- ----------------------------
DROP TABLE IF EXISTS `outpay`;
CREATE TABLE `outpay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_type` varchar(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `money` decimal(11,2) NOT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `create_time` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outpay
-- ----------------------------
INSERT INTO `outpay` VALUES ('1', '1', '1', '23.32', 'allen', '20160505211953');
INSERT INTO `outpay` VALUES ('2', '2', '2', '20.72', 'CGy', '20160505211953');
