package com.habench.fulfilmanifest.dao;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        ReceiptBroker.collect(value);
    }
}
