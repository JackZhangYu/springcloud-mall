package com.mall.ribbonservice.controller;

import com.mall.ribbonservice.service.GoodsRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/5/16 10:32
 */
@RestController
@RequestMapping("/goods")
public class GoodsRibbonController {

    @Autowired
    private GoodsRibbonService goodsRibbonService;

    @RequestMapping("/getUser")
    public String getGoodsInfo(){
        String message = goodsRibbonService.getUserInfo();
        return "ribbon message" + message;
    }
}
