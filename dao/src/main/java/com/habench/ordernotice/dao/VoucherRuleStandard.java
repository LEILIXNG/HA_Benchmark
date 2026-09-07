package com.habench.ordernotice.dao;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        BatchTranslator.resolve(value);
    }
}
