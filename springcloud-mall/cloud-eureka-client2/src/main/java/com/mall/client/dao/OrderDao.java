package com.mall.client.dao;

import com.mall.client.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author cheng
 * @date 2020/5/18 15:01
 */
@Repository
public interface OrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param money
     */
    void update(@Param("userId") Long userId,
                @Param("money") BigDecimal money,
                @Param("status") Integer status);

    /**
     * 根据用户Id，获取其全部订单信息
     * @param userId
     * @return
     */
    public List<Order> getOrderListByUserId(@Param("userId") Long userId);
}
