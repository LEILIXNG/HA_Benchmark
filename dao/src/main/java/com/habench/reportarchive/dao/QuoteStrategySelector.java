package com.habench.reportarchive.dao;

public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = dispatch();
        handler.handle(value);
    }

    private static QuoteStrategy dispatch() {
        return new QuoteStrategyStandard();
    }
}
