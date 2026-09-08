package com.habench.vendormerge.service;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        BatchFacade.dispatch(value);
    }
}
