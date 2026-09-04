package com.habench.ordertrace.web;

public final class QuoteStrategySelector {

    public static void submit(String value) {
        QuoteStrategy handler = assemble();
        handler.handle(value);
    }

    private static QuoteStrategy assemble() {
        return new QuoteStrategyStandard();
    }
}
