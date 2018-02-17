/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.12
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 192.168.1.12
 Source Database       : scaffold_backend_interactive

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 11/28/2017 13:57:52 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hy_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `create_tm` datetime DEFAULT NULL COMMENT '创建时间',
  `update_tm` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色表';

-- ----------------------------
--  Records of `hy_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', 'ROLE_CLIENT_USER', '2017-11-24 09:15:54', '2017-11-24 09:15:57'), ('2', 'ROLE_CLIENT_GUST', '2017-11-24 09:17:42', '2017-11-24 09:17:44');
COMMIT;

-- ----------------------------
--  Table structure for `hy_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `username` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户登录名称',
  `userpassword` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `realname` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户真实姓名',
  `mobile` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户手机号码',
  `userstatus` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户状态，1：为正常状态',
  `credentialssalt` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '加密盐',
  `email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户邮箱地址',
  `create_tm` datetime DEFAULT NULL COMMENT '创建时间',
  `update_tm` datetime DEFAULT NULL COMMENT '修改时间',
  `last_password_reset_date` datetime DEFAULT NULL,
  `headimage` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';

-- ----------------------------
--  Records of `hy_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$R8FBdJq.lBU81kRoiSe6FexfMqQp63pt.wKC9PYkHYvtoOZHC1nWW', 'admin', null, '1', '25b7f5afee0d962a', null, null, null, null, null), ('933906447044534272', 'baidu-123', '$2a$10$LPJo.ckYIiPNIVli9TB2n.JOA81GPYnDdLtcJEKECOTUlcoxufggi', '122112', null, '1', '25b7f5afee0d962a', null, '2017-11-24 11:53:42', null, null, 'https://gam.kits.com/e0b7b9a3-f228-4505-91b4-7a777821d95d');
COMMIT;

-- ----------------------------
--  Table structure for `hy_userconnection`
-- ----------------------------
DROP TABLE IF EXISTS `sys_userconnection`;
CREATE TABLE `sys_userconnection` (
  `userId` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `providerId` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `providerUserId` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rank` int(11) DEFAULT NULL,
  `displayName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `profileUrl` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `imageUrl` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `accessToken` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `secret` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `refreshToken` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  `unionid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Records of `hy_userconnection`
-- ----------------------------
BEGIN;
INSERT INTO `sys_userconnection` VALUES ('1', 'baidu', '3778335622', '1', 'aaaaasd2222', null, '9de161616161617364323232325930', '21.5f9709d8c649466dd277ce81aa296477.2592000.1514022485.3778335622-10427375', null, '22.b776a6e23a8cfc4bdb3df1aca8850bfc.315360000.1826790485.3778335622-10427375', '1514022489558', null), ('933906447044534272', 'baidu', '123', '1', '122112', null, 'http://pic62.nipic.com/file/20150325/20317067_142103944000_2.jpg', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Records of `user_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('933906447271026688', '933906447044534272', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
