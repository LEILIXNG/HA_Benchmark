package com.habench.shippingintake.web;

public final class BundleStrategySelector {

    public static void route(String value) {
        BundleStrategy handler = attach();
        handler.handle(value);
    }

    private static BundleStrategy attach() {
        return new BundleStrategyStandard();
    }
}
