package com.habench.orderexport.web;

public final class ManifestPlanStandard implements ManifestPlan {
    @Override
    public void handle(String value) {
        LedgerBuilder.resolve(value);
    }
}
