package com.habench.vendorexport.web;

public final class BatchPlanSelector {

    public static void merge(String value) {
        BatchPlan handler = dispatch();
        handler.handle(value);
    }

    private static BatchPlan dispatch() {
        return new BatchPlanStandard();
    }
}
