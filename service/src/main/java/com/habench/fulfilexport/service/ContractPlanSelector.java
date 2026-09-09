package com.habench.fulfilexport.service;

public final class ContractPlanSelector {

    public static void refine(String value) {
        ContractPlan handler = dispatch();
        handler.handle(value);
    }

    private static ContractPlan dispatch() {
        return new ContractPlanStandard();
    }
}
