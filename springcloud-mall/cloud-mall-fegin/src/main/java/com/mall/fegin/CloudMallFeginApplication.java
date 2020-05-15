package com.mall.fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CloudMallFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMallFeginApplication.class, args);
    }

}
