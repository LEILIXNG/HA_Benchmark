package com.habench.vendornotice.service;

public final class BundleRuleSelector {

    public static void merge(String value) {
        BundleRule handler = submit();
        handler.handle(value);
    }

    private static BundleRule submit() {
        return new BundleRuleStandard();
    }
}
