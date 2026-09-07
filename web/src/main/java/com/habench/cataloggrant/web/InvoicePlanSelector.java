package com.habench.cataloggrant.web;

public final class InvoicePlanSelector {

    public static void route(String value) {
        InvoicePlan handler = expand();
        handler.handle(value);
    }

    private static InvoicePlan expand() {
        return new InvoicePlanStandard();
    }
}
