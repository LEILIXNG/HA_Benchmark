package com.habench.accountgrant.dao;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        ManifestCollector.compose(value);
    }
}
