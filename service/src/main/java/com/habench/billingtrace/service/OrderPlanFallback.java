package com.habench.billingtrace.service;

public final class OrderPlanFallback implements OrderPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
