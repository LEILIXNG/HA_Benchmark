package com.habench.customerrenewal.service;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        LedgerNormalizer.attach(value);
    }
}
