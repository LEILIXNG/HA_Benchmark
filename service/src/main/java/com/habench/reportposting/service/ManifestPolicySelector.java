package com.habench.reportposting.service;

public final class ManifestPolicySelector {

    public static void resolve(String value) {
        ManifestPolicy handler = publish();
        handler.handle(value);
    }

    private static ManifestPolicy publish() {
        return new ManifestPolicyStandard();
    }
}
