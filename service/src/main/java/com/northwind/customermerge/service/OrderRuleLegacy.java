package com.northwind.customermerge.service;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
public final class OrderRuleLegacy implements OrderRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
