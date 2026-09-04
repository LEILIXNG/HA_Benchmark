package com.habench.fulfilrenewal.service;

public final class CatalogRuleSelector {

    public static void translate(String value) {
        CatalogRule handler = compose();
        handler.handle(value);
    }

    private static CatalogRule compose() {
        return new CatalogRuleStandard();
    }
}
