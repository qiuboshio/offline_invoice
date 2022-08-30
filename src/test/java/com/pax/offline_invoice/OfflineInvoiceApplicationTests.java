package com.pax.offline_invoice;

import com.alibaba.fastjson.JSONObject;
import com.pax.offline_invoice.entity.MerchantsConfig;
import nuonuo.open.sdk.NNOpenSDK;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
class OfflineInvoiceApplicationTests {

    @Test
    void contextLoads() {
        NNOpenSDK sdk = NNOpenSDK.getIntance();

        String senid1 = UUID.randomUUID().toString();
        String senid = senid1.replace("-", "");
        System.out.println(System.currentTimeMillis());
        System.currentTimeMillis();
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString());
//
//        System.out.println(senid1);
//        System.out.println(senid);
//        System.out.println(senid.length());
    }
    @Test
    void RandomTest(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<8;i++){
            stringBuffer.append(random.nextInt(10));
        }
        String nonce = new String(stringBuffer);
        System.out.println(String.valueOf(System.currentTimeMillis()));
    }
    @Test
    void jsonTest(){
        Map<String,String> map = new HashMap<>();
        map.put("goodsName","测试商品");
        map.put("withTaxFlag","1");
        map.put("goodsCode","1090511030000000000");
        map.put("taxRate","0.13");
        Map<String,Object> map1 = new HashMap<>();
        map1.put("detail",map);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(map1);
        System.out.println(jsonObject);
    }

//    https://open.nuonuo.com/authorize?appKey=SD63236305&response_type=code&redirect_uri=https://baidu.com&state=xxxxxx
    @Test
    void tokenTest(){
        String appkey = "SD63236305";
        String aPPSecret = "SDDED2523BED4643";
        String url = "https://sandbox.nuonuocs.cn/open/v1/services";
        String merchantToken = NNOpenSDK.getIntance().getMerchantToken(appkey, aPPSecret, url);
        String json = NNOpenSDK.getIntance().getISVToken(appkey,aPPSecret,"code","taxnum","redirectUri");
        System.out.println("11"+merchantToken);
    }
    @Test
    void sdkPost(){
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String taxnum = "339902999999789113";//ISV下授权商户税号
        String appKey = "SD63236305";
        String appSecret = "SDDED2523BED4643";
        String method = "nuonuo.ElectronInvoice.saveScanTemp";//API方法名
        String token = "2d484e**************pdui";//访问令牌
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
                "  \"orderNo1\": \"cb213dcf6pfd0aep92c47430336fa2030e181bbf0d8c01f\",\n" +
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
      //  String content = String.valueOf(JSON.parseObject(String.valueOf(jsonObject)));
        System.out.println(jsonObject);
        //String url = "https://sdk.nuonuo.com/open/v1/services"; //SDK请求地址（正式环境）
        String url = "https://sandbox.nuonuocs.cn/open/v1/services"; //sdk请求地址（测试环境）
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
        String json = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, String.valueOf(jsonObject));
        System.out.println(json);
    }
    @Test
    void stringTest(){
        String xx = "cb213dcf69fd0aep92c47430336fa2030e181bbf0d8c01f";
        System.out.println(xx.length());
        MerchantsConfig merchantsConfig = new MerchantsConfig();
        merchantsConfig.setMerchantsName("23");
        merchantsConfig.getMerchantsName();
        System.out.println(merchantsConfig.getMerchantsName());
    }


}
