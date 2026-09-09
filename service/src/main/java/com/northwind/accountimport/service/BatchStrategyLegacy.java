package com.northwind.accountimport.service;

import org.springframework.stereotype.Service;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
@Service("accountimportBatchStrategyLegacy")
public class BatchStrategyLegacy implements BatchStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
