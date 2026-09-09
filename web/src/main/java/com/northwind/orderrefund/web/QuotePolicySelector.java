package com.northwind.orderrefund.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("orderrefundQuotePolicySelector")
public class QuotePolicySelector {
    private static final String ACTIVE = "orderrefundQuotePolicyStandard";
    private final Map<String, QuotePolicy> handlers;

    public QuotePolicySelector(Map<String, QuotePolicy> handlers) {
        this.handlers = handlers;
    }

    public void enrich(String value) {
        QuotePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
