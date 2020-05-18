package com.mall.client.service.impl;

import com.mall.client.dao.OrderDao;
import com.mall.client.feign.AccountApi;
import com.mall.client.feign.StorageApi;
import com.mall.client.model.Order;
import com.mall.client.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cheng
 * @date 2020/5/18 15:07
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageApi storageApi;

    @Autowired
    private AccountApi accountApi;
    /**
     * 创建订单
     * @param order
     * @return
     * 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
    @GlobalTransactional
    public void create(Order order) {
        LOGGER.info("创建订单开始");
        orderDao.create(order);

        storageApi.decrease(order.getProductId(),order.getCount());

        accountApi.decrease(order.getUserId(),order.getMoney());

        LOGGER.info("扣减账户结束");
        LOGGER.info("订单创建成功！");
    }

    @Override
    public void update(Long userId, BigDecimal money, Integer status) {
        orderDao.update(userId,money,status);
    }

    @Override
    public List<Order> getOrderListByUserId(Long userId) {
        return orderDao.getOrderListByUserId(userId);
    }
}
