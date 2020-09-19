package com.mall.clouduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudNacosUserConsomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosUserConsomerApplication.class, args);
    }

}
