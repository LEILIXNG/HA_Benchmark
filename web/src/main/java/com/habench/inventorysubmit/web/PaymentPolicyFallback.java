package com.habench.inventorysubmit.web;

public final class PaymentPolicyFallback implements PaymentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
