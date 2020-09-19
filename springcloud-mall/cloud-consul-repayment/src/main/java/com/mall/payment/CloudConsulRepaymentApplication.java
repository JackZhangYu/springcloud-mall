package com.mall.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulRepaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulRepaymentApplication.class, args);
    }

}
