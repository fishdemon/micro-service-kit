/*
Navicat MySQL Data Transfer

Source Server         : Localhost_root
Source Server Version : 50626
Source Host           : 127.0.0.1:3306
Source Database       : msk-auth

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2020-07-01 17:05:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` int(11) NOT NULL,
  `ip` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `type` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `action_method` varchar(255) DEFAULT NULL,
  `action_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求参数',
  `browser` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '浏览器',
  `class_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类路径',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `finish_time` timestamp NULL DEFAULT NULL COMMENT '完成时间',
  `consuming_time` bigint(11) DEFAULT NULL COMMENT '消耗时间',
  `ex_desc` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '异常详情信息',
  `ex_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '异常描述',
  `tenant_id` int(11) DEFAULT NULL COMMENT '租户id',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作地点',
  `os` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作系统',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号,本权限可能是该父编号权限的子权限',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `code` varchar(100) NOT NULL COMMENT '权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
  `icon` varchar(255) NOT NULL DEFAULT '' COMMENT '图标',
  `type` varchar(20) NOT NULL COMMENT '资源类型，[menu|button|api]',
  `url` varchar(200) NOT NULL COMMENT '资源路径 如：/userinfo/list',
  `method` varchar(6) NOT NULL COMMENT '请求方法 get/post/put/delete',
  `sort` int(11) NOT NULL COMMENT '顺序',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态：0:已删除 1:正常',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '角色标识程序中判断使用,如"admin"',
  `code` varchar(20) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '角色描述,UI界面显示使用',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除状态：0:已删除 1:正常',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `fk_role_id` (`role_id`) USING BTREE,
  KEY `fk_permission_id` (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `nickname` varchar(30) NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像',
  `email` varchar(30) NOT NULL DEFAULT '' COMMENT '用户邮件',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态：1: 正常状态, 2：用户被锁定',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态：0:已删除 1:正常',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `nickname` (`nickname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`) USING BTREE,
  KEY `fk_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
