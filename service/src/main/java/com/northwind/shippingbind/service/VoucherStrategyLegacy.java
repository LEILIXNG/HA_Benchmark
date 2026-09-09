package com.northwind.shippingbind.service;

import org.springframework.stereotype.Service;

/**
 * 发运的备用处理策略，当前渠道未启用。
 */
@Service("shippingbindVoucherStrategyLegacy")
public class VoucherStrategyLegacy implements VoucherStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
