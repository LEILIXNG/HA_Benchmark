package com.habench.inventorydispatch.web;

public final class CatalogRuleSelector {

    public static void publish(String value) {
        CatalogRule handler = submit();
        handler.handle(value);
    }

    private static CatalogRule submit() {
        return new CatalogRuleStandard();
    }
}
