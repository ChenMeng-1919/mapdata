package com.a5ibug.lifemap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.a5ibug.lifemap.dao")
public class LifeMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeMapApplication.class, args);
    }

}
