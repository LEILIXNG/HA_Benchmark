package com.habench.catalogrevise.web;

public final class ManifestPlanLegacy implements ManifestPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
