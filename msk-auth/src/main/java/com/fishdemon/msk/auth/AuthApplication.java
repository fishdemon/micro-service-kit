package com.fishdemon.msk.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * auth center
 * @author Anjin.Ma
 * @date 2020-3-21
 */
@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
@MapperScan("com.fishdemon.msk.auth.mapper")
@EnableAsync
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
