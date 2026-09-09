package com.northwind.customerquote.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
@Repository("customerquoteBundlePolicyFallback")
public class BundlePolicyFallback implements BundlePolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
