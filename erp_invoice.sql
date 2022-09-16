/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : erp_invoice

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2022-09-06 14:14:06
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
  `order_amount` decimal(20,4) NOT NULL DEFAULT '0.0000' COMMENT '开票金额',
  `goods_detail` varchar(200) NOT NULL COMMENT '商品详细信息',
  `apply_time` datetime NOT NULL,
  `sign` varchar(64) DEFAULT NULL COMMENT '签名信息',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_b_invoice_information
-- ----------------------------
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MTA1NDA4OTA3MjA1NnByanB3aA==&on=NzA0ODA1MzA1NzEwMTA1NDA5OTA1MDA5OTEwMDA1NzEwMTA5NzA1MjA1NDA5OTA1MjA1NzA1NzA5NzA1MzA1MzA1NTEwMTA1NTA1NTA5OTA1MzA0OTA5OTA0ODA1NjA1NjA1MzEwMDA1NTA1NjA0OTEwMTA1NDEwMDA1NjEwMDA1NDA1NjA1MjA0OTA1MTA1MjA5ODA1NzA5OTA5ODA0ODA5NzA1MTEwMTA1MTA1NDA1NDA5OTA1MDA0OHNyaHJreg==&flag=NjA5OTEwODEwNTEwMXBwa3BwcQ==', '059e6c2cd9ea46c499a557e77c51c0885d781e6d8d684134b9cb0a3e366c20f0', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-05 14:20:21', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NzA1NDA4OTA3MjA1NnJhd3Jqcw==&on=MzA0OTA1MDA1MTA1MjA0OTA1MTA1MDA1MzA0OTA1MDA1MzA1MDA1MTA1MzA0OTA1MDA1M3lseXlsaw==&flag=NjA5OTEwODEwNTEwMXBwa3BwcQ==', '1234132512523512523', null, '12.0000', '{\"taxRate\":\"0.06\",\"price\":12,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 11:42:36', '12342135124');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NjA1NDA4OTA3MjA1NmtxaGtucA==&on=MTA0OTA1MjA1NjA1NzA5OTA5NzA5NzA1MTA1NjEwMjA1MjA1NDA1MjEwMjA5ODEwMjA5NzA5ODA0ODA5OTEwMDA1MzA5OTA1NDEwMTA1NjA1MjEwMDA1NTA5NzA5NzA5ODA5ODA1NDEwMjA5OTA1NDA1NzA1MzA5ODEwMTEwMTEwMDA0OTA1MjA1NzA1NzA1NTA1NjA1MzA5OTA5ODA1MzEwMTA5ODA1NjA1MDA0OTA1MzA1MDA1MjA1MnBqZXBzeA==&flag=OTA5OTEwODEwNTEwMWdnZmdnaQ==', '1489caa38f464fbfab0cd5c6e84d7aabb6fc695beed1499785cb5eb821524451', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 13:38:04', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MTA1NDA4OTA3MjA1NnByanB3aA==&on=NjA0OTA5ODA0OTA1MjA5NzA0ODEwMjEwMjA1NDA5ODA5NzA5ODA1MjA1NzA1NzA0ODA5ODA1MTA1NjA5OTA1MDA5NzA0ODA1MjA0ODA1NDA0ODA5NzA0ODA0OTA1MzEwMTA1MjA0OTA1NjA1MTA5ODEwMjA1NDA0ODA1NzA1NjEwMjA5NzA1MjEwMDA0ODA1NDA5NzA1NjA1MjA1NDEwMjA1MTA1MzA1NTA0OTA1MTA1NTA0OTA1MDEwMGtoc2t3Zg==&flag=MTA5OTEwODEwNTEwMWhocGhocg==', '1b14a0ff6bab4990b38c2a04060a015e4183bf6098fa4d06a846f35713712d41', null, '325.0000', '{\"taxRate\":\"0.06\",\"price\":325.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 10:14:33', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NTA1NDA4OTA3MjA1NmdwcWdqbQ==&on=MjA0OTEwMjA1NzA5OTA1MjA0ODEwMTA1MjA5OTA1NjA5ODA5ODA1MjA5NzA1MzA1MjA5ODA1MDA1NDEwMjA1NTEwMDEwMjA1MjA1NTA1NDA5NzEwMjA1MzEwMDA1NjA1NjEwMTA1MzEwMjA1NDA1NjA1NjA1NTA0ODA1NjA5OTA5NzEwMDA1MjA1MzEwMTA0OTA1NjA1MzEwMDA0OTA1MzA1MjA0ODA1MjA1NzA5OTA1MzA0OTA1NTA0OW5seG53Yw==&flag=NjA5OTEwODEwNTEwMXBwa3BwcQ==', '1f9c40e4c8bb4a54b26f7df476af5d88e5f688708cad45e185d154049c517141', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 10:20:39', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NjA1NDA4OTA3MjA1NmtxaGtucA==&on=MTA1MDA1MTA1MTA5NzEwMDA0OTA0ODA1MzA0ODA5NzA5NzA1MzA1MjEwMjA1MTA5ODA5NzEwMTA5OTA1NDEwMDA1MjA5ODEwMDEwMjA0ODA1MTA1MzA1NjA0ODEwMDA1MTA1NTEwMDA1MDA1MjA1MjA1MDA1MzA1MDA1MzA1NjA0OTA1NTA1MjA1NzA1MDA1MTA1NzA5OTA1NzA0OTA0OTA5OTA1MjA0OTA0ODA1MjA1MTA1NjEwMTEwMXBqZXBqag==&flag=ODA5OTEwODEwNTEwMWxsamxsaA==', '233ad1050aa54f3baec6d4bdf03580d37d244252581749239c911c410438ee57', null, '32525.0000', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-08-31 17:45:01', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NzA1NDA4OTA3MjA1NnJhd3Jqcw==&on=NTA1MDA1MjA1MTA1MGdiY2dxdg==&flag=MDA5OTEwODEwNTEwMWJibGJiaw==', '243215', null, '1.0000', '{\"taxRate\":\"0.06\",\"price\":1,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 18:23:55', '235455');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NzA1NDA4OTA3MjA1NnJhd3Jqcw==&on=MDA1MTA1MzA5OTA0OTA0OTEwMTA0ODA1NTA1MzEwMDA1MDA0ODA1MjA0ODA0OTA0ODA5NzEwMDA1MzA1MzA5ODA1NjEwMjA1NTEwMDA1MjA1NzA1MDA1NDA0OTA5NzEwMTA1NjA1MDA1MjA1MjA1MzEwMjEwMDA1MTA5NzA1MDA5NzA1NzA1MjA1MTA1NzA1NzA5NzEwMjA0ODEwMjA0OTA1NzA1MjA1MTEwMTA5NzA1NjA5ODA1NDA0OWxpZ2xpbA==&flag=NTA5OTEwODEwNTEwMW1tZ21tcA==', '35c11e075d204010ad55b8f7d49261ae82445fd3a2a94399af0f1943ea8b6162', null, '32.2300', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-05 14:48:21', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MzA1NDA4OTA3MjA1NnlwbHlkaw==&on=MzA1MTEwMTA1MzA1MTA1MjEwMDA0ODA1MTA1NDA5OTA5ODA5OTA1MjA1MzA0ODA5ODA5ODEwMDA5ODA1NTA5NzA0ODA5NzA1MDA1MDA5ODEwMDA1MzA1NjA5NzEwMDA1NjEwMjA1MDA1MzA0OTA1NzA5NzA0OTEwMjEwMjEwMjEwMTA5ODA1MjA1NzA1NTA1MjA1NzEwMTA1NTA5NzEwMTA5ODA1MTA5ODA1MjEwMDA1NjA1NTEwMjEwMmt5ZXlseQ==&flag=MTA5OTEwODEwNTEwMWhocGhocg==', '3e534d036cbc450bbdb7a0a22bd58ad8f2519a1fffeb49749e7aeb3b4d87fff2', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 14:09:19', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NzA1NDA4OTA3MjA1NnJhd3Jqcw==&on=NjA1MjA1MjA1MTEwMjA1NjA1MTA1NzA5NzA5OTA1NTA1MzA1NzA1MjA0ODA5ODA0ODA5ODA5ODA1MjA1MTA1NTA1MzA1MDA1MzA1MDA1NTEwMTA1MDEwMTA5OTA5ODA5OTA1NjA1NDA1NDA1NzA0OTEwMTA1NjA1MjA1NTA5OTEwMDA0ODA1MjA1MzA1MTEwMTA5NzA0ODA0ODA1MjEwMjEwMTA1NTA1NjA5OTEwMjA1NTA1NjA1MTA5N2tobmtmZg==&flag=OTA5OTEwODEwNTEwMWdnZmdnaQ==', '443f839ac75940b0bb43752527e2ecbc86691e847cd0453ea004fe78cf783a9c', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-05 14:42:51', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MDA1NDA4OTA3MjA1NmxraWx1Yg==&on=NDA1MzEwMTA1NDEwMTA1MzA1NjA1NjA5NzA5OTA0OTEwMTA1NjA1MjA1NTA1MDA1NzA5NzA5OTA1NjA1MjA1NjA5NzA1MjA1MTA1NTEwMDA5OTEwMjA5ODA5OTA5ODA1NTEwMjA0ODA1MjA5ODA0OTEwMTA0ODA1MzA1NTA1MjA5OTA1MDA1MjA0ODA1MjEwMTA1NjA0ODA0ODA1MzA1NjA0ODA1MDA1NDA1MzA1MjA1NzA1MTA1MzA0OHhsbHhsbA==&flag=NDA5OTEwODEwNTEwMWdneGdncA==', '5e6e588ac1e84729ac848a437dcfbcb7f04b1e0574c2404e80058026549350cc', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 10:24:06', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NDA1NDA4OTA3MjA1NnhwZXhrZw==&on=MTA1NTA5ODA1NzA1MTA5ODEwMDEwMjA0OTA0ODA1NzA1MzEwMTA1MjA5ODEwMDA5NzA1NzA5OTEwMTA1NjA1MTA0OTA1MTA1NTA1MzA1NjA5OTEwMjA1NjA1NzA1NzA0ODA5NzEwMjA1NjA1MTEwMTA1NDA1MjA1MjA1NDA5ODA0OTA1MzA1MjEwMTA0OTA0OTA5ODEwMTA1MDA0OTA5NzA0OTA1NzEwMTEwMjA1NjEwMDA0ODA1NzEwMnBqd3Bqcg==&flag=NDA5OTEwODEwNTEwMWdneGdncA==', '7b93bdf1095e4bda9ce8313758cf8990af83e6446b154e11be21a19ef8d09f98', null, '32525.0000', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 09:27:38', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MjA1NDA4OTA3MjA1Nm52bG5lbQ==&on=MjA1NjA1NjA5OTA1NjA1MDA1NjA1NTA5ODA5NzA5OTA1MzA0OTA1MjEwMjEwMDA1NzA1NjEwMDA1NjA1MjA1NjA1MjA0ODA1MDA1MTEwMDA5OTA1NDA1MjA1MzA1NTA0OTA0ODA1NTA1NDA1NTEwMDA5OTA1NTEwMDA0OTA5ODA1MzA5ODA1MjA0OTA1NzA1NzA5NzA1NTA1NTA0ODEwMjA1NDA1NzEwMjA1MTA1MjA5ODA0ODA0ODA1MW5sbm53Yw==&flag=MTA5OTEwODEwNTEwMWhocGhocg==', '88c8287bac514fd98d8484023dc645710767dc7d1b5b4199a770f69f34b00321', null, '32525.0000', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 09:52:09', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NjA1NDA4OTA3MjA1NmtxaGtucA==&on=MjA1NzA1NzA0OTA1MjEwMTA5ODA1NTA5ODA1NjEwMTA1NjEwMDA1MjA1MTEwMDA1NTA5ODA1NDA1NTA0ODA5ODEwMDA1NTA1MjA1NzA0OTA1NDA1NDEwMTA1MTEwMTA5ODA1MzA5OTA1MDEwMDA1MTA1MDA1MjEwMjA1NDA0OTA5OTA0OTA1MjA0OTA0OTA5NzA5ODEwMTA1NzA5OTEwMDA0ODA1NjA1NTEwMDA1MTEwMDA1NDEwMTA1N25jZW1ueA==&flag=MTA5OTEwODEwNTEwMWhocGhocg==', '9914eb7b8e8d43d7b670bd749166e3eb5c2d324f61c1411abe9cd087d3d6e9af', null, '325.0000', '{\"taxRate\":\"0.06\",\"price\":325.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 09:57:39', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NzA1NDA4OTA3MjA1NnJhd3Jqcw==&on=NzA1NzA5NzA0OTEwMDA1NzA1NjEwMTEwMDA1NTEwMDA5ODA1NTA1MjA5OTEwMjEwMjA1NjA1NjA1MjA1MjEwMTA5ODA1NjA1NDA5OTA1MTA5OTEwMDA1MTA5NzEwMTA1NTA0ODEwMjA5NzA1NzA1MjEwMTA5NzA1MTA1MDA1MDEwMDA1MjA1MjA0ODA1NjA1MzA5NzA1NzA1NDA1NTA0ODA1MDEwMjA1MDA0ODEwMDA1MDA1MDA1MzA1MHJ3d3J3aA==&flag=MTA5OTEwODEwNTEwMWhocGhocg==', '9a1d98ed7db74cff8844eb86c3cd3ae70fa94ea322d44085a96702f20d225274', null, '32525.0000', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 09:48:50', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MjA1NDA4OTA3MjA1Nm52bG5lbQ==&on=NjA5NzA1MTA1MjA5NzA5ODA1NTEwMTA0OTA1NzA1NjA0OTA1NDA1MjA1MzA5NzEwMDA5NzA1NDA1NjEwMDA1MjEwMTEwMTA1NzA1MTA1NjA5ODA0OTA1NTA1NTEwMjA0OTA1MjA5ODEwMjA1MDA0ODA1MDA1MzA1NjA5ODEwMjA1NDEwMTA1MjA1MTA1NTA1MTA5ODA1MDA1NTA5NzA1MTA1NTA1NDA1MTA1MzEwMDA1MTA1NDA1MzA5OWtod2tocQ==&flag=MDA5OTEwODEwNTEwMWJibGJiaw==', 'a34ab7e1981645ada68d4ee938b177f14bf20258bf6e4373b27a37635d365c68', null, '32525.0000', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 09:24:47', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=OTA1NDA4OTA3MjA1NmZpamZlZw==&on=MzA5ODA1MDA1NDA1NjA1NTA1MDEwMDEwMjEwMjA1NDA0OTA1NjA1MjEwMjA5NzA1NzA5NzEwMjA0OTA5OTA1NTEwMTA1NDA1MTA0ODA1NzA1NTA1MzA1MzA5ODA5NzA1MzA1MDEwMDA1NzA5ODEwMTA1NTEwMDA1MzA0ODA0ODA1MzA1NjA1MjEwMDA1MzA1NDA1NjA5NzA1MDA5OTEwMDA0OTA1MzEwMDEwMjA1NjA1NjA1MDA1MjA1Nmt5a2t5eQ==&flag=MjA5OTEwODEwNTEwMW1tbm1tdg==', 'b26872dff6184fa9af1c7e6309755ba52d9be7d500584d568a2cd15df88248ed', null, '32.2300', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-05 15:41:49', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MDA1NDA4OTA3MjA1NmxraWx1Yg==&on=NDA5OTA1MzEwMjA1NDEwMjA5OTA1MzA5ODA1NjA0ODA1MTA1MzA1MjA0OTA1MjA1MTA1NjA1MDA1NTA1MDA1MzA1NDA1NDA1MDA1MjEwMDA0OTA1MzA5NzA1NTA1MTEwMjA1NzA1MDA5OTA1NTA5NzA1NzA5NzA1MjEwMjA0OTEwMDA1NTA1MjA1NDA1MzA1MzA1NjA0ODA0ODA0OTA1MTA1MTA1MjEwMDA1NDA1NTA0OTA1MTA0ODA0OHhobHhleA==&flag=NTA5OTEwODEwNTEwMW1tZ21tcA==', 'c5f6fc5b80354143827256624d15a73f92c7a9a4f1d746558001334d67130012', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-05 10:19:36', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=OTA1NDA4OTA3MjA1NmZpamZlZw==&on=MTA5OTA5OTA5ODA0OTEwMDA1MTA5ODEwMDA1MzA1NTA0OTA0ODA1MjEwMDEwMDA1MjA1NjA1MzA1NDA1NzA1MTA1MTA1MzA5ODA0OTA1MjA1MjA0ODA5NzA1MjA1MTA1MjA1NDA1MTA5NzA5OTA1NDA1MjEwMDA0ODEwMTA5ODA5OTA0ODA1MjA1NzA1MTA1MDA1NjA1NTA1MjA1NDA1MzEwMjA1NTA1MzA1MjA1MDA1NDA1NzEwMTA5OHBqcHBqZA==&flag=MjA5OTEwODEwNTEwMW1tbm1tdg==', 'ccb1d3bd57104dd48569335b1440a43463ac64d0ebc0493287465f754269eb24', null, '32.0000', '{\"taxRate\":\"0.06\",\"price\":32.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-05 14:41:11', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=MDA1NDA4OTA3MjA1NmxraWx1Yg==&on=MzEwMDA1MjA1NDA1MjA1NDA0OTA5NzA5OTEwMjA1MzA1NTA1NjA1MjEwMTA5OTA1MTA5ODA1NDA0OTA0ODA5ODA5NzA1NTEwMTA1MTA1NTA5NzA1MTA0OTEwMjEwMDA1MTA0OTA1NTEwMjA1MjA1MjA0OTA1MTA1MjEwMjA1NDA1MTA0OTA1MjA1MDA1NDA0OTA1NjA1MTEwMDA5OTA1MzA1NTA1MzA5NzEwMjA1NTA1NjA1NTEwMDA1NHlsZXlseQ==&flag=OTA5OTEwODEwNTEwMWdnZmdnaQ==', 'd46461acf5784ec3b610ba7e37a31fd317f44134f631426183dc575af787d642', null, '325.0000', '{\"taxRate\":\"0.06\",\"price\":325.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-09-01 10:11:08', '863812666');
INSERT INTO `t_b_invoice_information` VALUES ('123456789', 'http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=ODA1NDA4OTA3MjA1NmpoYWp6bA==&on=MzEwMjA5ODA5ODA1NzA5OTEwMDA1MzA1NjEwMTA5OTEwMjA1MTA1MjEwMjA5OTA1MTA1NzA1NDA1MzA5OTA1NDA1MDA1NzA0OTA5NzA1NDA1MDA0ODA0OTA1MDA0ODA1MjA1NjA1MzA0OTA0ODA1MzA0OTA5OTA0OTEwMDA1MTA1NTA1NjA1MjA1MjA1MzA5NzA1NzA1NjEwMDA1MTEwMDA1NjA1MDA1NjA1NTA5ODEwMDA1NTA5OTA1MHlseXlsZQ==&flag=OTA5OTEwODEwNTEwMWdnZmdnaQ==', 'fbb9cd58ecf34fc3965c6291a6201204851051c1d378445a98d3d8287bd7c224', null, '32525.0000', '{\"taxRate\":\"0.06\",\"price\":32525.23,\"num\":1,\"withTaxFlag\":\"1\",\"goodsName\":\"测试商品\"}', '2022-08-31 17:41:20', '863812666');

-- ----------------------------
-- Table structure for t_b_merchants_config
-- ----------------------------
DROP TABLE IF EXISTS `t_b_merchants_config`;
CREATE TABLE `t_b_merchants_config` (
  `merchants_name` varchar(100) DEFAULT NULL COMMENT '商户名称',
  `customer_id` varchar(16) NOT NULL COMMENT '平台商户标识',
  `store_name` varchar(50) DEFAULT NULL COMMENT '门店名称',
  `store_id` varchar(32) NOT NULL COMMENT '平台门店标识',
  `channel_name` varchar(50) DEFAULT NULL COMMENT '开票渠道',
  `channel_url` varchar(50) DEFAULT NULL COMMENT '开票渠道地址',
  `credentials` varchar(200) NOT NULL COMMENT '门店凭证(appkey等)',
  `merchants_tax_num` varchar(50) NOT NULL COMMENT '商户税号',
  `apply_invoice_person` varchar(50) NOT NULL COMMENT '开票人',
  `goods_detail` varchar(255) NOT NULL COMMENT '商品详情',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_b_merchants_config
-- ----------------------------
INSERT INTO `t_b_merchants_config` VALUES ('1234', '1234', '1234', '1234', null, null, '1234', '1234', '邱泽鹏', '1234', '2022-09-05 15:54:30', '2022-09-05 15:54:30', '1234');
INSERT INTO `t_b_merchants_config` VALUES ('1234', '1234', '1234', '123445', null, null, '1234', '1234', '邱泽鹏', '1234', '2022-09-05 15:57:37', '2022-09-05 15:57:37', '1234');
INSERT INTO `t_b_merchants_config` VALUES ('1234', '1234', '1234', '1234456', null, null, '1234', '1234', '邱泽鹏', '1234', '2022-09-05 15:58:19', '2022-09-05 15:58:19', '1234');
INSERT INTO `t_b_merchants_config` VALUES ('乡村基', '123456', '乡村基鲤鱼池店', '123456789', '航信诺诺', 'https://open.nuonuo.com', '{\"appKey\":\"SD63236305\",\"appSecret\":\"SDDED2523BED4643\"}', '339902999999789114', '张三', '{\"goodsName\": \"测试商品\",\"withTaxFlag\":\"1\",\"taxRate\":\"0.06\"}', '2022-08-31 13:40:05', '2022-08-31 13:40:09', '915878367@qq.com');
