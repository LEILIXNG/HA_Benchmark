package com.habench.reportadjust.web;

public final class CatalogPlanExtended implements CatalogPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
