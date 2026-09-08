package com.habench.billingintake.dao;

public final class PaymentPolicyLegacy implements PaymentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
