package com.habench.catalogrollup.web;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        OrderRegistry.forward(value);
    }
}
