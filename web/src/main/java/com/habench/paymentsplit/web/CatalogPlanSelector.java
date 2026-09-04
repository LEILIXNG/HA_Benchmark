package com.habench.paymentsplit.web;

public final class CatalogPlanSelector {

    public static void enrich(String value) {
        CatalogPlan handler = forward();
        handler.handle(value);
    }

    private static CatalogPlan forward() {
        return new CatalogPlanStandard();
    }
}
