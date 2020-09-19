package com.mall.userservice.service.impl;

import com.mall.userservice.config.RabbitConfig;
import com.mall.userservice.model.OrderModel;
import com.mall.userservice.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cheng
 * @date 2020/7/14 21:16
 */
@Service
@Slf4j
public class MQOrderService {
    @Autowired
    private IOrderService orderService;

    /**
     * 监听订单消息队列，并消费
     * @param orderModel
     */
    @RabbitListener(queues = RabbitConfig.ORDER_QUEUE)
    public void create(OrderModel orderModel){
        log.info("收到订单消息，订单用户为：{}，商品名称为：{}", orderModel.getUserName(),
                orderModel.getOrderName());
        orderService.createOrder(orderModel);
    }
}
