package com.habench.paymentledger.service;

public final class LedgerPlanSelector {

    public static void forward(String value) {
        LedgerPlan handler = publish();
        handler.handle(value);
    }

    private static LedgerPlan publish() {
        return new LedgerPlanStandard();
    }
}
