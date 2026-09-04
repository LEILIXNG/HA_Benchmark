package com.habench.fulfilissue.web;

public final class QuotePolicySelector {

    public static void translate(String value) {
        QuotePolicy handler = compose();
        handler.handle(value);
    }

    private static QuotePolicy compose() {
        return new QuotePolicyStandard();
    }
}
