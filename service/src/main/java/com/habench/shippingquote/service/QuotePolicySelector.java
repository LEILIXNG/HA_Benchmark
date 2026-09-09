package com.habench.shippingquote.service;

public final class QuotePolicySelector {

    public static void expand(String value) {
        QuotePolicy handler = translate();
        handler.handle(value);
    }

    private static QuotePolicy translate() {
        return new QuotePolicyStandard();
    }
}
