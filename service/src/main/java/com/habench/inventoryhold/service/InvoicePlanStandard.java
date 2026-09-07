package com.habench.inventoryhold.service;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        BatchBroker.enrich(value);
    }
}
