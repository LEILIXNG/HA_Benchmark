package com.habench.inventoryassign.service;

public final class VoucherPolicyFallback implements VoucherPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
