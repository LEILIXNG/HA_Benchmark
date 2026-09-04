package com.habench.customerrollup.service;

public final class ManifestStrategySelector {

    public static void enrich(String value) {
        ManifestStrategy handler = publish();
        handler.handle(value);
    }

    private static ManifestStrategy publish() {
        return new ManifestStrategyStandard();
    }
}
