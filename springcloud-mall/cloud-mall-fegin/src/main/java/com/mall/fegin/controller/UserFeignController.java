package com.mall.fegin.controller;

import com.mall.fegin.entity.Result;
import com.mall.fegin.entity.User;
import com.mall.fegin.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/4/29 11:48
 */
@RestController
@RequestMapping("/api")
public class UserFeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/getUser")
    public String getUser(){
        return userFeignClient.getUserName();
    }

    @RequestMapping(value = "/user/{id}")
    public Result<User> getInfo(@PathVariable("id") Long id){
        return userFeignClient.getInfo(id);
    }
}
