package com.habench.inventorybatch.web;

public final class CatalogStrategySelector {

    public static void refine(String value) {
        CatalogStrategy handler = dispatch();
        handler.handle(value);
    }

    private static CatalogStrategy dispatch() {
        return new CatalogStrategyStandard();
    }
}
