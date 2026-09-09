package com.northwind.billingdigest.web;

/**
 * 账务处理策略的入口。
 */
public final class BatchPlanSelector {

    public static void refine(String value) {
        BatchPlan handler = stage();
        handler.handle(value);
    }

    private static BatchPlan stage() {
        return new BatchPlanStandard();
    }
}
