package com.habench.billingdraft.dao;

public final class ManifestPolicySelector {

    public static void stage(String value) {
        ManifestPolicy handler = assemble();
        handler.handle(value);
    }

    private static ManifestPolicy assemble() {
        return new ManifestPolicyStandard();
    }
}
