package com.mall.userservice.controller;

import com.mall.userservice.model.BrandModel;
import com.mall.userservice.model.Result;
import com.mall.userservice.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cheng
 * @date 2020/7/11 12:04
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/{brandId}")
    public Result<BrandModel> getBrandInfo(@PathVariable("brandId") Long brandId){
        BrandModel brandModel = brandService.getBrandById(brandId);
        return new Result<BrandModel>(brandModel);
    }

    @RequestMapping(value = "/getAllBrand", method = RequestMethod.GET)
    public Result<List<BrandModel>> getAllBrand(){
        List<BrandModel> list = brandService.getAllBrandList();
        return new Result<>(list);
    }

    @RequestMapping("/redis/{brandId}")
    public Result<BrandModel> getInfoRedis(@PathVariable("brandId") Long brandId){
        BrandModel brandModel = (BrandModel) redisTemplate.opsForValue().get(brandId);
        return new Result<>(brandModel);
    }
}
