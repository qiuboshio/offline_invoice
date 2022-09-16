package com.pax.offline_invoice.util.resultutil;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @projectname offline-invoice
 * @Classname JsonResult
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/9 15:54
 * @Created by qiuzepeng
 */
@Data
public class  JsonResult {
    private int code;
    private String message;
    private Object result;
    private Long timestamp;


    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("success");
        this.setTimestamp(System.currentTimeMillis());
    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
        this.setTimestamp(System.currentTimeMillis());
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
        this.setTimestamp(System.currentTimeMillis());
    }

    public JsonResult(ResultCode code, String message, Object result) {

        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
        this.setTimestamp(System.currentTimeMillis());
    }

    public String toString() {

        JSONObject json = new JSONObject();
        try {
            json.put("code", code);
            json.put("message", message);
            json.put("result", result);
            json.put("timestamp",timestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.code();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp =  timestamp;
    }


}
