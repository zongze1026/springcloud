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

 Date: 02/12/2019 15:40:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for point
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `point_num` bigint(20) NOT NULL DEFAULT 0 COMMENT '消费积分',
  `add_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
