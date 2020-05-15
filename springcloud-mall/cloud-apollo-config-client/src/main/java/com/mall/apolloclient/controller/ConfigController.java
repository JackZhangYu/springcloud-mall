package com.mall.apolloclient.controller;

import com.mall.apolloclient.config.ApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/4/28 10:45
 */
@RestController
public class ConfigController {

    @Autowired
    private ApolloConfig apolloConfig;

    @RequestMapping("/apollo/getConfig")
    public String getConfig(){
        return apolloConfig.getEnv();
    }

    @RequestMapping("/apollo/getRedis")
    public String getRedisPort(){
        return apolloConfig.getRedisPort();
    }
}
