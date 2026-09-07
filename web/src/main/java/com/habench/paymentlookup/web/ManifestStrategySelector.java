package com.habench.paymentlookup.web;

public final class ManifestStrategySelector {

    public static void compose(String value) {
        ManifestStrategy handler = resolve();
        handler.handle(value);
    }

    private static ManifestStrategy resolve() {
        return new ManifestStrategyStandard();
    }
}
