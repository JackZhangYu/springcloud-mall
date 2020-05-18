package com.mall.ribbonservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author cheng
 * @date 2020/5/16 10:26
 */
@Service
public class GoodsRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")},
            fallbackMethod = "getUserInfoFailure")
    public String getUserInfo() {
        String message;
        try {
            message = restTemplate.getForObject("http://cloud-user-center/goods/getUser", String.class);
        } catch (RestClientException e) {
            message = e.getMessage();
        }
        return message;
    }

    public String getUserInfoFailure(){
        String message = "线路繁忙，稍后再试";
        return message;
    }
}
