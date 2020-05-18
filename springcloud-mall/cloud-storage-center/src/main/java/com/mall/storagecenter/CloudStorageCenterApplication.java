package com.mall.storagecenter;

import com.mall.storagecenter.config.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author cheng
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableEurekaClient
@Import(DruidConfig.class)
@MapperScan("com.mall.storagecenter.dao")
public class CloudStorageCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStorageCenterApplication.class, args);
    }

}
