package com.mall.client.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/18 15:00
 */
@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**订单状态：0：创建中；1：已完结*/
    private Integer status;


}
