package com.habench.vendormerge.service;

public final class CatalogPolicySelector {

    public static void collect(String value) {
        CatalogPolicy handler = prepare();
        handler.handle(value);
    }

    private static CatalogPolicy prepare() {
        return new CatalogPolicyStandard();
    }
}
