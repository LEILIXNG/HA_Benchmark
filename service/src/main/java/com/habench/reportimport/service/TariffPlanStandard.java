package com.habench.reportimport.service;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        ContractFacade.reconcile(value);
    }
}
