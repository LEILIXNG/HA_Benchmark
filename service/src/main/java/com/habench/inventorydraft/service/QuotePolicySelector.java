package com.habench.inventorydraft.service;

public final class QuotePolicySelector {

    public static void enrich(String value) {
        QuotePolicy handler = resolve();
        handler.handle(value);
    }

    private static QuotePolicy resolve() {
        return new QuotePolicyStandard();
    }
}
