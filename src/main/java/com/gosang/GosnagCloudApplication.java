package com.gosang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.gosang.mapper")
public class GosnagCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(GosnagCloudApplication.class, args);
    }

}
