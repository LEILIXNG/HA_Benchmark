package com.habench.customerverify.web;

public final class ManifestStrategySelector {

    public static void attach(String value) {
        ManifestStrategy handler = enrich();
        handler.handle(value);
    }

    private static ManifestStrategy enrich() {
        return new ManifestStrategyStandard();
    }
}
