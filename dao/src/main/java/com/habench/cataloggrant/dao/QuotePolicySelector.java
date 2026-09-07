package com.habench.cataloggrant.dao;

public final class QuotePolicySelector {

    public static void translate(String value) {
        QuotePolicy handler = compose();
        handler.handle(value);
    }

    private static QuotePolicy compose() {
        return new QuotePolicyStandard();
    }
}
