package com.habench.customerrollup.web;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ManifestAdapter.normalize(value);
    }
}
