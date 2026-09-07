package com.habench.orderexport.web;

public final class ManifestPlanFallback implements ManifestPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
