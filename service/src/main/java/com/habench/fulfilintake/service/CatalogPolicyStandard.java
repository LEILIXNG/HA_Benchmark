package com.habench.fulfilintake.service;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        BundleCoordinator.collect(value);
    }
}
