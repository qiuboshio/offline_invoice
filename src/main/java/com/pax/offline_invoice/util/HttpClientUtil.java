package com.pax.offline_invoice.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class HttpClientUtil {
    /**
     * get请求示例
     */
    public static void doGet() {
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1 = HttpUtil.get("https://www.baidu.com");

        // 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2 = HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8);

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result3 = HttpUtil.get("https://www.baidu.com", paramMap);
    }

    /**
     * post请求示例
     */
    public static String doPost() {
        //post请求
        HashMap<String, Object> paramMap = new HashMap<>();

        String result= HttpUtil.post("https://sandbox.nuonuocs.cn/open/v1/services", paramMap);
        return result;
//
//        //文件上传示例
//        HashMap<String, Object> paramMap1 = new HashMap<>();
//        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
//        paramMap1.put("file", FileUtil.file("D:\\face.jpg"));
//        String result1= HttpUtil.post("https://www.baidu.com", paramMap1);
//
//        //下载文件（很少用）
//        String fileUrl = "http://mirrors.sohu.com/centos/8.4.2105/isos/x86_64/CentOS-8.4.2105-x86_64-dvd1.iso";
//        //将文件下载后保存在E盘，返回结果为下载文件大小
//        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"));
//        System.out.println("Download size: " + size);
    }


}
