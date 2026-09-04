package com.habench.ordertrace.web;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        OrderTranslator.attach(value);
    }
}
