package com.habench.catalogadjust.service;

public final class QuoteStrategySelector {

    public static void dispatch(String value) {
        QuoteStrategy handler = expand();
        handler.handle(value);
    }

    private static QuoteStrategy expand() {
        return new QuoteStrategyStandard();
    }
}
