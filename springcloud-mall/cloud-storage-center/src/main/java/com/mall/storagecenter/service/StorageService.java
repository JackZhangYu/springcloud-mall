package com.mall.storagecenter.service;

import com.mall.storagecenter.entity.Storage;

/**
 * @author cheng
 * @date 2020/5/18 14:30
 */
public interface StorageService {

    void decrease(Long productId, Integer count);

    public Storage getStorageInfoByPId(Long productId);


}
