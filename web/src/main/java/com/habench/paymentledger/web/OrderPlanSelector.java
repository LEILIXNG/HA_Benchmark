package com.habench.paymentledger.web;

public final class OrderPlanSelector {

    public static void translate(String value) {
        OrderPlan handler = merge();
        handler.handle(value);
    }

    private static OrderPlan merge() {
        return new OrderPlanStandard();
    }
}
