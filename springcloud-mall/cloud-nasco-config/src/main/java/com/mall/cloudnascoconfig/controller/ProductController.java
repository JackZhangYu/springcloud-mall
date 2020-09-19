package com.mall.cloudnascoconfig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/6/29 10:56
 */
@RestController
@RequestMapping("/pro")
public class ProductController {

    @RequestMapping("/getInfo")
    public String getProduct(){
        return "return product success";
    }

}
