package com.habench.pricinghold.web;

public final class BundlePlanSelector {

    public static void expand(String value) {
        BundlePlan handler = submit();
        handler.handle(value);
    }

    private static BundlePlan submit() {
        return new BundlePlanStandard();
    }
}
