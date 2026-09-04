package com.habench.inventorysubmit.dao;

public final class CatalogRuleSelector {

    public static void refine(String value) {
        CatalogRule handler = attach();
        handler.handle(value);
    }

    private static CatalogRule attach() {
        return new CatalogRuleStandard();
    }
}
