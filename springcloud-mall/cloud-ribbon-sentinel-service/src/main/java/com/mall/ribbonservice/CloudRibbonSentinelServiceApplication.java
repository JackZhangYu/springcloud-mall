package com.mall.ribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudRibbonSentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonSentinelServiceApplication.class, args);
    }

}
