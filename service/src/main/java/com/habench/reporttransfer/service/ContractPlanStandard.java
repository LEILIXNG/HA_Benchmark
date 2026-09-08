package com.habench.reporttransfer.service;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        TariffAssembler.stage(value);
    }
}
