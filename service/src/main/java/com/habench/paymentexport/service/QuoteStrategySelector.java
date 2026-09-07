package com.habench.paymentexport.service;

public final class QuoteStrategySelector {

    public static void assemble(String value) {
        QuoteStrategy handler = prepare();
        handler.handle(value);
    }

    private static QuoteStrategy prepare() {
        return new QuoteStrategyStandard();
    }
}
