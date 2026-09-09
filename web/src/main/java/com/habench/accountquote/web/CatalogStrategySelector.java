package com.habench.accountquote.web;

public final class CatalogStrategySelector {

    public static void prepare(String value) {
        CatalogStrategy handler = dispatch();
        handler.handle(value);
    }

    private static CatalogStrategy dispatch() {
        return new CatalogStrategyStandard();
    }
}
