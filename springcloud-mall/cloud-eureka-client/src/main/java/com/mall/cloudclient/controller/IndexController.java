package com.mall.cloudclient.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/5/9 16:38
 */
@RestController
public class IndexController {

    @ApiOperation(value = "获取用户信息")
    @RequestMapping("/user/get")
    public String getInfo(String id){
        return "success";
    }
}
