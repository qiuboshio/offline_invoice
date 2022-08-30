/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : erp_invoice

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2022-08-30 17:58:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for invoice_information
-- ----------------------------
DROP TABLE IF EXISTS `invoice_information`;
CREATE TABLE `invoice_information` (
  `merchants_no` varchar(50) CHARACTER SET utf32 NOT NULL COMMENT '商户编号',
  `branch_no` varchar(50) NOT NULL COMMENT '门店编号',
  `invoice_url` varchar(100) NOT NULL COMMENT '开票地址',
  `order_id` varchar(100) NOT NULL COMMENT '订单编号',
  `order_source` varchar(100) DEFAULT NULL COMMENT '订单来源',
  `order_amount` decimal(20,0) NOT NULL DEFAULT '0' COMMENT '开票金额',
  `goods_detail` varchar(200) NOT NULL COMMENT '商品详细信息',
  `goods_num` int(10) NOT NULL DEFAULT '1' COMMENT '商品数量',
  `apply_time` datetime NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invoice_information
-- ----------------------------

-- ----------------------------
-- Table structure for merchants_config
-- ----------------------------
DROP TABLE IF EXISTS `merchants_config`;
CREATE TABLE `merchants_config` (
  `merchants_name` varchar(50) NOT NULL COMMENT '商户名称',
  `merchants_no` varchar(50) NOT NULL COMMENT '商户编号',
  `branch_name` varchar(50) NOT NULL COMMENT '门店名称',
  `branch_no` varchar(50) NOT NULL COMMENT '门店编号',
  `channel_name` varchar(50) NOT NULL COMMENT '开票渠道',
  `channel_url` varchar(50) DEFAULT NULL COMMENT '开票渠道地址',
  `credentials` varchar(200) NOT NULL COMMENT '门店凭证',
  `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
  `goods_no` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `tax_flag` int(2) NOT NULL DEFAULT '0' COMMENT '含税标志(0:不含税 1:含税)',
  `tax_rate` double(10,0) NOT NULL COMMENT '税率',
  `merchants_tax_num` varchar(50) NOT NULL COMMENT '商户税号',
  PRIMARY KEY (`branch_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of merchants_config
-- ----------------------------
