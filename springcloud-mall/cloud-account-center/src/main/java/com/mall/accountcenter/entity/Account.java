package com.mall.accountcenter.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/17 16:44
 */
@Data
public class Account {

    private Long id;

    /**用户id*/
    private Integer userId;

    /**总额度*/
    private BigDecimal total;

    /**已用额度*/
    private BigDecimal usedMoney;

    /**剩余额度*/
    private BigDecimal residue;
}
