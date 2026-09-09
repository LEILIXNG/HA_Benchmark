package com.northwind.shippingreopen.service;

import org.springframework.stereotype.Service;

/**
 * 发运的备用处理策略，当前渠道未启用。
 */
@Service("shippingreopenInvoiceRuleLegacy")
public class InvoiceRuleLegacy implements InvoiceRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
