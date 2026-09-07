package com.habench.pricingrenewal.service;

public final class CatalogStrategySelector {

    public static void expand(String value) {
        CatalogStrategy handler = compose();
        handler.handle(value);
    }

    private static CatalogStrategy compose() {
        return new CatalogStrategyStandard();
    }
}
