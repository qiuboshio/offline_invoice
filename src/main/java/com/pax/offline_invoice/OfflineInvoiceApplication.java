package com.pax.offline_invoice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.pax.offline_invoice.dao")
@EnableSwagger2
public class OfflineInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfflineInvoiceApplication.class, args);
    }

}
