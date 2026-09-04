package com.habench.catalogrenewal.dao;

public final class BundleRuleSelector {

    public static void dispatch(String value) {
        BundleRule handler = expand();
        handler.handle(value);
    }

    private static BundleRule expand() {
        return new BundleRuleStandard();
    }
}
