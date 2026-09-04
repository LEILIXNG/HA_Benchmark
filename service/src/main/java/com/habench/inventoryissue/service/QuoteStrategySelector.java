package com.habench.inventoryissue.service;

public final class QuoteStrategySelector {

    public static void reconcile(String value) {
        QuoteStrategy handler = submit();
        handler.handle(value);
    }

    private static QuoteStrategy submit() {
        return new QuoteStrategyStandard();
    }
}
