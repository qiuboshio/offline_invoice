package com.pax.offline_invoice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @projectname offline_invoice
 * @Classname lockTest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/14 20:22
 * @Created by qiuzepeng
 */
@SpringBootTest
public class lockTest {
    @Test
    public static void testlock() {
        String body = String.format("{\"signature\":\"%s\"}","测试");
        System.out.println(body);
    }

}
