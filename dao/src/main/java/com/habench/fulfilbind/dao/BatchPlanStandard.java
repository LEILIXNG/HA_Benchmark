package com.habench.fulfilbind.dao;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ManifestAdapter.collect(value);
    }
}
