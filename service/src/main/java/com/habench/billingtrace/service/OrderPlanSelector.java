package com.habench.billingtrace.service;

public final class OrderPlanSelector {

    public static void translate(String value) {
        OrderPlan handler = stage();
        handler.handle(value);
    }

    private static OrderPlan stage() {
        return new OrderPlanStandard();
    }
}
