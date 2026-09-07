package com.habench.inventorysettlequeue.web;

public final class CatalogPolicySelector {

    public static void route(String value) {
        CatalogPolicy handler = forward();
        handler.handle(value);
    }

    private static CatalogPolicy forward() {
        return new CatalogPolicyStandard();
    }
}
