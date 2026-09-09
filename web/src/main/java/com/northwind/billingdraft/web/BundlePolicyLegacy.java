package com.northwind.billingdraft.web;

import org.springframework.stereotype.Component;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
@Component("billingdraftBundlePolicyLegacy")
public class BundlePolicyLegacy implements BundlePolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
