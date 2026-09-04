package com.habench.customerledger.dao;

public final class CatalogStrategySelector {

    public static void compose(String value) {
        CatalogStrategy handler = forward();
        handler.handle(value);
    }

    private static CatalogStrategy forward() {
        return new CatalogStrategyStandard();
    }
}
