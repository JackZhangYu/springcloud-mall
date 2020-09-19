package com.mall.userservice;

import com.mall.userservice.util.RedisClientUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cheng
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mall.userservice.dao")

public class CloudUserServiceApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(CloudUserServiceApplication.class, args);
    }

    /**
     * Ribbon实现客户端的负载均衡，根据一定的策略和算法：
     * 比如轮询，服务器资源充足的进行访问等策略，Spring Cloud EurekaClient自带ribbon，hystrix
     * @return
     */

    @Autowired
    private RedisClientUtil redisClientUtil;

    /**
     * 初始化redis中的数据，包含库存和其他信息
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisClientUtil.set("苹果手机",100,20);
    }
}
