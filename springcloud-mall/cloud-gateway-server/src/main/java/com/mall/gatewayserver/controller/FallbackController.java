package com.mall.gatewayserver.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cheng
 * @date 2020/5/12 10:33
 */
@RestController
public class FallbackController {

    @RequestMapping(value = "/fallback")
    @ResponseStatus
    public Mono<Map<String,Object>> fallback(ServerWebExchange exchange,Throwable throwable){
        Map<String, Object> result = new HashMap<>(8);
        ServerHttpRequest request = exchange.getRequest();
        result.put("path", request.getPath().pathWithinApplication().value());
        result.put("method", request.getMethodValue());
        if (null != throwable.getCause()) {
            result.put("message", throwable.getCause().getMessage());
        } else {
            result.put("message", throwable.getMessage());
        }
        return Mono.just(result);
    }

}
