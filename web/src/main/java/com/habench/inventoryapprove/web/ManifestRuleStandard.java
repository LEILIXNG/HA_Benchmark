package com.habench.inventoryapprove.web;

public final class ManifestRuleStandard implements ManifestRule {
    @Override
    public void handle(String value) {
        CatalogCoordinator.translate(value);
    }
}
