package com.pax.offline_invoice.service;

import com.pax.offline_invoice.entity.TBInvoiceInformation;

/**
 * @projectname offline_invoice
 * @Classname InvoiceInformationService
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/8/31 16:07
 * @Created by qiuzepeng
 */
public interface InvoiceInformationService {
    //插入开票信息
    int insert(TBInvoiceInformation tbInvoiceInformation);
    //根据订单号查询开票信息
    TBInvoiceInformation findByOrderNO(String orderNO);
}
