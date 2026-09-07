package com.habench.billingadjust.web;

public final class InvoicePlanSelector {

    public static void attach(String value) {
        InvoicePlan handler = stage();
        handler.handle(value);
    }

    private static InvoicePlan stage() {
        return new InvoicePlanStandard();
    }
}
