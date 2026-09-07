package com.habench.inventoryadjust.dao;

public final class BundlePolicySelector {

    public static void submit(String value) {
        BundlePolicy handler = expand();
        handler.handle(value);
    }

    private static BundlePolicy expand() {
        return new BundlePolicyStandard();
    }
}
