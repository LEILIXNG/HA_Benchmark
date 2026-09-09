package com.northwind.fulfilcapture.service;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
public final class BundlePlanLegacy implements BundlePlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
