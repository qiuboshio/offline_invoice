package com.pax.offline_invoice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @projectname offline-invoice
 * @Classname MD5Util
 * @Description MD5算法
 * @Version 1.0.0
 * @Date 2022/9/7 16:43
 * @Created by qiuzepeng
 */
public class MD5Util {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //B3261E02110E2BB2862AE99433B90F0A
        String xx = "amount=3.00&orderId=er52dfsdfddqLLLdCCfafppv8&sessionId=32&sessionKey=1663221534617";

        System.out.println(HEXByMd5(xx));
    }
    
    public static String HEXByMd5(String s) throws NoSuchAlgorithmException {
        /**
         * @MethodName: HEXByMd5
         * @Description: 传入明文数据，返回固定32位的密文数据
         * @Author: qiuzepeng
         * @Date: 2022/9/7 16:58
         * @param s:
          * @return java.lang.String
        */

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = s.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        char[] str = new char[md.length * 2];
        int k = 0;
        for (byte byte0 : md) {
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }
}
