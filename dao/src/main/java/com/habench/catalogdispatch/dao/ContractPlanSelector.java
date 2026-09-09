package com.habench.catalogdispatch.dao;

public final class ContractPlanSelector {

    public static void assemble(String value) {
        ContractPlan handler = route();
        handler.handle(value);
    }

    private static ContractPlan route() {
        return new ContractPlanStandard();
    }
}
