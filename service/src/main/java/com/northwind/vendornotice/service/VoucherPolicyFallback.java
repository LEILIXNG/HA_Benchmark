package com.northwind.vendornotice.service;

import org.springframework.stereotype.Service;

/**
 * 供应商的备用处理策略，当前渠道未启用。
 */
@Service("vendornoticeVoucherPolicyFallback")
public class VoucherPolicyFallback implements VoucherPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
