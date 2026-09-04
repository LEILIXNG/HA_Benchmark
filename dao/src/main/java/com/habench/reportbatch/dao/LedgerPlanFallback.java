package com.habench.reportbatch.dao;

public final class LedgerPlanFallback implements LedgerPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
