package com.example.resttemplatetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResttemplatetestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResttemplatetestApplication.class, args);
    }

}
