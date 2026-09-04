package com.habench.orderrefund.web;

public final class BundleRuleSelector {

    public static void resolve(String value) {
        BundleRule handler = translate();
        handler.handle(value);
    }

    private static BundleRule translate() {
        return new BundleRuleStandard();
    }
}
