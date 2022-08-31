package com.pax.offline_invoice.service;

import com.pax.offline_invoice.entity.TBMerchantsConfig;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfigService
 * @Description TODO
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
}
