package com.northwind.reportsync.service;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
public final class QuotePlanExtended implements QuotePlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
