package com.habench.pricingissue.service;

public final class LedgerStrategySelector {

    public static void attach(String value) {
        LedgerStrategy handler = register();
        handler.handle(value);
    }

    private static LedgerStrategy register() {
        return new LedgerStrategyStandard();
    }
}
