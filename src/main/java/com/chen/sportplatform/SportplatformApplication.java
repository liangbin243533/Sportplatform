package com.chen.sportplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chen.sportplatform.dao")
@SpringBootApplication
public class SportplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportplatformApplication.class, args);
    }

}
