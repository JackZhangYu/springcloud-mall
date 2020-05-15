package com.mall.ribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonServiceApplication.class, args);
    }

}
