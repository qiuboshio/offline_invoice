/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : erp_invoice

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2022-08-31 18:23:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_b_invoice_information
-- ----------------------------
DROP TABLE IF EXISTS `t_b_invoice_information`;
CREATE TABLE `t_b_invoice_information` (
  `store_no` varchar(31) NOT NULL COMMENT '平台门店标识',
  `invoice_url` varchar(500) NOT NULL COMMENT '开票地址',
  `order_id` varchar(100) NOT NULL COMMENT '订单编号',
  `order_source` varchar(100) DEFAULT NULL COMMENT '订单来源',
  `order_amount` decimal(20,0) NOT NULL DEFAULT '0' COMMENT '开票金额',
  `goods_detail` varchar(200) NOT NULL COMMENT '商品详细信息',
  `apply_time` datetime NOT NULL,
  `sign` varchar(64) DEFAULT NULL COMMENT '签名信息',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_b_invoice_information
-- ----------------------------
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NjA1NDA4OTA3MjA1NmtxaGtucA==&on=MTA1MDA1MTA1MTA5NzEwMDA0OTA0ODA1MzA0ODA5NzA5NzA1MzA1MjEwMjA1MTA5ODA5NzEwMTA5OTA1NDEwMDA1MjA5ODEwMDEwMjA0ODA1MTA1MzA1NjA0ODEwMDA1MTA1NTEwMDA1MDA1MjA1MjA1MDA1MzA1MDA1MzA1NjA0OTA1NTA1MjA1NzA1MDA1MTA1NzA5OTA1NzA0OTA0OTA5OTA1MjA0OTA0ODA1MjA1MTA1NjEwMTEwMXBqZXBqag==&flag=ODA5OTEwODEwNTEwMWxsamxsaA==', '233ad1050aa54f3baec6d4bdf03580d37d244252581749239c911c410438ee57', null, '32525', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-08-31 17:45:01', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=ODA1NDA4OTA3MjA1NmpoYWp6bA==&on=MzEwMjA5ODA5ODA1NzA5OTEwMDA1MzA1NjEwMTA5OTEwMjA1MTA1MjEwMjA5OTA1MTA1NzA1NDA1MzA5OTA1NDA1MDA1NzA0OTA5NzA1NDA1MDA0ODA0OTA1MDA0ODA1MjA1NjA1MzA0OTA0ODA1MzA0OTA5OTA0OTEwMDA1MTA1NTA1NjA1MjA1MjA1MzA5NzA1NzA1NjEwMDA1MTEwMDA1NjA1MDA1NjA1NTA5ODEwMDA1NTA5OTA1MHlseXlsZQ==&flag=OTA5OTEwODEwNTEwMWdnZmdnaQ==', 'fbb9cd58ecf34fc3965c6291a6201204851051c1d378445a98d3d8287bd7c224', null, '32525', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-08-31 17:41:20', '863812666');

-- ----------------------------
-- Table structure for t_b_merchants_config
-- ----------------------------
DROP TABLE IF EXISTS `t_b_merchants_config`;
CREATE TABLE `t_b_merchants_config` (
  `merchants_name` varchar(100) NOT NULL COMMENT '商户名称',
  `customer_id` varchar(16) NOT NULL COMMENT '平台商户标识',
  `store_name` varchar(50) NOT NULL COMMENT '门店名称',
  `store_id` varchar(32) NOT NULL COMMENT '平台门店标识',
  `channel_name` varchar(50) NOT NULL COMMENT '开票渠道',
  `channel_url` varchar(50) DEFAULT NULL COMMENT '开票渠道地址',
  `credentials` varchar(200) NOT NULL COMMENT '门店凭证(appkey等)',
  `tax_flag` varchar(2) NOT NULL DEFAULT '0' COMMENT '含税标志(0:不含税 1:含税)',
  `tax_rate` double(10,0) NOT NULL COMMENT '税率',
  `merchants_tax_num` varchar(50) NOT NULL COMMENT '商户税号',
  `apply_invoice_person` varchar(50) NOT NULL COMMENT '开票人',
  `goods_detail` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_b_merchants_config
-- ----------------------------
INSERT INTO `t_b_merchants_config` VALUES ('乡村基', '123456', '乡村基鲤鱼池店', '123456789', '航信诺诺', 'https://open.nuonuo.com', '{\"APPKey\":\"SD63236305\",\"APPSecret\":\"SDDED2523BED4643\"}', '1', '0', '339902999999789114', '张三', '{\"goodsName\": \"测试商品\",\"withTaxFlag\":\"1\",\"taxRate\":\"0.06\"}', '2022-08-31 13:40:05', '2022-08-31 13:40:09', null);
