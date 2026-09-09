package com.northwind.fulfilexport.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("fulfilexportQuotePlanSelector")
public class QuotePlanSelector {
    private static final String ACTIVE = "fulfilexportQuotePlanStandard";
    private final Map<String, QuotePlan> handlers;

    public QuotePlanSelector(Map<String, QuotePlan> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        QuotePlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
