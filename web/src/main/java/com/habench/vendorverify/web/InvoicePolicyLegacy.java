package com.habench.vendorverify.web;

public final class InvoicePolicyLegacy implements InvoicePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
