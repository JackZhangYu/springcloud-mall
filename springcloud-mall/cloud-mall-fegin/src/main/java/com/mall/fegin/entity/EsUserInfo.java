package com.mall.fegin.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/13 12:16
 */
@Data
public class EsUserInfo {

    private Integer id;

    private String username;

    private String email;

    private BigDecimal earning;

    private Integer familyPop;

    private String education;

    private String address;

    private BigDecimal expenditure;

    private Integer age;

    private String personDetail;

    private String registerTime;
}
