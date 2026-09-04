package com.habench.accountreconcile.service;

public final class BundleStrategySelector {

    public static void translate(String value) {
        BundleStrategy handler = reconcile();
        handler.handle(value);
    }

    private static BundleStrategy reconcile() {
        return new BundleStrategyStandard();
    }
}
