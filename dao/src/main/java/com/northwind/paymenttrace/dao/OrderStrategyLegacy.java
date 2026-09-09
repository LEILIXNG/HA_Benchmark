package com.northwind.paymenttrace.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付的备用处理策略，当前渠道未启用。
 */
@Repository("paymenttraceOrderStrategyLegacy")
public class OrderStrategyLegacy implements OrderStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
