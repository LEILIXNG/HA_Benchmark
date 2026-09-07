package com.habench.billingdraft.web;

public final class BundlePolicySelector {

    public static void prepare(String value) {
        BundlePolicy handler = submit();
        handler.handle(value);
    }

    private static BundlePolicy submit() {
        return new BundlePolicyStandard();
    }
}
