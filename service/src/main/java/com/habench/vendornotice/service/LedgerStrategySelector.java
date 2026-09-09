package com.habench.vendornotice.service;

public final class LedgerStrategySelector {

    public static void refine(String value) {
        LedgerStrategy handler = stage();
        handler.handle(value);
    }

    private static LedgerStrategy stage() {
        return new LedgerStrategyStandard();
    }
}
