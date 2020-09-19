package com.mall.userservice.dao;

import com.mall.userservice.model.BrandModel;

import java.util.List;

/**
 * @author cheng
 * @date 2020/7/11 11:27
 */
public interface IBrandDao {
    /**
     * 获取所有品牌信息
     * @return
     */
    public List<BrandModel> getAllBrandList();

    public BrandModel getBrandById(Long brandId);

    public boolean addBrandInfo(BrandModel brandModel);

    public boolean delBrandById(Long brandId);

    public boolean updateBrandInfo(BrandModel brandModel);


}
