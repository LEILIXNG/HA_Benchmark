package com.habench.accountreconcile.service;

public final class CatalogRuleSelector {

    public static void collect(String value) {
        CatalogRule handler = translate();
        handler.handle(value);
    }

    private static CatalogRule translate() {
        return new CatalogRuleStandard();
    }
}
