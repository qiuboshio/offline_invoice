package com.pax.offline_invoice.service.impl;

import com.pax.offline_invoice.dao.MerchantsConfigDao;
import com.pax.offline_invoice.entity.TBMerchantsConfig;
import com.pax.offline_invoice.service.MerchantsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfigServiceImpl
 * @Description 获取商户基本配置信息业务层
 * @Version 1.0.0
 * @Date 2022/8/31 9:48
 * @Created by qiuzepeng
 */
@Service
public class MerchantsConfigServiceImpl implements MerchantsConfigService {
    @Autowired
    private MerchantsConfigDao merchantsConfigDao;
    @Override
    public TBMerchantsConfig findById(String storeId) {
        /**
         * @MethodName: findById
         * @Description: 根据门店标识号查找对应的配置信息
         * @Author: qiuzepeng
         * @Date: 2022/8/31 11:31
         * @param storeId:
          * @return com.pax.offline_invoice.entity.MerchantsConfig
        */

        TBMerchantsConfig merchantsConfig = merchantsConfigDao.findById(storeId);
        return merchantsConfig;

    }

    @Override
    public void add(TBMerchantsConfig tbMerchantsConfig) {
        merchantsConfigDao.insert(tbMerchantsConfig);
    }

    @Override
    public int update(TBMerchantsConfig tbMerchantsConfig) {
        int i = merchantsConfigDao.updateById(tbMerchantsConfig);
        return i;
    }

    @Override
    public int delete(String storeId) {
        int i = merchantsConfigDao.deleteById(storeId);
        return i;
    }
}
