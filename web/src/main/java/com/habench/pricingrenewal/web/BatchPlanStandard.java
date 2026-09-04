package com.habench.pricingrenewal.web;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ContractResolver.resolve(value);
    }
}
