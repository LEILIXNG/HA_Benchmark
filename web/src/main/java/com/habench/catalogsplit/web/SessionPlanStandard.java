package com.habench.catalogsplit.web;

public final class SessionPlanStandard implements SessionPlan {
    @Override
    public void handle(String value) {
        ManifestRouter.enrich(value);
    }
}
