package com.habench.shippingtransfer.dao;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        AccountTranslator.attach(value);
    }
}
