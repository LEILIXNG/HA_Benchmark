package com.habench.reportrollup.dao;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        BatchFacade.register(value);
    }
}
