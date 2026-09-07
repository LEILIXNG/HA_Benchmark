package com.habench.shippingledger.web;

public final class LedgerStrategySelector {

    public static void normalize(String value) {
        LedgerStrategy handler = attach();
        handler.handle(value);
    }

    private static LedgerStrategy attach() {
        return new LedgerStrategyStandard();
    }
}
