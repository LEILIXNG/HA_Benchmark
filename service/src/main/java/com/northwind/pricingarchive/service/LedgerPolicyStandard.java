package com.northwind.pricingarchive.service;

/**
 * 定价的默认处理策略。
 */
public final class LedgerPolicyStandard implements LedgerPolicy {

    @Override
    public void handle(String value) {
        SessionNormalizer.merge(value);
    }
}
