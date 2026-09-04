package com.habench.paymentsettlequeue.dao;

public final class CatalogRuleSelector {

    public static void enrich(String value) {
        CatalogRule handler = refine();
        handler.handle(value);
    }

    private static CatalogRule refine() {
        return new CatalogRuleStandard();
    }
}
