package com.habench.accountsplit.web;

public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = reconcile();
        handler.handle(value);
    }

    private static QuoteStrategy reconcile() {
        return new QuoteStrategyStandard();
    }
}
