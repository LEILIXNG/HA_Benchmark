package com.habench.inventoryapprove.web;

public final class ManifestRuleSelector {

    public static void assemble(String value) {
        ManifestRule handler = reconcile();
        handler.handle(value);
    }

    private static ManifestRule reconcile() {
        return new ManifestRuleStandard();
    }
}
