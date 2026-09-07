package com.habench.accountsettle.service;

public final class CatalogPolicySelector {

    public static void translate(String value) {
        CatalogPolicy handler = forward();
        handler.handle(value);
    }

    private static CatalogPolicy forward() {
        return new CatalogPolicyStandard();
    }
}
