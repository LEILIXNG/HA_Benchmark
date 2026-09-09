package com.northwind.customerassign.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
@Repository("customerassignLedgerStrategyLegacy")
public class LedgerStrategyLegacy implements LedgerStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
