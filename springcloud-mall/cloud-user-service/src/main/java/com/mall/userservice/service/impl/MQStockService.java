package com.mall.userservice.service.impl;

import com.mall.userservice.config.RabbitConfig;
import com.mall.userservice.service.IStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cheng
 * @date 2020/7/14 21:18
 */
@Service
@Slf4j
public class MQStockService {
    @Autowired
    private IStockService stockService;

    /**
     * 监听库存消息队列，并监听
     * @param stockName
     */
    @RabbitListener(queues = RabbitConfig.STOCK_QUEUE)
    public void deccByStock(String stockName) {
        log.info("仓库名称");
        stockService.decrByStock(stockName);
    }
}
