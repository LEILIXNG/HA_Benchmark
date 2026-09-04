package com.habench.customermanifest.dao;

public final class CatalogPolicySelector {

    public static void dispatch(String value) {
        CatalogPolicy handler = normalize();
        handler.handle(value);
    }

    private static CatalogPolicy normalize() {
        return new CatalogPolicyStandard();
    }
}
