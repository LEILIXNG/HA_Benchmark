package com.habench.pricingsubmit.service;

public final class BundlePlanSelector {

    public static void prepare(String value) {
        BundlePlan handler = publish();
        handler.handle(value);
    }

    private static BundlePlan publish() {
        return new BundlePlanStandard();
    }
}
