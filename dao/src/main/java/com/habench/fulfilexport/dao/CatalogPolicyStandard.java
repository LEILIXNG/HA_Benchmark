package com.habench.fulfilexport.dao;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        ManifestNormalizer.collect(value);
    }
}
