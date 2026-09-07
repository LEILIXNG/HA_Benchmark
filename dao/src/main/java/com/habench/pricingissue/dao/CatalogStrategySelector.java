package com.habench.pricingissue.dao;

public final class CatalogStrategySelector {

    public static void resolve(String value) {
        CatalogStrategy handler = merge();
        handler.handle(value);
    }

    private static CatalogStrategy merge() {
        return new CatalogStrategyStandard();
    }
}
