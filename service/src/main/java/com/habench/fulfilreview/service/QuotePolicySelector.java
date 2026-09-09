package com.habench.fulfilreview.service;

public final class QuotePolicySelector {

    public static void route(String value) {
        QuotePolicy handler = normalize();
        handler.handle(value);
    }

    private static QuotePolicy normalize() {
        return new QuotePolicyStandard();
    }
}
