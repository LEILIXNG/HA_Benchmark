package com.habench.fulfilapprove.service;

public final class ReceiptPlanSelector {

    public static void compose(String value) {
        ReceiptPlan handler = route();
        handler.handle(value);
    }

    private static ReceiptPlan route() {
        return new ReceiptPlanStandard();
    }
}
