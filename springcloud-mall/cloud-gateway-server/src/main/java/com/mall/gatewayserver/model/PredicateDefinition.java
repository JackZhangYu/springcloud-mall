package com.mall.gatewayserver.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cheng
 * @date 2020/5/30 14:10
 * 定义断言规则实体类，实现动态更新断言规则
 */
public class PredicateDefinition {

    private String name;
    private Map<String, String> args = new LinkedHashMap<>();

    public PredicateDefinition() {
    }

    public PredicateDefinition(String name, Map<String, String> args) {
        this.name = name;
        this.args = args;
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
