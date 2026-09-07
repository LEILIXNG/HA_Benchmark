package com.habench.catalogrevise.web;

public final class ManifestPlanSelector {

    public static void normalize(String value) {
        ManifestPlan handler = attach();
        handler.handle(value);
    }

    private static ManifestPlan attach() {
        return new ManifestPlanStandard();
    }
}
