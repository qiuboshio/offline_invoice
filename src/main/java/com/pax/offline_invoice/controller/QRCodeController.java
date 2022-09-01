package com.pax.offline_invoice.controller;

import com.pax.offline_invoice.util.QrUtil.QrCodeUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @projectname offline_invoice
 * @Classname QRCodeController
 * @Description 生成二维码
 * @Version 1.0.0
 * @Date 2022/8/31 9:50
 * @Created by qiuzepeng
 */
@RestController
@RequestMapping("/QRCode")
@Api( description = "生成二维码功能")
public class QRCodeController {
    @GetMapping("/generate")
    public String QRCode(){
        /**
         * @MethodName: QRCode
         * @Description: 生成二维码  http://192.168.10.250:8888/QRCode/generate
         * @Author: qiuzepeng
         * @Date: 2022/8/31 10:06
         * @param :
         * @return String
         */
        //门店id
        String storeId = "123456789";
        //订单金额
        String price = "32.23";
        //商品数量
        String num = "1";
        //签名
        String sign = "863812666";
        //订单编号
        String orderNo = UUID.randomUUID().toString().replace("-", "")+UUID.randomUUID().toString().replace("-", "");
        String content = "http://192.168.10.250:8888/invoice/find"+"?storeId="+storeId+"&price="+price+"&num="+num+"&sign="+sign+"&orderNo="+orderNo;
        QrCodeUtil.encode("UTF-8",content,500,500,"jpg","D:\\nuonuo.jpg");
        return content;
    }
}
