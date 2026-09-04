package com.habench.fulfilissue.web;

public final class CatalogRuleSelector {

    public static void enrich(String value) {
        CatalogRule handler = collect();
        handler.handle(value);
    }

    private static CatalogRule collect() {
        return new CatalogRuleStandard();
    }
}
