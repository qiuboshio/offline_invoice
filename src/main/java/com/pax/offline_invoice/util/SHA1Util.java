package com.pax.offline_invoice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @projectname offline_invoice
 * @Classname SHA1Util
 * @Description SHA1算法生成安全
 * @Version 1.0.0
 * @Date 2022/9/5 13:47
 * @Created by qiuzepeng
 */
public class SHA1Util {
    public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws NoSuchAlgorithmException {

            String[] array = new String[] { token, timestamp, nonce, encrypt };
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 4; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();

    }
}
