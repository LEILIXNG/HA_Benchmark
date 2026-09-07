package com.habench.reportclose.dao;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        QuoteAssembler.publish(value);
    }
}
