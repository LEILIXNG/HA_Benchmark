package com.northwind.orderintake.service;

import org.springframework.stereotype.Service;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Service("orderintakeReceiptRuleLegacy")
public class ReceiptRuleLegacy implements ReceiptRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
