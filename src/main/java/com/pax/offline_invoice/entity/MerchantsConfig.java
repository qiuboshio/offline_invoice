package com.pax.offline_invoice.entity;

import lombok.Data;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfig
 * @Description 商户配置信息
 * @Version 1.0.0
 * @Date 2022/8/30 17:27
 * @Created by qiuzepeng
 */
@Data
public class MerchantsConfig {
    private String merchantsName;//商户名称
    private String merchantsNo; //商户编号
    private String branchName; //门店名称
    private String branchNo; //门店编号
    private String channel_name; //渠道编号
    private String channel_url; //渠道地址
    private String credentials; //门店凭证
    private String goods_name; //商品名称
    private String goods_no; //商品编号
    private Integer taxFlag; //税率标志
    private double taxRate; //税率
    private String merchantsTaxNum; //商户税号
}
