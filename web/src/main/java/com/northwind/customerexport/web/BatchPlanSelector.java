package com.northwind.customerexport.web;

/**
 * 客户处理策略的入口。
 */
public final class BatchPlanSelector {

    public static void resolve(String value) {
        BatchPlan handler = collect();
        handler.handle(value);
    }

    private static BatchPlan collect() {
        return new BatchPlanStandard();
    }
}
