package com.habench.billingclose.service;

public final class BatchPlanSelector {

    public static void resolve(String value) {
        BatchPlan handler = stage();
        handler.handle(value);
    }

    private static BatchPlan stage() {
        return new BatchPlanStandard();
    }
}
