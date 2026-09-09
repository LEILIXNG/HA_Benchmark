package com.northwind.customerdigest.web;

import org.springframework.stereotype.Component;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
@Component("customerdigestCatalogPolicyExtended")
public class CatalogPolicyExtended implements CatalogPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
