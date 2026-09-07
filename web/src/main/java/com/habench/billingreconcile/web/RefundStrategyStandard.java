package com.habench.billingreconcile.web;

public final class RefundStrategyStandard implements RefundStrategy {
    @Override
    public void handle(String value) {
        QuoteTranslator.route(value);
    }
}
