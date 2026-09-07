package com.habench.reportreopen.dao;

public final class OrderPlanSelector {

    public static void register(String value) {
        OrderPlan handler = reconcile();
        handler.handle(value);
    }

    private static OrderPlan reconcile() {
        return new OrderPlanStandard();
    }
}
