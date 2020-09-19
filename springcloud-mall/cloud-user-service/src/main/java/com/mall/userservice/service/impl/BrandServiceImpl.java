package com.mall.userservice.service.impl;

import com.mall.userservice.dao.IBrandDao;
import com.mall.userservice.model.BrandModel;
import com.mall.userservice.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cheng
 * @date 2020/7/11 12:01
 */
@Service("brandService")
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IBrandDao iBrandDao;
    @Override
    public List<BrandModel> getAllBrandList() {
        return iBrandDao.getAllBrandList();
    }

    @Override
    public BrandModel getBrandById(Long brandId) {
        BrandModel brandModel = iBrandDao.getBrandById(brandId);
        redisTemplate.opsForValue().set(brandId,brandModel);
        return brandModel;
    }
}
