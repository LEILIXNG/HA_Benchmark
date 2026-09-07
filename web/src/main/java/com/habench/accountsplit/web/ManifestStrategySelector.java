package com.habench.accountsplit.web;

public final class ManifestStrategySelector {

    public static void attach(String value) {
        ManifestStrategy handler = route();
        handler.handle(value);
    }

    private static ManifestStrategy route() {
        return new ManifestStrategyStandard();
    }
}
