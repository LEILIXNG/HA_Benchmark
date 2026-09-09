package com.northwind.pricingrefund.dao;

import org.springframework.stereotype.Repository;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
@Repository("pricingrefundReceiptStrategyLegacy")
public class ReceiptStrategyLegacy implements ReceiptStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
