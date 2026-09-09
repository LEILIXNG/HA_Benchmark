package com.habench.pricingnotice.web;

public final class BundlePlanSelector {

    public static void publish(String value) {
        BundlePlan handler = submit();
        handler.handle(value);
    }

    private static BundlePlan submit() {
        return new BundlePlanStandard();
    }
}
