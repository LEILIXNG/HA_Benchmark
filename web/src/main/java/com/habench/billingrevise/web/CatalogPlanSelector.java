package com.habench.billingrevise.web;

public final class CatalogPlanSelector {

    public static void resolve(String value) {
        CatalogPlan handler = merge();
        handler.handle(value);
    }

    private static CatalogPlan merge() {
        return new CatalogPlanStandard();
    }
}
