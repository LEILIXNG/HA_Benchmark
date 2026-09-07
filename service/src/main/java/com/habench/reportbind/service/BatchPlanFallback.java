package com.habench.reportbind.service;

public final class BatchPlanFallback implements BatchPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
