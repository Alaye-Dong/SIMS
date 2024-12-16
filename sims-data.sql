/*
 Navicat Premium Dump SQL

 Source Server         : MysqlDemo
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : sims

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 16/12/2024 23:27:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_duration` int NOT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES (2, '操作系统', 4);
INSERT INTO `courses` VALUES (5, '实验', 4);
INSERT INTO `courses` VALUES (6, 'Koon Wai Han', 850);
INSERT INTO `courses` VALUES (7, 'Tang Wing Sze', 212);
INSERT INTO `courses` VALUES (8, 'Wong Wai Man', 401);
INSERT INTO `courses` VALUES (9, 'Takeuchi Mio', 30);
INSERT INTO `courses` VALUES (10, 'Lai Wing Fat', 322);
INSERT INTO `courses` VALUES (11, 'Siu Ling Ling', 428);
INSERT INTO `courses` VALUES (12, 'To Sum Wing', 841);
INSERT INTO `courses` VALUES (13, 'Hsuan Ka Ling', 749);
INSERT INTO `courses` VALUES (14, 'Shibata Hina', 285);
INSERT INTO `courses` VALUES (16, '实验2', 22);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '张三', 20, '女');
INSERT INTO `students` VALUES (5, 'Brenda Stephens', 461, 'F');
INSERT INTO `students` VALUES (6, 'Mok Hui Mei', 687, 'F');
INSERT INTO `students` VALUES (7, 'Nicole Thompson', 340, 'F');
INSERT INTO `students` VALUES (8, 'Miu Ting Fung', 921, 'M');
INSERT INTO `students` VALUES (9, 'Ishikawa Seiko', 275, 'F');
INSERT INTO `students` VALUES (10, 'Jiang Zhennan', 501, 'M');
INSERT INTO `students` VALUES (15, '增测试', 18, '男');
INSERT INTO `students` VALUES (16, 'Ala Vas', 17, '女');
INSERT INTO `students` VALUES (18, 'Kao Ka Ming', 807, 'M');
INSERT INTO `students` VALUES (19, 'Daniel Moreno', 146, 'M');
INSERT INTO `students` VALUES (20, 'Tammy Coleman', 349, 'F');
INSERT INTO `students` VALUES (21, 'Leung Sum Wing', 784, 'F');
INSERT INTO `students` VALUES (22, 'Yokoyama Sara', 104, 'F');
INSERT INTO `students` VALUES (23, 'Gong Xiuying', 77, 'F');
INSERT INTO `students` VALUES (24, 'Kong Ka Ling', 656, 'F');
INSERT INTO `students` VALUES (25, 'Frank Munoz', 865, 'M');
INSERT INTO `students` VALUES (29, '赠', 44, '女');
INSERT INTO `students` VALUES (30, '增测试', 55, '男');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (2, 'admin', 'admin123');
INSERT INTO `users` VALUES (3, 'user1', 'password1');
INSERT INTO `users` VALUES (4, 'user2', 'password2');
INSERT INTO `users` VALUES (5, 'guest', 'guest123');
INSERT INTO `users` VALUES (6, 'test', 'pass');
INSERT INTO `users` VALUES (7, 'test2', 'pass');

SET FOREIGN_KEY_CHECKS = 1;
