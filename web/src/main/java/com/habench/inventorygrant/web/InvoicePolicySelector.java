package com.habench.inventorygrant.web;

public final class InvoicePolicySelector {

    public static void stage(String value) {
        InvoicePolicy handler = dispatch();
        handler.handle(value);
    }

    private static InvoicePolicy dispatch() {
        return new InvoicePolicyStandard();
    }
}
