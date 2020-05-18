package com.mall.accountcenter.service.impl;

import com.mall.accountcenter.dao.AccountDao;
import com.mall.accountcenter.entity.Account;
import com.mall.accountcenter.feign.OrderApi;
import com.mall.accountcenter.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/17 17:01
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private OrderApi orderApi;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->扣减账户开始account中");

        accountDao.decrease(userId,money);
        LOGGER.info("------->扣减账户结束account中");
        LOGGER.info("修改订单状态开始");
        String mess = orderApi.update(userId,money.multiply(new BigDecimal("0.09")),0);
        LOGGER.info("修改订单状态结束：{}",mess);

    }

    @Override
    public Account getAccountByUser(Integer userId) {
        return accountDao.getAccountByUser(userId);
    }
}
