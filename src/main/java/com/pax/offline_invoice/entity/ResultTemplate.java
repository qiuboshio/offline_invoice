package com.pax.offline_invoice.entity;

import lombok.Data;

/**
 * @projectname offline_invoice
 * @Classname ResultTemplate
 * @Description 返回数据格式
 * @Version 1.0.0
 * @Date 2022/8/31 16:35
 * @Created by qiuzepeng
 */
@Data
public class ResultTemplate {
    private String qrCodeUrl; //开票地址
    private String sign;//签名信息
}
