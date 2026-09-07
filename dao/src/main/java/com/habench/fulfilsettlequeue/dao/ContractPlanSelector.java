package com.habench.fulfilsettlequeue.dao;

public final class ContractPlanSelector {

    public static void translate(String value) {
        ContractPlan handler = collect();
        handler.handle(value);
    }

    private static ContractPlan collect() {
        return new ContractPlanStandard();
    }
}
