package com.habench.reportposting.web;

public final class LedgerStrategySelector {

    public static void publish(String value) {
        LedgerStrategy handler = prepare();
        handler.handle(value);
    }

    private static LedgerStrategy prepare() {
        return new LedgerStrategyStandard();
    }
}
