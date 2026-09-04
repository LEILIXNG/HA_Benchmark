package com.habench.vendorverify.web;

public final class InvoicePlanSelector {

    public static void resolve(String value) {
        InvoicePlan handler = attach();
        handler.handle(value);
    }

    private static InvoicePlan attach() {
        return new InvoicePlanStandard();
    }
}
