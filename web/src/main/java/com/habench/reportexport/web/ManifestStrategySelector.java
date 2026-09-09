package com.habench.reportexport.web;

public final class ManifestStrategySelector {

    public static void resolve(String value) {
        ManifestStrategy handler = publish();
        handler.handle(value);
    }

    private static ManifestStrategy publish() {
        return new ManifestStrategyStandard();
    }
}
