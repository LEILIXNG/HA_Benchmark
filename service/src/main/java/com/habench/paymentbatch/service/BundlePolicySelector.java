package com.habench.paymentbatch.service;

public final class BundlePolicySelector {

    public static void expand(String value) {
        BundlePolicy handler = assemble();
        handler.handle(value);
    }

    private static BundlePolicy assemble() {
        return new BundlePolicyStandard();
    }
}
