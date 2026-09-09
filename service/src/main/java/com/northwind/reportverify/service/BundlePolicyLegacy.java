package com.northwind.reportverify.service;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
public final class BundlePolicyLegacy implements BundlePolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
