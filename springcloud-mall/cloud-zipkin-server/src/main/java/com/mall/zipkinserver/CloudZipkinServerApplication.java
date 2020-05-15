package com.mall.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinServerApplication.class, args);
    }

}
