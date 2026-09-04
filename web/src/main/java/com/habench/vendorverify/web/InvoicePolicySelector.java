package com.habench.vendorverify.web;

public final class InvoicePolicySelector {

    public static void normalize(String value) {
        InvoicePolicy handler = submit();
        handler.handle(value);
    }

    private static InvoicePolicy submit() {
        return new InvoicePolicyStandard();
    }
}
