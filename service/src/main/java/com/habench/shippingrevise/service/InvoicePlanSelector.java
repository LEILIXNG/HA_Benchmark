package com.habench.shippingrevise.service;

public final class InvoicePlanSelector {

    public static void merge(String value) {
        InvoicePlan handler = register();
        handler.handle(value);
    }

    private static InvoicePlan register() {
        return new InvoicePlanStandard();
    }
}
