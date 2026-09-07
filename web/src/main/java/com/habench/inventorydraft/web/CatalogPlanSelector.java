package com.habench.inventorydraft.web;

public final class CatalogPlanSelector {

    public static void expand(String value) {
        CatalogPlan handler = resolve();
        handler.handle(value);
    }

    private static CatalogPlan resolve() {
        return new CatalogPlanStandard();
    }
}
