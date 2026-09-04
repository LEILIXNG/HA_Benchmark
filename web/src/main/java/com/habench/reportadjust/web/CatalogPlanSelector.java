package com.habench.reportadjust.web;

public final class CatalogPlanSelector {

    public static void merge(String value) {
        CatalogPlan handler = enrich();
        handler.handle(value);
    }

    private static CatalogPlan enrich() {
        return new CatalogPlanStandard();
    }
}
