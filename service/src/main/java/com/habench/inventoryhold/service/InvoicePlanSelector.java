package com.habench.inventoryhold.service;

public final class InvoicePlanSelector {

    public static void translate(String value) {
        InvoicePlan handler = normalize();
        handler.handle(value);
    }

    private static InvoicePlan normalize() {
        return new InvoicePlanStandard();
    }
}
