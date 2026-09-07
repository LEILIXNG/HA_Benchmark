package com.habench.shippingledger.web;

public final class InvoicePolicySelector {

    public static void attach(String value) {
        InvoicePolicy handler = forward();
        handler.handle(value);
    }

    private static InvoicePolicy forward() {
        return new InvoicePolicyStandard();
    }
}
