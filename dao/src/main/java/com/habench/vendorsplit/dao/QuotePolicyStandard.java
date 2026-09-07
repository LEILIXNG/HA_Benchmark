package com.habench.vendorsplit.dao;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        OrderTranslator.dispatch(value);
    }
}
