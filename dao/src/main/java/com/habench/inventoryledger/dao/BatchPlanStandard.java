package com.habench.inventoryledger.dao;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ManifestBroker.dispatch(value);
    }
}
