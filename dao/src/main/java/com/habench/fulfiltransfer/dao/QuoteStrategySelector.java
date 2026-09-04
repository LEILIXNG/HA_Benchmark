package com.habench.fulfiltransfer.dao;

public final class QuoteStrategySelector {

    public static void attach(String value) {
        QuoteStrategy handler = publish();
        handler.handle(value);
    }

    private static QuoteStrategy publish() {
        return new QuoteStrategyStandard();
    }
}
