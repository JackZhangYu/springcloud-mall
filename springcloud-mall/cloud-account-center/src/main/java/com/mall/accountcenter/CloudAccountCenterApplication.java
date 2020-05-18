package com.mall.accountcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * 这个是spring cloud seata分布式事务的account账户服务中心
 * @author cheng
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.mall.accountcenter.dao")
public class CloudAccountCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAccountCenterApplication.class, args);
    }

}
