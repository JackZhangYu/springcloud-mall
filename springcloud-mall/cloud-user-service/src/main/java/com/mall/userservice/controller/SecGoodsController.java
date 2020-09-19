package com.mall.userservice.controller;

import com.mall.userservice.config.RabbitConfig;
import com.mall.userservice.model.OrderModel;
import com.mall.userservice.service.IOrderService;
import com.mall.userservice.service.IStockService;
import com.mall.userservice.util.RedisClientUtil;
import com.mall.userservice.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng
 * 秒杀controller类
 * @date 2020/7/14 21:32
 */
@RestController
@Slf4j
@RequestMapping("/sec")
public class SecGoodsController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisClientUtil redisClientUtil;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IStockService stockService;

    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public Result sec(@RequestParam(value = "username") String username,
                      @RequestParam(value = "stockName") String stockName) {
        log.info("参加秒杀的用户是:{},秒杀的商品是{}", username, stockName);
        String message = "";
        Long decrByRedis = redisClientUtil.decrBy(stockName);
        if (decrByRedis >= 0) {
            rabbitTemplate.convertAndSend(RabbitConfig.STOCK_EXCHANGE,
                    RabbitConfig.STOCK_ROUTING_KEY, stockName);

            OrderModel orderModel = new OrderModel();
            orderModel.setOrderName(stockName);
            orderModel.setUserName(username);
            orderModel.setProductId("抢购成功" + stockName);
            orderModel.setCreateTime(System.currentTimeMillis());
            rabbitTemplate.convertAndSend(RabbitConfig.ORDER_EXCHANGE,
                    RabbitConfig.ORDER_ROUTING_KEY,orderModel);
            message = "用户" + username + "秒杀" + stockName +"成功";
        }else {
            log.info("库存为0，秒杀结束",username);
            message = "用户:" + username + "商品的库存没有了，秒杀结束";
        }
        return new Result(message);
    }
}
