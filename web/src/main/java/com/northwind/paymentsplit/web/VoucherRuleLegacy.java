package com.northwind.paymentsplit.web;

import org.springframework.stereotype.Component;

/**
 * 支付的备用处理策略，当前渠道未启用。
 */
@Component("paymentsplitVoucherRuleLegacy")
public class VoucherRuleLegacy implements VoucherRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
