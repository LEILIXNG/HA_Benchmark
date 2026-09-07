package com.habench.inventorymanifest.service;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        BatchCollector.translate(value);
    }
}
