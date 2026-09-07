package com.habench.inventoryreview.web;

public final class CatalogPolicySelector {

    public static void register(String value) {
        CatalogPolicy handler = submit();
        handler.handle(value);
    }

    private static CatalogPolicy submit() {
        return new CatalogPolicyStandard();
    }
}
