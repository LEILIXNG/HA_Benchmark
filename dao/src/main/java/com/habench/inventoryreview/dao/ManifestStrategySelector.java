package com.habench.inventoryreview.dao;

public final class ManifestStrategySelector {

    public static void refine(String value) {
        ManifestStrategy handler = translate();
        handler.handle(value);
    }

    private static ManifestStrategy translate() {
        return new ManifestStrategyStandard();
    }
}
