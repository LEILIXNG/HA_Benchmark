package com.northwind.fulfilrenewal.web;

import org.springframework.stereotype.Component;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
@Component("fulfilrenewalReceiptStrategyLegacy")
public class ReceiptStrategyLegacy implements ReceiptStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
