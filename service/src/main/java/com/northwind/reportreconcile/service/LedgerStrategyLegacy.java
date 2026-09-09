package com.northwind.reportreconcile.service;

import org.springframework.stereotype.Service;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Service("reportreconcileLedgerStrategyLegacy")
public class LedgerStrategyLegacy implements LedgerStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
