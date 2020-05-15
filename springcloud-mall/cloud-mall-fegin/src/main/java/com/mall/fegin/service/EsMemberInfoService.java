package com.mall.fegin.service;

import com.mall.fegin.config.FeignServiceFallBack;
import com.mall.fegin.entity.EsUserInfo;
import com.mall.fegin.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/13 15:17
 */
@FeignClient(name = "cloud-user-center",fallback = FeignServiceFallBack.class)
public interface EsMemberInfoService {

    /**
     * 这个参数要和调用的服务端的参数名一致，如word写成keyWord会出错
     * 并且请求多个参数的时候，这个参数要带上RequestParam注解，不然系统会启动报错。
     * @param keyWord
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/es/userSearch",method = RequestMethod.GET)
    public Result<List<EsUserInfo>> getMemberInfo(@RequestParam("word") String keyWord,
                                                  @RequestParam("page") int page,
                                                  @RequestParam("size") int size);
}
