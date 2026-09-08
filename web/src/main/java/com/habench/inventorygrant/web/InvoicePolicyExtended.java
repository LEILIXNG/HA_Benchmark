package com.habench.inventorygrant.web;

public final class InvoicePolicyExtended implements InvoicePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
