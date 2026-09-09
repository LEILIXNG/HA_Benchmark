package com.northwind.pricingissue.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("pricingissueQuotePolicySelector")
public class QuotePolicySelector {
    private static final String ACTIVE = "pricingissueQuotePolicyStandard";
    private final Map<String, QuotePolicy> handlers;

    public QuotePolicySelector(Map<String, QuotePolicy> handlers) {
        this.handlers = handlers;
    }

    public void refine(String value) {
        QuotePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
