package com.habench.paymentimport.service;

public final class InvoicePlanSelector {

    public static void register(String value) {
        InvoicePlan handler = translate();
        handler.handle(value);
    }

    private static InvoicePlan translate() {
        return new InvoicePlanStandard();
    }
}
