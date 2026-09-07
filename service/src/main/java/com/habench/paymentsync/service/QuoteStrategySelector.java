package com.habench.paymentsync.service;

public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = reconcile();
        handler.handle(value);
    }

    private static QuoteStrategy reconcile() {
        return new QuoteStrategyStandard();
    }
}
