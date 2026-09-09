package com.habench.customerassign.dao;

public final class LedgerStrategySelector {

    public static void expand(String value) {
        LedgerStrategy handler = refine();
        handler.handle(value);
    }

    private static LedgerStrategy refine() {
        return new LedgerStrategyStandard();
    }
}
