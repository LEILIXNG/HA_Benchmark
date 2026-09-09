package com.habench.catalogrollup.web;

public final class ContractPlanSelector {

    public static void stage(String value) {
        ContractPlan handler = submit();
        handler.handle(value);
    }

    private static ContractPlan submit() {
        return new ContractPlanStandard();
    }
}
