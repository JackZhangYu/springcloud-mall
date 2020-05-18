package com.mall.storagecenter.controller;

import com.mall.storagecenter.entity.Storage;
import com.mall.storagecenter.service.StorageService;
import io.seata.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * @date 2020/5/18 14:35
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @RequestMapping("/decrease")
    public String decrease(@RequestParam("productId")Long productId,
                           @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return "storage decrease successfull";
    }

    @RequestMapping("/getById")
    public Result<Storage> getStrorageByPid(@RequestParam("productId") Long productId){
        Storage storage = storageService.getStorageInfoByPId(productId);
        return Result.build(storage);
    }
}
