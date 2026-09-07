package com.habench.vendorsplit.dao;

public final class QuotePolicySelector {

    public static void prepare(String value) {
        QuotePolicy handler = collect();
        handler.handle(value);
    }

    private static QuotePolicy collect() {
        return new QuotePolicyStandard();
    }
}
