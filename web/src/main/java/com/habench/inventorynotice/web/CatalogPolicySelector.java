package com.habench.inventorynotice.web;

public final class CatalogPolicySelector {

    public static void translate(String value) {
        CatalogPolicy handler = enrich();
        handler.handle(value);
    }

    private static CatalogPolicy enrich() {
        return new CatalogPolicyStandard();
    }
}
