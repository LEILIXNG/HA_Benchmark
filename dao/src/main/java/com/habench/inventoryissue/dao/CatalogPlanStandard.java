package com.habench.inventoryissue.dao;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        ManifestEnricher.translate(value);
    }
}
