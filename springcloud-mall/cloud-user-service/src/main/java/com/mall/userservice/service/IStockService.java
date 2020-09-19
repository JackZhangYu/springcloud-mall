package com.mall.userservice.service;

/**
 * @author cheng
 * @date 2020/7/14 17:25
 */
public interface IStockService {

    /**
     * 秒杀商品以后，减少库存
     * @param stockName
     */
    public void decrByStock(String stockName);

}
