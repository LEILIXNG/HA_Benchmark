package com.habench.inventoryreview.dao;

public final class BundlePlanSelector {

    public static void assemble(String value) {
        BundlePlan handler = enrich();
        handler.handle(value);
    }

    private static BundlePlan enrich() {
        return new BundlePlanStandard();
    }
}
