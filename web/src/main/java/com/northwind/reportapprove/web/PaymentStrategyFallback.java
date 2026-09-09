package com.northwind.reportapprove.web;

import org.springframework.stereotype.Component;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Component("reportapprovePaymentStrategyFallback")
public class PaymentStrategyFallback implements PaymentStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
