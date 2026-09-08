package com.habench.reportrollup.dao;

public final class QuotePolicySelector {

    public static void expand(String value) {
        QuotePolicy handler = forward();
        handler.handle(value);
    }

    private static QuotePolicy forward() {
        return new QuotePolicyStandard();
    }
}
