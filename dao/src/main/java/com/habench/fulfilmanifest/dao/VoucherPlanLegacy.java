package com.habench.fulfilmanifest.dao;

public final class VoucherPlanLegacy implements VoucherPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
