package com.habench.inventorymerge.dao;

public final class PaymentPolicyExtended implements PaymentPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
