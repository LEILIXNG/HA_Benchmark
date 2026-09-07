package com.habench.inventoryhold.service;

public final class InvoicePlanExtended implements InvoicePlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
