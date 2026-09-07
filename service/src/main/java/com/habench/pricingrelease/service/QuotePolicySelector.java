package com.habench.pricingrelease.service;

public final class QuotePolicySelector {

    public static void prepare(String value) {
        QuotePolicy handler = attach();
        handler.handle(value);
    }

    private static QuotePolicy attach() {
        return new QuotePolicyStandard();
    }
}
