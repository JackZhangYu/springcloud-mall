package com.mall.oauth2service;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@MapperScan("com.mall.oauth2service.dao")
public class CloudOauth2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauth2ServiceApplication.class, args);
    }

}
