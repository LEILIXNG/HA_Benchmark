package com.habench.reportmerge.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        InvoiceBuilder.compose(value);
    }
}
