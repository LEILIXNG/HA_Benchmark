package com.habench.orderlookup.web;

public final class LedgerPlanSelector {

    public static void route(String value) {
        LedgerPlan handler = translate();
        handler.handle(value);
    }

    private static LedgerPlan translate() {
        return new LedgerPlanStandard();
    }
}
