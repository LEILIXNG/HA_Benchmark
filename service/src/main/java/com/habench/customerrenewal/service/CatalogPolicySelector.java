package com.habench.customerrenewal.service;

public final class CatalogPolicySelector {

    public static void collect(String value) {
        CatalogPolicy handler = stage();
        handler.handle(value);
    }

    private static CatalogPolicy stage() {
        return new CatalogPolicyStandard();
    }
}
