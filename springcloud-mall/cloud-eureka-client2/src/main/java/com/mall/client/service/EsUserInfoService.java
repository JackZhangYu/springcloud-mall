package com.mall.client.service;

import com.mall.client.model.EsUserInfo;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/13 13:45
 */
public interface EsUserInfoService {

    /**
     * 根据用户的详细信息进行全文检索
     * @param searchWord
     * @param page
     * @param size
     * @return
     */
    public List<EsUserInfo> getUserInfoByMulSearch(String searchWord, int page, int size);

    public List<EsUserInfo> getInfoByPhrase(String keyWord,int page,int size);


    }
