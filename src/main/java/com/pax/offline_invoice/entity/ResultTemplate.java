package com.pax.offline_invoice.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "响应数据模型")
public class ResultTemplate {
    @ApiModelProperty(value = "开票地址")
    private String qrCodeUrl; //开票地址
    @ApiModelProperty(value = "签名信息")
    private String sign;//签名信息
}
