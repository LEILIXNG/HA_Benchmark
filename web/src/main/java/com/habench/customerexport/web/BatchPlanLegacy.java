package com.habench.customerexport.web;

public final class BatchPlanLegacy implements BatchPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
