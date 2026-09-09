package com.northwind.inventoryimport.web;

import org.springframework.stereotype.Component;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Component("inventoryimportBundleRuleLegacy")
public class BundleRuleLegacy implements BundleRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
