package com.northwind.vendormerge.service;

import org.springframework.stereotype.Service;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Service("vendormergeCatalogPolicyFallback")
public class CatalogPolicyFallback implements CatalogPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
