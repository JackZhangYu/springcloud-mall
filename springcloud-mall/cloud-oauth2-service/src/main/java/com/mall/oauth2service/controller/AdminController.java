package com.mall.oauth2service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/5/5 15:37
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @RequestMapping("/{id}")
    public String getAdminInfo(@PathVariable("id") Integer id){
        return "返回查询的admin用户信息";
    }
}
