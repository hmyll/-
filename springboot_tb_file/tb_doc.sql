/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : tb_doc

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2022-05-12 18:35:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_doc
-- ----------------------------
DROP TABLE IF EXISTS `tb_doc`;
CREATE TABLE `tb_doc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `type` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_doc
-- ----------------------------
INSERT INTO `tb_doc` VALUES ('1', '-1', 'C', '0');
INSERT INTO `tb_doc` VALUES ('2', '1', 'picture', '0');
INSERT INTO `tb_doc` VALUES ('3', '2', 'pic1.jpg', '1');
INSERT INTO `tb_doc` VALUES ('4', '2', 'pic2.jpg', '1');
INSERT INTO `tb_doc` VALUES ('5', '1', 'powerpoint', '0');
INSERT INTO `tb_doc` VALUES ('6', '5', 'ppt1.ppt', '1');
INSERT INTO `tb_doc` VALUES ('7', '5', 'ppt2.ppt', '1');
SET FOREIGN_KEY_CHECKS=1;
