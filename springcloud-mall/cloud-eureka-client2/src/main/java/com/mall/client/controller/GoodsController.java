package com.mall.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/5/16 10:24
 * 注意不要再restController中写请求地址，要在requestMapping写url路径
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/getUser")
    public String getGoodsInfo(){
        return "返回用户得信息接口";
    }
}
