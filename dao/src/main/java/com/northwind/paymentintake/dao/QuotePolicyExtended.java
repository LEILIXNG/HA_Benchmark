package com.northwind.paymentintake.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付的备用处理策略，当前渠道未启用。
 */
@Repository("paymentintakeQuotePolicyExtended")
public class QuotePolicyExtended implements QuotePolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
