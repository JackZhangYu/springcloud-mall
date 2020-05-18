package com.mall.client.controller;

import com.mall.client.model.Order;
import com.mall.client.model.Result;
import com.mall.client.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cheng
 * @date 2020/5/18 15:32
 */
@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService orderServiceImpl;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @GetMapping("create")
    public String create(Order order){
        orderServiceImpl.create(order);
        return "Create order success";
    }

    /**
     * 修改订单状态
     * @param userId
     * @param money
     * @param status
     * @return
     */
    @RequestMapping("update")
    String update(@RequestParam("userId") Long userId,
                  @RequestParam("money") BigDecimal money,
                  @RequestParam("status") Integer status){
        orderServiceImpl.update(userId,money,status);
        return "订单状态修改成功";
    }

    @RequestMapping("/getOrderList")
    public Result<List<Order>> getOrderList(@RequestParam("userId") Long userId){
        List<Order> orders = orderServiceImpl.getOrderListByUserId(userId);
        return new Result<>(orders);
    }
}
