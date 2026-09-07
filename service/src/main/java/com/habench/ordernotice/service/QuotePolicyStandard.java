package com.habench.ordernotice.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        AccountService.normalize(value);
    }
}
