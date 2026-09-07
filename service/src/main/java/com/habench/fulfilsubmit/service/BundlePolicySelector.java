package com.habench.fulfilsubmit.service;

public final class BundlePolicySelector {

    public static void submit(String value) {
        BundlePolicy handler = translate();
        handler.handle(value);
    }

    private static BundlePolicy translate() {
        return new BundlePolicyStandard();
    }
}
