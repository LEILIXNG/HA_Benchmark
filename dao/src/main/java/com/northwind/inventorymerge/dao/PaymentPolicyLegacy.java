package com.northwind.inventorymerge.dao;

import org.springframework.stereotype.Repository;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Repository("inventorymergePaymentPolicyLegacy")
public class PaymentPolicyLegacy implements PaymentPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
