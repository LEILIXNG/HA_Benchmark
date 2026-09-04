package com.habench.vendorverify.service;

public final class QuoteStrategySelector {

    public static void publish(String value) {
        QuoteStrategy handler = resolve();
        handler.handle(value);
    }

    private static QuoteStrategy resolve() {
        return new QuoteStrategyStandard();
    }
}
