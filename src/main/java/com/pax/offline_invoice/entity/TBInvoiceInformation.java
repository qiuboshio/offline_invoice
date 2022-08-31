package com.pax.offline_invoice.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @projectname offline_invoice
 * @Classname InvoiceInformation
 * @Description 发票信息
 * @Version 1.0.0
 * @Date 2022/8/30 17:52
 * @Created by qiuzepeng
 */
@Data
public class TBInvoiceInformation implements Serializable {
    private String storeNo; //门店编号
    private String invoiceUrl; //开票地址
    private String orderId; //订单id
    private String orderSource; //订单来源
    private BigDecimal orderAmount; //订单金额
    private String goodsDetail; //商品详细信息
    private String applyTime; //申请时间
    private String sign; //签名信息

}
