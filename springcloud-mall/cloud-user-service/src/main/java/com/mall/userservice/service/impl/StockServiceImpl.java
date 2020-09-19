package com.mall.userservice.service.impl;

import com.mall.userservice.dao.IStockDao;
import com.mall.userservice.model.StockModel;
import com.mall.userservice.model.StockModelExample;
import com.mall.userservice.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author cheng
 * @date 2020/7/14 17:28
 */
@Service("stockService")
public class StockServiceImpl implements IStockService {
    @Autowired
    private IStockDao stockDao;

    @Override
    public void decrByStock(String stockName) {
        StockModelExample example = new StockModelExample();
        example.createCriteria().andNameEqualTo(stockName);
        List<StockModel> list = stockDao.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)) {
            StockModel stockModel = list.get(0);
            stockModel.setStock(stockModel.getStock() -1);
            stockDao.updateByPrimaryKey(stockModel);
        }
    }

    /**
     * @param stockName
     * @return
     */
    public Integer selectByExample(String stockName) {
        StockModelExample example = new StockModelExample();
        example.createCriteria().andNameEqualTo(stockName);
        List<StockModel> list = stockDao.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0).getStock().intValue();
        }
        return 0;
    }

}