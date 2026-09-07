package com.habench.paymentsubmit.dao;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        LedgerEnricher.compose(value);
    }
}
