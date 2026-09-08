package com.habench.fulfilapprove.service;

public final class ReceiptPlanFallback implements ReceiptPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
