package com.mall.fegin.config;

import com.mall.fegin.entity.Result;
import com.mall.fegin.entity.User;
import com.mall.fegin.service.UserFeignClient;

/**
 * @author cheng
 */
public class FeignServiceFallBack implements UserFeignClient {
    @Override
    public String getUserName() {
        return "请求错误，返回页面";
    }

    @Override
    public Result<User> getInfo(Long id) {
         return new Result<>(new User(1L,"你好","123123"));
    }
}
