package com.habench.inventoryapprove.dao;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        ManifestFacade.stage(value);
    }
}
