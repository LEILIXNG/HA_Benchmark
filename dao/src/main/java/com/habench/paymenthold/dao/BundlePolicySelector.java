package com.habench.paymenthold.dao;

public final class BundlePolicySelector {

    public static void compose(String value) {
        BundlePolicy handler = prepare();
        handler.handle(value);
    }

    private static BundlePolicy prepare() {
        return new BundlePolicyStandard();
    }
}
