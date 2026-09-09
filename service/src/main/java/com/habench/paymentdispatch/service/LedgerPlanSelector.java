package com.habench.paymentdispatch.service;

public final class LedgerPlanSelector {

    public static void enrich(String value) {
        LedgerPlan handler = submit();
        handler.handle(value);
    }

    private static LedgerPlan submit() {
        return new LedgerPlanStandard();
    }
}
