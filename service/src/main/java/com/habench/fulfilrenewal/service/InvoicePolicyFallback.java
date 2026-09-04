package com.habench.fulfilrenewal.service;

public final class InvoicePolicyFallback implements InvoicePolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
