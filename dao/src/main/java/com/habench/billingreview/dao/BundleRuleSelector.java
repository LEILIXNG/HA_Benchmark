package com.habench.billingreview.dao;

public final class BundleRuleSelector {

    public static void stage(String value) {
        BundleRule handler = reconcile();
        handler.handle(value);
    }

    private static BundleRule reconcile() {
        return new BundleRuleStandard();
    }
}
