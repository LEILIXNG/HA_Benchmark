package com.habench.paymentledger.service;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        ContractFacade.prepare(value);
    }
}
