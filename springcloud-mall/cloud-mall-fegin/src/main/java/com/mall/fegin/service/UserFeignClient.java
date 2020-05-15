package com.mall.fegin.service;

import com.mall.fegin.config.FeignServiceFallBack;
import com.mall.fegin.entity.Result;
import com.mall.fegin.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cheng
 * 这是FeignClient注解，指明在Eureka注册的服务名称，
 * ureka注册的服务名称，也是可以直接使用ip的，如果指定了url ，那么name就是只是一个标识
 */

@FeignClient(value = "cloud-user-service",fallback = FeignServiceFallBack.class)
public interface UserFeignClient {

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "/user/getUser")
    public String getUserName();

    /**
     * 获取单个用户详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}")
    public Result<User> getInfo(@PathVariable("id") Long id);
}
