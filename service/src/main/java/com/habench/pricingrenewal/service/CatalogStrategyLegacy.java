package com.habench.pricingrenewal.service;

public final class CatalogStrategyLegacy implements CatalogStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
