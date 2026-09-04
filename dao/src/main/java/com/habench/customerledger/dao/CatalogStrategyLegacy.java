package com.habench.customerledger.dao;

public final class CatalogStrategyLegacy implements CatalogStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
