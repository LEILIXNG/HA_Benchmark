package com.northwind.orderrefund.web;

import org.springframework.stereotype.Component;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Component("orderrefundQuotePolicyLegacy")
public class QuotePolicyLegacy implements QuotePolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
