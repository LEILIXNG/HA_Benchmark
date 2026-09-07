package com.habench.customerdigest.web;

public final class LedgerPlanExtended implements LedgerPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
