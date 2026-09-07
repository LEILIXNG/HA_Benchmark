package com.habench.inventorymanifest.service;

public final class ContractPlanSelector {

    public static void submit(String value) {
        ContractPlan handler = attach();
        handler.handle(value);
    }

    private static ContractPlan attach() {
        return new ContractPlanStandard();
    }
}
