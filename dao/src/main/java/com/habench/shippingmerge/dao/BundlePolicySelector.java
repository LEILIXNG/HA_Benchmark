package com.habench.shippingmerge.dao;

public final class BundlePolicySelector {

    public static void assemble(String value) {
        BundlePolicy handler = forward();
        handler.handle(value);
    }

    private static BundlePolicy forward() {
        return new BundlePolicyStandard();
    }
}
