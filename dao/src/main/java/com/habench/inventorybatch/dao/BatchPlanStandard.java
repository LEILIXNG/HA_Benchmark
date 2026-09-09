package com.habench.inventorybatch.dao;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        LedgerCoordinator.prepare(value);
    }
}
