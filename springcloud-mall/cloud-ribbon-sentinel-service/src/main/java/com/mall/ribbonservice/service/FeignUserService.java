package com.mall.ribbonservice.service;

import com.mall.ribbonservice.model.Result;
import com.mall.ribbonservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cheng
 * @date 2020/6/11 10:55
 */
@FeignClient(value = "cloud-user-service")
public interface FeignUserService {

    @RequestMapping(value = "/user/{id}")
    public Result<User> getInfo(@PathVariable("id") Long id);
}
