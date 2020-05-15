package com.mall.fegin.controller;

import com.mall.fegin.entity.EsUserInfo;
import com.mall.fegin.entity.Result;
import com.mall.fegin.service.EsMemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/13 15:24
 */
@RestController
@RequestMapping(value = "/es-user")
public class EsMemberInfoController {

    @Autowired
    private EsMemberInfoService esMemberInfoService;

    @RequestMapping("/es/userSearch")
    public Result<List<EsUserInfo>> getUserInfoByEs(@RequestParam("word") String keyWord,
                                                    @RequestParam("page") int page,
                                                    @RequestParam("size") int size){
        Result<List<EsUserInfo>> userInfos = esMemberInfoService.getMemberInfo(keyWord,page,size);
        return userInfos;
    }
}
