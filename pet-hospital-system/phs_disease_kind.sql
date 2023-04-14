/*
 Navicat Premium Data Transfer

 Source Server         : RuoYi
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : localhost:3306
 Source Schema         : phs

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 31/03/2023 12:31:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for phs_disease_kind
-- ----------------------------
DROP TABLE IF EXISTS `phs_disease_kind`;
CREATE TABLE `phs_disease_kind`  (
  `id` int(11) NOT NULL,
  `kind_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phs_disease_kind
-- ----------------------------
INSERT INTO `phs_disease_kind` VALUES (1, '传染病');
INSERT INTO `phs_disease_kind` VALUES (2, '寄生虫病');
INSERT INTO `phs_disease_kind` VALUES (3, '内科病例');
INSERT INTO `phs_disease_kind` VALUES (4, '其他病例');

SET FOREIGN_KEY_CHECKS = 1;
