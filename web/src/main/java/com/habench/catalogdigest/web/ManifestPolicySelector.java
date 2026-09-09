package com.habench.catalogdigest.web;

public final class ManifestPolicySelector {

    public static void submit(String value) {
        ManifestPolicy handler = normalize();
        handler.handle(value);
    }

    private static ManifestPolicy normalize() {
        return new ManifestPolicyStandard();
    }
}
