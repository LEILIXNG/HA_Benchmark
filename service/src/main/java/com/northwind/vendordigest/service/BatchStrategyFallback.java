package com.northwind.vendordigest.service;

import org.springframework.stereotype.Service;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Service("vendordigestBatchStrategyFallback")
public class BatchStrategyFallback implements BatchStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
