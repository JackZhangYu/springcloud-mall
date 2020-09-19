package com.mall.userservice.service.impl;

import com.mall.userservice.dao.IOrderDao;
import com.mall.userservice.model.OrderModel;
import com.mall.userservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cheng
 * @date 2020/7/14 21:12
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Override
    public void createOrder(OrderModel orderModel) {
        orderDao.insertOrder(orderModel);
    }
}
