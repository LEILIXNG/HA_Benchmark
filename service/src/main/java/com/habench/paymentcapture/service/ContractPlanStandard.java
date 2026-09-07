package com.habench.paymentcapture.service;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        OrderAdapter.assemble(value);
    }
}
