package com.habench.billingledger.web;

public final class VoucherPolicyExtended implements VoucherPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
