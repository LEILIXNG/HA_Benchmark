package com.habench.shippingrevise.service;

public final class LedgerPlanSelector {

    public static void refine(String value) {
        LedgerPlan handler = publish();
        handler.handle(value);
    }

    private static LedgerPlan publish() {
        return new LedgerPlanStandard();
    }
}
