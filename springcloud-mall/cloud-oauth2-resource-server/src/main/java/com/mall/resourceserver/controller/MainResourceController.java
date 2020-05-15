package com.mall.resourceserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/5/9 9:32
 */
@RestController("/api")
public class MainResourceController {

    @PostMapping("/get/info")
    public String getUserInfo(String username){
        return username;
    }
}
