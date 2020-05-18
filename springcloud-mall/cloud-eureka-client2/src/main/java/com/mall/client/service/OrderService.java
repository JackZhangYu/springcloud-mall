package com.mall.client.service;

import com.mall.client.model.Order;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cheng
 * @date 2020/5/18 15:05
 */
public interface OrderService {


    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId
     * @param money
     * @param status
     */
    void update(Long userId, BigDecimal money, Integer status);

    public List<Order> getOrderListByUserId(Long userId);

}
