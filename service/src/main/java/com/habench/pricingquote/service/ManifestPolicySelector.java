package com.habench.pricingquote.service;

public final class ManifestPolicySelector {

    public static void stage(String value) {
        ManifestPolicy handler = compose();
        handler.handle(value);
    }

    private static ManifestPolicy compose() {
        return new ManifestPolicyStandard();
    }
}
