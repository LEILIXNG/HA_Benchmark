package com.habench.customerledger.dao;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        BatchNormalizer.reconcile(value);
    }
}
