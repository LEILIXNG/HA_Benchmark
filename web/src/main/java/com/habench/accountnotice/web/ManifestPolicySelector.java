package com.habench.accountnotice.web;

public final class ManifestPolicySelector {

    public static void normalize(String value) {
        ManifestPolicy handler = merge();
        handler.handle(value);
    }

    private static ManifestPolicy merge() {
        return new ManifestPolicyStandard();
    }
}
