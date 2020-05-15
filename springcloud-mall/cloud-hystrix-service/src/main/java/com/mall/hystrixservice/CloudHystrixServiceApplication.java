package com.mall.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudHystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixServiceApplication.class, args);
    }

}
