package com.mall.client.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author cheng
 * @date 2019/12/14 9:10
 */
@Slf4j
@Configuration
public class ElasticRestClient {
    //elastic服务器的IP地址
    private static final String HOST = "127.0.0.1";

    private static final int PORT_ONE = 9200;
    /**
     *  REST服务器使用9201端口，外部客户端可以使用它来连接和执行操作。
     */
    private static final int PORT_TWO = 9201;
    /**
     * 通信方式
     */
    private static final String SCHEME = "http";
    private static RestHighLevelClient restHighLevelClient;

    private static synchronized RestHighLevelClient getConn() {
        if (restHighLevelClient == null) {
            restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME),
                    new HttpHost(HOST, PORT_TWO, SCHEME)));
        }
        return restHighLevelClient;
    }

    /**
     * 关闭ES的连接
     * @throws IOException
     */
    private static synchronized void closeConn() throws IOException {
        restHighLevelClient.close();
        restHighLevelClient = null;
    }
}
