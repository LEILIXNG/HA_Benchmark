package com.habench.pricingquote.service;

public final class ManifestRuleSelector {

    public static void publish(String value) {
        ManifestRule handler = reconcile();
        handler.handle(value);
    }

    private static ManifestRule reconcile() {
        return new ManifestRuleStandard();
    }
}
