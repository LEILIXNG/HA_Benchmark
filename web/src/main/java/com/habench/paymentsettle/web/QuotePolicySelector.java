package com.habench.paymentsettle.web;

public final class QuotePolicySelector {

    public static void merge(String value) {
        QuotePolicy handler = forward();
        handler.handle(value);
    }

    private static QuotePolicy forward() {
        return new QuotePolicyStandard();
    }
}
