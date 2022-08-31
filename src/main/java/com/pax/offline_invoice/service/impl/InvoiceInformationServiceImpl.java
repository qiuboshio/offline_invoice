package com.pax.offline_invoice.service.impl;

import com.pax.offline_invoice.dao.InvoiceInformationDao;
import com.pax.offline_invoice.entity.TBInvoiceInformation;
import com.pax.offline_invoice.service.InvoiceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectname offline_invoice
 * @Classname InvoiceInformationServiceImpl
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/8/31 16:19
 * @Created by qiuzepeng
 */
@Service
public class InvoiceInformationServiceImpl implements InvoiceInformationService {
    @Autowired
    private InvoiceInformationDao invoiceInformationDao;
    @Override
    public int insert(TBInvoiceInformation tbInvoiceInformation) {
        int insert = invoiceInformationDao.insert(tbInvoiceInformation);
        return insert;
    }

    @Override
    public TBInvoiceInformation findByOrderNO(String orderNO) {
        /**
         * @MethodName: findByOrderNO
         * @Description: 根据订单号查询开票信息
         * @Author: qiuzepeng
         * @Date: 2022/8/31 16:24
         * @param orderNO:
          * @return com.pax.offline_invoice.entity.TBInvoiceInformation
        */

        return invoiceInformationDao.findByOrderNO(orderNO);
    }
}
