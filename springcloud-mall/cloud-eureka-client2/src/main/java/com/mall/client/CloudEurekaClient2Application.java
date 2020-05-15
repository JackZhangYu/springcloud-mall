package com.mall.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mall.client.dao")
public class CloudEurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClient2Application.class, args);
    }

}
