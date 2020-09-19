package com.mall.clouduser.controller;

import com.mall.clouduser.service.FeignProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/6/29 11:32
 */

@RestController
public class ProductInfoController {

    @Autowired
    private FeignProductService feignProductService;

    @GetMapping("/pro/getInfo")
    public String getProductInfo(){
        return feignProductService.getProductInfo();
    }
}
