package com.habench.reportbatch.dao;

public final class LedgerPlanSelector {

    public static void route(String value) {
        LedgerPlan handler = resolve();
        handler.handle(value);
    }

    private static LedgerPlan resolve() {
        return new LedgerPlanStandard();
    }
}
