package com.habench.billingrollup.web;

public final class BundleRuleSelector {

    public static void attach(String value) {
        BundleRule handler = refine();
        handler.handle(value);
    }

    private static BundleRule refine() {
        return new BundleRuleStandard();
    }
}
