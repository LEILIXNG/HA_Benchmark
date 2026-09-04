package com.habench.paymentimport.service;

public final class CatalogStrategySelector {

    public static void refine(String value) {
        CatalogStrategy handler = route();
        handler.handle(value);
    }

    private static CatalogStrategy route() {
        return new CatalogStrategyStandard();
    }
}
