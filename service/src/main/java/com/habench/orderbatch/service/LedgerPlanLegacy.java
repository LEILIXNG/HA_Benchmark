package com.habench.orderbatch.service;

public final class LedgerPlanLegacy implements LedgerPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
