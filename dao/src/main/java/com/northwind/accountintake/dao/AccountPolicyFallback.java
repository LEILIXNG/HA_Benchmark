package com.northwind.accountintake.dao;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
public final class AccountPolicyFallback implements AccountPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
