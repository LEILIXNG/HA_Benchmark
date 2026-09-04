package com.habench.fulfilrenewal.service;

public final class InvoicePolicySelector {

    public static void reconcile(String value) {
        InvoicePolicy handler = forward();
        handler.handle(value);
    }

    private static InvoicePolicy forward() {
        return new InvoicePolicyStandard();
    }
}
