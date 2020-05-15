package com.mall.apolloclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudApolloConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApolloConfigClientApplication.class, args);
    }

}
