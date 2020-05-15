package com.mall.ssoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudSsoAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSsoAuthServerApplication.class, args);
    }

}
