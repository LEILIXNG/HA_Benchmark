package com.habench.vendorexport.web;

public final class BatchPlanExtended implements BatchPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
