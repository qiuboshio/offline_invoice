package com.pax.offline_invoice.util.resultutil;

/**
 * @projectname offline-invoice
 * @Classname CodeEnum
 * @Description 相应状态码枚举
 * @Version 1.0.0
 * @Date 2022/9/9 15:14
 * @Created by qiuzepeng
 */
public enum ResultCode {
    SUCCESS(20000,"success"),
    SIGN_INVALID(40001,"sign invalid"),
    SYSTEM_ERROR (40004,"system error")
    ;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    private int code;
    private String msg;



}
