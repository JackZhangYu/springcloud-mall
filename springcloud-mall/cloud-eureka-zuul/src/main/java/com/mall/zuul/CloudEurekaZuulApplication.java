package com.mall.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloudEurekaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaZuulApplication.class, args);
    }

}
