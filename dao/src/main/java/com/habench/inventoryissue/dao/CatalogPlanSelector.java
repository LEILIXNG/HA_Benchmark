package com.habench.inventoryissue.dao;

public final class CatalogPlanSelector {

    public static void stage(String value) {
        CatalogPlan handler = enrich();
        handler.handle(value);
    }

    private static CatalogPlan enrich() {
        return new CatalogPlanStandard();
    }
}
