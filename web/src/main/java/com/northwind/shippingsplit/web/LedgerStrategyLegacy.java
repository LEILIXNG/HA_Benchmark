package com.northwind.shippingsplit.web;

import org.springframework.stereotype.Component;

/**
 * 发运的备用处理策略，当前渠道未启用。
 */
@Component("shippingsplitLedgerStrategyLegacy")
public class LedgerStrategyLegacy implements LedgerStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
