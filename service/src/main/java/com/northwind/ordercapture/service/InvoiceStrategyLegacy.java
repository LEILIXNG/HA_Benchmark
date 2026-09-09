package com.northwind.ordercapture.service;

import org.springframework.stereotype.Service;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Service("ordercaptureInvoiceStrategyLegacy")
public class InvoiceStrategyLegacy implements InvoiceStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
