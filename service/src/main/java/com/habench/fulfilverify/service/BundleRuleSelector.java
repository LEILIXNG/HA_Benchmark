package com.habench.fulfilverify.service;

public final class BundleRuleSelector {

    public static void submit(String value) {
        BundleRule handler = publish();
        handler.handle(value);
    }

    private static BundleRule publish() {
        return new BundleRuleStandard();
    }
}
