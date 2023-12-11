/*
 Navicat MySQL Data Transfer

 Source Server         : javaWeb
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 10/07/2023 16:35:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cId` int NOT NULL,
  `cName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `credit` float NOT NULL,
  `deleted` int NOT NULL,
  PRIMARY KEY (`cId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高数', 4, 0);
INSERT INTO `course` VALUES (2, '英语', 3, 0);
INSERT INTO `course` VALUES (3, '计算机网络', 3, 0);

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `sId` int NOT NULL,
  `sName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cId` int NOT NULL,
  `cName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` float NOT NULL,
  `deleted` int NOT NULL,
  PRIMARY KEY (`sId`, `cId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '张三', 1, '高数', 70, 1);
INSERT INTO `grade` VALUES (1, '张三', 2, '英语', 60, 1);
INSERT INTO `grade` VALUES (1, '张三', 3, '计算机网络', 81, 1);
INSERT INTO `grade` VALUES (2, '李四', 1, '高数', 55, 1);
INSERT INTO `grade` VALUES (2, '李四', 2, '英语', 57, 1);
INSERT INTO `grade` VALUES (2, '李四', 3, '计算机网络', 77, 1);
INSERT INTO `grade` VALUES (3, '王五', 1, '高数', 100, 1);
INSERT INTO `grade` VALUES (3, '王五', 2, '英语', 88, 1);
INSERT INTO `grade` VALUES (3, '王五', 3, '计算机网络', 52, 1);
INSERT INTO `grade` VALUES (4, '赵六', 1, '高数', 60, 0);
INSERT INTO `grade` VALUES (4, '赵六', 2, '英语', 65, 0);
INSERT INTO `grade` VALUES (4, '赵六', 3, '计算机网络', 54, 0);
INSERT INTO `grade` VALUES (5, '陈七', 1, '高数', 68, 0);
INSERT INTO `grade` VALUES (5, '陈七', 2, '英语', 46, 0);
INSERT INTO `grade` VALUES (5, '陈七', 3, '计算机网络', 73, 0);
INSERT INTO `grade` VALUES (6, '刘八', 1, '高数', 52, 1);
INSERT INTO `grade` VALUES (6, '刘八', 2, '英语', 45, 1);
INSERT INTO `grade` VALUES (6, '刘八', 3, '计算机网络', 76, 1);
INSERT INTO `grade` VALUES (7, '杨九', 1, '高数', 55, 0);
INSERT INTO `grade` VALUES (7, '杨九', 2, '英语', 51, 0);
INSERT INTO `grade` VALUES (7, '杨九', 3, '计算机网络', 48, 0);
INSERT INTO `grade` VALUES (8, '黄十', 1, '高数', 49, 0);
INSERT INTO `grade` VALUES (8, '黄十', 2, '英语', 62, 0);
INSERT INTO `grade` VALUES (8, '黄十', 3, '计算机网络', 83, 0);
INSERT INTO `grade` VALUES (9, '吴十一', 1, '高数', 86, 0);
INSERT INTO `grade` VALUES (9, '吴十一', 2, '英语', 46, 0);
INSERT INTO `grade` VALUES (9, '吴十一', 3, '计算机网络', 72, 0);
INSERT INTO `grade` VALUES (10, '马十二', 1, '高数', 77, 0);
INSERT INTO `grade` VALUES (10, '马十二', 2, '英语', 70, 0);
INSERT INTO `grade` VALUES (10, '马十二', 3, '计算机网络', 49, 0);
INSERT INTO `grade` VALUES (11, '高十三', 1, '高数', 80, 0);
INSERT INTO `grade` VALUES (11, '高十三', 2, '英语', 56, 0);
INSERT INTO `grade` VALUES (11, '高十三', 3, '计算机网络', 59, 0);
INSERT INTO `grade` VALUES (12, '郭十四', 1, '高数', 83, 0);
INSERT INTO `grade` VALUES (12, '郭十四', 2, '英语', 82, 0);
INSERT INTO `grade` VALUES (12, '郭十四', 3, '计算机网络', 54, 0);
INSERT INTO `grade` VALUES (13, '谭十五', 1, '高数', 64, 0);
INSERT INTO `grade` VALUES (13, '谭十五', 2, '英语', 58, 0);
INSERT INTO `grade` VALUES (13, '谭十五', 3, '计算机网络', 69, 0);
INSERT INTO `grade` VALUES (14, '叶十六', 1, '高数', 79, 0);
INSERT INTO `grade` VALUES (14, '叶十六', 2, '英语', 81, 0);
INSERT INTO `grade` VALUES (14, '叶十六', 3, '计算机网络', 61, 0);
INSERT INTO `grade` VALUES (15, '丁十七', 1, '高数', 51, 0);
INSERT INTO `grade` VALUES (15, '丁十七', 2, '英语', 74, 0);
INSERT INTO `grade` VALUES (15, '丁十七', 3, '计算机网络', 50, 0);
INSERT INTO `grade` VALUES (16, '洪十八', 1, '高数', 71, 0);
INSERT INTO `grade` VALUES (16, '洪十八', 2, '英语', 56, 0);
INSERT INTO `grade` VALUES (16, '洪十八', 3, '计算机网络', 84, 0);
INSERT INTO `grade` VALUES (17, '康十九', 1, '高数', 66, 0);
INSERT INTO `grade` VALUES (17, '康十九', 2, '英语', 71, 0);
INSERT INTO `grade` VALUES (17, '康十九', 3, '计算机网络', 86, 0);
INSERT INTO `grade` VALUES (18, '冯二十', 1, '高数', 70, 0);
INSERT INTO `grade` VALUES (18, '冯二十', 2, '英语', 43, 0);
INSERT INTO `grade` VALUES (18, '冯二十', 3, '计算机网络', 65, 0);
INSERT INTO `grade` VALUES (19, '陆二十一', 1, '高数', 59, 0);
INSERT INTO `grade` VALUES (19, '陆二十一', 2, '英语', 50, 0);
INSERT INTO `grade` VALUES (19, '陆二十一', 3, '计算机网络', 86, 0);
INSERT INTO `grade` VALUES (20, '余二十二', 1, '高数', 44, 0);
INSERT INTO `grade` VALUES (20, '余二十二', 2, '英语', 60, 0);
INSERT INTO `grade` VALUES (20, '余二十二', 3, '计算机网络', 87, 0);
INSERT INTO `grade` VALUES (21, '何二十三', 1, '高数', 65, 0);
INSERT INTO `grade` VALUES (21, '何二十三', 2, '英语', 61, 0);
INSERT INTO `grade` VALUES (21, '何二十三', 3, '计算机网络', 80, 0);
INSERT INTO `grade` VALUES (22, '雷二十四', 1, '高数', 76, 0);
INSERT INTO `grade` VALUES (22, '雷二十四', 2, '英语', 83, 0);
INSERT INTO `grade` VALUES (22, '雷二十四', 3, '计算机网络', 79, 0);
INSERT INTO `grade` VALUES (23, '龙二十五', 1, '高数', 90, 0);
INSERT INTO `grade` VALUES (23, '龙二十五', 2, '英语', 60, 0);
INSERT INTO `grade` VALUES (23, '龙二十五', 3, '计算机网络', 53, 0);
INSERT INTO `grade` VALUES (24, '谢二十六', 1, '高数', 89, 0);
INSERT INTO `grade` VALUES (24, '谢二十六', 2, '英语', 81, 0);
INSERT INTO `grade` VALUES (24, '谢二十六', 3, '计算机网络', 78, 0);
INSERT INTO `grade` VALUES (25, '潘二十七', 1, '高数', 44, 0);
INSERT INTO `grade` VALUES (25, '潘二十七', 2, '英语', 82, 0);
INSERT INTO `grade` VALUES (25, '潘二十七', 3, '计算机网络', 65, 0);
INSERT INTO `grade` VALUES (26, '段二十八', 1, '高数', 73, 0);
INSERT INTO `grade` VALUES (26, '段二十八', 2, '英语', 67, 0);
INSERT INTO `grade` VALUES (26, '段二十八', 3, '计算机网络', 48, 0);
INSERT INTO `grade` VALUES (27, '任二十九', 1, '高数', 86, 0);
INSERT INTO `grade` VALUES (27, '任二十九', 2, '英语', 82, 0);
INSERT INTO `grade` VALUES (27, '任二十九', 3, '计算机网络', 44, 0);
INSERT INTO `grade` VALUES (28, '梁三十', 1, '高数', 64, 0);
INSERT INTO `grade` VALUES (28, '梁三十', 2, '英语', 85, 0);
INSERT INTO `grade` VALUES (28, '梁三十', 3, '计算机网络', 73, 0);
INSERT INTO `grade` VALUES (29, '龚三十一', 1, '高数', 57, 0);
INSERT INTO `grade` VALUES (29, '龚三十一', 2, '英语', 63, 0);
INSERT INTO `grade` VALUES (29, '龚三十一', 3, '计算机网络', 69, 0);
INSERT INTO `grade` VALUES (30, '韩三十二', 1, '高数', 59, 0);
INSERT INTO `grade` VALUES (30, '韩三十二', 2, '英语', 85, 0);
INSERT INTO `grade` VALUES (30, '韩三十二', 3, '计算机网络', 86, 0);
INSERT INTO `grade` VALUES (1111, '999', 656, '544', 898, 1);

SET FOREIGN_KEY_CHECKS = 1;



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `account` int NULL DEFAULT NULL,
  `password` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, 123);
INSERT INTO `login` VALUES (2, 123);
INSERT INTO `login` VALUES (3, 123);
INSERT INTO `login` VALUES (4, 123);
INSERT INTO `login` VALUES (5, 123);
INSERT INTO `login` VALUES (6, 123);
INSERT INTO `login` VALUES (7, 123);
INSERT INTO `login` VALUES (8, 123);
INSERT INTO `login` VALUES (9, 123);
INSERT INTO `login` VALUES (10, 123);

SET FOREIGN_KEY_CHECKS = 1;



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sId` int NOT NULL,
  `sName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sClass` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deleted` int NOT NULL,
  PRIMARY KEY (`sId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '男', '计算机类2班', 0);
INSERT INTO `student` VALUES (2, '李四', '男', '计算机类1班', 0);
INSERT INTO `student` VALUES (3, '王五', '女', '计算机类1班', 0);
INSERT INTO `student` VALUES (4, '赵六', '男', '计算机类1班', 0);
INSERT INTO `student` VALUES (5, '陈七', '女', '计算机类1班', 0);
INSERT INTO `student` VALUES (6, '刘八', '男', '计算机类1班', 0);
INSERT INTO `student` VALUES (7, '杨九', '女', '计算机类1班', 0);
INSERT INTO `student` VALUES (8, '黄十', '男', '计算机类1班', 0);
INSERT INTO `student` VALUES (9, '吴十一', '女', '计算机类1班', 0);
INSERT INTO `student` VALUES (10, '马十二', '男', '计算机类1班', 0);
INSERT INTO `student` VALUES (11, '高十三', '女', '计算机类2班', 0);
INSERT INTO `student` VALUES (12, '郭十四', '男', '计算机类2班', 0);
INSERT INTO `student` VALUES (13, '谭十五', '女', '计算机类2班', 0);
INSERT INTO `student` VALUES (14, '叶十六', '男', '计算机类2班', 0);
INSERT INTO `student` VALUES (15, '丁十七', '女', '计算机类2班', 0);
INSERT INTO `student` VALUES (16, '洪十八', '男', '计算机类2班', 0);
INSERT INTO `student` VALUES (17, '康十九', '女', '计算机类2班', 0);
INSERT INTO `student` VALUES (18, '冯二十', '男', '计算机类2班', 0);
INSERT INTO `student` VALUES (19, '陆二十一', '女', '计算机类2班', 0);
INSERT INTO `student` VALUES (20, '余二十二', '男', '计算机类2班', 0);
INSERT INTO `student` VALUES (21, '何二十三', '女', '计算机类3班', 0);
INSERT INTO `student` VALUES (22, '雷二十四', '男', '计算机类3班', 0);
INSERT INTO `student` VALUES (23, '龙二十五', '女', '计算机类3班', 0);
INSERT INTO `student` VALUES (24, '谢二十六', '男', '计算机类3班', 0);
INSERT INTO `student` VALUES (25, '潘二十七', '女', '56', 1);
INSERT INTO `student` VALUES (26, '段二十八', '男', '计算机类3班', 0);
INSERT INTO `student` VALUES (27, '任二十九', '女', '计算机类3班', 0);
INSERT INTO `student` VALUES (28, '梁三十', '男', '计算机类3班', 0);
INSERT INTO `student` VALUES (29, '龚三十一', '女', '计算机类3班', 1);
INSERT INTO `student` VALUES (30, '韩三十二', '男', '计算机类3班', 1);
INSERT INTO `student` VALUES (100, 'wanghai', '男', '计算机类1班', 1);
INSERT INTO `student` VALUES (101, 'wangli', '女', '计算机类89班', 1);
INSERT INTO `student` VALUES (103, '666', '男', '计算机类456', 1);
INSERT INTO `student` VALUES (125, '六撒旦', '男', '计算机类5班', 0);

SET FOREIGN_KEY_CHECKS = 1;
