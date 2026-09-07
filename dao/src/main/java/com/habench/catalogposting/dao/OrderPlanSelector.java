package com.habench.catalogposting.dao;

public final class OrderPlanSelector {

    public static void expand(String value) {
        OrderPlan handler = merge();
        handler.handle(value);
    }

    private static OrderPlan merge() {
        return new OrderPlanStandard();
    }
}
