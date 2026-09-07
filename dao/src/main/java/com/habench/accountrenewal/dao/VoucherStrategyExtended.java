package com.habench.accountrenewal.dao;

public final class VoucherStrategyExtended implements VoucherStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
