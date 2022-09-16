package com.pax.offline_invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @projectname offline_invoice
 * @Classname WeixinControler
 * @Description 测试微信   secret:8bbcfb9c34454454b0e14f0457441736,  appid:wxe52d0f50f14898dd
 * @Version 1.0.0
 * @Date 2022/9/16 15:10
 * @Created by qiuzepeng
 */
@RestController
@RequestMapping("/weixin")
public class WeixinControler {
    //验证code
    String jscode2session = "https://api.weixin.qq.com/sns/jscode2session";
    //获取接口调用凭证
    String aoolyToken = "https://api.weixin.qq.com/cgi-bin/token";
    //获取电话
    String phone = "https://api.weixin.qq.com/wxa/business/getuserphonenumber";
    String appId = "wxe52d0f50f14898dd";
    String secret = "8bbcfb9c34454454b0e14f0457441736";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/login")
    public String weixinLogin(HttpServletRequest request){
        //获取request头中的所有参数
        /*request.getParameterNames();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }*/
        //09341F0w3DH3fZ2RFu3w3t1Vuu241F0g
        String code = request.getParameter("code");
        System.out.println(code);
        //String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxe52d0f50f14898dd&secret=8bbcfb9c34454454b0e14f0457441736&js_code=033BzI0w39ZafZ2GCJ1w3mIi8e1BzI00&grant_type=authorization_code";
        String url = jscode2session+"?appid="+appId+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
        System.out.println(url);
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;

    }
    //http://localhost:8888/weixin/token  获取token
    @RequestMapping("/token")
    public String applyToken(){
        String url = aoolyToken+"?appid="+appId+"&secret="+secret+"&grant_type=client_credential";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;

    }
    //获取手机号
    @GetMapping("/phone")
    public String applyPhone(HttpServletRequest request){
        LinkedMultiValueMap<String, String> request1 = new LinkedMultiValueMap<>();
        request1.set("access_token","60_eNZxjB8eMsgFyrT7RmmeR8tvHamTTio9SpBkmOwTI9z3l47Rx-WCns6rW0xbFv5ZDuV-r_itYtLmvHDC4JYjsCrSv6dCjrZw8WFEqCZuYot-YiawuGoPrGRdsGA3WwejzcX0pEMNFjO5mfYZUPVhABAGBH");
        request1.set("code","013nnrGa1xXJSD0usgHa19TzlD4nnrGA");
        String url = phone;
        String s = restTemplate.postForObject(url, request1, String.class);

        request.getParameterNames();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }
        return s;

    }
}
