package com.habench.customerexport.web;

public final class BatchPlanSelector {

    public static void resolve(String value) {
        BatchPlan handler = collect();
        handler.handle(value);
    }

    private static BatchPlan collect() {
        return new BatchPlanStandard();
    }
}
