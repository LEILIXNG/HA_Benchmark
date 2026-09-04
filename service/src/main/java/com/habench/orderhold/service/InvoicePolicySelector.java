package com.habench.orderhold.service;

public final class InvoicePolicySelector {

    public static void collect(String value) {
        InvoicePolicy handler = assemble();
        handler.handle(value);
    }

    private static InvoicePolicy assemble() {
        return new InvoicePolicyStandard();
    }
}
