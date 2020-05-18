package com.mall.accountcenter.dao;

import com.mall.accountcenter.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/17 16:48
 */
@Repository
public interface AccountDao {

    /**
     * 扣减相应的账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

    /**
     * 根据用户id获取详细账户信息
     * @param userId
     * @return
     */
    public Account getAccountByUser(@Param("userId") Integer userId);

}
