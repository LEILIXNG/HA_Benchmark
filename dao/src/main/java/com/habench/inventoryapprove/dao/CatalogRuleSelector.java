package com.habench.inventoryapprove.dao;

public final class CatalogRuleSelector {

    public static void stage(String value) {
        CatalogRule handler = route();
        handler.handle(value);
    }

    private static CatalogRule route() {
        return new CatalogRuleStandard();
    }
}
