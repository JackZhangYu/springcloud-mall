package com.mall.clouduser.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cheng
 * @date 2020/6/29 11:28
 */
@FeignClient(value = "cloud-nacos-config")
public interface FeignProductService {

    @RequestMapping(value = "/pro/getInfo")
    public String getProductInfo();
}
