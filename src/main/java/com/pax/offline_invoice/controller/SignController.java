package com.pax.offline_invoice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @projectname offline_invoice
 * @Classname SignController
 * @Description 签名相关
 * @Version 1.0.0
 * @Date 2022/9/5 10:49
 * @Created by qiuzepeng
 */
@RestController
@RequestMapping("/sign")
public class SignController {
    //localhost:8888/sign/validation
    @GetMapping("/validation")
    public void signValidation(HttpSession httpSession){
      //  HttpSession sess = httpSession.getSessionContext().getSession(sid);

        System.out.println();


    }

}
