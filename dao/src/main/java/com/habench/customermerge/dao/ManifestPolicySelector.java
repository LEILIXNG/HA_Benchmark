package com.habench.customermerge.dao;

public final class ManifestPolicySelector {

    public static void resolve(String value) {
        ManifestPolicy handler = register();
        handler.handle(value);
    }

    private static ManifestPolicy register() {
        return new ManifestPolicyStandard();
    }
}
