package com.mall.gatewayserver.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cheng
 * @date 2020/5/30 14:08
 * 定义过滤规则实体类，动态更新规则
 */
public class FilterDefinition {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();


    public FilterDefinition(String name, Map<String, String> args) {
        this.name = name;
        this.args = args;
    }

    public FilterDefinition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
