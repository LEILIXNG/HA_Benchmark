package com.northwind.catalogdigest.web;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
public final class ManifestPolicyLegacy implements ManifestPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
