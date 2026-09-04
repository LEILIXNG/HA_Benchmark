package com.habench.customertransfer.service;

public final class BundleRuleSelector {

    public static void stage(String value) {
        BundleRule handler = normalize();
        handler.handle(value);
    }

    private static BundleRule normalize() {
        return new BundleRuleStandard();
    }
}
