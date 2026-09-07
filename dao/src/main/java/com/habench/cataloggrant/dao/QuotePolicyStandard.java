package com.habench.cataloggrant.dao;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        QuoteComposer.route(value);
    }
}
