package com.habench.orderreview.web;

public final class ManifestStrategySelector {

    public static void collect(String value) {
        ManifestStrategy handler = refine();
        handler.handle(value);
    }

    private static ManifestStrategy refine() {
        return new ManifestStrategyStandard();
    }
}
