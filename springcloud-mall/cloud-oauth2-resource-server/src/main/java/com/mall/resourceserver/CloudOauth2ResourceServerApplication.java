package com.mall.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudOauth2ResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauth2ResourceServerApplication.class, args);
    }

}
