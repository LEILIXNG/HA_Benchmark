package com.northwind.pricingnotice.service;

import org.springframework.stereotype.Service;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
@Service("pricingnoticeQuotePlanExtended")
public class QuotePlanExtended implements QuotePlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
