package com.habench.billingmanifest.web;

public final class SessionPlanFallback implements SessionPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
