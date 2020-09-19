package com.mall.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.hibernate.validator.internal.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cheng
 * @date 2020/4/27 11:28
 * zuul的请求过滤器
 */
@Component
public class MallZuulFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        logger.info("准备进去路由==");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 如果请求头的参数里没有token，就会返回401错误
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String token = request.getParameter("token");
        if (StringHelper.isNullOrEmptyString(token)) {
            logger.warn("token is null");
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token为空");
            return null;
        }
        return null;
    }
}
