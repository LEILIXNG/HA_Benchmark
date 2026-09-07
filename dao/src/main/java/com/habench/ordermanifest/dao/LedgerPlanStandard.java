package com.habench.ordermanifest.dao;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        PaymentCoordinator.collect(value);
    }
}
