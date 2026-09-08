package com.habench.vendormerge.service;

public final class CatalogPolicyFallback implements CatalogPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
