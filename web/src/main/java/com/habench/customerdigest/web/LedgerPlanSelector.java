package com.habench.customerdigest.web;

public final class LedgerPlanSelector {

    public static void prepare(String value) {
        LedgerPlan handler = enrich();
        handler.handle(value);
    }

    private static LedgerPlan enrich() {
        return new LedgerPlanStandard();
    }
}
