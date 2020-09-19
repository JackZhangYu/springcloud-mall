package com.mall.gatewayserver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cheng
 * @date 2020/5/30 14:13
 * 断言路由规则实体类，包含过滤规则，断言规则和uri
 */
public class RouteDefinition {

    /**
     * 断言集合
     */
    private List<PredicateDefinition> predicates = new ArrayList<>();
    /**
     * 过滤集合
     */
    private List<FilterDefinition> filters = new ArrayList<>();
    /**
     * 路由到的地址
     */
    private String uri;
    /**
     * 执行次序
     */
    private int order = 0;

    public RouteDefinition(List<PredicateDefinition> predicates, List<FilterDefinition> filters, String uri, int order) {
        this.predicates = predicates;
        this.filters = filters;
        this.uri = uri;
        this.order = order;
    }

    public RouteDefinition() {
    }

    public List<PredicateDefinition> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<PredicateDefinition> predicates) {
        this.predicates = predicates;
    }

    public List<FilterDefinition> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterDefinition> filters) {
        this.filters = filters;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
