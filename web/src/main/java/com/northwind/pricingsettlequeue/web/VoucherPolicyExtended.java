package com.northwind.pricingsettlequeue.web;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
public final class VoucherPolicyExtended implements VoucherPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
