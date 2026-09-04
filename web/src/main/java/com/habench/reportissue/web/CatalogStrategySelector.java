package com.habench.reportissue.web;

public final class CatalogStrategySelector {

    public static void normalize(String value) {
        CatalogStrategy handler = stage();
        handler.handle(value);
    }

    private static CatalogStrategy stage() {
        return new CatalogStrategyStandard();
    }
}
