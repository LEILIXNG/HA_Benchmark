package com.habench.shippingposting.service;

public final class InvoicePolicySelector {

    public static void collect(String value) {
        InvoicePolicy handler = expand();
        handler.handle(value);
    }

    private static InvoicePolicy expand() {
        return new InvoicePolicyStandard();
    }
}
