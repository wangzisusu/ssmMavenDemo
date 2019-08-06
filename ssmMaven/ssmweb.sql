/*
Navicat MySQL Data Transfer

Source Server         : localhost@mm
Source Server Version : 50540
Source Host           : 127.0.0.1:3361
Source Database       : ssmweb

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-06-16 10:55:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `username` varchar(20) DEFAULT NULL COMMENT '登录用户',
  `time` datetime DEFAULT NULL COMMENT '登录时间',
  `url` varchar(200) DEFAULT NULL COMMENT '访问地址',
  `cost` int(11) DEFAULT NULL COMMENT '请求耗时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 1:男  0:女',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `address` varchar(100) DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '张三', '0', '18', '北京');
INSERT INTO `t_student` VALUES ('3', '李四', '1', '22', '天津');
INSERT INTO `t_student` VALUES ('4', '王五', '1', '23', '上海');
INSERT INTO `t_student` VALUES ('5', '赵六', '1', '34', '广州');
INSERT INTO `t_student` VALUES ('6', '田七', '0', '12', '日本');
INSERT INTO `t_student` VALUES ('7', '孙八', '1', '34', '重庆');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `t_user` VALUES ('2', 'haohao', 'haohao');
