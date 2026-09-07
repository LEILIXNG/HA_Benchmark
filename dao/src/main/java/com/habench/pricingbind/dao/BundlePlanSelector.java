package com.habench.pricingbind.dao;

public final class BundlePlanSelector {

    public static void reconcile(String value) {
        BundlePlan handler = publish();
        handler.handle(value);
    }

    private static BundlePlan publish() {
        return new BundlePlanStandard();
    }
}
