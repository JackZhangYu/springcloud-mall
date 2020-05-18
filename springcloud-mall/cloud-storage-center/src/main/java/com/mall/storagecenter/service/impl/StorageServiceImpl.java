package com.mall.storagecenter.service.impl;

import com.mall.storagecenter.dao.StorageDao;
import com.mall.storagecenter.entity.Storage;
import com.mall.storagecenter.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cheng
 * @date 2020/5/18 14:31
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);


    @Autowired
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }

    @Override
    public Storage getStorageInfoByPId(Long productId) {
        LOGGER.info("------------->扣减库存开始");
        return storageDao.getStorageInfoByPId(productId);

    }
}
