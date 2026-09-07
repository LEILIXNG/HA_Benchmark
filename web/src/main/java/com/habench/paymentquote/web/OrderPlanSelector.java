package com.habench.paymentquote.web;

public final class OrderPlanSelector {

    public static void route(String value) {
        OrderPlan handler = collect();
        handler.handle(value);
    }

    private static OrderPlan collect() {
        return new OrderPlanStandard();
    }
}
