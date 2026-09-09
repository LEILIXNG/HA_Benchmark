package com.northwind.vendorsync.service;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
public final class BundleRuleFallback implements BundleRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
