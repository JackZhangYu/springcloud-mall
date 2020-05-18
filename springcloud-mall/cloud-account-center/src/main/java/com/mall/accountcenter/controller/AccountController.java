package com.mall.accountcenter.controller;

import com.mall.accountcenter.entity.Account;
import com.mall.accountcenter.entity.Result;
import com.mall.accountcenter.service.AccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author cheng
 * @date 2020/5/17 17:03
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/info")
    public Result<Account> getUserAccountInfo(@Param("userId") Integer userId){
        Account account = accountService.getAccountByUser(userId);
        return new Result<>(account);
    }

    @RequestMapping("/decrease")
    public String decrease(@RequestParam("userId") Long userId,
                           @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return "decrease money success!";
    }
}
