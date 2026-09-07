package com.habench.accountgrant.dao;

public final class LedgerPlanSelector {

    public static void assemble(String value) {
        LedgerPlan handler = submit();
        handler.handle(value);
    }

    private static LedgerPlan submit() {
        return new LedgerPlanStandard();
    }
}
