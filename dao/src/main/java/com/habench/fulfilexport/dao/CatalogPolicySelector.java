package com.habench.fulfilexport.dao;

public final class CatalogPolicySelector {

    public static void dispatch(String value) {
        CatalogPolicy handler = forward();
        handler.handle(value);
    }

    private static CatalogPolicy forward() {
        return new CatalogPolicyStandard();
    }
}
