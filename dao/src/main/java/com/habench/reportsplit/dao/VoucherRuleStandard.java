package com.habench.reportsplit.dao;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        AccountTranslator.attach(value);
    }
}
