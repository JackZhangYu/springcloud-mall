package com.mall.accountcenter.service;

import com.mall.accountcenter.entity.Account;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/17 16:59
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);

    public Account getAccountByUser( Integer userId);
}
