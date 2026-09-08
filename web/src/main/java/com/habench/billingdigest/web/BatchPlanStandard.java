package com.habench.billingdigest.web;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ManifestAdapter.normalize(value);
    }
}
