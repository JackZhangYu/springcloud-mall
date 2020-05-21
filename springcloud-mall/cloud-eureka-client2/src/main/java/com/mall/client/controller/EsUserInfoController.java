package com.mall.client.controller;

import com.mall.client.model.EsUserInfo;
import com.mall.client.model.Result;
import com.mall.client.service.EsUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/13 13:51
 */
@RestController
@RequestMapping("/es")
public class EsUserInfoController {

    @Autowired
    private EsUserInfoService esUserInfoService;

    @RequestMapping(value = "/userSearch",method = RequestMethod.GET)
    public Result<List<EsUserInfo>> getUserSearchResult(@RequestParam("word") String word,
                                                        @RequestParam("page") int page,
                                                        @RequestParam("size") int size){
        List<EsUserInfo> userInfos = esUserInfoService.getUserInfoByMulSearch(word,page,size);
        return new Result<>(userInfos);
    }

    @RequestMapping(value = "/phrase/search",method = RequestMethod.GET)
    public Result<List<EsUserInfo>> getUserPhraseSea(@RequestParam("keyWord") String keyWord,
                                                        @RequestParam("page") int page,
                                                        @RequestParam("size") int size){
        List<EsUserInfo> userInfos = esUserInfoService.getInfoByPhrase(keyWord,page,size);
        return new Result<>(userInfos);
    }
}
