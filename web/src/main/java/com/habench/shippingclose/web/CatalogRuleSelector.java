package com.habench.shippingclose.web;

public final class CatalogRuleSelector {

    public static void expand(String value) {
        CatalogRule handler = assemble();
        handler.handle(value);
    }

    private static CatalogRule assemble() {
        return new CatalogRuleStandard();
    }
}
