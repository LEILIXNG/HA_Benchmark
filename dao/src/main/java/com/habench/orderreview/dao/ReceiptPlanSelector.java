package com.habench.orderreview.dao;

public final class ReceiptPlanSelector {

    public static void compose(String value) {
        ReceiptPlan handler = dispatch();
        handler.handle(value);
    }

    private static ReceiptPlan dispatch() {
        return new ReceiptPlanStandard();
    }
}
