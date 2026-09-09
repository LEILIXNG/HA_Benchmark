package com.northwind.orderdraft.web;

import org.springframework.stereotype.Component;

/**
 * 订单的备用处理策略，当前渠道未启用。
 */
@Component("orderdraftInvoiceStrategyLegacy")
public class InvoiceStrategyLegacy implements InvoiceStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
