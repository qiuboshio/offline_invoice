package com.pax.offline_invoice;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import nuonuo.open.sdk.NNOpenSDK;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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
        String xx = "{\"code\":\"E0000\",\"describe\":\"同步成功\",\"result\":{\"ewmUrl\":\"http://nnfpbox.nuonuocs.cn/invoice/scan/k.do?jc=NDA1NDA4OTA3MjA1NnhwZXhrZw==&on=NjEwMDA5OTA1MjA1NTA1NTA1NzA5ODA5NzA0OTA1NzEwMDEwMDA1MjA0OTEwMjA1NjA5NzA1NDA0OTEwMDA5NzA0OTA1NjA5NzA1MDEwMjA1NDA1MjEwMjEwMTEwMTA1MjA1NjA5NzA5NzA0OTA0ODA5ODA1MDA1MTA1MTA1NTA1MjA5OTA1MjA0OTA1MjA0OTA5ODA1NDA5NzA1NjA1MzA5ODA1MDA5OTA1NDA1MTA0ODA5NzA1MDA1MWtmeWtmZg==&flag=MzA5OTEwODEwNTEwMWtreWtrcA==\"}}";
        JSONObject jsonObject = JSON.parseObject(xx);
        String result = JSON.parseObject(jsonObject.get("result").toString()).get("ewmUrl").toString();
        System.out.println(result);
        System.out.println(jsonObject.get("result"));
        System.out.println(jsonObject.get("code"));
    }
    @Test
    void timeTest(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
    @Test
    void messageDigestTest() throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("md5");
        String UUID = java.util.UUID.randomUUID().toString();
        String pwd = "123456";
        String name = UUID+pwd;
        System.out.println("盐值："+UUID);
        System.out.println("密码："+pwd);
        System.out.println("盐值加密："+name);
        instance.update(name.getBytes());
        instance.reset();
        byte[] digest = instance.digest(name.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String row = Integer.toHexString(b&0xff);
            if(row.length()==1){
                row = "0" + row;
            }
            sb.append(row);
        }
        System.out.println("加密后："+sb.toString());

    }
    @Test
    void splitTest(){

        long time = new DateTime("2022-09-13 15:25:06").getTime();
        long l = time + 86400;
        long c = Long.valueOf("84000");
        System.out.println(time);
        System.out.println(l);
        System.out.println(l>time);
        System.out.println(c);
    }
    @Test
    void base64(){
        String token = "eyJhdGkiOiI5ZmMyMGU5ZS1jYTljLTRhODEtYjRmZS00YjFmYjU3MGRkYzEiLCJjbGllbnRfaWQiOiJtcy13ZWIiLCJyb2xlVHlwZXMiOlsiY21zLmFkbWluIiwiY3VzdG9tZXIiLCJvcy5jdXN0b21lciIsIm9zLnN0b3JlIiwicW9zLmN1c3RvbWVyIiwicW9zLnN0b3JlIiwic3IuY3VzdG9tZXIiLCJzci5zdG9yZSIsInN0b3JlIl0sInJvbGVzIjpbImN1c3RvbWVyLmFkbWluIiwic3RvcmUuYWRtaW4iLCJvcy5jdXN0b21lci5hZG1pbiIsIm9zLnN0b3JlLmFkbWluIiwic3IuY3VzdG9tZXIuYWRtaW4iLCJzci5zdG9yZS5hZG1pbiIsInFvcy5zdG9yZS5hZG1pbiIsInFvcy5jdXN0b21lci5hZG1pbiIsIm1wLmN1c3RvbWVyLmFkbWluIiwibXAuc3RvcmUuYWRtaW4iXSwidXNlcklkIjoxMDA3MzkzMiwidXNlck5hbWUiOiJtZXJjaGFudDg4In0=";
        byte[] decode = Base64.getDecoder().decode(token.getBytes(StandardCharsets.UTF_8));
        JSONObject jsonObject = JSON.parseObject(new String(decode, StandardCharsets.UTF_8));
        Integer userId = (Integer) jsonObject.get("userId");
        System.out.println(new String(decode, StandardCharsets.UTF_8));
        System.out.println(userId);
    }
    @Test
    void storeId(HttpServletRequest request){
        //String xx = "[{\"storeId\":\"0202111000000060013\",\"customerId\":\"020211100000006\",\"agentId\":\"88800024\",\"merchantName\":\"商户助手测试有限公司\",\"acquirerId\":\"72000007\",\"merId\":\"13202111151020310003\",\"storeName\":\"真正的\",\"storeType\":\"4\",\"address\":\"英语歌润发\",\"contactPhone\":\"18555555\",\"storeImage\":\"http://192.168.13.242:8888/M00/00/98/wKgN8mGumy2AesUbAGr3Lu60XeU148.jpg\",\"gmtCreate\":\"2021-12-07 15:17:56\",\"creator\":\"admin\",\"gmtModified\":\"2022-07-28 17:01:05\",\"version\":0,\"memberIdentify\":\"0\",\"memberAdd\":\"0\",\"memberRecharge\":\"0\",\"memberRefund\":\"0\",\"memberApply\":\"0\",\"memberReturn\":\"0\",\"memberReport\":\"0\",\"cmsAgentKey\":\"\",\"giftCardSell\":\"\",\"giftCardOrderQuery\":\"\",\"giftCardQuery\":\"\",\"giftCardSnQuery\":\"\",\"products\":0,\"productList\":[{\"versionId\":86,\"productId\":56,\"productCode\":\"os\",\"productName\":\"智慧餐饮管理平台\",\"versionName\":\"测试版本\",\"saleType\":\"2\",\"month\":\"\",\"price\":\"0\",\"expireDate\":\"长期\",\"creator\":\"admin\",\"gmtCreate\":\"2021-12-07 15:18:51\"}],\"openProducts\":\"os\"},{\"storeId\":\"0202111000000060003\",\"customerId\":\"020211100000006\",\"agentId\":\"88800024\",\"merchantName\":\"商户助手测试有限公司\",\"acquirerId\":\"72000007\",\"merId\":\"13202111151020310003\",\"storeName\":\"正餐门店\",\"storeType\":\"3\",\"provinceCode\":\"\",\"cityCode\":\"\",\"districtCode\":\"\",\"address\":\"\",\"contactPhone\":\"1333333\",\"storeImage\":\"http://192.168.13.242:8888/M00/00/95/wKgN8mGUge-AXc-MAAD6IsarA38875.jpg\",\"gmtCreate\":\"2021-11-17 20:11:38\",\"creator\":\"admin\",\"gmtModified\":\"2022-07-28 17:01:05\",\"version\":0,\"memberIdentify\":\"0\",\"memberAdd\":\"0\",\"memberRecharge\":\"0\",\"memberRefund\":\"0\",\"memberApply\":\"0\",\"memberReturn\":\"0\",\"memberReport\":\"0\",\"cmsAgentKey\":\"\",\"giftCardSell\":\"\",\"giftCardOrderQuery\":\"\",\"giftCardQuery\":\"\",\"giftCardSnQuery\":\"\",\"products\":0,\"productList\":[{\"versionId\":86,\"productId\":56,\"productCode\":\"os\",\"productName\":\"智慧餐饮管理平台\",\"versionName\":\"测试版本\",\"saleType\":\"2\",\"month\":\"\",\"price\":\"0\",\"expireDate\":\"\",\"creator\":\"admin\",\"gmtCreate\":\"2021-11-17 20:11:48\"}],\"openProducts\":\"os\"}]";
      //  String xx= "[]";
        String xx = "{\"code\":20000,\"message\":\"请求成功\",\"result\":[{\"storeId\":\"0202109000000310011\",\"customerId\":\"020210900000031\",\"agentId\":\"88800026\",\"merchantName\":\"商户服务平台测试商户\",\"acquirerId\":\"72000009\",\"merId\":\"11202109271743090001\",\"storeName\":\"2022\",\"storeType\":\"\",\"provinceCode\":\"\",\"cityCode\":\"\",\"districtCode\":\"\",\"address\":\"\",\"contactPhone\":\"023-67904081\",\"storeImage\":\"http://192.168.13.242:8888/M00/00/9E/wKgN8mHmhvKAaeSUAAEbvvZeDEg144.jpg\",\"gmtCreate\":\"2022-01-18 17:23:15\",\"creator\":\"merchant88\",\"gmtModified\":\"2022-07-05 19:12:12\",\"modifier\":\"merchant88\",\"version\":0,\"memberIdentify\":\"0\",\"memberAdd\":\"0\",\"memberRecharge\":\"0\",\"memberRefund\":\"0\",\"memberApply\":\"0\",\"memberReturn\":\"0\",\"memberReport\":\"0\",\"cmsAgentKey\":\"\",\"giftCardSell\":\"\",\"giftCardOrderQuery\":\"\",\"giftCardQuery\":\"\",\"giftCardSnQuery\":\"\",\"products\":0,\"productList\":[{\"versionId\":86,\"productId\":56,\"productCode\":\"os\",\"productName\":\"智慧正餐\",\"versionName\":\"测试版本\",\"saleType\":\"2\",\"month\":\"\",\"price\":\"0\",\"expireDate\":\"\",\"creator\":\"merchant88\",\"gmtCreate\":\"2022-03-24 13:40:16\"}],\"openProducts\":\"os\"},{\"storeId\":\"0202109000000310002\",\"customerId\":\"020210900000031\",\"agentId\":\"88800026\",\"merchantName\":\"商户服务平台测试商户\",\"acquirerId\":\"72000009\",\"merId\":\"11202109271743090001\",\"storeName\":\"餐饮--私房菜\",\"storeType\":\"4\",\"provinceCode\":\"\",\"cityCode\":\"\",\"districtCode\":\"\",\"address\":\"1\",\"contactPhone\":\"023-67904081\",\"storeImage\":\"http://192.168.13.242:8888/M00/00/91/wKgN8mFRKD6ADuA7AADZNhO67Nc298.JPG\",\"gmtCreate\":\"2021-09-27 18:07:27\",\"creator\":\"merchant88\",\"gmtModified\":\"2022-07-05 19:12:00\",\"modifier\":\"merchant88\",\"version\":0,\"memberIdentify\":\"0\",\"memberAdd\":\"0\",\"memberRecharge\":\"0\",\"memberRefund\":\"0\",\"memberApply\":\"0\",\"memberReturn\":\"0\",\"memberReport\":\"0\",\"cmsCustomerId\":\"\",\"cmsStoreid\":\"\",\"cmsMerchantname\":\"\",\"cmsStorename\":\"\",\"cmsStoreshortname\":\"\",\"cmsAgentKey\":\"\",\"giftCardSell\":\"\",\"giftCardOrderQuery\":\"\",\"giftCardQuery\":\"\",\"giftCardSnQuery\":\"\",\"products\":0,\"productList\":[{\"versionId\":86,\"productId\":56,\"productCode\":\"os\",\"productName\":\"智慧正餐\",\"versionName\":\"测试版本\",\"saleType\":\"2\",\"month\":\"\",\"price\":\"0\",\"expireDate\":\"\",\"creator\":\"merchant88\",\"gmtCreate\":\"2021-09-27 18:08:30\"},{\"versionId\":160,\"productId\":93,\"productCode\":\"mp\",\"productName\":\"聚合支付\",\"versionName\":\"标准版\",\"saleType\":\"1\",\"month\":\"12\",\"price\":\"0\",\"expireDate\":\"2023-03-23\",\"creator\":\"ran415\",\"gmtCreate\":\"2022-03-24 16:22:05\"}],\"openProducts\":\"os,mp\"},{\"storeId\":\"0202109000000310005\",\"customerId\":\"020210900000031\",\"agentId\":\"88800026\",\"merchantName\":\"商户服务平台测试商户\",\"acquirerId\":\"72000009\",\"merId\":\"11202109271743090001\",\"storeName\":\"餐饮--小吃\",\"storeType\":\"1\",\"provinceCode\":\"\",\"cityCode\":\"\",\"districtCode\":\"\",\"address\":\"\",\"contactPhone\":\"023-67904081\",\"storeImage\":\"http://192.168.13.242:8888/M00/00/92/wKgN8mFx6uaAZfaPAADZNhO67Nc950.JPG\",\"gmtCreate\":\"2021-10-22 14:30:31\",\"creator\":\"merchant88\",\"gmtModified\":\"2022-07-28 17:01:05\",\"modifier\":\"merchant88\",\"version\":0,\"memberIdentify\":\"0\",\"memberAdd\":\"0\",\"memberRecharge\":\"0\",\"memberRefund\":\"0\",\"memberApply\":\"0\",\"memberReturn\":\"0\",\"memberReport\":\"0\",\"cmsAgentKey\":\"\",\"giftCardSell\":\"\",\"giftCardOrderQuery\":\"\",\"giftCardQuery\":\"\",\"giftCardSnQuery\":\"\",\"products\":0,\"productList\":[{\"versionId\":86,\"productId\":56,\"productCode\":\"os\",\"productName\":\"智慧正餐\",\"versionName\":\"测试版本\",\"saleType\":\"2\",\"month\":\"\",\"price\":\"0\",\"expireDate\":\"长期\",\"creator\":\"merchant88\",\"gmtCreate\":\"2021-11-15 14:00:06\"}],\"openProducts\":\"os\"},{\"storeId\":\"0202109000000310006\",\"customerId\":\"020210900000031\",\"agentId\":\"88800026\",\"merchantName\":\"商户服务平台测试商户\",\"acquirerId\":\"72000009\",\"merId\":\"11202109271743090001\",\"storeName\":\"餐饮--粉面馆\",\"storeType\":\"3\",\"provinceCode\":\"\",\"cityCode\":\"\",\"districtCode\":\"\",\"address\":\"\",\"contactPhone\":\"023-67904081\",\"storeImage\":\"http://192.168.13.242:8888/M00/00/93/wKgN8mGEJTqAANTiAAFNepVrj8o133.jpg\",\"gmtCreate\":\"2021-11-05 10:20:02\",\"creator\":\"merchant88\",\"gmtModified\":\"2022-07-28 17:01:05\",\"modifier\":\"quchi001\",\"version\":0,\"memberIdentify\":\"0\",\"memberAdd\":\"0\",\"memberRecharge\":\"0\",\"memberRefund\":\"0\",\"memberApply\":\"0\",\"memberReturn\":\"0\",\"memberReport\":\"0\",\"cmsCustomerId\":\"\",\"cmsStoreid\":\"\",\"cmsMerchantname\":\"\",\"cmsStorename\":\"\",\"cmsStoreshortname\":\"\",\"cmsAgentKey\":\"\",\"giftCardSell\":\"\",\"giftCardOrderQuery\":\"\",\"giftCardQuery\":\"\",\"giftCardSnQuery\":\"\",\"products\":0,\"productList\":[{\"versionId\":86,\"productId\":56,\"productCode\":\"os\",\"productName\":\"智慧正餐\",\"versionName\":\"测试版本\",\"saleType\":\"2\",\"month\":\"\",\"price\":\"0\",\"expireDate\":\"长期\",\"creator\":\"merchant88\",\"gmtCreate\":\"2021-11-15 13:59:35\"},{\"versionId\":160,\"productId\":93,\"productCode\":\"mp\",\"productName\":\"聚合支付\",\"versionName\":\"标准版\",\"saleType\":\"1\",\"month\":\"12\",\"price\":\"0\",\"expireDate\":\"2023-03-29\",\"creator\":\"quchi001\",\"gmtCreate\":\"2022-03-30 14:28:47\"}],\"openProducts\":\"os,mp\"}],\"timestamp\":1662530021941}";
        JSONObject jsonObject1 = JSON.parseObject(xx);
        String result = jsonObject1.getString("result");
        System.out.println(result);
        JSONArray array = JSON.parseArray(result);
        List<String> storeList = new ArrayList<String>();
        int size = array.size();
        for(int i =0;i<size;i++){
            JSONObject jsonObject = array.getJSONObject(i);
            String storeId = (String) jsonObject.get("storeId");
            storeList.add(storeId);
        }
        System.out.println(storeList);
        System.out.println(storeList.get(0));
        System.out.println(storeList.get(1));
        System.out.println(storeList);
        int count = 0;
        for (int i=0;i<storeList.size();i++){
            if (storeList.get(i).equals("0202111000000060003")){
                count++;
            }
        }
        System.out.println(count);

        String s = System.currentTimeMillis() + "";
        System.out.println(s);
        /*System.out.println(size);
        JSONObject jsonObject = array.getJSONObject(0);
        Object storeId = jsonObject.get("storeId");
        //JSONObject jsonObject = JSON.parseObject() ;
      //  Object storeId = jsonObject.get("storeId");
      //  System.out.println(storeId);
      //  System.out.println(o);
        System.out.println(storeId);
        System.out.println(jsonObject);
        System.out.println(array);
        int[] addd = {1,3,5,6,7};
        System.out.println(addd);*/

        System.out.println(request.getContextPath());
    }
    @Test
    void ip() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        InetAddress.getLocalHost();
    }
    @Test
    void array(){
        String xx = "[{\"appKey\":\"SD63236305\",\"appSecret\":\"SDDED2523BED4643\"},{\"appKey\":\"8888888\",\"appSecret\":\"SDDED2523BED4643\"}]";
        JSONArray array = JSONObject.parseArray(xx);
        JSONObject jsonObject = array.getJSONObject(1);
        String appKey = (String) array.getJSONObject(1).get("appKey");
        System.out.println(appKey);
        //System.out.println(o);
        System.out.println(array);
        jsonObject.put("TEST","TEST");
        System.out.println(jsonObject);
        BigDecimal bigDecimal =new BigDecimal(11.2423);
        int i = bigDecimal.multiply(BigDecimal.valueOf(1000)).intValue();
        System.out.println(i+"====");


    }
    @Test
    void tt(){
        Date date=new Timestamp(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Timestamp(System.currentTimeMillis()));

        for (int i=0;i<1000 ;i++){
            int j=0;
        }
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
    @Test
    void t1(){
        String body = String.format("{\"signature\":\"%s\"}","测试");
        System.out.println(body);
    }
}
