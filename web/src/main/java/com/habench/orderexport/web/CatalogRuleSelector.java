package com.habench.orderexport.web;

public final class CatalogRuleSelector {

    public static void compose(String value) {
        CatalogRule handler = resolve();
        handler.handle(value);
    }

    private static CatalogRule resolve() {
        return new CatalogRuleStandard();
    }
}
