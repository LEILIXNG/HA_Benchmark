package com.habench.fulfilhold.dao;

public final class BundlePolicySelector {

    public static void translate(String value) {
        BundlePolicy handler = stage();
        handler.handle(value);
    }

    private static BundlePolicy stage() {
        return new BundlePolicyStandard();
    }
}
