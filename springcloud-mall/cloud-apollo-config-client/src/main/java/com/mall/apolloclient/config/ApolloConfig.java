package com.mall.apolloclient.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author cheng
 * @date 2020/4/28 10:37
 */
@Configuration
@EnableApolloConfig
public class ApolloConfig {
    @Value("${env}")
    private String env;

    @Value("${spring.redis.port}")
    private String redisPort;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(String redisPort) {
        this.redisPort = redisPort;
    }
}
