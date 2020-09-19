package com.mall.fegin;

import com.mall.fegin.service.UserFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloudMallFeginApplicationTests {

    @Autowired
    private UserFeignClient userFeignClient;
    @Test
    void contextLoads() {
        String userName = userFeignClient.getUserName();

        System.out.println("输入结果，" + userName);
    }

}
