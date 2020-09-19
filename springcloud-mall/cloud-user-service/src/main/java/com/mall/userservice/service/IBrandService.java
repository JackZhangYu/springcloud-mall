package com.mall.userservice.service;

import com.mall.userservice.model.BrandModel;

import java.util.List;

/**
 * @author cheng
 * @date 2020/7/11 12:00
 */
public interface IBrandService {
    public List<BrandModel> getAllBrandList();

    public BrandModel getBrandById(Long brandId);
}
