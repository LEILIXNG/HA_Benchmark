package com.habench.ordertransfer.service;

public final class ContractPlanSelector {

    public static void collect(String value) {
        ContractPlan handler = forward();
        handler.handle(value);
    }

    private static ContractPlan forward() {
        return new ContractPlanStandard();
    }
}
