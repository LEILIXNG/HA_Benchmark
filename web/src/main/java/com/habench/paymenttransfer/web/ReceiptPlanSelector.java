package com.habench.paymenttransfer.web;

public final class ReceiptPlanSelector {

    public static void translate(String value) {
        ReceiptPlan handler = register();
        handler.handle(value);
    }

    private static ReceiptPlan register() {
        return new ReceiptPlanStandard();
    }
}
