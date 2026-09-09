package com.northwind.fulfilapprove.service;

import org.springframework.stereotype.Service;

/**
 * 履约的备用处理策略，当前渠道未启用。
 */
@Service("fulfilapproveReceiptPlanLegacy")
public class ReceiptPlanLegacy implements ReceiptPlan {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
