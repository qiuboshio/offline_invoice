package com.pax.offline_invoice.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 诺诺离线扫码接口
 */
@RestController
@Api( description = "直连调试")
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
                "  \"buyerTel\": \"16666666666\",\n" +
                "  \"listFlag\": \"0\",\n" +
                "  \"departmentId\": \"\",\n" +
                "  \"clerkId\": \"\",\n" +
                "  \"remark\": \"这是备注\",\n" +
                "  \"checker\": \"王五\",\n" +
                "  \"buyerInfoEditAble\": \"0\",\n" +
                "  \"payee\": \"李四\",\n" +
                "  \"buyerAddress\": \"文一路999999号\",\n" +
                "  \"buyerTaxNum\": \"339901999999119\",\n" +
                "  \"invoiceLine\": \"p\",\n" +
                "  \"salerAccount\": \"中国银行9999999999\",\n" +
                "  \"orderNo\": \"cb213e4cf69fd0aea92c47430336fa2030e181bbf0d8c01f\",\n" +
                "  \"salerTel\": \"0571-88888888\",\n" +
                "  \"callBackUrl\": \"\",\n" +
                "  \"invoiceDate\": \"2018-04-26 18:51:41\",\n" +
                "  \"buyerName\": \"张三丰有限公司\",\n" +
                "  \"notifyPhone\": \"13892827272\",\n" +
                "  \"orderTotal\": \"11\",\n" +
                "  \"salerAddress\": \"杭州文一路888号\",\n" +
                "  \"clerk\": \"张三\",\n" +
                "  \"buyerAccount\": \"中国银行23434554535\",\n" +
                "  \"productOilFlag\": \"0\",\n" +
                "  \"salerTaxNum\": \"339902999999789113\",\n" +
                "  \"listName\": \"\",\n" +
                "  \"detail\": [\n" +
                "    {\n" +
                "      \"specType\": \"规格型号\",\n" +
                "      \"favouredPolicyName\": \"\",\n" +
                "      \"num\": \"1\",\n" +
                "      \"favouredPolicyFlag\": \"0\",\n" +
                "      \"taxRate\": \"0.13\",\n" +
                "      \"unit\": \"kg\",\n" +
                "      \"deduction\": \"\",\n" +
                "      \"zke\": \"\",\n" +
                "      \"price\": \"8\",\n" +
                "      \"zeroRateFlag\": \"\",\n" +
                "      \"goodsCode\": \"1090511030000000000\",\n" +
                "      \"goodsName\": \"测试商品\",\n" +
                "      \"taxIncludedAmount\": \"100\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"notifyEmail\": \"19883@qq.com\"\n" +
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
