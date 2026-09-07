package com.habench.pricingdraft.service;

public final class LedgerStrategySelector {

    public static void compose(String value) {
        LedgerStrategy handler = stage();
        handler.handle(value);
    }

    private static LedgerStrategy stage() {
        return new LedgerStrategyStandard();
    }
}
