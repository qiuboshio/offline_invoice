package com.pax.offline_invoice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfig
 * @Description 商户配置信息
 * @Version 1.0.0
 * @Date 2022/8/30 17:27
 * @Created by qiuzepeng
 */
@Data
public class TBMerchantsConfig implements Serializable {
    private String merchantsName;//商户名称
    private String customerId; //平台商户标识
    private String storeName; //门店名称
    @TableId
    private String storeId; //门店编号
    private String channelName; //渠道编号
    private String channelUrl; //渠道地址
    private String credentials; //门店凭证
    private String merchantsTaxNum; //商户税号
    private String applyInvoicePerson; //申请人
    private String goodsDetail; //商品详情
    private String updateTime; //修改时间
    private String addTime; //添加时间
    private String email; //交付邮箱
}
