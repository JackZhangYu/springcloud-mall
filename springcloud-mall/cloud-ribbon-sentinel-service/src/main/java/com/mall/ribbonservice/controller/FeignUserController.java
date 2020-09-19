package com.mall.ribbonservice.controller;

import com.mall.ribbonservice.model.Result;
import com.mall.ribbonservice.model.User;
import com.mall.ribbonservice.service.FeignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/6/11 10:59
 */
@RestController
@RequestMapping("/api")
public class FeignUserController {

    @Autowired
    private FeignUserService feignUserService;

    @RequestMapping(value = "/user/{id}")
    public Result<User> getInfo(@PathVariable("id") Long id){
        return feignUserService.getInfo(id);
    }
}
