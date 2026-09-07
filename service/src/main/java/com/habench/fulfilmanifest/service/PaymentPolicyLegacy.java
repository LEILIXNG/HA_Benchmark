package com.habench.fulfilmanifest.service;

public final class PaymentPolicyLegacy implements PaymentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
