package com.northwind.pricingnotice.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("pricingnoticeQuotePlanSelector")
public class QuotePlanSelector {
    private static final String ACTIVE = "pricingnoticeQuotePlanStandard";
    private final Map<String, QuotePlan> handlers;

    public QuotePlanSelector(Map<String, QuotePlan> handlers) {
        this.handlers = handlers;
    }

    public void refine(String value) {
        QuotePlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
