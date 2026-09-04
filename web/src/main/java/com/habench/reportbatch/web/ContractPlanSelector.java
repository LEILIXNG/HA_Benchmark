package com.habench.reportbatch.web;

public final class ContractPlanSelector {

    public static void forward(String value) {
        ContractPlan handler = expand();
        handler.handle(value);
    }

    private static ContractPlan expand() {
        return new ContractPlanStandard();
    }
}
