package com.habench.catalogsplit.service;

public final class ContractPlanSelector {

    public static void prepare(String value) {
        ContractPlan handler = resolve();
        handler.handle(value);
    }

    private static ContractPlan resolve() {
        return new ContractPlanStandard();
    }
}
