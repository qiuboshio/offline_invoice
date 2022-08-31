package com.pax.offline_invoice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pax.offline_invoice.dao")
public class OfflineInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfflineInvoiceApplication.class, args);
    }

}
