/*
 Navicat Premium Data Transfer

 Source Server         : 47.111.163.95
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 47.111.163.95:3306
 Source Schema         : dayuanyun

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 02/12/2019 15:39:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_price` decimal(10, 2) NOT NULL,
  `order_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
