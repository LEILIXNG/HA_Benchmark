package com.habench.fulfiltransfer.service;

public final class BundleRuleSelector {

    public static void register(String value) {
        BundleRule handler = reconcile();
        handler.handle(value);
    }

    private static BundleRule reconcile() {
        return new BundleRuleStandard();
    }
}
