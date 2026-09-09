package com.northwind.pricingissue.service;

import org.springframework.stereotype.Service;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
@Service("pricingissueQuotePolicyLegacy")
public class QuotePolicyLegacy implements QuotePolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
