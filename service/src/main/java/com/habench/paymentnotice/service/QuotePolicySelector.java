package com.habench.paymentnotice.service;

public final class QuotePolicySelector {

    public static void attach(String value) {
        QuotePolicy handler = enrich();
        handler.handle(value);
    }

    private static QuotePolicy enrich() {
        return new QuotePolicyStandard();
    }
}
