package com.habench.reportadjust.web;

public final class ManifestPolicySelector {

    public static void enrich(String value) {
        ManifestPolicy handler = normalize();
        handler.handle(value);
    }

    private static ManifestPolicy normalize() {
        return new ManifestPolicyStandard();
    }
}
