package com.mall.client.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mall.client.model.EsUserInfo;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author cheng
 * @date 2020/5/13 12:26
 */
@Repository("esUserInfoDao")
public class EsUserInfoDao {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public List<EsUserInfo> getUserInfoByMulSearch(String searchWord, int page, int size){
        List<EsUserInfo> userInfos = new ArrayList<>();
        EsUserInfo esUserInfo = new EsUserInfo();
        SearchRequest request = new SearchRequest("userinfo");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        if(!StringUtils.isEmpty(searchWord)){
            builder.query(QueryBuilders.matchQuery("persondetail",searchWord));
        }
        builder.from(page);
        builder.size(size);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(builder);
        try {
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            long num = response.getHits().getTotalHits().value;
            System.out.println("查询的总条数为:"+ num);
            SearchHit[] searchHits = hits.getHits();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd hh:mm:ss")
                    .create();
            for(SearchHit searchHit :searchHits){
                Map<String,Object> map = searchHit.getSourceAsMap();
                String object = gson.toJson(map);
                esUserInfo = gson.fromJson(object,EsUserInfo.class);
                userInfos.add(esUserInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfos;
    }
}
