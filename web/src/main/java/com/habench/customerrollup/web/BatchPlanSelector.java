package com.habench.customerrollup.web;

public final class BatchPlanSelector {

    public static void refine(String value) {
        BatchPlan handler = stage();
        handler.handle(value);
    }

    private static BatchPlan stage() {
        return new BatchPlanStandard();
    }
}
