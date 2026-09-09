package com.northwind.billingrollup.web;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
public final class LedgerRuleLegacy implements LedgerRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
