package com.syg.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 靖鸿宣
 * @since 2021/1/4
 */
@SpringBootApplication
@MapperScan({"com.syg.demo.dao"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
