package com.pax.offline_invoice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pax.offline_invoice.entity.TBMerchantsConfig;

/**
 * @projectname offline_invoice
 * @Classname MerchantsConfigDao
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/8/31 9:43
 * @Created by qiuzepeng
 */
public interface MerchantsConfigDao extends BaseMapper<TBMerchantsConfig>{
    //通过主键查找
    TBMerchantsConfig findById(String storeId);
}
