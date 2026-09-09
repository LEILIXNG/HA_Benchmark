package com.northwind.paymentposting.dao;

/**
 * 支付的备用处理策略，当前渠道未启用。
 */
public final class ContractRuleLegacy implements ContractRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
