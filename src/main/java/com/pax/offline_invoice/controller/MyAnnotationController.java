package com.pax.offline_invoice.controller;

import com.pax.offline_invoice.config.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectname offline_invoice
 * @Classname MyAnnotationController
 * @Description 测试自定义注解
 * @Version 1.0.0
 * @Date 2022/9/1 18:33
 * @Created by qiuzepeng
 */
@RestController
public class MyAnnotationController {
    @GetMapping("/annotation")
    @MyAnnotation(name = "xx",age = 18, hobby ={"x1","x2"})//注解里面的字段
    public String get(){
        return "Hello Annotation";
    }
}
