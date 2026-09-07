package com.habench.fulfilintake.service;

public final class CatalogPolicyLegacy implements CatalogPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
