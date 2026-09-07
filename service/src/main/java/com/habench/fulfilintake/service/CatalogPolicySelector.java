package com.habench.fulfilintake.service;

public final class CatalogPolicySelector {

    public static void attach(String value) {
        CatalogPolicy handler = translate();
        handler.handle(value);
    }

    private static CatalogPolicy translate() {
        return new CatalogPolicyStandard();
    }
}
