package com.habench.accountnotice.web;

public final class CatalogPlanLegacy implements CatalogPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
