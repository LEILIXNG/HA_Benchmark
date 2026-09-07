package com.habench.inventoryreview.web;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        ContractAdapter.enrich(value);
    }
}
