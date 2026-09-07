package com.habench.paymentexport.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        QuoteNormalizer.forward(value);
    }
}
