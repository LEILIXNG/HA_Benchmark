package com.habench.shippingcapture.web;

public final class ReceiptPlanSelector {

    public static void submit(String value) {
        ReceiptPlan handler = resolve();
        handler.handle(value);
    }

    private static ReceiptPlan resolve() {
        return new ReceiptPlanStandard();
    }
}
