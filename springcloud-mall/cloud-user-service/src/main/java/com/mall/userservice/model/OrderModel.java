package com.mall.userservice.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cheng
 * @date 2020/7/14 16:46
 */
@Data
public class OrderModel implements Serializable {
    private Long id;
    private String orderName;
    private String userName;
    private String productId;
    private Long createTime;
}
