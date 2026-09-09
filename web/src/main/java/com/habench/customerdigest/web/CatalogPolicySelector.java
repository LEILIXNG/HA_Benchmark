package com.habench.customerdigest.web;

public final class CatalogPolicySelector {

    public static void stage(String value) {
        CatalogPolicy handler = register();
        handler.handle(value);
    }

    private static CatalogPolicy register() {
        return new CatalogPolicyStandard();
    }
}
