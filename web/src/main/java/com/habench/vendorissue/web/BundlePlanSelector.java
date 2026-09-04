package com.habench.vendorissue.web;

public final class BundlePlanSelector {

    public static void publish(String value) {
        BundlePlan handler = enrich();
        handler.handle(value);
    }

    private static BundlePlan enrich() {
        return new BundlePlanStandard();
    }
}
