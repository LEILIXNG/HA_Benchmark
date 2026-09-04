package com.habench.paymentsplit.web;

public final class CatalogPlanFallback implements CatalogPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
