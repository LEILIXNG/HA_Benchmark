package com.habench.vendorrenewal.service;

public final class BundlePolicySelector {

    public static void dispatch(String value) {
        BundlePolicy handler = enrich();
        handler.handle(value);
    }

    private static BundlePolicy enrich() {
        return new BundlePolicyStandard();
    }
}
