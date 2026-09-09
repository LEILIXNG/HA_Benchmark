package com.northwind.vendorarchive.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Component("vendorarchiveAccountStrategyFallback")
public class AccountStrategyFallback implements AccountStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
