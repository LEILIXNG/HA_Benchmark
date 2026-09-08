package com.habench.pricingissue.service;

public final class QuotePolicySelector {

    public static void refine(String value) {
        QuotePolicy handler = dispatch();
        handler.handle(value);
    }

    private static QuotePolicy dispatch() {
        return new QuotePolicyStandard();
    }
}
