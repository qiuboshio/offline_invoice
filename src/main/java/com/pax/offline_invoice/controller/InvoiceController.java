package com.pax.offline_invoice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pax.offline_invoice.entity.ResultTemplate;
import com.pax.offline_invoice.entity.TBInvoiceInformation;
import com.pax.offline_invoice.entity.TBMerchantsConfig;
import com.pax.offline_invoice.service.InvoiceInformationService;
import com.pax.offline_invoice.service.MerchantsConfigService;
import lombok.extern.slf4j.Slf4j;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfigController
 * @Description 商户开票信息相关配置
 * @Version 1.0.0
 * @Date 2022/8/31 9:37
 * @Created by qiuzepeng
 */
@Controller
@ResponseBody
@RequestMapping("/invoice")
@Slf4j
public class InvoiceController {
    @Autowired
    private MerchantsConfigService merchantsConfigService;
    @Autowired
    private InvoiceInformationService invoiceInformationService;
    @GetMapping("/find")
    public ResultTemplate QRCode(@RequestParam("storeId")String storeId, @RequestParam("price")BigDecimal price,
                       @RequestParam("num")Integer num,@RequestParam("sign") String sign,@RequestParam("orderNo")String orderNo){
        /**
         * @MethodName: QRCode
         * @Description: 获取申请发票的参数信息  http://192.168.10.250:8888/invoice/find
         * @Author: qiuzepeng
         * @Date: 2022/8/31 11:37
         * @param storeId: 门店标识
        	 * @param price: 价格
        	 * @param num: 数量
        	 * @param sign: 签名
             * @param orderId: 订单id
          * @return void
        */
        TBMerchantsConfig merchantsConfig = merchantsConfigService.findById(storeId);
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String taxnum = merchantsConfig.getMerchantsTaxNum();//ISV下授权商户税号
        String appKey = "SD63236305";
        String appSecret = "SDDED2523BED4643";
        String method = "nuonuo.ElectronInvoice.saveScanTemp";//API方法名
        String token = "2d484e**************pdui";//访问令牌
        String url = "https://sandbox.nuonuocs.cn/open/v1/services"; //sdk请求地址（测试环境）
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
        JSONObject map = new JSONObject();
        //订单号
        map.put("orderNo",orderNo);
        //申请时间
        String invoiceDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        map.put("invoiceDate",invoiceDate);
        //销售方税号
        map.put("salerTaxNum",merchantsConfig.getMerchantsTaxNum());
        //开票人姓名
        map.put("clerk",merchantsConfig.getApplyInvoicePerson());
        //订单金额
        map.put("orderTotal",price);
        //商品详细信息
        JSONObject jsonObject = JSON.parseObject(merchantsConfig.getGoodsDetail());
        jsonObject.put("num",num);
        jsonObject.put("price",price);
        map.put("detail",JSON.parseArray("["+jsonObject+"]"));
        //获取诺诺开发票返回结果
        String json = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, String.valueOf(map));
        //组装返回信息
        ResultTemplate resultTemplate = new ResultTemplate();
        //获取状态码
        JSONObject jsonObject1 = JSONObject.parseObject(json);
        String code = jsonObject1.get("code").toString();
        //如果状态码为E9999,代表该发票已经开具，根据订单号从数据库查询开票地址
        if (code.equals("E9999")){
            TBInvoiceInformation byOrderNO = invoiceInformationService.findByOrderNO(orderNo);
            resultTemplate.setQrCodeUrl(byOrderNO.getInvoiceUrl());
            resultTemplate.setSign(byOrderNO.getSign());
        }
        //如果状态码为E0000,代表是第一次开发票，存入开票信息表并且返回结果
        if(code.equals("E0000")){
            String invoiceUrl = JSON.parseObject(jsonObject1.get("result").toString()).get("ewmUrl").toString();
            TBInvoiceInformation tbInvoiceInformation = new TBInvoiceInformation();
            tbInvoiceInformation.setStoreNo(storeId);
            tbInvoiceInformation.setInvoiceUrl(invoiceUrl);
            tbInvoiceInformation.setOrderId(orderNo);
            tbInvoiceInformation.setOrderAmount(price);
            tbInvoiceInformation.setGoodsDetail(String.valueOf(jsonObject));
            tbInvoiceInformation.setApplyTime(invoiceDate);
            tbInvoiceInformation.setSign(sign);
            invoiceInformationService.insert(tbInvoiceInformation);
            resultTemplate.setSign(sign);
            resultTemplate.setQrCodeUrl(invoiceUrl);
        }
        System.out.println(json);
        return resultTemplate;

    }
}
