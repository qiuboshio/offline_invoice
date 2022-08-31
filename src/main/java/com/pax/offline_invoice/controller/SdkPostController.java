package com.pax.offline_invoice.controller;

import com.alibaba.fastjson.JSONObject;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 诺诺离线扫码接口
 */
@RestController
public class SdkPostController {

    @GetMapping("/sdkPostController")
    /**
     * @MethodName: sdkPostController
     * @Description: http://192.168.10.250:8888/sdkPostController  向诺诺发送post请求开票地址
     * @Author: qiuzepeng
     * @Date: 2022/8/31 10:16
     * @param :
      * @return java.lang.String
    */

    public String sdkPostController(){
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String taxnum = "339902999999789113";//ISV下授权商户税号
        String appKey = "SD63236305";
        String appSecret = "SDDED2523BED4643";
        String method = "nuonuo.ElectronInvoice.saveScanTemp";//API方法名
        String token = "2d484e**************pdui";//访问令牌
        //随机生成64位uuid作为订单号
        String orderNo = UUID.randomUUID().toString().replace("-", "")+UUID.randomUUID().toString().replace("-", "");
        String content1 = "{\n" +
                "  \"invoiceDate\": \"2018-04-26 18:51:41\",\n" +
                "  \"orderTotal\": \"11\",\n" +
                "  \"salerTaxNum\": \"339902999999789113\",\n" +
                "  \"detail\": [\n" +
                "    {\n" +
                "      \"num\": \"1\",\n" +
                "      \"taxRate\": \"0.13\",\n" +
                "      \"price\": \"8\",\n" +
                "      \"goodsName\": \"测试商品\",\n" +
                "    }\n" +
                "  ],\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(content1);
        jsonObject.put("orderNo",orderNo);
        //String url = "https://sdk.nuonuo.com/open/v1/services"; //SDK请求地址（正式环境）
        String url = "https://sandbox.nuonuocs.cn/open/v1/services"; //sdk请求地址（测试环境）
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
        String json = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, String.valueOf(jsonObject));
        JSONObject jsonObject1 = JSONObject.parseObject(json);
        Object ewmUrl = jsonObject1.getJSONObject("result").get("ewmUrl").toString();
        System.out.println(ewmUrl);
        System.out.println(json);
        return json;
    }
}
