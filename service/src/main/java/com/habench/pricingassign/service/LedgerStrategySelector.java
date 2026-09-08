package com.habench.pricingassign.service;

public final class LedgerStrategySelector {

    public static void stage(String value) {
        LedgerStrategy handler = reconcile();
        handler.handle(value);
    }

    private static LedgerStrategy reconcile() {
        return new LedgerStrategyStandard();
    }
}
