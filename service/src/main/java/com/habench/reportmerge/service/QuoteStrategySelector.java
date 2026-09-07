package com.habench.reportmerge.service;

public final class QuoteStrategySelector {

    public static void refine(String value) {
        QuoteStrategy handler = collect();
        handler.handle(value);
    }

    private static QuoteStrategy collect() {
        return new QuoteStrategyStandard();
    }
}
