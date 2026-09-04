package com.habench.billingapprove.service;

public final class SessionPlanLegacy implements SessionPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
