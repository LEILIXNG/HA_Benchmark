package com.habench.orderlookup.web;

public final class InvoicePolicySelector {

    public static void refine(String value) {
        InvoicePolicy handler = route();
        handler.handle(value);
    }

    private static InvoicePolicy route() {
        return new InvoicePolicyStandard();
    }
}
