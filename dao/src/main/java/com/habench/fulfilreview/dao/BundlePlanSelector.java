package com.habench.fulfilreview.dao;

public final class BundlePlanSelector {

    public static void submit(String value) {
        BundlePlan handler = stage();
        handler.handle(value);
    }

    private static BundlePlan stage() {
        return new BundlePlanStandard();
    }
}
