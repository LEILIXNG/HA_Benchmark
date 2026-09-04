package com.habench.accountsettle.dao;

public final class VoucherPolicyFallback implements VoucherPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
