package com.habench.orderexport.web;

public final class ManifestPlanSelector {

    public static void reconcile(String value) {
        ManifestPlan handler = publish();
        handler.handle(value);
    }

    private static ManifestPlan publish() {
        return new ManifestPlanStandard();
    }
}
