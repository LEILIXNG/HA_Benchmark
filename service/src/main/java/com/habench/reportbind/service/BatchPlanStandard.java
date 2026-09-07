package com.habench.reportbind.service;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ContractEnricher.enrich(value);
    }
}
