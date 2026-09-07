package com.habench.shippingsplit.web;

public final class LedgerStrategySelector {

    public static void forward(String value) {
        LedgerStrategy handler = register();
        handler.handle(value);
    }

    private static LedgerStrategy register() {
        return new LedgerStrategyStandard();
    }
}
