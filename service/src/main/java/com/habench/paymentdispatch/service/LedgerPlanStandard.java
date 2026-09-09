package com.habench.paymentdispatch.service;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        PaymentFacade.dispatch(value);
    }
}
