package com.pax.offline_invoice.controller;

import com.pax.offline_invoice.entity.TBMerchantsConfig;
import com.pax.offline_invoice.service.MerchantsConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfig
 * @Description 商户相关
 * @Version 1.0.0
 * @Date 2022/9/5 15:13
 * @Created by qiuzepeng
 */
@RestController
@RequestMapping("/merchants")
@Api(value = "商户信息" ,tags = "商户信息相关接口")
public class MerchantsConfig {
    @Autowired
    private MerchantsConfigService merchantsConfigService;
    @PostMapping("/add")
    @ApiOperation(value = "添加商户元信息")
    public void addMerchants(@RequestParam(value = "merchantsName",required = false) String merchantsName, @RequestParam("customerId") String customerId,
                             @RequestParam(value = "storeName",required = false) String storeName, @RequestParam("storeId") String storeid,
                             @RequestParam("credentials") String credentials, @RequestParam("merchantsTaxNum") String merchantsTaxNum,
                             @RequestParam(value = "applyInvoicePerson",required = false) String applyInvoicePerson, @RequestParam("email") String email,
                             @RequestParam("goodsDetail") String goodsDetail
                             ){
        /**
         * @MethodName: addMerchants
         * @Description: 添加商户信息 localhost:8888/merchants/add
         * @Author: qiuzepeng
         * @Date: 2022/9/5 15:33
         * @param merchantsName: 商户名
        	 * @param customerId: 商户号
        	 * @param storeName: 门店名
        	 * @param storeid: 门店号
        	 * @param credentials: 门店凭证
        	 * @param merchantsTaxNum: 商户税号
        	 * @param applyInvoicePerson: 申请人
        	 * @param email: 交付邮箱
        	 * @param goodsDetail: 商品详情
          * @return void
        */
        TBMerchantsConfig tbMerchantsConfig = new TBMerchantsConfig();
        tbMerchantsConfig.setMerchantsName(merchantsName);
        tbMerchantsConfig.setCustomerId(customerId);
        tbMerchantsConfig.setStoreName(storeName);
        tbMerchantsConfig.setStoreId(storeid);
        tbMerchantsConfig.setCredentials(credentials);
        tbMerchantsConfig.setMerchantsTaxNum(merchantsTaxNum);
        tbMerchantsConfig.setApplyInvoicePerson(applyInvoicePerson);
        tbMerchantsConfig.setEmail(email);
        tbMerchantsConfig.setGoodsDetail(goodsDetail);
        tbMerchantsConfig.setAddTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        tbMerchantsConfig.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        merchantsConfigService.add(tbMerchantsConfig);
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改商户元信息")
    public String updateMerchants(@RequestParam(value = "merchantsName",required = false) String merchantsName, @RequestParam("customerId") String customerId,
                             @RequestParam(value = "storeName",required = false) String storeName, @RequestParam("storeId") String storeid,
                             @RequestParam("credentials") String credentials, @RequestParam("merchantsTaxNum") String merchantsTaxNum,
                             @RequestParam(value = "applyInvoicePerson",required = false) String applyInvoicePerson, @RequestParam("email") String email,
                             @RequestParam("goodsDetail") String goodsDetail
    ){
        /**
         * @MethodName: updateMerchants
         * @Description: 修改商户信息 localhost:8888/merchants/update
         * @Author: qiuzepeng
         * @Date: 2022/9/5 15:33
         * @param merchantsName: 商户名
         * @param customerId: 商户号
         * @param storeName: 门店名
         * @param storeid: 门店号
         * @param credentials: 门店凭证
         * @param merchantsTaxNum: 商户税号
         * @param applyInvoicePerson: 申请人
         * @param email: 交付邮箱
         * @param goodsDetail: 商品详情
         * @return void
         */
        TBMerchantsConfig tbMerchantsConfig = new TBMerchantsConfig();
        tbMerchantsConfig.setMerchantsName(merchantsName);
        tbMerchantsConfig.setCustomerId(customerId);
        tbMerchantsConfig.setStoreName(storeName);
        tbMerchantsConfig.setStoreId(storeid);
        tbMerchantsConfig.setCredentials(credentials);
        tbMerchantsConfig.setMerchantsTaxNum(merchantsTaxNum);
        tbMerchantsConfig.setApplyInvoicePerson(applyInvoicePerson);
        tbMerchantsConfig.setEmail(email);
        tbMerchantsConfig.setGoodsDetail(goodsDetail);
        tbMerchantsConfig.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int i = merchantsConfigService.update(tbMerchantsConfig);
        return "修改条数"+i;
    }
    @GetMapping("/delete")
    @ApiOperation(value = "删除商户元信息")
    public Integer deleteMerchants(@RequestParam(value = "storeId",required = true) String storeId){
        /**
         * @MethodName: deleteMerchants
         * @Description: 删除商户信息
         * @Author: qiuzepeng
         * @Date: 2022/9/5 16:56
         * @param storeId:
          * @return java.lang.String
        */
        return merchantsConfigService.delete(storeId);

    }
}
