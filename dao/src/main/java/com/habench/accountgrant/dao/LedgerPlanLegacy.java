package com.habench.accountgrant.dao;

public final class LedgerPlanLegacy implements LedgerPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
