package com.habench.inventorydraft.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        ContractBuilder.compose(value);
    }
}
