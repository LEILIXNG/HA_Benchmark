package com.habench.pricingrenewal.web;

public final class BatchPlanSelector {

    public static void reconcile(String value) {
        BatchPlan handler = attach();
        handler.handle(value);
    }

    private static BatchPlan attach() {
        return new BatchPlanStandard();
    }
}
