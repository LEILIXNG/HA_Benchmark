package com.habench.pricingreview.web;

public final class VoucherPlanFallback implements VoucherPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
