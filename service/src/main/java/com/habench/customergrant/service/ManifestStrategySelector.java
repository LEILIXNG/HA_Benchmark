package com.habench.customergrant.service;

public final class ManifestStrategySelector {

    public static void merge(String value) {
        ManifestStrategy handler = enrich();
        handler.handle(value);
    }

    private static ManifestStrategy enrich() {
        return new ManifestStrategyStandard();
    }
}
