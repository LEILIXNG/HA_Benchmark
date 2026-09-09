package com.habench.billingbind.web;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ManifestCoordinator.enrich(value);
    }
}
