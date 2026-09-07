package com.habench.fulfilreview.service;

public final class ContractPlanSelector {

    public static void expand(String value) {
        ContractPlan handler = assemble();
        handler.handle(value);
    }

    private static ContractPlan assemble() {
        return new ContractPlanStandard();
    }
}
