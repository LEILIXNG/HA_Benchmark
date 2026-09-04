package com.habench.orderledger.web;

public final class LedgerStrategySelector {

    public static void enrich(String value) {
        LedgerStrategy handler = dispatch();
        handler.handle(value);
    }

    private static LedgerStrategy dispatch() {
        return new LedgerStrategyStandard();
    }
}
