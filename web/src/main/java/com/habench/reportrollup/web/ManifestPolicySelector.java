package com.habench.reportrollup.web;

public final class ManifestPolicySelector {

    public static void refine(String value) {
        ManifestPolicy handler = translate();
        handler.handle(value);
    }

    private static ManifestPolicy translate() {
        return new ManifestPolicyStandard();
    }
}
