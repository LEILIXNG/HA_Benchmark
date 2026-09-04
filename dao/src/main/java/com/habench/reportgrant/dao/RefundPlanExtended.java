package com.habench.reportgrant.dao;

public final class RefundPlanExtended implements RefundPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
