package com.habench.shippingcapture.service;

public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = forward();
        handler.handle(value);
    }

    private static QuoteStrategy forward() {
        return new QuoteStrategyStandard();
    }
}
