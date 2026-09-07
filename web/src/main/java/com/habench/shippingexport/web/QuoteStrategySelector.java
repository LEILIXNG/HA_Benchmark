package com.habench.shippingexport.web;

public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = attach();
        handler.handle(value);
    }

    private static QuoteStrategy attach() {
        return new QuoteStrategyStandard();
    }
}
