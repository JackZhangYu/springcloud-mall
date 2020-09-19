package com.mall.userservice.dao;

import com.mall.userservice.model.OrderModel;

import java.util.List;

/**
 * @author cheng
 * @date 2020/7/14 16:52
 */
public interface IOrderDao {

    void insertOrder(OrderModel orderModel);

    OrderModel getOrderById(Long orderId);

    List<OrderModel> getAllOrder();

    void updateOrderById(OrderModel orderModel);
}
