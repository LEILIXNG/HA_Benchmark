package com.habench.inventoryposting.web;

public final class ManifestStrategySelector {

    public static void enrich(String value) {
        ManifestStrategy handler = resolve();
        handler.handle(value);
    }

    private static ManifestStrategy resolve() {
        return new ManifestStrategyStandard();
    }
}
