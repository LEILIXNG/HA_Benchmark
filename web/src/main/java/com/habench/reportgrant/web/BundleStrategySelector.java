package com.habench.reportgrant.web;

public final class BundleStrategySelector {

    public static void collect(String value) {
        BundleStrategy handler = refine();
        handler.handle(value);
    }

    private static BundleStrategy refine() {
        return new BundleStrategyStandard();
    }
}
