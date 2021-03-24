package com.jhx.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 靖鸿宣
 * @since 2021/3/24
 */
@SpringBootApplication
@MapperScan({"com.jhx.payment.dao"})

public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class,args);
    }
}
