package com.pax.offline_invoice.service;

import com.pax.offline_invoice.entity.TBMerchantsConfig;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfigService
 * @Description 商户信息服务层
 * @Version 1.0.0
 * @Date 2022/8/31 9:45
 * @Created by qiuzepeng
 */
public interface MerchantsConfigService {
    /**
     * 通过主键查找
     * @param OrderId
     * @return
     */
    TBMerchantsConfig findById(String OrderId);

    /**
     * 新增商户信息
     * @param tbMerchantsConfig
     * @return
     */
     void add(TBMerchantsConfig tbMerchantsConfig);

    /**
     * 修改商户信息
     * @param tbMerchantsConfig
     * @return
     */
     int update(TBMerchantsConfig tbMerchantsConfig);

    /**
     * 删除商户信息
     * @param storeId
     * @return
     */
     int delete(String storeId);
}
