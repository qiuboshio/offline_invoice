package com.pax.offline_invoice.controller;

import com.pax.offline_invoice.util.QrUtil.QrCodeUtil;
import com.pax.offline_invoice.util.resultutil.JsonResult;
import com.pax.offline_invoice.util.resultutil.ResultCode;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
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
    public JsonResult QRCode(){
        /**
         * @MethodName: QRCode
         * @Description: 生成二维码  http://192.168.10.250:8888/QRCode/generate   http://192.168.88.1:8888/QRCode/generate
         * @Author: qiuzepeng
         * @Date: 2022/8/31 10:06
         * @param :
         * @return String
         */
        //门店id
        String storeId = "0202109000000310005";
        //订单金额
        String price = "32.23";
        //商品数量
        String num = "1";
        //签名
        String sign = "863812666";
        //订单编号
        String orderId = UUID.randomUUID().toString().replace("-", "")+UUID.randomUUID().toString().replace("-", "");
        //192.168.88.1
       // String xx = "amount=10&orderId=1234&sessionId=99E6AD9B386AF269D7FB3E60132C3C0C&sessionKey=1662542261608";
       // String content = "http://192.168.10.250:19001/offline-invoice/invoice/apply?amount=10&sessionId=A01BED0D65776D9EAE762ED28778ABAD&sign=430476045CEDF1CD47FE50AB333CA9C8&orderId="+orderId;
        // String content = "http://192.168.88.1:19001/offline-invoice/invoice/apply?amount=3.00&orderId=2452LLsppv8&sessionId=19&sign=11E7C507A7A9B59D5C6457EB05EF00F9";
        String content = "http://192.168.10.250:19001/vas-ois/invoice/apply?amount=3.00&orderId=er52dfsdfddqLLLdCCfafppv8&sessionId=32&sign=7BA893EA1C2D93D9FA2CCB3D05EF20E5";
        //String content = "http://192.168.10.250:8888/invoice/apply"+"?storeId="+storeId+"&price="+price+"&num="+num+"&sign="+sign+"&orderNo="+orderNo;
        QrCodeUtil.encode("UTF-8",content,500,500,"jpg","D:\\nuonuo.jpg");

        Map map = new HashMap();
        map.put("url","324");
        map.put("xxx","2451");
        JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS,"success",map);
        return jsonResult;
    }
}
