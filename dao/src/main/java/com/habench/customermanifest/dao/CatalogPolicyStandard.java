package com.habench.customermanifest.dao;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        ShipmentCollector.enrich(value);
    }
}
