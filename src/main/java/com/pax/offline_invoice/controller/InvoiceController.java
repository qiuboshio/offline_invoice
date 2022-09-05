package com.pax.offline_invoice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pax.offline_invoice.entity.ResultTemplate;
import com.pax.offline_invoice.entity.TBInvoiceInformation;
import com.pax.offline_invoice.entity.TBMerchantsConfig;
import com.pax.offline_invoice.service.InvoiceInformationService;
import com.pax.offline_invoice.service.MerchantsConfigService;
import com.pax.offline_invoice.util.GlobalParamUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "发票功能" ,tags = "发票相关接口")
public class InvoiceController {
    @Autowired
    private MerchantsConfigService merchantsConfigService;
    @Autowired
    private InvoiceInformationService invoiceInformationService;
    @GetMapping("/find")
    @ApiOperation(value = "请求开票" , notes = "返回开票地址")
    public ResultTemplate QRCode(@ApiParam(value = "门店标识",required = true) @RequestParam(value = "storeId")String storeId,
                                 @ApiParam(value = "订单金额",required = true) @RequestParam("price")BigDecimal price,
                                 @ApiParam(value = "商品数量（始终为1）",required = true,defaultValue = "1") @RequestParam("num")Integer num,
                                 @ApiParam(value = "签名信息",required = true) @RequestParam("sign") String sign,
                                 @ApiParam(value = "订单号",required = true) @RequestParam("orderNo")String orderNo){
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
        String method = GlobalParamUtil.OfflineMethod;//API方法名
        String token = "2d484e**************pdui";//访问令牌
        String url = GlobalParamUtil.OfflineUrl; //sdk请求地址
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
        //String appKey = "SD63236305";
        //String appSecret = "SDDED2523BED4643";
        JSONObject jsonObject2 = JSONObject.parseObject(merchantsConfig.getCredentials());
        String appKey = (String) jsonObject2.get("appKey");
        String appSecret = (String) jsonObject2.get("appSecret");
        JSONObject map = new JSONObject();
        //订单号
        map.put("orderNo",orderNo);
        //申请时间
        String invoiceDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        map.put("invoiceDate",invoiceDate);
        //销售方税号
        map.put("salerTaxNum",merchantsConfig.getMerchantsTaxNum());
        //开票人姓名
        //map.put("clerk",merchantsConfig.getApplyInvoicePerson());
        //订单金额
        map.put("orderTotal",price);
        //商品详细信息
        JSONObject jsonObject = JSON.parseObject(merchantsConfig.getGoodsDetail());
        jsonObject.put("num",num);
        jsonObject.put("price",price);
        map.put("detail",JSON.parseArray("["+jsonObject+"]"));
        //=====以下需要自填的参数
        //买方抬头
        map.put("buyerName","百富计算机");
        //买方税号
        map.put("buyerTaxNum","339901999999119");
        //申请人电话
        map.put("notifyPhone","17783501904");
        //通知交付邮箱
        map.put("notifyEmail","915878367@qq.com");
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
        System.out.println(resultTemplate.getQrCodeUrl());
        return resultTemplate;

    }
}
