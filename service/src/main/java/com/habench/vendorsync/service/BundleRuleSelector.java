package com.habench.vendorsync.service;

public final class BundleRuleSelector {

    public static void translate(String value) {
        BundleRule handler = prepare();
        handler.handle(value);
    }

    private static BundleRule prepare() {
        return new BundleRuleStandard();
    }
}
