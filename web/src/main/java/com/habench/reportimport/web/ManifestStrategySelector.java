package com.habench.reportimport.web;

public final class ManifestStrategySelector {

    public static void stage(String value) {
        ManifestStrategy handler = refine();
        handler.handle(value);
    }

    private static ManifestStrategy refine() {
        return new ManifestStrategyStandard();
    }
}
