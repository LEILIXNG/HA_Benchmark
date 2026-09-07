package com.habench.accountrefund.dao;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        BatchFacade.register(value);
    }
}
