package com.wang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wang.mapper")
@SpringBootApplication
public class AdditionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdditionApplication.class, args);
    }

}
