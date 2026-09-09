package com.habench.fulfilcapture.service;

public final class BundlePlanSelector {

    public static void route(String value) {
        BundlePlan handler = refine();
        handler.handle(value);
    }

    private static BundlePlan refine() {
        return new BundlePlanStandard();
    }
}
