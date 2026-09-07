package com.habench.fulfilsettlequeue.dao;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        BundleService.collect(value);
    }
}
