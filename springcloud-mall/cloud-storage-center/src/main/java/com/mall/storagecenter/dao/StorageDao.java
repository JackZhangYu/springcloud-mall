package com.mall.storagecenter.dao;

import com.mall.storagecenter.entity.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @author cheng
 * @date 2020/5/17 19:31
 */
public interface StorageDao {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

    public Storage getStorageInfoByPId(@Param("productId") Long productId);
}
