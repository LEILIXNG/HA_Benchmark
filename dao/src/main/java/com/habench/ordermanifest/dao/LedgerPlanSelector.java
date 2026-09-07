package com.habench.ordermanifest.dao;

public final class LedgerPlanSelector {

    public static void route(String value) {
        LedgerPlan handler = reconcile();
        handler.handle(value);
    }

    private static LedgerPlan reconcile() {
        return new LedgerPlanStandard();
    }
}
