package com.habench.inventoryapprove.web;

public final class BundleRuleSelector {

    public static void register(String value) {
        BundleRule handler = expand();
        handler.handle(value);
    }

    private static BundleRule expand() {
        return new BundleRuleStandard();
    }
}
