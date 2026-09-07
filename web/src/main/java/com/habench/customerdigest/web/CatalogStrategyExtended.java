package com.habench.customerdigest.web;

public final class CatalogStrategyExtended implements CatalogStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
