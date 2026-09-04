package com.habench.orderbatch.service;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        ReceiptAdapter.register(value);
    }
}
