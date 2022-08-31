package com.pax.offline_invoice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pax.offline_invoice.entity.TBInvoiceInformation;

/**
 * @projectname offline_invoice
 * @Classname InvoiceInformation
 * @Description 开票信息
 * @Version 1.0.0
 * @Date 2022/8/31 16:05
 * @Created by qiuzepeng
 */
public interface InvoiceInformationDao extends BaseMapper<TBInvoiceInformation> {
    //插入开票信息
    int insert(TBInvoiceInformation tbInvoiceInformation);
    //根据订单号查询开票信息
    TBInvoiceInformation findByOrderNO(String orderNO);
}
