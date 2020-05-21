package com.mall.client.service.impl;

import com.mall.client.dao.EsUserInfoDao;
import com.mall.client.model.EsUserInfo;
import com.mall.client.service.EsUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/13 13:49
 */
@Service
public class EsUserInfoServiceImpl implements EsUserInfoService {

    @Autowired
    private EsUserInfoDao esUserInfoDao;

    @Override
    public List<EsUserInfo> getUserInfoByMulSearch(String searchWord, int page, int size) {
        return esUserInfoDao.getUserInfoByMulSearch(searchWord,page,size);
    }

    @Override
    public List<EsUserInfo> getInfoByPhrase(String keyWord, int page, int size) {
        return esUserInfoDao.getInfoByPhrase(keyWord,page,size);
    }
}
