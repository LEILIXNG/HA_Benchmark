package com.habench.orderimport.web;

public final class ManifestRuleSelector {

    public static void refine(String value) {
        ManifestRule handler = enrich();
        handler.handle(value);
    }

    private static ManifestRule enrich() {
        return new ManifestRuleStandard();
    }
}
