package com.fishdemon.msk.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * auth center
 * @author Anjin.Ma
 * @date 2020-3-21
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.fishdemon.msk.auth.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
