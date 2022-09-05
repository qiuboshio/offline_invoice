package com.pax.offline_invoice.util;

/**
 * @projectname offline_invoice
 * @Classname GlobalParam
 * @Description 全局常量
 * @Version 1.0.0
 * @Date 2022/9/5 10:00
 * @Created by qiuzepeng
 */
public class GlobalParamUtil {
    /**
     * 离线开票请求地址：
     *      沙箱：https://sandbox.nuonuocs.cn/open/v1/services
     *      正式环境：https://sdk.nuonuo.com/open/v1/services
     */
    public static final String OfflineUrl = "https://sandbox.nuonuocs.cn/open/v1/services";
    /**
     * 离线扫码请求方法
     */
    public static final String OfflineMethod = "nuonuo.ElectronInvoice.saveScanTemp";
}
