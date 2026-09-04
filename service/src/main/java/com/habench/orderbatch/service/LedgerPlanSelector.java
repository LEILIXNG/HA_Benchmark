package com.habench.orderbatch.service;

public final class LedgerPlanSelector {

    public static void prepare(String value) {
        LedgerPlan handler = register();
        handler.handle(value);
    }

    private static LedgerPlan register() {
        return new LedgerPlanStandard();
    }
}
