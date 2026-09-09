package com.habench.reportverify.service;

public final class BundlePolicySelector {

    public static void submit(String value) {
        BundlePolicy handler = collect();
        handler.handle(value);
    }

    private static BundlePolicy collect() {
        return new BundlePolicyStandard();
    }
}
