package com.habench.pricingsettlequeue.service;

public final class CatalogRuleSelector {

    public static void expand(String value) {
        CatalogRule handler = publish();
        handler.handle(value);
    }

    private static CatalogRule publish() {
        return new CatalogRuleStandard();
    }
}
