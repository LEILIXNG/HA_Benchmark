package com.habench.paymentlookup.dao;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        QuoteRegistry.refine(value);
    }
}
